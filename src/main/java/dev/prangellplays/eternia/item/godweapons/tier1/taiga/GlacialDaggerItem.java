package dev.prangellplays.eternia.item.godweapons.tier1.taiga;

import dev.prangellplays.eternia.Eternia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.Random;

public class GlacialDaggerItem extends SwordItem {
    public GlacialDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random roll = new Random();
        if (attacker instanceof PlayerEntity player) {
            if (roll.nextDouble() < 0.34D && !player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                target.addStatusEffect(new StatusEffectInstance(Eternia.FROZEN, 80, 0, false, false, true), attacker);
                player.getItemCooldownManager().set(this, 600);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
