package com.nyaccoon.eesmp.item;
import com.nyaccoon.eesmp.EEsmp;
import com.nyaccoon.eesmp.item.custom.HeartOfIrellia;
import com.nyaccoon.eesmp.item.custom.HeartOfReality;
import com.nyaccoon.eesmp.item.custom.HeartOfZuelia;
import com.nyaccoon.eesmp.item.custom.ShardOfDeath;
import com.nyaccoon.eesmp.item.custom.ShardOfDreams;
import com.nyaccoon.eesmp.item.custom.ShardOfLife;
import com.nyaccoon.eesmp.item.custom.ShardOfReality;
import com.nyaccoon.eesmp.item.custom.ShardOfSpace;
import com.nyaccoon.eesmp.item.custom.ShardOfTime;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems{
    //shards
    public static final Item SHARD_OF_LIFE = registerItem("shard_of_life", new ShardOfLife(new Item.Settings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item SHARD_OF_DEATH = registerItem("shard_of_death", new ShardOfDeath(new Item.Settings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item SHARD_OF_DREAMS = registerItem("shard_of_dreams", new ShardOfDreams(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SHARD_OF_REALITY = registerItem("shard_of_reality", new ShardOfReality(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item SHARD_OF_TIME = registerItem("shard_of_time", new ShardOfTime(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)));
    public static final Item SHARD_OF_SPACE = registerItem("shard_of_space", new ShardOfSpace(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)));

    //hearts
    public static final Item HEART_OF_IRELLIA = registerItem("heart_of_irellia", new HeartOfIrellia(new Item.Settings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item HEART_OF_ZUELIA = registerItem("heart_of_zuelia", new HeartOfZuelia(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)));
    public static final Item HEART_OF_REALITY = registerItem("heart_of_reality", new HeartOfReality(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1)));

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(EEsmp.MOD_ID, name), item);
    }
    
    public static void registerModItems(){
        EEsmp.LOGGER.info("Registering mod items for " + EEsmp.MOD_ID );
    }
}

