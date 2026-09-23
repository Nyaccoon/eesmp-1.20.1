package com.nyaccoon.eesmp.item;

import com.nyaccoon.eesmp.EEsmp;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems{
    public static final Item SHARD_OF_LIFE = registerItem("shard_of_life", new Item(new Item.Settings())); 

    private static void addItemToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.add(SHARD_OF_LIFE);
        // Add the item to the ingredients item group
        // This is a placeholder for the actual implementation
    }

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(EEsmp.MOD_ID, name), item);
    }
    
    public static void registerModItems(){
        EEsmp.LOGGER.info("Registering mod items for " + EEsmp.MOD_ID );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientsItemGroup);
    }
}

