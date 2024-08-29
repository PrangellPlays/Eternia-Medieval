package dev.prangellplays.eternia.item.godweapons.tier1.desert;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PharaohsStaffItem extends Item {
    public PharaohsStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            MobEntity entity = (MobEntity) ((EntityType<Entity>) EntityType.get("minecraft:husk").get()).create(world);
            entity.setPosition(user.getX(), user.getY(), user.getZ());
            entity.setCustomName(Text.of("Pharaohs Servant"));
            entity.setGlowing(true);
            entity.setSilent(true);
            entity.setPersistent();
            entity.disableExperienceDropping();
            entity.isTeammate(user);
            world.spawnEntity(entity);
            MobEntity entity1 = (MobEntity) ((EntityType<Entity>) EntityType.get("minecraft:husk").get()).create(world);
            entity1.setPosition(user.getX(), user.getY(), user.getZ());
            entity1.setCustomName(Text.of("Pharaohs Servant"));
            entity1.setGlowing(true);
            entity1.setSilent(true);
            entity1.setPersistent();
            entity1.disableExperienceDropping();
            entity1.isTeammate(user);
            world.spawnEntity(entity1);
            MobEntity entity2 = (MobEntity) ((EntityType<Entity>) EntityType.get("minecraft:husk").get()).create(world);
            entity2.setPosition(user.getX(), user.getY(), user.getZ());
            entity2.setCustomName(Text.of("Pharaohs Servant"));
            entity2.setGlowing(true);
            entity2.setSilent(true);
            entity2.setPersistent();
            entity2.disableExperienceDropping();
            entity2.isTeammate(user);
            world.spawnEntity(entity2);
            user.getItemCooldownManager().set(this, 400);
            BlockPos pos = new BlockPos(10, -64, -1);
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.setBlockState(pos, Blocks.REDSTONE_BLOCK.getDefaultState());
        return super.use(world, user, hand);
    }
}
