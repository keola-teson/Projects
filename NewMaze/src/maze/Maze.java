package maze;

import player.Player;
import tile.GameTile;

/**
 * MAZE
 * controlls the printing and filling of the maze
 */
public class Maze
{
	/* class attibutes */
	private GameTile[][] maze; // board
	
	/**
	 * CONSTRUCTOR
	 * @param maze
	 */
	public Maze(char[][] board, Player player)
	{
		this.maze = fillMaze(player, board);
	}

	/**
	 * GETTER
	 * @return the maze
	 */
	public GameTile[][] getMaze()
	{
		return maze;
	}

	/**
	 * SETTER
	 * @param maze
	 */
	public void setMaze(GameTile[][] maze)
	{
		this.maze = maze;
	}
	
	/**
	 * PRINT
	 */
	public void printMaze()
	{
		// prints each element one by one row by row and surrounds it in brackets
		for (GameTile[] row : maze)
		{
			System.out.print("[");
			for (GameTile tile : row)
			{
				System.out.print(tile);
			}
			System.out.println("]");
		}
	}
	
	/**
	 * fills the 2D Tile array with Tile objects to generate walls and path
	 * @param player
	 * @param board
	 * @return the updated 2D Tile array
	 */
	public GameTile[][] fillMaze(Player player, char[][] board)
	{
		maze = new GameTile[board.length][board[0].length];
		
		// goes row by row
		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{
				if (board[i][j] == ' ')
				{
					maze[i][j] = new GameTile(false, false, null);
				}
				if (board[i][j] == '|')
				{
					maze[i][j] = new GameTile(true, false, null);
				}
				if (board[i][j] == '8')
				{
					maze[i][j] = new GameTile(false, false, player);
				}
			}
		}
		printMaze();
		
		return maze;
	}
}
