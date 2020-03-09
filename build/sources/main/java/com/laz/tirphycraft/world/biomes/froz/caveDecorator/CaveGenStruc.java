package com.laz.tirphycraft.world.biomes.froz.caveDecorator;

import java.util.Random;

import com.laz.tirphycraft.world.gen.generators.froz.GenFrozRuinsTemplate;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CaveGenStruc {
	public GenFrozRuinsTemplate [] struct = new GenFrozRuinsTemplate [] {
			new GenFrozRuinsTemplate("underground_01"),
			new GenFrozRuinsTemplate("underground_02"),
			new GenFrozRuinsTemplate("underground_03"),
			new GenFrozRuinsTemplate("underground_04"),
			new GenFrozRuinsTemplate("underground_05"),
			new GenFrozRuinsTemplate("underground_06"),
			new GenFrozRuinsTemplate("underground_07"),
			new GenFrozRuinsTemplate("underground_08"),
			new GenFrozRuinsTemplate("underground_09"),
			new GenFrozRuinsTemplate("underground_10"),
			new GenFrozRuinsTemplate("underground_11"),
			new GenFrozRuinsTemplate("underground_12")
			
	};
	
	public void generate(World world, BlockPos pos, Random rand){
			struct[rand.nextInt(struct.length)].generate(world, rand, pos);
		
		
	}
	
	
}
