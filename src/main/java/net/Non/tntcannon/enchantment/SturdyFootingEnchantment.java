package net.Non.tntcannon.enchantment;

import net.Non.tntcannon.registries.ModEnchantmentTargets;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;

public class SturdyFootingEnchantment extends Enchantment {

    public SturdyFootingEnchantment(Enchantment.Rarity weight) {
        super(weight, ModEnchantmentTargets.TNT_CANNON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinPower(int enchantmentLevel) {
        return super.getMinPower(enchantmentLevel);
    }
    @Override
    public int getMaxPower(int enchantmentLevel) {
        return this.getMinPower(enchantmentLevel) + 15;
    }
    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }
    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }
    @Override
    protected boolean canAccept(Enchantment ench) {
        return this != ench && ench.type != ModEnchantmentTargets.TNT_CANNON;
    }
}
