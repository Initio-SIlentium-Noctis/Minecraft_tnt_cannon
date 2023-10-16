package net.Non.tntcannon.registries;

import net.Non.tntcannon.entities.projectiles.CannonBallEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

import static net.Non.tntcannon.registries.ModProjectiles.CANNON_BALL_ENTITY_TYPE;

public class ModRenderers {

    public static void register() {
        registerRenderers(CANNON_BALL_ENTITY_TYPE, CannonBallEntityRenderer::new);
    }

    private static <E extends Entity> void registerRenderers(EntityType<? extends E> type, EntityRendererFactory<E> renderer) {
        EntityRendererRegistry.register(type, renderer);
    }

}
