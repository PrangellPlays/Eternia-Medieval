package dev.prangellplays.eternia.item.item.spawn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class VillagerSpawnItem extends Item {
    public VillagerSpawnItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Entity entity = ((EntityType<Entity>) EntityType.get("minecraft:villager").get()).create(world);
        entity.setPosition(user.getX(), user.getY(), user.getZ());
        world.spawnEntity(entity);
        if (user.getMainHandStack().isOf(this)) {
            user.getMainHandStack().decrement(1);
        } else if (user.getOffHandStack().isOf(this)) {
            user.getOffHandStack().decrement(1);
        }
        return super.use(world, user, hand);
    }
}
