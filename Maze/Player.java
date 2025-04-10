import java.util.Scanner;
/**
 * PLAYER
 * where the location and move logic is stores
 */
public class Player
{
	/* CLASS ATTRIBUTES */
	private int collidedCount; // a count of the amount of times the player collided with the wall
	private int posY; // the position of the player in the Y dimension
	private int posX; // the position of the player in the X dimension
	
	/**
	 * CONSTRUCTOR
	 * @param collidedCount
	 * @param posY
	 * @param posX
	 */
	public Player(int collidedCount, int posY, int posX)
	{
		this.collidedCount = collidedCount;
		this.posY = posY;
		this.posX = posX;
	}

	/**
	 * GETTER
	 * @return collidedCount
	 */
	public int getCollidedCount()
	{
		return collidedCount;
	}
	/**
	 * SETTER
	 * @param collidedCount
	 */
	public void setCollidedCount(int collidedCount)
	{
		this.collidedCount = collidedCount;
	}

	/**
	 * GETTER
	 * @return posY
	 */
	public int getPosY()
	{
		return posY;
	}
	/**
	 * SETTER
	 * @param posY
	 */
	public void setPosY(int posY)
	{
		this.posY = posY;
	}

	/**
	 * GETTER
	 * @return posX
	 */
	public int getPosX()
	{
		return posX;
	}
	/**
	 * SETTER
	 * @param posX
	 */
	public void setPosX(int posX)
	{
		this.posX = posX;
	}
	
	/**
	 * MOVE
	 * moves the player in the direction they want to go
	 * @param maze
	 * @return true to continue the loop
	 */
	public void checkDirection(Maze maze, Scanner scanner)
	{
		switch (chooseDirection(scanner)) // calls the chooseDirection() method to get the player direction
		{
			case "up":
				moveUp(maze);
				break;
			
			case "down":
				moveDown(maze);
				break;
				
			case "left":
				moveLeft(maze);
				break;
			
			case "right":
				moveRight(maze);
				break;
		}
	}

	/**
	 * MOVE
	 * moves the player right
	 * @param maze
	 */
	public void moveRight(Maze maze)
	{
		int posX = getPosX();
		int posY = getPosY();
		GameTile[][] board = maze.getMaze();
		
		if (posX + 1 < board[posY].length) // checked for error protection
		{
			if (board[posY][posX + 1].isWall()) // checks if the tile right of the player is a wall
			{
				System.out.println("You hit a wall.");
				
				/* changes the value of isRevealed for the tile to true allows it to be printed */
				board[posY][posX + 1].setRevealed(true);
				
				setCollidedCount(getCollidedCount() + 1); // increments collided count
			}
			else
			{
				board[posY][posX].setPlayer(null); // gets rid of the player on the previous tile
				
				/* moves the player by moving the instance of this class to the tile to the right */
				board[posY][posX + 1].setPlayer(this);
				
				board[posY][posX].setRevealed(true); // reveals path
				
				setPosX(getPosX() + 1); // increments collided count
			}
		}
	}

	/**
	 * MOVE
	 * moves the player left
	 * @param maze
	 */
	public void moveLeft(Maze maze)
	{
		int posX = getPosX();
		int posY = getPosY();
		GameTile[][] board = maze.getMaze();
		
		if (posX - 1 > -1) // checked for error protection
		{
			if (board[posY][posX - 1].isWall()) // checks if the tile left of the player is a wall
			{
				System.out.println("You hit a wall.");
				
				/* changes the value of isRevealed for the tile to true allows it to be printed */
				board[posY][posX - 1].setRevealed(true);
				
				setCollidedCount(getCollidedCount() + 1); // increments collided count
			}
			else
			{
				board[posY][posX].setPlayer(null); // gets rid of the player on the previous tile
				
				/* moves the player by moving the instance of this class to the tile to the left */
				board[posY][posX - 1].setPlayer(this);
				
				board[posY][posX].setRevealed(true); // reveals path
				
				setPosX(getPosX() - 1); // increments collided count
			}
		}
	}

	/**
	 * MOVE
	 * moves the player down
	 * @param maze
	 */
	public void moveDown(Maze maze)
	{
		int posX = getPosX();
		int posY = getPosY();
		GameTile[][] board = maze.getMaze();
		
		if (posY + 1 < board.length) // checked for error protection
		{
			if (board[posY + 1][posX].isWall()) // checks if the tile below the player is a wall
			{
				System.out.println("You hit a wall.");
				
				/* changes the value of isRevealed for the tile to true, allows it to be printed */
				board[posY + 1][posX].setRevealed(true);
				
				setCollidedCount(getCollidedCount() + 1); // increments collided count
			}
			else
			{
				board[posY][posX].setPlayer(null); // gets rid of the player on the previous tile
				
				/* moves the player by moving the instance of this class to the tile below */
				board[posY + 1][posX].setPlayer(this);
				
				board[posY][posX].setRevealed(true); // reveals path
				
				setPosY(getPosY() + 1); // increments posY
			}
		}
	}

	/**
	 * MOVE
	 * moves the player up
	 * @param maze
	 */
	public void moveUp(Maze maze)
	{
		int posX = getPosX();
		int posY = getPosY();
		GameTile[][] board = maze.getMaze();
		
		if (posY - 1 > -1) // checked for error protection
		{
			if (board[posY - 1][posX].isWall()) // checks if the tile above the player is a wall
			{
				System.out.println("You hit a wall.");
				
				/* changes the value of isRevealed for the tile to true, allows it to be printed */
				board[posY - 1][posX].setRevealed(true);
				
				setCollidedCount(getCollidedCount() + 1); // increments collided count
			}
			else
			{
				board[posY][posX].setPlayer(null); // gets rid of the player on the previous tile
				
				/* moves the player by moving the instance of this class to the tile above */
				board[posY - 1][posX].setPlayer(this);
				
				board[posY][posX].setRevealed(true); // reveals path
				
				setPosY(getPosY() - 1); // decrements posY
			}
		}
	}
	
	/**
	 * allows player to choose direction
	 * @return up, down, left, or right
	 */
	public String chooseDirection(Scanner scanner)
	{
		String direction = scanner.nextLine().toLowerCase(); // stores player input
		
		/* loops until player types up, down, left, or right */
		while (!direction.equals("up") && !direction.equals("down") && !direction.equals("left") && !direction.equals("right"))
		{
			System.out.println("Please choose a valid direction");
			direction = scanner.nextLine().toLowerCase();
		}
		
		return direction;
	}
}
