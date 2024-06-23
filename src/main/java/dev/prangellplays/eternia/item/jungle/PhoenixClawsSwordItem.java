package dev.prangellplays.eternia.item.jungle;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.registry.EterniaEnchantments;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class PhoenixClawsSwordItem extends SwordItem {
    public PhoenixClawsSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.takeKnockback(1.0F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        java.util.Random roll = new java.util.Random();
        if (attacker instanceof PlayerEntity player) {
            if (roll.nextDouble() < 0.34D && !player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                target.setOnFireFor(3);
                player.getItemCooldownManager().set(this, 60);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.PHOENIX_CLAWS) && world.getBiome(player.getBlockPos()).isIn(BiomeTags.IS_JUNGLE)) {
                player.addStatusEffect(new StatusEffectInstance(Eternia.CALL_OF_THE_JUNGLE, 2, 0, false, false, false));
            }
            else {
                return;
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {
            user.setStackInHand(hand, EterniaItems.PHOENIX_CLAWS_SHOVEL.getDefaultStack());
        } else {
            Vec3d vec3d = user.getRotationVector();
            double d = 3;
            double e = 0.2;
            Vec3d vec3d2 = user.getVelocity();
            user.setVelocity(vec3d2.add(vec3d.x * e + (vec3d.x * d - vec3d2.x) * 0.5, vec3d.y * e + (vec3d.y * d - vec3d2.y) * 0.5, vec3d.z * e + (vec3d.z * d - vec3d2.z) * 0.5));
            user.getItemCooldownManager().set(this, 60);
            user.addStatusEffect(new StatusEffectInstance(Eternia.PHOENIXS_GRACE, 50, 0, false, false, false));
        }
        return super.use(world, user, hand);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        {
            tooltip.add(Text.translatable("tooltip.eternia.phoenix_claws_sword.swap").formatted(Formatting.GOLD));
        }
    }
}
