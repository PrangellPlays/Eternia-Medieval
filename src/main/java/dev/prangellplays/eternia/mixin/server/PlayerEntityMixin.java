package dev.prangellplays.eternia.mixin.server;

import com.mojang.authlib.GameProfile;
import dev.prangellplays.eternia.item.godweapons.tier1.jungle.NaturesUndergrowthItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    public PlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(EntityType.PLAYER, world);
    }

    @Override
    public boolean disablesShield() {
        ItemStack itemStack = this.getMainHandStack();
        return super.disablesShield() || itemStack.getItem() instanceof NaturesUndergrowthItem;
    }

}