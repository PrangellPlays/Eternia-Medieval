package dev.prangellplays.eternia.item.godweapons.event;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class SoulstealerItem extends SwordItem {
    public SoulstealerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        if (!world.isClient && mainHand == this) {
            if (target instanceof PlayerEntity player) {
                if (player.isDead()) {
                    EntityAttributeInstance health = attacker.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH);
                    double current = health.getBaseValue();
                    double finalHealth = current + 2;

                    if (finalHealth >= 41) {
                        return false;
                    } else if (finalHealth <= 0) {
                        return false;
                    } else {

                        health.setBaseValue(finalHealth);
                    }
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
