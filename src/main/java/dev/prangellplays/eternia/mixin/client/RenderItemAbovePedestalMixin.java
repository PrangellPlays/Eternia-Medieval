package dev.prangellplays.eternia.mixin.client;

import dev.prangellplays.eternia.block.PedestalBlock;
import dev.prangellplays.eternia.block.entity.PedestalBlockEntity;
import dev.prangellplays.eternia.utils.MapUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("all")
@Mixin(ChestBlockEntityRenderer.class)
public class RenderItemAbovePedestalMixin <T extends BlockEntity> {
    @Inject(at = @At("TAIL"), method = "render")
    private void renderItemAbovePedestalMixin(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexCosnumers, int light, int overlay, CallbackInfo info) {
        renderItem(entity, tickDelta, matrices, vertexCosnumers, light, overlay);
    }

    public void renderItem(T blockEntity, float tickDelta,MatrixStack matrices, VertexConsumerProvider vertexCosnumers, int light, int overlay){
        World world = blockEntity.getWorld();
        if(world == null || blockEntity.isRemoved()) return;

        BlockState state = world.getBlockState(blockEntity.getPos());
        if(!(state.getBlock() instanceof PedestalBlock)) return;

        PedestalBlock block = (PedestalBlock)state.getBlock();

        PedestalBlockEntity pedestalBlockEntity = (PedestalBlockEntity) blockEntity;

        MinecraftClient minecraft = MinecraftClient.getInstance();

        ItemStack activeItem = MapUtils.pedestals.get(pedestalBlockEntity.getPos());

        if(activeItem == null) return;

        if(!pedestalBlockEntity.canPlayerUse(minecraft.player)) return;

        matrices.push();

        BakedModel model = minecraft.getItemRenderer().getModel(activeItem, world, null, 0);
        Vector3f translate = model.getTransformation().ground.translation;

        double yPos = activeItem.getItem() instanceof BlockItem ? 0.9 : 1.1;

        boolean blockAbove = !world.getBlockState(pedestalBlockEntity.getPos().up()).isAir();

        yPos = blockAbove ? yPos-0.8 : yPos;

        double offset = blockAbove ? -0.8 : 0;

        float size = activeItem.getItem() instanceof BlockItem ? 1.5f : 1.25f;
                matrices.translate(translate.x() + 0.5 + offset, translate.y() + yPos, translate.z() + 0.5);

        matrices.scale(size, size, size);

        int age = getAge();
        float rotation = ((age + tickDelta) / 25.0f + 6.0f) * 100;
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        minecraft.getItemRenderer().renderItem(activeItem, ModelTransformationMode.GROUND, false, matrices, vertexCosnumers, light, overlay, model);
        matrices.pop();
    }

    private int getAge(){
        return (int)(MinecraftClient.getInstance().world.getTime() % 314);
    }
}