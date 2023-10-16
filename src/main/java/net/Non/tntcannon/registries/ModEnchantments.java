package net.Non.tntcannon.registries;

import net.Non.tntcannon.enchantment.QuickReloadEnchantment;
import net.Non.tntcannon.enchantment.ShortFuseEnchantment;
import net.Non.tntcannon.enchantment.SturdyFootingEnchantment;
import net.Non.tntcannon.enchantment.VolatileGunPowderEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;

import static net.Non.tntcannon.TntCannon.identifier;

public class ModEnchantments {

    public static final Enchantment QUICK_RELOAD_ENCHANTMENT = new QuickReloadEnchantment(Enchantment.Rarity.RARE);
    public static final Enchantment STURDY_FOOTING_ENCHANTMENT = new SturdyFootingEnchantment(Enchantment.Rarity.UNCOMMON);
    public static final Enchantment VOLATILE_GUNPOWDER_ENCHANTMENT = new VolatileGunPowderEnchantment(Enchantment.Rarity.UNCOMMON);
    public static final Enchantment SHORT_FUSE_ENCHANTMENT = new ShortFuseEnchantment(Enchantment.Rarity.UNCOMMON);

    public static void register() {
        registerEnchantment("quick_reload", QUICK_RELOAD_ENCHANTMENT);
        registerEnchantment("sturdy_footing", STURDY_FOOTING_ENCHANTMENT);
        registerEnchantment("volatile_gunpowder", VOLATILE_GUNPOWDER_ENCHANTMENT);
        registerEnchantment("short_fuse", SHORT_FUSE_ENCHANTMENT);
    }

    private static void registerEnchantment(String name, Enchantment enchantment) {
        Registry.register(Registry.ENCHANTMENT, identifier(name), enchantment);
        enchantment.getMinLevel();
        enchantment.getMaxLevel();
    }

}
