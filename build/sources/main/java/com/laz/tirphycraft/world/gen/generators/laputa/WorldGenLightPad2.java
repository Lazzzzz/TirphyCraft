package com.laz.tirphycraft.world.gen.generators.laputa;

import java.util.Random;

import com.laz.tirphycraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenLightPad2 {
    private final Block block = BlockInit.SUN_STONE;
    private final int basePathWidth;

    public WorldGenLightPad2(int basePathWidthIn)
    {
        this.basePathWidth = basePathWidthIn;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        while (worldIn.isAirBlock(position) && position.getY() > 2)
        {
            position = position.down();
        }

        if (worldIn.getBlockState(position).getBlock() != BlockInit.LAPUTA_GRASS)
        {
            return false;
        }
        else
        {
            int i = rand.nextInt(this.basePathWidth - 1) + 2;
            int j = 1;

            for (int k = position.getX() - i; k <= position.getX() + i; ++k)
            {
                for (int l = position.getZ() - i; l <= position.getZ() + i; ++l)
                {
                    int i1 = k - position.getX();
                    int j1 = l - position.getZ();

                    if (i1 * i1 + j1 * j1 <= i * i)
                    {
                        for (int k1 = position.getY() - 1; k1 <= position.getY() + 1; ++k1)
                        {
                            BlockPos blockpos = new BlockPos(k, k1, l);
                            Block block = worldIn.getBlockState(blockpos).getBlock();

                            if (block ==  BlockInit.LAPUTA_DIRT || block ==  BlockInit.LAPUTA_GRASS)
                            {
                                worldIn.setBlockState(blockpos, this.block.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}