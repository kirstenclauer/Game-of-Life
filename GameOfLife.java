/**
 * Kirsten Clauer
 * Project1: Game of Life
 * 
 */


public class GameOfLife {

	private int[][] grid;
	private static LifeWindow life;

	//goes through the grid, assigns each cell alive or dead
	public GameOfLife(int[][] grid) {
		this.grid = new int[grid.length][grid[0].length];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[(int) row].length; col++) {
				double newVal = Math.random();

				if (newVal > .5) {
					this.grid[row][col] = 1;
				} else {
					this.grid[row][col] = 0;
				}
			}
		}
		life = new LifeWindow(this.grid, 50);
	}
	
	//Checks if neighboring cells are alive or dead, returns the count
	private int countNeighbors(int row, int col) {
		int count = 0;
		for (int i = (row - 1); i <= row+1; i++) {
			if (i >= 0 && i < grid.length) {
				for (int j = (col - 1); j <= col + 1; j++) {
					if (j >= 0 && j < grid[i].length) {
						if (i != row || j != col) {
							if (grid[i][j] == 0) {
								count++;
							}
						}
					}
				}
			}
		}
		return count;
	}

	//creates life window, animates game of life by following rules of life and incrementing count
	public void run(int cycles) {
		int count = 0;
		while (count < cycles) {
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[row].length; col++) {
					count++;
					life.displayLife();

					if (grid[row][col] == 1) {

						if (countNeighbors(row, col) < 2) {
							grid[row][col] = 0;
						}
						if (countNeighbors(row, col) > 3) {
							grid[row][col] = 0;
						}
					
					}else {
						if (countNeighbors(row, col) == 3) {
							grid[row][col] = 1;
						}
					}

					
					}
				}

			}
		}
}
