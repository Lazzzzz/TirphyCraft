package com.laz.tirphycraft.entity.trade;

import java.util.Random;

import com.laz.tirphycraft.init.ItemInit;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class customTrade {
    public static class TradeQueenHeartExplosionCore implements ITradeList
    {
        public ItemStack stack;
        public EntityVillager.PriceInfo priceInfo;

        public TradeQueenHeartExplosionCore()
        {
            stack = new ItemStack(ItemInit.EXPLOSION_CORE, 4);
            priceInfo = new PriceInfo(1, 1);
        }

        @Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
            }

            ItemStack stackToPay = new ItemStack(ItemInit.QUEEN_HEART, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, stack));
            System.out.println("add TradeQueenHeartExplosionCore");
        }
    }
    
    public static class TradeAnkhLifeCore implements ITradeList
    {
        public ItemStack stack;
        public EntityVillager.PriceInfo priceInfo;

        public TradeAnkhLifeCore()
        {
            stack = new ItemStack(ItemInit.LIFE_CORE, 4);
            priceInfo = new PriceInfo(1, 1);
        }

        @Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
            }

            ItemStack stackToPay = new ItemStack(ItemInit.ANKH, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, stack));
            System.out.println("add TradeAnkhLifeCore");
        }
    }
    
    public static class TradeHarpSeaCore implements ITradeList
    {
        public ItemStack stack;
        public EntityVillager.PriceInfo priceInfo;

        public TradeHarpSeaCore()
        {
            stack = new ItemStack(ItemInit.SEA_CORE, 4);
            priceInfo = new PriceInfo(1, 1);
        }

        @Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
            }

            ItemStack stackToPay = new ItemStack(ItemInit.POSEIDON_EYE, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, stack));
            System.out.println("add TradeHarpSeaCore");
        }
    }
}
