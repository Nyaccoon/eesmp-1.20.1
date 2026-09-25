package com.nyaccoon.eesmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nyaccoon.eesmp.item.ModItemGroups;
import com.nyaccoon.eesmp.item.ModItems;
import com.nyaccoon.eesmp.item.customItems.HeartOfIrellia;
import com.nyaccoon.eesmp.item.customItems.ShardOfDeath;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.ActionResult;
public class EEsmp implements ModInitializer {
	public static final String MOD_ID = "eesmp";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		AttackEntityCallback.EVENT.register(
			(player,world,hand,entity,hit) ->{

				if((player.getMainHandStack().getItem() instanceof ShardOfDeath || player.getMainHandStack().getItem() instanceof HeartOfIrellia) || (player.getOffHandStack().getItem() instanceof ShardOfDeath || player.getOffHandStack().getItem() instanceof HeartOfIrellia) ){
					if(entity.isAlive()) ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(20),800,1));
					return ActionResult.PASS;
				}
				return ActionResult.PASS;
				
			}
		);

		LOGGER.info("Hello Fabric world!");
	}

}
