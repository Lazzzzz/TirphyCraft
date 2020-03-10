package com.laz.tirphycraft.gosyn.common.world.gen.stage1.structures;

import java.util.Random;

public class MazeGenerator {

	private char[][] grid;
	private final int WIDTH;
	private final int HEIGHT;
	Random randomGen = new Random();
	
	private boolean hasUnvisited(char[][] grid, int sr, int sc) {
		if (sc + 2 > HEIGHT - 2) {
		} else if (grid[sr][sc + 2] == '#') {
			return true;
		}
		if (sc - 2 < 0) {
		} else if (grid[sr][sc - 2] == '#') {
			return true;
		}
		if (sr + 2 > WIDTH - 2) {
		} else if (grid[sr + 2][sc] == '#') {
			return true;
		}
		if (sr - 2 < 0) {
		} else if (grid[sr - 2][sc] == '#') {
			return true;
		}
		return false;
	}

	private void pather(char[][] grid, int sr, int sc) {
		grid[sr][sc] = '.';

		if (sr > WIDTH - 2 || sr < 1 || sc > HEIGHT - 2 || sc < 1) {
			return;
		}
		switch (randomGen.nextInt(4)) {
		case 0:
			if (hasUnvisited(grid, sr, sc)) {
				if (sc + 2 > HEIGHT - 2) {
				} else if (grid[sr][sc + 2] != '.') {
					grid[sr][sc + 1] = '.';
					pather(grid, sr, sc + 2);
				}
				pather(grid, sr, sc);
			}
			break;
		case 1:
			if (hasUnvisited(grid, sr, sc)) {
				if (sc - 2 < 0) {
				} else if (grid[sr][sc - 2] != '.') {
					grid[sr][sc - 1] = '.';
					pather(grid, sr, sc - 2);
				}
				pather(grid, sr, sc);
			}
			break;
		case 2:
			if (hasUnvisited(grid, sr, sc)) {
				if (sr + 2 > WIDTH - 2) {
				} else if (grid[sr + 2][sc] != '.') {
					grid[sr + 1][sc] = '.';
					pather(grid, sr + 2, sc);
				}
				pather(grid, sr, sc);
			}
			break;

		case 3:
			if (hasUnvisited(grid, sr, sc)) {
				if (sr - 2 < 0) {
				} else if (grid[sr - 2][sc] != '.') {
					grid[sr - 1][sc] = '.';
					pather(grid, sr - 2, sc);
				}
				pather(grid, sr, sc);
			}
			break;
		}
	}
	private char[][] mazer() {
		grid = new char[WIDTH][HEIGHT];
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				grid[i][j] = '#';
			}
		}
		int sr = 1, sc = 1;
		pather(grid, sr, sc);

		return grid;
	}

	public MazeGenerator(int wIn, int hIn) {
		WIDTH = wIn;
		HEIGHT = hIn;
		grid = mazer();
	}
	
	public char[][] getGrid(){
		return grid;
	}

}