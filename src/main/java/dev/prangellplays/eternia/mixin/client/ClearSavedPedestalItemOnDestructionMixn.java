package dev.prangellplays.eternia.mixin.client;

import dev.prangellplays.eternia.utils.MapUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class ClearSavedPedestalItemOnDestructionMixn {
    @Inject(at = @At("HEAD"), method = "onBroken")
    public void ClearSavedPedestalItemOnDestruction(WorldAccess world, BlockPos pos, BlockState state, CallbackInfo info) {
        if(world.isClient()){
            MapUtils.pedestals.remove(pos);
        }
    }
}
