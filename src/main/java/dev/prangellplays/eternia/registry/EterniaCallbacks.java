package dev.prangellplays.eternia.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.random.Random;
import org.joml.Vector3d;

public class EterniaCallbacks {

    public static void init() {
        EterniaEvents.SHIELD_BLOCKED.register(EterniaCallbacks::onShieldBlock);
        //EterniaEvents.SHIELD_DISABLED.register(EterniaCallbacks::onShieldDisabled);
    }

    // Logic for blocking
    private static void onShieldBlock(PlayerEntity user, DamageSource source, float amount) {
        Entity sourceEntity = source.getSource();
        if (sourceEntity instanceof LivingEntity attacker) blockLivingEntity(user, attacker);
        if (sourceEntity instanceof ProjectileEntity projectile) blockProjectile(user, source.getSource(), projectile);
    }

    // Logic for blocking a living entity
    private static void blockLivingEntity(PlayerEntity user, LivingEntity attacker) {
        handleSpikes(user, attacker);
    }

    // Logic for blocking a projectile
    private static void blockProjectile(PlayerEntity user, Entity damageCauser, ProjectileEntity projectile) {

        Vector3d motion = new Vector3d(user.getX() - damageCauser.getX(), 0.0f, user.getZ() - damageCauser.getZ()).absolute();
        projectile.setVelocity(motion.x(), -1.5f, motion.z());
    }

    private static void handleSpikes(PlayerEntity user, LivingEntity attacker) {
        Random random = user.getRandom();
        float damage = 2.0f;
        float chance = 1.0f;

        if ((random.nextFloat() <= chance && chance > 0.0f)) {
            attacker.damage(attacker.getDamageSources().thorns(user), damage);
        }
    }
}
