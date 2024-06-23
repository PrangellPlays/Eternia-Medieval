package dev.prangellplays.eternia.entity.projectile;

import com.google.common.collect.Sets;
import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.registry.EterniaEntityTypes;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CursedArrowEntity extends PersistentProjectileEntity {

    public CursedArrowEntity(EntityType<? extends CursedArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public CursedArrowEntity(World world, double x, double y, double z) {
        super(EterniaEntityTypes.CURSED_ARROW, x, y, z, world);
    }

    public CursedArrowEntity(World world, LivingEntity owner) {
        super(EterniaEntityTypes.CURSED_ARROW, owner, world);
    }

    protected void initDataTracker() {
        super.initDataTracker();
    }

    public void tick() {
        super.tick();
        if (this.age >= 1000) {
            this.discard();
        }
    }

    protected void onHit(LivingEntity target) {
        LivingEntity attacker;
        super.onHit(target);
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 0.25f, World.ExplosionSourceType.NONE);
        target.addStatusEffect(new StatusEffectInstance(Eternia.CURSED, 40, 0, false, false, true));
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 0.5f, World.ExplosionSourceType.NONE);
        super.onBlockHit(blockHitResult);
    }

    protected ItemStack asItemStack() {
        return new ItemStack(EterniaItems.CURSED_ARROW);
    }
}