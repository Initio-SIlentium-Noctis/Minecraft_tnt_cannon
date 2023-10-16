package net.Non.tntcannon.entities.projectiles;

import net.Non.tntcannon.registries.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class CannonBallEntity extends ThrownItemEntity {


    public CannonBallEntity(EntityType<? extends CannonBallEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected ItemStack getItem() {
        return new ItemStack(ModItems.CANNON_BALL);
    }
    @Override
    protected Item getDefaultItem() {
        return ModItems.CANNON_BALL;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 20);
            world.createExplosion(entity, entity.getX(), entity.getY() + 1.0, entity.getZ(), 2.0F, Explosion.DestructionType.NONE);
        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.5F, Explosion.DestructionType.NONE);
            this.discard();
        }
    }

}
