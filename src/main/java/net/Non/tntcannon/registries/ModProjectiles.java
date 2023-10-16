package net.Non.tntcannon.registries;

import net.Non.tntcannon.entities.projectiles.CannonBallEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.util.registry.Registry;

import static net.Non.tntcannon.TntCannon.identifier;

public class ModProjectiles {

    public static final EntityType<CannonBallEntity> CANNON_BALL_ENTITY_TYPE = FabricEntityTypeBuilder.create(SpawnGroup.MISC, CannonBallEntity::new).dimensions(EntityDimensions.fixed(0.3F, 0.3F)).trackRangeBlocks(4).trackedUpdateRate(10).build();


    public static void register() {
        registerProjectile("cannon_ball_projectile", CANNON_BALL_ENTITY_TYPE);
    }

    private static void registerProjectile(String name, EntityType<? extends Entity> type) {
        Registry.register(Registry.ENTITY_TYPE, identifier(name), type);
    }


}
