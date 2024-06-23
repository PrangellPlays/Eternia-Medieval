package dev.prangellplays.eternia.item.plains;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WindwalkerBladeItem extends SwordItem {
    public WindwalkerBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.WINDWALKER_BLADE)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, 1, false, false, false));
                player.addStatusEffect(new StatusEffectInstance(Eternia.WIND_WALKER, 2, 0, false, false, false));
            }
            else {
                return;
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.takeKnockback(1.0F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Vec3d vec3d = user.getRotationVector();
        double d = 3;
        double e = 0.2;
        Vec3d vec3d2 = user.getVelocity();
        user.setVelocity(vec3d2.add(vec3d.x * e + (vec3d.x * d - vec3d2.x) * 0.5, vec3d.y * e + (vec3d.y * d - vec3d2.y) * 0.5, vec3d.z * e + (vec3d.z * d - vec3d2.z) * 0.5));
        user.getItemCooldownManager().set(this, 200);
        return super.use(world, user, hand);
    }
}
