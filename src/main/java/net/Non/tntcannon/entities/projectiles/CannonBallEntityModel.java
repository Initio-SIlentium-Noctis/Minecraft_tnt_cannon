package net.Non.tntcannon.entities.projectiles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class CannonBallEntityModel extends EntityModel<CannonBallEntity> {

    private final ModelPart bb_main;
    public CannonBallEntityModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-10.5F, -6.0F, 5.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
                .uv(9, 11).cuboid(-9.5F, -7.0F, 6.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-9.5F, -1.0F, 6.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 14).cuboid(-5.5F, -5.0F, 6.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(8, 15).cuboid(-11.5F, -5.0F, 6.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(13, 15).cuboid(-9.5F, -5.0F, 4.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(16, 17).cuboid(-9.5F, -3.0F, 4.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 2).cuboid(-9.5F, -4.0F, 4.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-7.5F, -4.0F, 4.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(15, 0).cuboid(-9.5F, -5.0F, 10.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 5.6F, -8.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(CannonBallEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

}
