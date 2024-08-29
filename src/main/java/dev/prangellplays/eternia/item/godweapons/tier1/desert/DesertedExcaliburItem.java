package dev.prangellplays.eternia.item.godweapons.tier1.desert;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.world.World;

import java.util.Random;

public class DesertedExcaliburItem extends SwordItem {
    public DesertedExcaliburItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random roll = new Random();
        if (attacker instanceof PlayerEntity player) {
            if (roll.nextDouble() < 0.34D && !player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                target.setOnFireFor(5);
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 140, 0, false, false, true));
                player.getItemCooldownManager().set(this, 400);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.DESERTED_EXCALIBUR)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, 0, false, false, false));
            }
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.DESERTED_EXCALIBUR) && player.getSteppingBlockState().isIn(BlockTags.SAND)) {
                player.addStatusEffect(new StatusEffectInstance(Eternia.WINDSWEPT, 2, 0, false, false, false));
            }
            super.inventoryTick(stack, world, entity, slot, selected);
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
