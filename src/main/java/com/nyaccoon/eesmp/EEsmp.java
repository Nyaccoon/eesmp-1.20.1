package com.nyaccoon.eesmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nyaccoon.eesmp.item.ModItems;

import net.fabricmc.api.ModInitializer;
public class EEsmp implements ModInitializer {
	public static final String MOD_ID = "eesmp";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();

		LOGGER.info("Hello Fabric world!");
	}

}
