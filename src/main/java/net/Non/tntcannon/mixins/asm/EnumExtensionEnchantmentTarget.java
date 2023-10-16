package net.Non.tntcannon.mixins.asm;

import net.Non.tntcannon.Item.weapons.TntCannonItem;
import net.minecraft.item.*;
public class EnumExtensionEnchantmentTarget {

    public static class TntCannon extends EnchantmentTargetExtensible {
        @Override
        public boolean isAcceptableItem(Item item) {
            return item instanceof TntCannonItem;
        }
    }

}
