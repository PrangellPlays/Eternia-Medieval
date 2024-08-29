package dev.prangellplays.eternia.item.godweapons.tier1.jungle;

import dev.prangellplays.eternia.Eternia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class VineWhipItem extends SwordItem {
    public VineWhipItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random roll = new Random();
        if (attacker instanceof PlayerEntity player) {
            if (roll.nextDouble() < 0.34D && !player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                target.addStatusEffect(new StatusEffectInstance(Eternia.POISON_IVY, 400, 0, false, false, true), attacker);
                player.getItemCooldownManager().set(this, 400);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            Vec3d vec3d = user.getRotationVector();
            double d = 3;
            double e = 0.2;
            Vec3d vec3d2 = user.getVelocity();
            user.setVelocity(vec3d2.add(vec3d.x * e + (vec3d.x * d - vec3d2.x) * 0.5, vec3d.y * e + (vec3d.y * d - vec3d2.y) * 0.5, vec3d.z * e + (vec3d.z * d - vec3d2.z) * 0.5));
            user.getItemCooldownManager().set(this, 60);
            user.addStatusEffect(new StatusEffectInstance(Eternia.PHOENIXS_GRACE, 50, 0, false, false, false));
        return super.use(world, user, hand);
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
