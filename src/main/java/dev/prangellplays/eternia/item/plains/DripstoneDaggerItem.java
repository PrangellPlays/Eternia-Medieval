package dev.prangellplays.eternia.item.plains;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class DripstoneDaggerItem extends SwordItem {
    public DripstoneDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.DRIPSTONE_DAGGER)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2, 1, false, false, false));
                player.addStatusEffect(new StatusEffectInstance(Eternia.DRIPSTONE, 2, 0, false, false, false));
            } else {
                return;
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
    //do not receive damage from falling objects and blocks like gravel, sand and anvils etc
}
