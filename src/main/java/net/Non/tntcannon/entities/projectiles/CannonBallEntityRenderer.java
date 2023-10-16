package net.Non.tntcannon.entities.projectiles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;


@Environment(value= EnvType.CLIENT)
public class CannonBallEntityRenderer extends EntityRenderer<CannonBallEntity> {


    private final CannonBallEntityModel model;

    public CannonBallEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new CannonBallEntityModel(CannonBallEntityModel.getTexturedModelData().createModel());
    }

    @Override
    public Identifier getTexture(CannonBallEntity entity) {
        return new Identifier("tntcannon", "textures/entity/projectiles/cannon_ball.png");
    }


    @Override
    public void render(CannonBallEntity entity, float yaw, float tickDelta, net.minecraft.client.util.math.MatrixStack matrices, net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        minecraftClient.getTextureManager().bindTexture(getTexture(entity));
        this.model.setAngles(entity, tickDelta, 0, 0, 0, 0);
        this.model.render(matrices, vertexConsumers.getBuffer(this.model.getLayer(getTexture(entity))), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

}
