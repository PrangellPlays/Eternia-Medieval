package dev.prangellplays.eternia.mixin.server;

import dev.prangellplays.eternia.Eternia;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {
    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(method = "setTarget", at = @At("HEAD"), argsOnly = true)
    public LivingEntity setTarget(LivingEntity target) {
        if (this.hasStatusEffect(Eternia.FROZEN)) {
            return null;
        }
        return target;
    }
}
