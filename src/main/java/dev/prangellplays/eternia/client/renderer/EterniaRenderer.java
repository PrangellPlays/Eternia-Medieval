package dev.prangellplays.eternia.client.renderer;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.EterniaClient;
import dev.prangellplays.eternia.client.models.kings_crown.KingsCrownModel;
import dev.prangellplays.eternia.utils.IntToRGB;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.awt.*;

public class EterniaRenderer implements ArmorRenderer {
    private Identifier ARMOR_LAYER_0;
    private Identifier ARMOR_LAYER_1;
    private Identifier ARMOR_LAYER_2;
    private Identifier SCUBA_GEAR;

    private static ArmorEntityModel<LivingEntity> armorModel;
    private static ArmorEntityModel<LivingEntity> legArmorModel;
    private static KingsCrownModel<LivingEntity> kingsCrownModel;

    private final boolean hasVanillaArmorModel;
    private final boolean hasKingsCrown;
    private final boolean dyeable;

    public EterniaRenderer(String cosmeticName, boolean hasVanillaArmorModel, boolean hasKingsCrown, boolean dyeable) {
        ARMOR_LAYER_0 = new Identifier(Eternia.MOD_ID, "textures/models/cosmetics/" + cosmeticName + "_layer_0.png");
        ARMOR_LAYER_1 = new Identifier(Eternia.MOD_ID, "textures/models/cosmetics/" + cosmeticName + "_layer_1.png");
        ARMOR_LAYER_2 = new Identifier(Eternia.MOD_ID, "textures/models/cosmetics/" + cosmeticName + "_layer_2.png");
        SCUBA_GEAR = new Identifier(Eternia.MOD_ID, "textures/models/kings_crown/" + cosmeticName + ".png");

        this.hasVanillaArmorModel = hasVanillaArmorModel;
        this.hasKingsCrown = hasKingsCrown;
        this.dyeable = dyeable;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        armorModel = new ArmorEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER_OUTER_ARMOR));
        legArmorModel = new ArmorEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER_INNER_ARMOR));
        kingsCrownModel = new KingsCrownModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EterniaClient.KINGS_CROWN_MODEL_LAYER));

        if (slot == EquipmentSlot.HEAD) {
            if (hasVanillaArmorModel) {
                contextModel.copyBipedStateTo(armorModel);
                armorModel.setVisible(false);
                armorModel.head.visible = true;
                armorModel.hat.visible = true;
                renderArmor(matrices, vertexConsumers, light, stack, armorModel, ARMOR_LAYER_1, this.dyeable);
            }
            if (hasKingsCrown) {
                contextModel.copyBipedStateTo(kingsCrownModel);
                kingsCrownModel.setVisible(false);
                kingsCrownModel.hat.visible = true;
                renderArmor(matrices, vertexConsumers, light, stack, kingsCrownModel, SCUBA_GEAR, this.dyeable);
            }
        }
    }


    static void renderArmor(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ItemStack stack, Model model, Identifier texture, boolean dyeable){
        if(dyeable){
            renderDyeable(matrices, vertexConsumers, light, stack, model, texture);
            if(!(model == kingsCrownModel)){
                renderDyeable(matrices, vertexConsumers, light, stack, model, new Identifier(Eternia.MOD_ID,
                        texture.getPath().replaceAll(".png", "_overlay.png")));
            }
        } else {
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, model, texture);
        }
    }

    static void renderDyeable(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ItemStack stack, Model model, Identifier texture) {
        VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(texture), false, stack.hasGlint());
        Color rgb = IntToRGB.ex(((DyeableItem)stack.getItem()).getColor(stack));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, rgb.getRed()/255f, rgb.getGreen()/255f, rgb.getBlue()/255f, 1.0F);
    }
}