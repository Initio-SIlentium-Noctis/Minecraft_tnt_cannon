package net.Non.tntcannon.Item.weapons;

import net.Non.tntcannon.entities.projectiles.CannonBallEntity;
import net.Non.tntcannon.registries.ModEnchantments;
import net.Non.tntcannon.registries.ModItems;
import net.Non.tntcannon.registries.ModProjectiles;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.stat.Stats;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import java.util.function.Predicate;


public class TntCannonItem extends RangedWeaponItem {

    private static final Predicate<ItemStack> AMMO = (stack) -> {
        return stack.getItem().equals(Items.GUNPOWDER) || stack.getItem().equals(Items.TNT) || stack.getItem().equals(ModItems.CANNON_BALL) || stack.getItem().equals(Items.FIRE_CHARGE);
    };

    public TntCannonItem(Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return AMMO;
    }

    @Override
    public int getRange() {
        return 15;
    }

    public boolean isEnchantable(ItemStack stack) {
        return true;
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        ItemStack stack = player.getStackInHand(hand);
        ItemStack ammo = player.getArrowType(stack);

        if (hand.equals(Hand.MAIN_HAND)) {
            if (!ammo.isEmpty() || player.isCreative()) {
                int volatilePowderLevel = EnchantmentHelper.getLevel(ModEnchantments.VOLATILE_GUNPOWDER_ENCHANTMENT, stack);
                int sturdyFootingLevel = EnchantmentHelper.getLevel(ModEnchantments.STURDY_FOOTING_ENCHANTMENT, stack);
                int shortFuseLevel = EnchantmentHelper.getLevel(ModEnchantments.SHORT_FUSE_ENCHANTMENT, stack);

                if (ammo.isEmpty()) {
                    new ItemStack(Items.GUNPOWDER);
                }

                Vec3d target = player.getPos();
                Vec3d targetLook = player.getRotationVector();

                if (!world.isClient()) {
                    world.createExplosion(player, target.getX(), target.getY() + 1.0, target.getZ(), 1.5F * (1.0F + (float) volatilePowderLevel / 3.0F), Explosion.DestructionType.NONE);
                    if (ammo.getItem().equals(Items.TNT)) {
                        TntEntity tnt = new TntEntity(world, target.getX(), target.getY(), target.getZ(), player);
                        if (shortFuseLevel > 0) {
                            tnt.setFuse(40);
                        } else tnt.setFuse(60);
                        tnt.setPos(target.getX(), target.getY() + 1.0, target.getZ());
                        tnt.addVelocity(targetLook.getX() * (1.0 + (double) volatilePowderLevel / 6.0), targetLook.getY() * (1.0 + (double) volatilePowderLevel / 6.0), targetLook.getZ() * (1.0 + (double) volatilePowderLevel / 6.0));
                        world.spawnEntity(tnt);
                    }
                    if (ammo.getItem().equals(ModItems.CANNON_BALL)) {
                        CannonBallEntity ball = new CannonBallEntity(ModProjectiles.CANNON_BALL_ENTITY_TYPE, world);
                        ball.setPos(target.getX(), target.getY() + 1.0, target.getZ());
                        ball.addVelocity(targetLook.getX() * (2.0 + (double) volatilePowderLevel / 6.0), targetLook.getY() * (2.0 + (double) volatilePowderLevel / 6.0), targetLook.getZ() * (2.0 + (double) volatilePowderLevel / 6.0));
                        world.spawnEntity(ball);
                    }
                    if (ammo.getItem().equals(Items.FIRE_CHARGE)) {
                        FireballEntity fireball = new FireballEntity(world, player, 0.0, 0.0, 0.0, volatilePowderLevel);
                        fireball.setPos(target.getX(), target.getY() + 1.0, target.getZ());
                        fireball.powerX = targetLook.getX() / 2.0;
                        fireball.powerY = targetLook.getY() / 2.0;
                        fireball.powerZ = targetLook.getZ() / 2.0;
                        world.spawnEntity(fireball);
                    }
                    ammo.decrement(1);
                    if (ammo.isEmpty()) {
                        player.getInventory().removeOne(ammo);
                    }
                }

                if (volatilePowderLevel > 0) {
                    player.addVelocity(-targetLook.getX() * (1.0 + (double) volatilePowderLevel / 6.0), -targetLook.getY() * (1.0 + (double) volatilePowderLevel / 6.0), -targetLook.getZ() * (1.0 + (double) volatilePowderLevel / 6.0));
                } else if (sturdyFootingLevel > 0) {
                    player.addVelocity(-targetLook.getX() * (1.0 / Math.pow(2.0, (double) sturdyFootingLevel)), -targetLook.getY() * (1.0 / Math.pow(2.0, (double) sturdyFootingLevel)), -targetLook.getZ() * (1.0 / Math.pow(2.0, (double) sturdyFootingLevel)));
                } else {
                    player.addVelocity(-targetLook.getX(), -targetLook.getY(), -targetLook.getZ());
                }

                player.getItemCooldownManager().set(this, 60 - 30 * EnchantmentHelper.getLevel(ModEnchantments.QUICK_RELOAD_ENCHANTMENT, stack));
                player.incrementStat(Stats.USED.getOrCreateStat(this));
                return TypedActionResult.consume(stack);
            }
            return TypedActionResult.fail(stack);
        } else return TypedActionResult.fail(stack);
    }

}
