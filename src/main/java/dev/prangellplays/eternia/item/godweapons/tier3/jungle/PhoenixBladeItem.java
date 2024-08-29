package dev.prangellplays.eternia.item.godweapons.tier3.jungle;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class PhoenixBladeItem extends SwordWeaponItem {
    public PhoenixBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //PlayerEntity cUser;
        if (!world.isClient) {
            Vec3d start = user.getCameraPosVec(1.0f);
            Vec3d end = start.add(user.getRotationVec(1.0f).multiply(100.0));

            BlockHitResult result = world.raycast(new RaycastContext(start, end, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, user));
            if (result.getType() == HitResult.Type.BLOCK) {
                BlockPos targetPos = result.getBlockPos();
                world.addParticle(ParticleTypes.PORTAL, targetPos.getX(), targetPos.getY() + world.random.nextDouble() * 2.0, targetPos.getZ(), world.random.nextGaussian(), 0.0, world.random.nextGaussian());
                if (targetPos.isWithinDistance(user.getPos(), 25)) {
                    user.requestTeleport(targetPos.getX(), targetPos.getY() + 1, targetPos.getZ());
                }
            }
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return super.use(world, user, hand);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
