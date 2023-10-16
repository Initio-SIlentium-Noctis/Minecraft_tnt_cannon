package net.Non.tntcannon.registries;

import net.Non.tntcannon.Item.ammo.CannonBallItem;
import net.Non.tntcannon.Item.weapons.TntCannonItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static net.Non.tntcannon.TntCannon.identifier;

public class ModItems {

    public static final Item TNT_CANNON = new TntCannonItem(new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item CANNON_BALL = new CannonBallItem(new FabricItemSettings().group(ItemGroup.COMBAT));


    public static void register() {
        registerItem("tnt_cannon", TNT_CANNON);
        registerItem("cannon_ball", CANNON_BALL);
    }

    private static void registerItem(String name, Item item) {
        Registry.register(Registry.ITEM, identifier(name), item);
    }

}
