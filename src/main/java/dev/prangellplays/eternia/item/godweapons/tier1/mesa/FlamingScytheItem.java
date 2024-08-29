package dev.prangellplays.eternia.item.godweapons.tier1.mesa;

import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class FlamingScytheItem extends SwordItem {
    public FlamingScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(7);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (player.getMainHandStack().isOf(EterniaItems.FLAMING_SCYTHE)) {
                Vec3d pos1 = new Vec3d(entity.getX() - 5, entity.getY() - 5, entity.getZ() - 5);
                Vec3d pos2 = new Vec3d(entity.getX() + 5, entity.getY() + 5, entity.getZ() + 5);
                world.getEntitiesByClass(LivingEntity.class, new Box(pos1, pos2), (livingEntity) -> !livingEntity.equals(entity)).forEach(livingEntity -> {
                    if (!livingEntity.isOnFire()) {
                        livingEntity.setOnFireFor(3);
                    }
                });
                if (world != null && world.isClient) {
                    Vec3d vel = player.getVelocity();
                    Random random = new Random();
                    for (int i = 0; i < 0.1f; i++) {
                        //North
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 5, player.getY() + 0.5f, player.getZ() + 1, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 5, player.getY() + 0.5f, player.getZ() + 3, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 5, player.getY() + 0.5f, player.getZ() - 1, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 5, player.getY() + 0.5f, player.getZ() - 3, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 5, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);

                        //East
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 1, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 3, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 1, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 3, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 5, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);

                        //South
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 5, player.getY() + 0.5f, player.getZ() + 1, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 5, player.getY() + 0.5f, player.getZ() + 3, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 5, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 5, player.getY() + 0.5f, player.getZ() - 1, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 5, player.getY() + 0.5f, player.getZ() - 3, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 5, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);

                        //West
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 1, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() + 3, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 1, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 3, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.FLAME, player.getX() - 5, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                    }
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
