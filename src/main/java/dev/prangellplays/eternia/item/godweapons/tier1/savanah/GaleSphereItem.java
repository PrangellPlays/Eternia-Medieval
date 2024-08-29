package dev.prangellplays.eternia.item.godweapons.tier1.savanah;

import dev.prangellplays.eternia.entity.projectile.GaleSphereEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GaleSphereItem extends Item {
    public GaleSphereItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.8F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            GaleSphereEntity entity = new GaleSphereEntity(world, user);
            entity.setItem(itemStack);
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 1.0F);
            world.spawnEntity(entity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(0);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
