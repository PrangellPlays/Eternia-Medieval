package dev.prangellplays.eternia.mixin.client;

import dev.prangellplays.eternia.block.PedestalBlock;
import dev.prangellplays.eternia.utils.MapUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("all")
@Mixin(HandledScreen.class)
public class UpdateRenderOnPedestalScreenMixin<T extends ScreenHandler>{

    HandledScreen screen = ((HandledScreen)(Object)this);
    @Shadow
    @Final
    T handler;
    PlayerInventory inventory;
    BlockPos pedestalPos = null;

    @Inject(at = @At("TAIL"), method = "<init>")
    public void init(T handler, PlayerInventory inventory, Text title, CallbackInfo info) {
        this.inventory = inventory;
    }

    @Inject(at = @At("HEAD"), method = "render")
    private void updateRenderOnPedestalScreenMixin(DrawContext matrices, int mouseX, int mouseY, float delta, CallbackInfo info) {
        if(handler instanceof GenericContainerScreenHandler){
            ItemStack toRender = MapUtils.getMostCommonItemStack(((GenericContainerScreenHandler)handler).getInventory());

            HitResult hit = inventory.player.raycast(5, delta, false);

            if(hit instanceof BlockHitResult hitResult){
                pedestalPos = hitResult.getBlockPos();

                BlockState state = MinecraftClient.getInstance().world.getBlockState(pedestalPos);
                if(state.getBlock() instanceof PedestalBlock block){
                        MapUtils.lastOpened = pedestalPos;
                        MapUtils.pedestals.put(pedestalPos, toRender);

                }
            }
        }
    }
}