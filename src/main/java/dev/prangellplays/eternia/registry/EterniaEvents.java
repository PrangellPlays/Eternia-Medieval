package dev.prangellplays.eternia.registry;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class EterniaEvents {

    public static final Event<ShieldBlocked> SHIELD_BLOCKED = EventFactory.createArrayBacked(ShieldBlocked.class, callbacks -> (user, damageSource, amount) -> {
        for (var callback : callbacks) {
            callback.shieldBlocked(user, damageSource, amount);
        }
    });

    @FunctionalInterface
    public interface ShieldBlocked {
        void shieldBlocked(PlayerEntity user, DamageSource damageSource, float amount);
    }
}
