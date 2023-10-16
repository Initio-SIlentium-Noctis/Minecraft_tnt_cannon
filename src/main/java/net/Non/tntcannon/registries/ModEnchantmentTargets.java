package net.Non.tntcannon.registries;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.enchantment.EnchantmentTarget;

public class ModEnchantmentTargets {

    public static EnchantmentTarget TNT_CANNON;

    public static void initialize() {

        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String enchantmentTarget = remapper.mapClassName("intermediary", "net.minecraft.class_1886");

        ClassTinkerers.enumBuilder(enchantmentTarget).addEnumSubclass("NON$TNT_CANNON", "net.Non.tntcannon.mixins.asm.EnumExtensionEnchantmentTarget$TntCannon").build();

    }

    public static void register() {
        TNT_CANNON = ClassTinkerers.getEnum(EnchantmentTarget.class, "NON$TNT_CANNON");
    }



}
