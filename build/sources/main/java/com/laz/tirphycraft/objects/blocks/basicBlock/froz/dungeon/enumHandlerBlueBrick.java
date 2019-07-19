package com.laz.tirphycraft.objects.blocks.basicBlock.froz.dungeon;

import net.minecraft.util.IStringSerializable;

public class enumHandlerBlueBrick {

	public static enum EnumType implements IStringSerializable {
		
		VARIANT_0(0, "variant_0"),
		VARIANT_1(1, "variant_1"),
		VARIANT_2(2, "variant_2"),
		VARIANT_3(3, "variant_3"),
		VARIANT_4(4, "variant_4"),
		VARIANT_5(5, "variant_5"),
		VARIANT_6(6, "variant_6"),
		VARIANT_7(7, "variant_7"),
		VARIANT_8(8, "variant_8"),
		VARIANT_9(9, "variant_9"),
		VARIANT_10(10, "variant_10");
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private final int meta;
		private final String name, unlocializedName;
		
		private EnumType(int meta, String name) {
			this(meta, name, name);
			
		}
		
		private EnumType(int meta, String name, String unlocializedName) {
			
			this.meta = meta;
			this.name = name;
			this.unlocializedName = unlocializedName;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getMeta() {
			return this.meta;
		}
		
		public String getUnlocializedName() {
			return this.unlocializedName;
		
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		 public static EnumType byMetadata(int meta) {
			return META_LOOKUP[meta];
			
		}
		 
		 static {
			 for (EnumType enumtype : values() ) {
				 META_LOOKUP[enumtype.getMeta()] = enumtype;
			 }
		 }
		
	}
	
}
