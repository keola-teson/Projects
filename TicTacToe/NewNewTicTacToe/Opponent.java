
/**
 * OPPONENT CLASS
 * robot opponent
 * 
 * <p> Might make a new opponent super class with these methods and
 * let the player choose the difficulty of the bot <p>
 * @author Keola Teson :)
 */
public class Opponent
{
	//Player (to access player methods and board duhhhhhhhh)
	private Player player;
	
	/**
	 * CONSTRUCTOR
	 * @param player
	 */
	public Opponent(Player player)
	{
		this.player = player;
	}
	
	/**
	 * chooses the position of the O based on stuff
	 */
	public void chooseBox()
	{
		int posY = 0;
		int posX = 0;
		
		//leaves method if the check was successful and an O was placed
		if (checkRows()) return;
		
		//ditto
		if (checkColumns(posY, posX)) return;
		
		//ditto
		if (checkDiagonals(posY, posX)) return;
		
		/*
		 * if checks were unsuccessful find a position randomly and put an O there
		 */
		while (player.getBoardRef().getBoard()[posY][posX] == 'X')
		{
			posY = (int)(Math.random() * 2);
			posX = (int)(Math.random() * 2);
		}
		player.getBoardRef().changeBoardValue(posY, posX, 'O');
	}
	
	/**
	 * CHECK ONE
	 * checks the row to see if the player is close to winning
	 * @return true if the an O was placed
	 */
	private boolean checkRows()
	{
		char[][] board = player.getBoardRef().getBoard();
		
		/*
		 * moves through the rows and checks for an almost win
		 * check for the amount of Os in the row because the bot wouldn't move passed that spot every time
		 */
		int amountX;
		int amountO;
		for (int i = 0; i < board.length; i++)
		{
			amountX = 0;
			amountO = 0;
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == 'X')
				{
					amountX++;
				}
				if (board[i][j] == 'O')
				{
					amountO++;
				}
			}
			if (amountX == 2 && amountO == 0)
			{
				placeORow(board);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * STILL CHECK ONE
	 * called if the player is about to win
	 * seperated from check for organization duhhhhhhh
	 * @param board
	 */
	private void placeORow(char[][] board)
	{
		//places the O where the empty space is
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == ' ')
				{
					player.getBoardRef().changeBoardValue(i, j, 'O');
					return;
				}
			}
		}
	}
	
	/**
	 * CHECK TWO
	 * checks the columns to see if the player is close to winning
	 * @param posY
	 * @param posX
	 * @return true if an O was placed
	 */
	private boolean checkColumns(int posY, int posX)
	{
		char[][] board = player.getBoardRef().getBoard();
		
		int amountX;
		int amountO;
		
		/*
		 * moves through the column and checks for an almost win
		 * check for the amount of Os in the row because the bot wouldn't move passed that spot every time
		 */
		for (int i = 0; i < board[0].length; i++)
		{
			amountX = 0;
			amountO = 0;
			for (int j = 0; j < board.length; j++)
			{
				if (board[j][i] == 'X')
				{
					amountX++;
					posY = j;
					posX = i;
				}
				if (board[j][i] =='O')
				{
					amountO++;
				}
			}
			if (amountX == 2 && amountO == 0)
			{
				placeOColumn(board);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * STILL CHECK TWO
	 * called if the player is about to win
	 * seperated from check for organization duhhhhhhh
	 * @param board
	 */
	private void placeOColumn(char[][] board)
	{
		//places the O where the empty space is
		for (int i = 0; i < board[0].length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				if (board[j][i] == ' ')
				{
					player.getBoardRef().changeBoardValue(j, i, 'O');
				}
			}
		}
	}
	
	/**
	 * CHECK THREE
	 * checks diagonals for if the player is close to winning
	 * @param posY
	 * @param posX
	 * @return true if an O was placed
	 */
	private boolean checkDiagonals(int posY, int posX)
	{
		char[][] board = player.getBoardRef().getBoard();
		
		if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] != 'O')
		{
			player.getBoardRef().changeBoardValue(2, 2, 'O');
			return true;
		}
		else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] != 'O')
		{
			player.getBoardRef().changeBoardValue(2, 0, 'O');
			return true;
		}
		
		return false;
	}
}
