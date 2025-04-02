package board;

/**
 * BOARD CLASS
 * This class controls the logic of the board like a player winning or tieing
 * @author Keola Teson :)
 */
public class Board
{
	//BOARD
	private char[][] board;
	
	/**
	 * CONSTRUCTOR
	 * @param board
	 */
	public Board(char[][] board)
	{
		this.board = board;
	}
	
	/**
	 * GETTER
	 * @return the board
	 */
	public char[][] getBoard()
	{
		return board;
	}
	
	/**
	 * PRINTS BOARD
	 * prints the board like this -> [_|_|_]
	 * Arrays.toString(board[i]) does the same thing but Mr. Trauger said I couldn't use it (￢_￢),
	 */
	public void printBoard()
	{
		for (char[] row : board)
		{
			System.out.print("[");
			System.out.print("\033[4m");
			for (int i = 0; i < row.length; i++)
			{
				System.out.print(row[i]);
				if (i < row.length - 1)
				{
					System.out.print("|");
				}
			}
			System.out.print("\033[0m");
			System.out.println("]");
		}
	}
	
	/**
	 * SETTER (kinda)
	 * allows user to change a specific elements on board without making a whole new array
	 * @param posY
	 * @param posX
	 * @param XO
	 */
	public void changeBoardValue(int posY, int posX, char XO)
	{
		this.board[posY][posX] = XO;
	}
	
	/**
	 * Checks board
	 * boolean to be used for future logic
	 * @return a true or false value based on the nor gates
	 */
	public boolean checkBoard()
	{
		//nor gate because false is turned to true which breaks the while loop (said future logic)
		return checkWin() && checkTie();
	}
	
	/**
	 * CHECKER ONE
	 * checks if X won
	 * @return false if the player won 
	 */
	private boolean checkWin()
	{
		int amountX;
		int amountO;
		
		/*
		 * CHECK ONE
		 * checks the rows for an X win condition (three in a row)
		 * returns false if found
		 * - moves to next check if not
		 */
		for (char row[] : board)
		{
			amountX = 0;
			amountO = 0;
			for (char box : row)
			{
				if (box == 'X')
				{
					amountX++;
				}
				else if (box == 'O')
				{
					amountO++;
				}
			}
			if (amountX == board.length)
			{
				System.out.println("Player One Wins!\n");
				return false;
			}
			else if (amountO == board.length)
			{
				System.out.println("Player One Loses!\n");
				return false;
			}
		}
		
		/*
		 * CHECK TWO
		 * checks the two diagonals for an X win condition (three in a row)
		 * returns false if found
		 * - moves to next check if not
		 */
		int posY = 0;
		int posX = 0;
		
		amountX = 0;
		amountO = 0;
		
		while (posY < board.length)
		{
			if (board[posY][posX] == 'X') amountX++;
			if (board[posY][posX] == 'O') amountO++;
			
			if (amountX == board.length)
			{
				System.out.println("Player One Wins!\n");
				return false;
			}
			if (amountO == board.length)
			{
				System.out.println("Player One Loses!\n");
				return false;
			}
			
			posY++;
			posX++;
		}
		
		posY = 0;
		posX = board.length - 1;
		
		amountX = 0;
		amountO = 0;
		
		while (posY < board.length)
		{
			if (board[posY][posX] == 'X') amountX++;
			if (board[posY][posX] == 'O') amountO++;
			
			if (amountX == board.length)
			{
				System.out.println("Player One Wins!\n");
				return false;
			}
			if (amountO == board.length)
			{
				System.out.println("Player One Loses!\n");
				return false;
			}
			
			posY++;
			posX--;
		}
		
		/*
		 * CHECK THREE
		 * checks the columns for an X win condition (three in a row)
		 * returns false if found
		 * - moves to next check it not
		 * 
		 * like row check but inversed
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
				}
				else if (board[j][i] == 'O')
				{
					amountO++;
				}
			}
			if (amountX == board.length)
			{
				System.out.println("Player One Wins!\n");
				return false;
			}
			else if (amountO == board.length)
			{
				System.out.println("Player One Loses!\n");
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * CHECK THREE
	 * checks for a tie in the event nobody wins
	 * @return true if not found false if found
	 */
	private boolean checkTie()
	{
		/*
		 * Similar to row checks but checks when the loops are done instead of only when the inner loop is done
		 */
		int count = 0;
		for (char[] row : board)
		{
			for (char box : row)
			{
				if (box != ' ')
				{
					count++;
				}
			}
		}
		if (count == board.length * board.length)
		{
			System.out.println("Tie!");
			return false;
		}
		
		return true;
	}
	
	/**
	 * RESET
	 * Used to reset the board when the game is finished and the player wants to play again
	 */
	public void resetBoard()
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				board[i][j] = ' ';
			}
		}
	}
}
