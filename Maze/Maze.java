/**
 * MAZE
 * controlls the printing and filling of the maze
 */
public class Maze
{
	/* class attibutes */
	private Tile[][] maze; // board
	
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
	public Tile[][] fillMaze(Player player, char[][] board)
	{
		maze = new Tile[board.length][board[0].length];
		
		// goes row by row
		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[i].length; j++)
			{
				if (board[i][j] == ' ')
				{
					maze[i][j] = new Tile(false, false, null);
				}
				if (board[i][j] == '|')
				{
					maze[i][j] = new Tile(true, false, null);
				}
				if (board[i][j] == '8')
				{
					maze[i][j] = new Tile(false, false, player);
				}
			}
		}
		printMaze();
		
		return maze;
	}
}
