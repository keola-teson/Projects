package main;

import java.util.Scanner;

import maze.Maze;
import player.Flashlight;
import player.Player;

/**
 * Where the game is played
 */
public class MazeMain
{
	public static void main(String[] args)
	{
		playGame();
	}
	
	static void playGame()
	{
		Scanner scanner = new Scanner(System.in); // input
		
		Player player = chooseGamemode(scanner); // player object
		Maze maze = new Maze(new char[][] {
			{'8', '|', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{' ', '|', ' ', ' ', ' ', '|', '|', ' ', '|', '|'},
			{' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', '|'},
			{' ', '|', '|', ' ', ' ', '|', ' ', '|', ' ', '|'},
			{' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '}}, player); // maze object with Tile map passed into it
		
		while (player.getPosY() != 4 || player.getPosX() != 9) // loops until player hit win
		{
			player.checkDirection(maze, scanner);
			maze.printMaze();
		}
		System.out.println("YOU WIN!\nFailure Count: " + player.getCollidedCount());
		
		scanner.close();
	}
	
	static Player chooseGamemode(Scanner scanner)
	{
		System.out.println("Choose Gamemode (Default | Flashlight)");
		String input = scanner.nextLine();
		
		if (input.equalsIgnoreCase("flashlight"))
		{
			return new Flashlight(0, 0, 0);
		}
		return new Player(0, 0, 0);
	}
}
