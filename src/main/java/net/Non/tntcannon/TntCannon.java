package net.Non.tntcannon;

import net.Non.tntcannon.registries.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;


public class TntCannon implements ModInitializer, ClientModInitializer, Runnable {

	public static final String MOD_ID = "tntcannon";

	public static Identifier identifier(String string)
	{
		return new Identifier(MOD_ID, string);
	}

	@Override
	public void run() {
		ModEnchantmentTargets.initialize();
	}

	@Override
	public void onInitialize() {
		ModEnchantmentTargets.register();
		ModEnchantments.register();
		ModItems.register();
		ModProjectiles.register();
	}

	@Override
	public void onInitializeClient() {
		ModRenderers.register();
	}



}
