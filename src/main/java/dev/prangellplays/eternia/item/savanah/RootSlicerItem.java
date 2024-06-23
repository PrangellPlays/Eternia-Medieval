package dev.prangellplays.eternia.item.savanah;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dev.prangellplays.eternia.Eternia;
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
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import java.util.Random;
import java.util.UUID;

public class RootSlicerItem extends SwordItem {
    public static final UUID ATTACK_RANGE_MODIFIER_ID = UUID.fromString("05869d86-c861-4954-9079-68c380ad063c");
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public RootSlicerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", 12, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", -2.8f, EntityAttributeModifier.Operation.ADDITION));
        builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(ATTACK_RANGE_MODIFIER_ID, "Weapon modifier", 1f, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }
    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random roll = new Random();
        if (attacker instanceof PlayerEntity player) {
            if (roll.nextDouble() < 0.34D && !player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                target.addStatusEffect(new StatusEffectInstance(Eternia.STRANGLED, 60, 0, false, false, true));
                player.getItemCooldownManager().set(this, 400);
            }
        }
        return super.postHit(stack, target, attacker);
    }
    //When wielding this weapon, you will have better pick up reach to any natural food and block. MAYBE IDK
}
