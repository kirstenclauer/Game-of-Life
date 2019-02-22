/**
 * Kirsten Clauer
 * Project1: Game of Life
 * 
 */

public class LifeDriver {
	
	public static void main(String[] args) {
		
		int[][] grid = new int[10][10]; 
		
		GameOfLife game; 
		game = new GameOfLife(grid);
		
		game.run(5);
		
	}
	
}
