package com.nyaccoon.eesmp.item.customItems;

import java.util.List;

import com.nyaccoon.eesmp.item.ModItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HeartOfZuelia extends Item {
    public HeartOfZuelia(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eesmp.heart_of_zuelia").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFED89D))));
    }
        @Override 
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if( entity.isPlayer()){

           PlayerEntity player = (PlayerEntity)entity;
            if(selected || player.getOffHandStack().isOf(this)) player.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(1),1,1), player);
        }
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = new ItemStack(ModItems.SHARD_OF_SPACE); // creates a new ItemStack instance of the user's itemStack in-hand
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
		
        user.getItemCooldownManager().set(this,200);

		if (!world.isClient) {
			EnderPearlEntity pearl = new EnderPearlEntity(world, user);
            pearl.setItem(itemStack);
            pearl.setVelocity(user,user.getPitch(),user.getYaw(),0.0f,2.25f,0.0f);
            world.spawnEntity(pearl);
		}
 
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		return TypedActionResult.success(new ItemStack(ModItems.HEART_OF_ZUELIA), world.isClient());
	}
}