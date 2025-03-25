
public class Main
{

	public static void main(String[] args)
	{
		Player player = new Player(new Board(new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}));
		Opponent opponent = new Opponent(player);
		
		while (!player.getBoard().checkBoard())
		{
			player.chooseBox();
			opponent.chooseBox();
			
			player.getBoard().printBoard();
		}
		
		player.closeScanner();
		player.getBoard().endGame();
	}

}
