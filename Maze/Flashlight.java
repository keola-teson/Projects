import java.util.Scanner;
/**
 * PLAYER
 * stores flashlight logic if player wants it
 */
public class Flashlight extends Player
{
	/**
	 * CONSTRUCTOR
	 * @param collidedCount
	 * @param posY
	 * @param posX
	 */
	public Flashlight(int collidedCount, int posY, int posX)
	{
		super(collidedCount, posY, posX);
	}

	/**
	 * MOVE
	 * moves the player and flashlight
	 */
	@Override
	public void checkDirection(Maze maze, Scanner scanner)
	{
		// hides every tiles
		for (GameTile[] set : maze.getMaze())
		{
			for (GameTile tile : set)
			{
				tile.setRevealed(false);
			}
		}
		
		int posY;
		int posX;
		
		switch (chooseDirection(scanner))
		{
			case "up":
				moveUp(maze);
				
				posY = getPosY();
				posX = getPosX();
				
				while (posY > -1 && !maze.getMaze()[posY][posX].isWall()) // loops until light hits error or wall
				{
					/* reveals tiles left of the light */
					if (posX - 1 > -1)
						maze.getMaze()[posY][posX - 1].setRevealed(true);
					
					/* reveals tiels right of the light */
					if (posX + 1 < maze.getMaze()[posY].length)
						maze.getMaze()[posY][posX + 1].setRevealed(true);
					
					posY--;
				}
				
				if (posY > -1) // error protection
					if (maze.getMaze()[posY][posX].isWall())
						maze.getMaze()[posY][posX].setRevealed(true); // reveals wall at the end of the tunnel
				
				break;
			
			case "down":
				moveDown(maze);
				
				posY = getPosY();
				posX = getPosX();
				
				while (posY < maze.getMaze().length && !maze.getMaze()[posY][posX].isWall()) // loops until light hits error or wall
				{
					/* reveals tiles left of the light */
					if (posX - 1 > -1)
						maze.getMaze()[posY][posX - 1].setRevealed(true);
					
					/* reveals tiles right of the light */
					if (posX + 1 < maze.getMaze()[posY].length)
						maze.getMaze()[posY][posX + 1].setRevealed(true);
					
					posY++;
				}
				
				if (posY < maze.getMaze().length) // error protection
					if (maze.getMaze()[posY][posX].isWall())
						maze.getMaze()[posY][posX].setRevealed(true); // reveals wall at the end of the tunnel
				
				break;
				
			case "left":
				moveLeft(maze);
				
				posY = getPosY();
				posX = getPosX();
				
				while (posX > -1 && !maze.getMaze()[posY][posX].isWall()) // loops until light hits error or wall
				{
					/* reveals tiles above the light */
					if (posY - 1 > - 1)
						maze.getMaze()[posY - 1][posX].setRevealed(true);
					
					/* reveals tiles below the light */
					if (posY + 1 < maze.getMaze().length)
						maze.getMaze()[posY + 1][posX].setRevealed(true);
					posX--;
				}
				
				if (posX > - 1) // error protection
					if (maze.getMaze()[posY][posX].isWall())
						maze.getMaze()[posY][posX].setRevealed(true); // reveals wall at the end of the tunnel
				
				break;
				
			case "right":
				moveRight(maze);
				
				posY = getPosY();
				posX = getPosX();
				
				while (posX < maze.getMaze()[posY].length && !maze.getMaze()[posY][posX].isWall()) // loops until light hits error or wall
				{
					/* reveals tiles above the light */
					if (posY - 1 > - 1)
						maze.getMaze()[posY - 1][posX].setRevealed(true);
					
					/* reveals tiles below the light */
					if (posY + 1 < maze.getMaze().length)
						maze.getMaze()[posY + 1][posX].setRevealed(true);
					posX++;
				}
				
				if (posX < maze.getMaze()[posY].length) // error protection
					if (maze.getMaze()[posY][posX].isWall())
						maze.getMaze()[posY][posX].setRevealed(true); // reveals wall at the end of the tunnel
				
				break;
		}
	}
}
