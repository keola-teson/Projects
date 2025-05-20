package player;

import java.util.Scanner;

import maze.Maze;
import tile.GameTile;

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
		GameTile[][] board;
		
		switch (chooseDirection(scanner))
		{
			case "up":
				moveUp(maze);
				
				board = maze.getMaze();
				posY = getPosY();
				posX = getPosX();
				
				while (posY > -1 && !board[posY][posX].isWall()) // loops until light hits error or wall
				{
					/* reveals tiles left of the light */
					if (posX - 1 > -1)
						board[posY][posX - 1].setRevealed(true);
					
					/* reveals tiels right of the light */
					if (posX + 1 < board[posY].length)
						board[posY][posX + 1].setRevealed(true);
					
					posY--;
				}
				
				if (posY > -1) // error protection
					if (board[posY][posX].isWall())
						board[posY][posX].setRevealed(true); // reveals wall at the end of the tunnel
				break;
			
			case "down":
				moveDown(maze);

				board = maze.getMaze();
				posY = getPosY();
				posX = getPosX();
				
				while (posY < board.length && !board[posY][posX].isWall()) // loops until light hits error or wall
				{
					/* reveals tiles left of the light */
					if (posX - 1 > -1)
						board[posY][posX - 1].setRevealed(true);
					
					/* reveals tiles right of the light */
					if (posX + 1 < maze.getMaze()[posY].length)
						board[posY][posX + 1].setRevealed(true);
					
					posY++;
				}
				
				if (posY < board.length) // error protection
					if (board[posY][posX].isWall())
						board[posY][posX].setRevealed(true); // reveals wall at the end of the tunnel
				break;
				
			case "left":
				moveLeft(maze);
				
				board = maze.getMaze();
				posY = getPosY();
				posX = getPosX();
				
				while (posX > -1 && !board[posY][posX].isWall()) // loops until light hits error or wall
				{
					/* reveals tiles above the light */
					if (posY - 1 > - 1)
						board[posY - 1][posX].setRevealed(true);
					
					/* reveals tiles below the light */
					if (posY + 1 < maze.getMaze().length)
						board[posY + 1][posX].setRevealed(true);
					posX--;
				}
				
				if (posX > - 1) // error protection
					if (board[posY][posX].isWall())
						board[posY][posX].setRevealed(true); // reveals wall at the end of the tunnel
				break;
				
			case "right":
				moveRight(maze);
				
				board = maze.getMaze();
				posY = getPosY();
				posX = getPosX();
				
				while (posX < board[posY].length && !board[posY][posX].isWall()) // loops until light hits error or wall
				{
					/* reveals tiles above the light */
					if (posY - 1 > - 1)
						board[posY - 1][posX].setRevealed(true);
					
					/* reveals tiles below the light */
					if (posY + 1 < maze.getMaze().length)
						board[posY + 1][posX].setRevealed(true);
					posX++;
				}
				
				if (posX < board[posY].length) // error protection
					if (board[posY][posX].isWall())
						board[posY][posX].setRevealed(true); // reveals wall at the end of the tunnel
				break;
		}
	}
}
