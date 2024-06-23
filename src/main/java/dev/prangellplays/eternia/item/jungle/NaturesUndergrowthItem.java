package dev.prangellplays.eternia.item.jungle;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.UUID;

import static net.minecraft.enchantment.EnchantmentHelper.getEquipmentLevel;

public class NaturesUndergrowthItem extends SwordItem {
    private static final double CLIMB_SPEED = 0.288D;
    public static final UUID ATTACK_RANGE_MODIFIER_ID = UUID.fromString("05869d86-c861-4954-9079-68c380ad063c");
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public NaturesUndergrowthItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", 9, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", -2.8f, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(ATTACK_RANGE_MODIFIER_ID, "Weapon modifier", 1f, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.getMainHandStack().getItem() instanceof NaturesUndergrowthItem) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.NATURES_UNDERGROWTH)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, 0, false, false, false));
            } if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.NATURES_UNDERGROWTH) && player.hasStatusEffect(StatusEffects.POISON)) {
                player.removeStatusEffect(StatusEffects.POISON);
            } if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.NATURES_UNDERGROWTH) && player.hasStatusEffect(Eternia.POISON_IVY)) {
                player.removeStatusEffect(Eternia.POISON_IVY);
            } else {
                return;
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld world = (ServerWorld) attacker.getWorld();
        if (!world.isClient && (target instanceof PlayerEntity player)) {
            if (attacker.onKilledOther(world, player)) {
                player.dropItem(Items.APPLE);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}