package dev.prangellplays.eternia.mixin.server;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.item.jungle.NaturesUndergrowthItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("all")
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow
    public float prevHeadYaw;
    float stuckYaw = 0;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow
    public abstract void heal(float amount);

    @Shadow
    @Nullable
    public abstract StatusEffectInstance getStatusEffect(StatusEffect effect);

    @Shadow
    public abstract boolean damage(DamageSource source, float amount);

    @Inject(method = "canSee", at = @At("HEAD"), cancellable = true)
    public void canSee(Entity entity, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (Eternia.isFrozen((LivingEntity) (Object) this)) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo callbackInfo) {
        if (Eternia.isFrozen((LivingEntity) (Object) this)) {
            this.setPitch(90);
            this.prevPitch = 90;
            this.setHeadYaw(stuckYaw);
            this.prevHeadYaw = stuckYaw;
            this.setYaw(stuckYaw);
            this.setSneaking(false);
            this.setSprinting(false);
        } else {
            this.stuckYaw = this.getYaw();
        }

        if (this.hasStatusEffect(Eternia.BLEED) && (this.age % (20 / (MathHelper.clamp(this.getStatusEffect(Eternia.BLEED).getAmplifier() + 1, 1, 20))) == 0)) {
            this.damage(getDamageSources().eSources().bleed(), 1.5f);
            this.timeUntilRegen = 0;
        }
        if (this.hasStatusEffect(Eternia.POISON_IVY) && (this.age % (20 / (MathHelper.clamp(this.getStatusEffect(Eternia.POISON_IVY).getAmplifier() + 1, 1, 20))) == 0)) {
            this.damage(getDamageSources().eSources().poison_ivy(), 2);
            this.timeUntilRegen = 0;
        }
        if (this.hasStatusEffect(Eternia.FREEZING) && (this.age % (20 / (MathHelper.clamp(this.getStatusEffect(Eternia.FREEZING).getAmplifier() + 1, 1, 20))) == 0)) {
            this.damage(getDamageSources().eSources().freeze(), 2);
            this.timeUntilRegen = 0;
        }
        if (this.hasStatusEffect(Eternia.STRANGLED) && (this.age % (20 / (MathHelper.clamp(this.getStatusEffect(Eternia.STRANGLED).getAmplifier() + 1, 1, 20))) == 0)) {
            this.damage(getDamageSources().eSources().strangled(), 2);
            this.timeUntilRegen = 0;
        }
        if (this.hasStatusEffect(Eternia.SLAMMED) && (this.age % (20 / (MathHelper.clamp(this.getStatusEffect(Eternia.SLAMMED).getAmplifier() + 1, 1, 20))) == 0)) {
            this.damage(getDamageSources().eSources().slammed(), 2);
            this.timeUntilRegen = 0;
        }
        if (this.hasStatusEffect(Eternia.FROZEN) && this.age % (40 / (MathHelper.clamp(this.getStatusEffect(Eternia.FROZEN).getAmplifier() + 1, 1, 40))) == 0) {
            //this.heal(1);
        }
    }

    @Inject(method = "Lnet/minecraft/entity/LivingEntity;getHandSwingDuration()I", at = @At("HEAD"), cancellable = true)
    private void getHandSwingDuration(CallbackInfoReturnable<Integer> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandStack();
        if (itemStack.getItem() instanceof NaturesUndergrowthItem) {
            info.setReturnValue(10);
        }
    }

    // Items can not block projectiles
    @Inject(method = "blockedByShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;getPierceLevel()B"), cancellable = true)
    private void blockedByShieldMixin(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandStack();
        if (itemStack.getItem() instanceof NaturesUndergrowthItem) {
            info.setReturnValue(false);
        }
    }

    @Inject(method = "blockedByShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;dotProduct(Lnet/minecraft/util/math/Vec3d;)D", shift = At.Shift.AFTER), cancellable = true)
    private void blockedByShieldDamageWeaponMixin(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getActiveItem();
        if (itemStack.getItem() instanceof NaturesUndergrowthItem) {
            if (livingEntity instanceof PlayerEntity) {
                ((PlayerEntity) livingEntity).getItemCooldownManager().set(itemStack.getItem(), 60);
            }
            livingEntity.clearActiveItem();
            if (!this.getWorld().isClient()) {
                livingEntity.getMainHandStack().damage(1, livingEntity, (p) -> p.sendToolBreakStatus(p.getActiveHand()));
            }
        }
    }
}
