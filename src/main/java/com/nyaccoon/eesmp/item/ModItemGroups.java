package com.nyaccoon.eesmp.item;

import com.nyaccoon.eesmp.EEsmp;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ElementalEthereumGroup = Registry.register(Registries.ITEM_GROUP, Identifier.of(EEsmp.MOD_ID, "elemental_ethereum_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.elemental_ethereum_group"))
                    .icon(() -> new ItemStack(ModItems.SHARD_OF_LIFE)).entries((displayContext,entries) -> {
                        entries.add(ModItems.SHARD_OF_LIFE);
                    }).build());

    public static void registerItemGroups() {
        // This method can be used to register custom item groups if needed

        EEsmp.LOGGER.info("registering item groups for " + EEsmp.MOD_ID );
    }
}
