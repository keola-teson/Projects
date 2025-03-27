
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
	 * prints the board like this -> [ , , ]
	 * Arrays.toString(board[i]) does the same thing but Mr. Trauger said I couldn't use it (￢_￢),
	 */
	public void printBoard()
	{
		for (char[] row : board)
		{
			System.out.print("[");
			for (int i = 0; i < row.length; i++)
			{
				System.out.print(row[i]);
				if (i < row.length - 1)
				{
					System.out.print(", ");
				}
			}
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
		return !checkWinX() || !checkWinO() || !checkTie();
	}
	
	/**
	 * CHECKER ONE
	 * checks if X won
	 * @return false if the player won 
	 */
	private boolean checkWinX()
	{
		/*
		 * CHECK ONE
		 * checks the rows for an X win condition (three in a row)
		 * returns false if found
		 * - moves to next check if not
		 */
		for (char i[] : board)
		{
			int xCount = 0;
			for (char j : i)
			{
				if (j == 'X')
				{
					xCount++;
				}
			}
			if (xCount == 3)
			{
				System.out.println("X wins!");
				return false;
			}
		}
		
		/*
		 * CHECK TWO
		 * checks the two diagonals for an X win condition (three in a row)
		 * returns false if found
		 * - moves to next check if not
		 */
		if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
		{
			System.out.println("X wins!");
			return false;
		}
		else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
		{
			System.out.println("X wins!");
			return false;
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
			int xCount = 0;
			for (int j = 0; j < board.length; j++)
			{
				if (board[j][i] == 'X')
				{
					xCount++;
				}
			}
			if (xCount == 3)
			{
				System.out.println("X wins!");
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * CHECKER TWO
	 * checks if O won
	 * @return false if the player won 
	 */
	private boolean checkWinO()
	{
		/*
		 * CHECK ONE
		 * checks the rows for an O win condition (three in a row)
		 * returns false if found
		 * - moves to next check if not
		 */
		for (char i[] : board)
		{
			int oCount = 0;
			for (char j : i)
			{
				if (j == 'O')
				{
					oCount++;
				}
			}
			if (oCount == 3)
			{
				System.out.println("O wins!");
				return false;
			}
		}
		
		/*
		 * CHECK TWO
		 * checks the two diagonals for an O win condition (three in a row)
		 * returns false if found
		 * - moves to next check if not
		 */
		if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
		{
			System.out.println("O wins!");
			return false;
		}
		else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
		{
			System.out.println("O wins!");
			return false;
		}
		
		/*
		 * CHECK THREE
		 * checks the columns for an O win condition (three in a row)
		 * returns false if found
		 * - moves to next check it not
		 * 
		 * like row check but inversed
		 */
		for (int i = 0; i < board[0].length; i++)
		{
			int oCount = 0;
			for (int j = 0; j < board.length; j++)
			{
				if (board[j][i] == 'O')
				{
					oCount++;
				}
			}
			if (oCount == 3)
			{
				System.out.println("O wins!");
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
		if (count == 9)
		{
			System.out.println("Tie!");
			return false;
		}
		
		return true;
	}
	
	/**
	 * ACTUAL SETTER
	 * Used to reset the board when the game is finished and the player wants to play again
	 */
	public void resetBoard(char[][] board)
	{
		this.board = board;
	}
}
