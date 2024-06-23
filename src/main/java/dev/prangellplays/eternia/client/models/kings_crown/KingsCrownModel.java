package dev.prangellplays.eternia.client.models.kings_crown;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.LivingEntity;

public class KingsCrownModel<T extends LivingEntity> extends BipedEntityModel<T> {
	private final ModelPart kings_crown;

	public KingsCrownModel(ModelPart root) {
		super(root);
		kings_crown = root.getChild("hat").getChild("kings_crown");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		Dilation dilation = new Dilation(0.0F);

		ModelPartData hat = modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		hat.addChild("kings_crown", ModelPartBuilder.create()
						.uv(0, 13).cuboid(-6.0F, -2.0F, -9.1F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(0, 10).cuboid(-6.0F, -2.0F, 0.1F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(0, 0).cuboid(-10.1F, -2.0F, -5.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
						.uv(0, 4).cuboid(-0.9F, -2.0F, -5.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
						.uv(10, 3).cuboid(-10.0F, -2.0F, -9.0F, 10.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(10, 15).cuboid(-7.0F, 0.0F, -9.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(10, 6).cuboid(-7.0F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(16, 6).cuboid(-1.0F, 0.0F, -6.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
						.uv(10, 10).cuboid(-10.0F, 0.0F, -6.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
						.uv(0, 10).cuboid(-1.0F, -2.0F, -8.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F))
						.uv(0, 0).cuboid(-10.0F, -2.0F, -8.0F, 1.0F, 2.0F, 8.0F, new Dilation(0.0F))
						.uv(22, 17).cuboid(-10.0F, -4.0F, -9.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(22, 6).cuboid(-1.0F, -4.0F, -9.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(20, 20).cuboid(-1.0F, -4.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(16, 20).cuboid(-10.0F, -4.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(8, 23).cuboid(-8.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(4, 16).cuboid(-10.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(0, 16).cuboid(-10.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(4, 23).cuboid(-5.0F, -3.0F, -9.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(0, 23).cuboid(-6.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(20, 14).cuboid(-6.0F, -4.0F, -9.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(0, 20).cuboid(-10.0F, -4.0F, -5.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(18, 17).cuboid(-10.0F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(4, 0).cuboid(-1.0F, -3.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(10, 10).cuboid(-1.0F, -4.0F, -4.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(4, 4).cuboid(-1.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
						.uv(16, 11).cuboid(-1.0F, -4.0F, -7.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(20, 11).cuboid(-5.0F, -4.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(12, 20).cuboid(-3.0F, -4.0F, -9.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(4, 20).cuboid(-3.0F, -4.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(8, 20).cuboid(-8.0F, -4.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
						.uv(10, 0).cuboid(-10.0F, -2.0F, 0.0F, 10.0F, 2.0F, 1.0F, new Dilation(0.0F)),
		ModelTransform.pivot(5.0F, -7.0F, 4.0F));

		modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}