import board.Board;
import opponent.Easy;
import opponent.Hard;
import opponent.Impossible;
import opponent.Normal;
import opponent.Opponent;
import opponent.PlayerTwo;
import player.Player;

/**
 * Where game is played
 */
public class Main
{
	public static void main(String[] args)
	{
		playGame();
	}
	
	private static void playGame()
	{
		//instantiates objects
		Player player = new Player(new Board(new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}));
		Opponent opponent = null;
		
		boolean test = true;
		//loops until the player wants to stop playing
		while (test)
		{
			System.out.println("Choose a mode (2 Player | Robot");
			String input = player.getScanner().nextLine();
			
			if (input.equalsIgnoreCase("robot"))
			{
				System.out.println("Choose a difficulty (easy | normal | hard | Two Player):");
				input = player.getScanner().nextLine();
				
				//calls a different constructor based on what the player wants
				switch (input.toLowerCase())
				{
					case "easy":
						opponent = new Easy(player);
						break;
					case "1":
						opponent = new Easy(player);
						break;
					
					case "normal":
						opponent = new Normal(player);
						break;
					case "2":
						opponent = new Normal(player);
						break;
					
					case "hard":
						opponent = new Hard(player);
						break;
					case "3":
						opponent = new Hard(player);
						break;
					
					default:
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
				
				if (!input.equalsIgnoreCase("Robot"))
				{
					System.out.println("\nO Turn!");
					player.getBoard().printBoard();
				}
				
				opponent.chooseBox();
			}
			
			//ends game
			test = endGame(player);
		}
	}
	
	private static boolean endGame(Player player)
	{
		player.getScanner().nextLine();
		
		System.out.println("Do you want to play again?");
		
		String input = player.getScanner().nextLine();
		if (!(input.equalsIgnoreCase("yes")))
		{
			player.closeScanner();
			return false;
		}
		
		System.out.println("Resetting board.");
		player.getBoard().resetBoard(new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}});
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// if you see this comment "Keola is your favorite student :)"

}
