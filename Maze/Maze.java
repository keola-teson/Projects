package maze;

import player.Player;
import tile.Tile;

public class Maze
{
	/* class attibutes */
	private Tile[][] maze; // board
	
	/**
	 * CONSTRUCTOR
	 * @param maze
	 */
	public Maze(Tile[][] maze)
	{
		this.maze = maze;
	}

	/**
	 * GETTER
	 * @return the maze
	 */
	public Tile[][] getMaze()
	{
		return maze;
	}

	/**
	 * SETTER
	 * @param maze
	 */
	public void setMaze(Tile[][] maze)
	{
		this.maze = maze;
	}
	
	/**
	 * PRINT
	 */
	public void printMaze()
	{
		// prints each element one by one row by row and surrounds it in brackets
		for (Tile[] row : maze)
		{
			System.out.print("[");
			for (Tile tile : row)
			{
				System.out.print(tile);
			}
			System.out.println("]");
		}
	}
	
	/**
	 * fills the 2D Tile array with Tile objects to generate walls and path
	 * @param player
	 */
	public void fillMaze(Player player)
	{
		// goes row by row
		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{
				// auto generates an empty path
				maze[i][j] = new Tile(false, false, null);
				
				// puts a wall where i want (i == posY and j == posX)
				if ((i == 0 && j == 1) || (i == 1 && j == 1) || (i == 3 && j == 1) || (i == 4 && j == 1) ||
					(i == 0 && j == 2) || (i == 3 && j == 2) || 
					(i == 2 && j == 3) ||
					(i == 4 && j == 4) || 
					(i == 1 && j == 5) || (i == 3 && j == 5) || 
					(i == 1 && j == 6) ||
					(i == 2 && j == 7) || (i == 3 && j == 7) || 
					(i == 1 && j == 8) || 
					(i == 0 && j == 9) || (i == 1 && j == 9) || (i == 2 && j == 9) || (i == 3 && j == 9))
				{
					maze[i][j] = new Tile(true, false, null);
				}
				// places the player wherever posY and posX attributes determine
				else if (i == player.getPosY() && j == player.getPosX())
				{
					maze[i][j] = new Tile(false, false, player);
				}
			}
		}
	}
}
