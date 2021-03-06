package com.laz.tirphycraft.gosyn.common.world.gen.stage1.structures;

import java.util.Random;

import com.laz.tirphycraft.gosyn.common.world.gen.stage1.structures.part.FortnestConnector;
import com.laz.tirphycraft.gosyn.common.world.gen.stage1.structures.part.FortnestStairs;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FortnestMazePlacer {

	int size = 12;

	public void generateMaze(World world, BlockPos pos) {

		MazeGenerator[] mazeList =

				{ new MazeGenerator(size, size), new MazeGenerator(size, size), new MazeGenerator(size, size),
						new MazeGenerator(size, size) };

		for (int m = 0; m < mazeList.length; m++) {

			MazeGenerator maze = mazeList[m];

			char[][] grid = maze.getGrid();

			for (int i = 1; i < grid.length - 2; i++) {
				for (int j = 1; j < grid[i].length - 2; j++) {
					String q = Character.toString(grid[i][j]);

					if (q.equals(".")) {

						boolean[] walls = { false, false, false, false };
						if (!Character.toString(grid[i - 1][j]).equals(".")) {
							walls[0] = true;
						}
						if (!Character.toString(grid[i + 1][j]).equals(".")) {
							walls[1] = true;
						}
						if (!Character.toString(grid[i][j - 1]).equals(".")) {
							walls[2] = true;
						}
						if (!Character.toString(grid[i][j + 1]).equals(".")) {
							walls[3] = true;
						}

						new FortnestConnector().generate(world, new Random(), pos.add(i * 8, m * 5, j * 8), walls);

					}
				}
			}
		}
		
		placeStairs(world, pos, mazeList);
	}

	public void placeStairs(World world, BlockPos pos, MazeGenerator[] mazeList) {
		System.out.println("YES");
		Random rand = new Random();
		boolean done = false;
		char[][] top = mazeList[1].getGrid();
		char[][] bot = mazeList[0].getGrid();
		
		while (!done) {
			int i = rand.nextInt(size);
			int j = rand.nextInt(size);
			String q1 = Character.toString(top[i][j]);
			String q2 = Character.toString(bot[i][j]);
			if (q1.equals(".") && q2.equals(".")) {
				done = true;
				new FortnestStairs().generate(world, rand, pos.add(i * 8, 1, j * 8));
			}

		}
		
		done = false;
		top = mazeList[2].getGrid();
		bot = mazeList[1].getGrid();
		
		while (!done) {
			int i = rand.nextInt(size);
			int j = rand.nextInt(size);
			String q1 = Character.toString(top[i][j]);
			String q2 = Character.toString(bot[i][j]);
			if (q1.equals(".") && q2.equals(".")) {
				done = true;
				new FortnestStairs().generate(world, rand, pos.add(i * 8, 6, j * 8));
			}

		}

		done = false;
		top = mazeList[3].getGrid();
		bot = mazeList[2].getGrid();
		
		while (!done) {
			int i = rand.nextInt(size);
			int j = rand.nextInt(size);
			String q1 = Character.toString(top[i][j]);
			String q2 = Character.toString(bot[i][j]);
			if (q1.equals(".") && q2.equals(".")) {
				done = true;
				new FortnestStairs().generate(world, rand, pos.add(i * 8, 11, j * 8));
			}

		}
		
	}

}
