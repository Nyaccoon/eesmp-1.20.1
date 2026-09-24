package com.nyaccoon.eesmp.item;
import com.nyaccoon.eesmp.EEsmp;
import com.nyaccoon.eesmp.item.custom.ShardOfLife;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems{
    public static final Item SHARD_OF_LIFE = registerItem("shard_of_life", new ShardOfLife(new Item.Settings().rarity(Rarity.EPIC).maxCount(1))); 

    /*private static void addItemToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.add(SHARD_OF_LIFE);
        // Add the item to the ingredients item group
        // This is a placeholder for the actual implementation
    }*/

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(EEsmp.MOD_ID, name), item);
    }
    
    public static void registerModItems(){
        EEsmp.LOGGER.info("Registering mod items for " + EEsmp.MOD_ID );
       //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientsItemGroup);
    }
}

