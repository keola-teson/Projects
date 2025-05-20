import java.util.Scanner;

/**
 * CONNECT FOUR
 * this was so much easier than i thought it would be
 * @author Keola Teson :)
 */
public class ConnectFour
{
	private static Scanner scanner = new Scanner(System.in); // allows input
	
	private static char[][] board = {
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
			{' ', ' ', ' ', ' ', ' ', ' ', ' '}};
	
	/**
	 * PLAY
	 * where the game is played
	 * @param args
	 */
	public static void main(String[] args)
	{
		//loops until a player wins
		while (checkWin('O'))
		{
			chooseRow('X');
			
			if (checkWin('X'))
			{
				chooseRow('O');
			}
			else
			{
				break;
			}
		}
	}
	
	/**
	 * PRINT
	 * prints it out with cool underlines underneath
	 */
	public static void printBoard()
	{
		System.out.println(" 1 2 3 4 5 6 7 ");
		for (char[] row : board)
		{
			System.out.print("[");
			for (int i = 0; i < row.length; i++)
			{
				System.out.print(row[i]);
				if (i < row.length - 1)
				{
					System.out.print("|");
				}
			}
			System.out.println("]");
		}
	}
	
	/**
	 * CHOOSE
	 * allows player to choose a row between 1 and 7
	 * @param let
	 */
	public static void chooseRow(char let)
	{
		printBoard();
		System.out.println("\n"+ let + " Turn:");
		
		System.out.println("Choose a row to drop a chip in (1 | 2 | 3 | 4 | 5 | 6 | 7):");
		int row = scanner.nextInt() - 1;
		
		while (!placeChip(row, let)) // tests if the row the player selected is valid
		{
			System.out.println("Please choose a valid position.");
			row = scanner.nextInt() - 1;
		}
	}
	
	/**
	 * CHOOSE
	 * the logic for placing the chip
	 * @param posX
	 * @param let
	 * @return true if the chip was placed and false if not
	 */
	private static boolean placeChip(int posX, char let)
	{
		if (posX >= board.length || posX <= 0) // checks if player selected row option
		{
			return false;
		}
		
		int posY = 0;
		
		boolean validRow = false;
		while (!validRow) // loops until a valid row is chosen
		{
			while (posY < board.length && board[posY][posX] == ' ')
			{
				validRow = true;
				posY++;
			}
			if (!validRow)
			{
				return validRow;
			}
		}
		board[posY - 1][posX] = let;
		return validRow;
	}
	
	/**
	 * CHECK
	 * checks for a win condition (4 in a row)
	 * @param let (X or O)
	 * @return true if a player wins and false if not
	 */
	public static boolean checkWin(char let)
	{
		/*
		 * LOGIC
		 * checks the four main paths a win condition could take
		 */
		for (int i = board.length - 1; i >= 0; i--)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == let)
				{
					if (i >= board.length - 4)// makes sure no uneccessary checks are done (also prevents errors)
					{
						// straight up
						if (board[i - 1][j] == let && board[i - 2][j] == let && board[i - 3][j] == let)
						{
							System.out.println(let + " wins!");
							return false;
						}
						
						if (j <= 3) // ditto
						{
							// diagonal to the right
							if (board[i - 1][j + 1] == let && board[i - 2][j + 2] == let && board[i - 3][j + 3] == let)
							{
								System.out.println(let + " wins!");
								return false;
							}
						}
						
						if (j >= board.length - 4) // ditto
						{
							// diagonal to the left
							if (board[i - 1][j - 1] == let && board[i - 2][j - 2] == let && board[i - 3][j - 3] == let)
							{
								System.out.println(let + " wins!");
								return false;
							}
						}
					}
					if (j <= board.length - 4) // ditto
					{
						// straight right
						if (board[i][j + 1] == let && board[i][j + 2] == let && board[i][j + 3] == let)
						{
							System.out.println(let + " wins!");
							return false;
						}
					}
					if (j >= board.length - 4) // ditto
					{
						// straight left
						if (board[i][j - 1] == let && board[i][j - 2] == let && board[i][j - 3] == let)
						{
							System.out.println(let + " wins!");
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	// if you see this comment "daniel is a stinky poopoo face -keola" on his connect four submission
}
