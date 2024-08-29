package dev.prangellplays.eternia.item.godweapons.tier1.taiga;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.entity.projectile.FrostedScytheEntity;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class FrostedScytheItem extends SwordItem {
    public FrostedScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.8F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            FrostedScytheEntity entity = new FrostedScytheEntity(world, user);
            entity.setItem(itemStack);
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 1.0F);
            world.spawnEntity(entity);
            user.getItemCooldownManager().set(this, 400);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(0);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (player.getMainHandStack().isOf(EterniaItems.FROSTED_SCYTHE)) {
                Vec3d pos1 = new Vec3d(entity.getX() - 5, entity.getY() - 5, entity.getZ() - 5);
                Vec3d pos2 = new Vec3d(entity.getX() + 5, entity.getY() + 5, entity.getZ() + 5);
                world.getEntitiesByClass(LivingEntity.class, new Box(pos1, pos2), (livingEntity) -> !livingEntity.equals(entity)).forEach(livingEntity -> {
                    if (!livingEntity.hasStatusEffect(Eternia.FREEZING)) {
                        livingEntity.addStatusEffect(new StatusEffectInstance(Eternia.FREEZING, 60, 0, false, false, false));
                    }
                });
                if (world != null && world.isClient) {
                    Vec3d vel = player.getVelocity();
                    Random random = new Random();
                    for (int i = 0; i < 0.1f; i++) {
                        //North
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 5, player.getY() + 0.5f, player.getZ() + 1, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 5, player.getY() + 0.5f, player.getZ() + 3, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 5, player.getY() + 0.5f, player.getZ() - 1, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 5, player.getY() + 0.5f, player.getZ() - 3, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 5, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);

                        //East
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 1, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 3, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 1, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 3, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 5, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);

                        //South
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 5, player.getY() + 0.5f, player.getZ() + 1, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 5, player.getY() + 0.5f, player.getZ() + 3, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 5, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 5, player.getY() + 0.5f, player.getZ() - 1, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 5, player.getY() + 0.5f, player.getZ() - 3, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 5, player.getY() + 0.5f, player.getZ() - 5, 0, 0, 0);

                        //West
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 1, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() + 3, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 1, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 3, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                        world.addParticle(ParticleTypes.SNOWFLAKE, player.getX() - 5, player.getY() + 0.5f, player.getZ() + 5, 0, 0, 0);
                    }
                }
            }
            super.inventoryTick(stack, world, entity, slot, selected);
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
