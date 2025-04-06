import java.util.Scanner;

import board.Board;
import opponent.Easy;
import opponent.Hard;
import opponent.Normal;
import opponent.Impossible;
import opponent.Opponent;
import player.Player;
import player.PlayerTwo;

/**
 * Where game is played
 */
public class TicTacToeMain
{
	public static void main(String[] args)
	{
		playGame();
	}
	
	private static void playGame()
	{
		Scanner scanner = new Scanner(System.in);
		
		//instantiates objects
		Player player = new Player(new Board(new char[][]{
											{' ', ' ', ' '},
											{' ', ' ', ' '},
											{' ', ' ', ' '}}));
		Opponent opponent = null;
		
		boolean test = true;
		//loops until the player wants to stop playing
		while (test)
		{
			System.out.println("Choose a mode (2 Player | Robot):");
			String input = scanner.nextLine();
			
			if (input.equalsIgnoreCase("robot"))
			{
				System.out.println("Choose a difficulty (easy | normal | hard):");
				input = scanner.nextLine();
				
				//calls a different constructor based on what the player wants
				switch (input.toLowerCase())
				{
					case "easy":
						System.out.println("Easy chosen.");
						opponent = new Easy(player);
						break;
					
					case "normal":
						System.out.println("Normal chosen.");
						opponent = new Normal(player);
						break;
					
					case "hard":
						System.out.println("Hard chosen.");
						opponent = new Hard(player);
						break;
					
					default:
						System.out.println("Impossible chosen.");
						opponent = new Impossible(player);
				}
			}
			else
			{
				opponent = new PlayerTwo(player);
				System.out.println("Two player mode chosen");
			}
			
			//loops until the player wins, loses, or ties
			while (player.getBoard().checkBoard())
			{
				System.out.println("\nX Turn:");
				player.getBoard().printBoard();
				
				player.chooseBox();
				
				if (player.getBoard().checkBoard())
				{
					System.out.println("\nO Turn!");
					player.getBoard().printBoard();
					opponent.chooseBox();
				}
				else
				{
					break;
				}
			}
			
			//ends game
			test = endGame(player, scanner);
		}
	}
	
	private static boolean endGame(Player player, Scanner scanner)
	{
		player.getBoard().printBoard();
		System.out.println();
		
		System.out.println("Do you want to play again?");
		
		
		String input = scanner.nextLine();
		if (!(input.equalsIgnoreCase("yes")))
		{
			player.closeScanner();
			System.exit(0);
		}
		
		System.out.println("Resetting board.");
		player.getBoard().resetBoard();
		
		return true;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
// if you see this comment "Keola is your favorite student :)"
