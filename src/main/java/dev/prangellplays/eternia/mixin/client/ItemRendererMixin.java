package dev.prangellplays.eternia.mixin.client;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.item.jungle.NaturesUndergrowthItem;
import dev.prangellplays.eternia.item.taiga.FrostboundShieldItem;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(EterniaItems.NATURES_UNDERGROWTH) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND && renderMode != ModelTransformationMode.FIXED) {
            return ((ItemRendererAccessor) this).bread$getModels().getModelManager().getModel(new ModelIdentifier(Eternia.MOD_ID, "natures_undergrowth_handheld", "inventory"));
        }
        if (stack.isOf(EterniaItems.WINDWALKER_BLADE) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND && renderMode != ModelTransformationMode.FIXED) {
            return ((ItemRendererAccessor) this).bread$getModels().getModelManager().getModel(new ModelIdentifier(Eternia.MOD_ID, "windwalker_blade_handheld", "inventory"));
        }
        return value;
    }

    @Inject(method = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V"))
    private void renderItemMixin(@Nullable LivingEntity entity, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, @Nullable World world, int light, int overlay, int seed, CallbackInfo info) {
        if (entity != null && (renderMode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND || renderMode == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND) && entity.isBlocking() && (stack.getItem() instanceof NaturesUndergrowthItem)) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(leftHanded ? -20F : 20F));
        }
        if (entity != null && (renderMode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND || renderMode == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND) && entity.isBlocking() && (stack.getItem() instanceof FrostboundShieldItem)) {
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(leftHanded ? -20F : 20F));
        }
    }
}
