
/**
 * Where game is played
 */
public class Main
{
	public static void main(String[] args)
	{
		/*
		 * OBJECTS
		 *  - Player
		 *  - Opponent
		 */
		Player player = new Player(new Board(new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}));
		Opponent opponent = new Opponent(player);
		
		//loops until the player wins, loses, or ties
		while (!player.getBoardRef().checkBoard())
		{
			player.getBoardRef().printBoard();
			
			player.chooseBox();
			opponent.chooseBox();
		}
		
		//ends game
		endGame(player);
	}
	
	private static void endGame(Player player)
	{
		System.out.println("Do you want to play again?");
		String input = player.getScanner().nextLine();
		if (!(input.equalsIgnoreCase("yes")))
		{
			player.closeScanner();
			System.exit(0);
		}
		System.out.println("Resetting board.");
		player.getBoardRef().resetBoard(new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}});
	}

}
