package dev.prangellplays.eternia.entity.projectile;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.registry.EterniaEntityTypes;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class FrostedScytheEntity extends ThrownItemEntity {
    public FrostedScytheEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public FrostedScytheEntity(World world, LivingEntity owner) {
        super(EterniaEntityTypes.FROSTED_SCYTHE, owner, world);
    }

    public FrostedScytheEntity(World world, double x, double y, double z) {
        super(EterniaEntityTypes.FROSTED_SCYTHE, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return EterniaItems.FROSTED_SCYTHE;
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            for(int i = 0; i < 1000; ++i) {
                this.getWorld().addParticle(ParticleTypes.SNOWFLAKE, this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.12, this.random.nextGaussian() * 0.12, this.random.nextGaussian() * 0.12);
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.discard();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        LivingEntity target = (LivingEntity) entityHitResult.getEntity();
        target.addStatusEffect(new StatusEffectInstance(Eternia.FREEZING, 100, 0, true, false, true));
        super.onEntityHit(entityHitResult);
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        if(world != null && world.isClient) {
            Vec3d vel = this.getVelocity();
            Random random = this.random;
            for(int i = 0; i < 18; i++) {
                world.addParticle(ParticleTypes.SNOWFLAKE, this.getX(), this.getY(), this.getZ(), vel.x * -0.2 + random.nextFloat() * 0.06 - 0.03, vel.y * -0.2 + random.nextFloat() * 0.06 - 0.03, vel.z * -0.2 + random.nextFloat() * 0.06 - 0.03);
            }
        }
        super.tick();
    }
}