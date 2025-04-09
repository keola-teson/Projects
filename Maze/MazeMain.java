package main;

import player.Player;
import tile.Tile;

public class MazeMain
{
	public static void main(String[] args)
	{
		Player player = new Player(0, 0, 0);
		Maze maze = new Maze(new Tile[5][10]);
		maze.fillMaze(player);
		
		while (player.getPosY() != 4 || player.getPosX() != 9)
		{
			maze.printMaze();
			player.checkDirection(maze);
		}
		maze.getMaze()[0][0] = new Tile(false, false, player);
		
		maze.printMaze();
		System.out.println("YOU WIN!");
		System.out.println("Failure Count: " + player.getCollidedCount());
	}
}
