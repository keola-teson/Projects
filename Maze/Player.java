import java.util.Scanner;

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
	 * CHECK
	 * moves the player in the direction they want to go
	 * @param maze
	 * @return true to continue the loop
	 */
	public void checkDirection(Maze maze, Scanner scanner)
	{
		switch (chooseDirection(scanner)) // calls the chooseDirection() method to get the player direction
		{
			case "up":
				if (getPosY() - 1 > -1) // checked for error protection
				{
					if (maze.getMaze()[getPosY() - 1][getPosX()].isWall()) // checks if the tile above the player is a wall
					{
						System.out.println("You hit a wall.");
						
						maze.getMaze()[getPosY() - 1][getPosX()].setRevealed(true); // changes the value of isRevealed for the tile to true
						// allows it to be printed
						
						setCollidedCount(getCollidedCount() + 1); // increments collided count
					}
					else
					{
						maze.getMaze()[getPosY()][getPosX()].setPlayer(null); // gets rid of the player on the previous tile
						maze.getMaze()[getPosY() - 1][getPosX()].setPlayer(this); // moves the player by moving the instance of this 
																				  // class to the tile above
						
						maze.getMaze()[getPosY()][getPosX()].setRevealed(true); // reveals path
						
						setPosY(getPosY() - 1); // decrements posY
					}
				}
				break;
			
			case "down":
				if (getPosY() + 1 < maze.getMaze()[getPosY()].length) // checked for error protection
				{
					if (maze.getMaze()[getPosY() + 1][getPosX()].isWall()) // checks if the tile below the player is a wall
					{
						System.out.println("You hit a wall.");
						
						maze.getMaze()[getPosY() + 1][getPosX()].setRevealed(true); // changes the value of isRevealed for the tile to true
																					// allows it to be printed
						
						setCollidedCount(getCollidedCount() + 1); // increments collided count
					}
					else
					{
						maze.getMaze()[getPosY()][getPosX()].setPlayer(null); // gets rid of the player on the previous tile
						maze.getMaze()[getPosY() + 1][getPosX()].setPlayer(this); // moves the player by moving the instance of this 
																				  // class to the tile below
						
						maze.getMaze()[getPosY()][getPosX()].setRevealed(true); // reveals path
						
						setPosY(getPosY() + 1); // increments posY
					}
				}
				break;
				
			case "left":
				if (getPosX() - 1 > -1) // checked for error protection
				{
					if (maze.getMaze()[getPosY()][getPosX() - 1].isWall()) // checks if the tile left of the player is a wall
					{
						System.out.println("You hit a wall.");
						
						maze.getMaze()[getPosY()][getPosX() - 1].setRevealed(true); // changes the value of isRevealed for the tile to true
																					// allows it to be printed
						
						setCollidedCount(getCollidedCount() + 1); // increments collided count
					}
					else
					{
						maze.getMaze()[getPosY()][getPosX()].setPlayer(null); // gets rid of the player on the previous tile
						maze.getMaze()[getPosY()][getPosX() - 1].setPlayer(this); // moves the player by moving the instance of this 
																				  // class to the tile to the right
						
						maze.getMaze()[getPosY()][getPosX()].setRevealed(true); // reveals path
						
						setPosX(getPosX() - 1); // increments collided count
					}
				}
				break;
			
			case "right":
				if (getPosX() + 1 < maze.getMaze()[getPosY()].length) // checked for error protection
				{
					
					if (maze.getMaze()[getPosY()][getPosX() + 1].isWall()) // checks if the tile right of the player is a wall
					{
						System.out.println("You hit a wall.");
						
						maze.getMaze()[getPosY()][getPosX() + 1].setRevealed(true); // changes the value of isRevealed for the tile to true
																					// allows it to be printed
						
						setCollidedCount(getCollidedCount() + 1); // increments collided count
					}
					else
					{
						maze.getMaze()[getPosY()][getPosX()].setPlayer(null); // gets rid of the player on the previous tile
						maze.getMaze()[getPosY()][getPosX() + 1].setPlayer(this); // moves the player by moving the instance of this 
																				  // class to the tile to the right
						
						maze.getMaze()[getPosY()][getPosX()].setRevealed(true); // reveals path
						
						setPosX(getPosX() + 1); // increments collided count
					}
				}
				break;
		}
	}
	
	/**
	 * allows player to choose direction
	 * @return up, down, left, or right
	 */
	private String chooseDirection(Scanner scanner)
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
