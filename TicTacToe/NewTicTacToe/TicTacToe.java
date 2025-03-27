import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe
{
	private static char[][] board =
		{{' ', ' ', ' '},
		 {' ', ' ', ' '},
		 {' ', ' ', ' '}};
	private static String rowInput;
	private static int row;
	private static String columnInput;
	private static int column;
	private static ArrayList<String> posCheck = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		playGame(0);
		
		scanner.close();
	}
	
	private static void printBoard()
	{
		System.out.println("   a  b  c");
		System.out.println("1 " + Arrays.toString(board[0]));
		System.out.println("2 " + Arrays.toString(board[1]));
		System.out.println("3 " + Arrays.toString(board[2]));
	}
	
	private static boolean isX = true;
	
	public static void playGame(int boxesFilled)
	{
		if (boxesFilled <= 9)
		{
			printBoard();
			
			System.out.println("Pick a row: 1 | 2 | 3");
			rowInput = scanner.nextLine();
			rowCheck(rowInput);
			
			System.out.println("Pick a column: a | b | c");
			columnInput = scanner.nextLine().toLowerCase();
			columnCheck(columnInput);
			
			String pos = "" + row + column;
			if (posCheck.contains(pos))
			{
				System.out.println("That box is already filled.");
				playGame(boxesFilled);
			}
			posCheck.add(pos);
			
			if (isX)
			{
				board[row][column] = 'X';
				isX = false;
			}
			else
			{
				board[row][column] = 'O';
				isX = true;
			}
			
			checkWin();
			
			playGame(boxesFilled + 1);
		}
		endGame();
		
	}
	
	private static void rowCheck(String input)
	{
		try
		{
			row = Integer.parseInt(input) - 1;
			
			if (row > 3 || row < 1)
			{
				System.out.println("Choose a valid row.");
				rowCheck(scanner.nextLine());
			}
		}
		catch (NumberFormatException nfe)
		{
			System.out.println("Choose a valid row.");
			rowCheck(scanner.nextLine());
		}
	}
	
	private static void columnCheck(String input)
	{
		if (input.length() > 1)
		{
			System.out.println("Choose a valid column.");
			columnCheck(scanner.nextLine().toLowerCase());
		}
		
		boolean broken = false;
		for (int i = 97; i < 100; i++)
		{
			if (input.charAt(0) == i)
			{
				broken = true;
				break;
			}
		}
		if (!broken)
		{
			System.out.println("Choose a valid column.");
			columnCheck(scanner.nextLine().toLowerCase());
		}
		
		column = input.charAt(0) - 97;
	}
	
	private static void checkWin()
	{
		checkWinX();
		checkWinY();
	}
	
	private static void checkWinX()
	{
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
				System.out.println("X wins");
				endGame();
			}
		}
		
		if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
		{
			System.out.println("X wins");
			endGame();
		}
		
		if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
		{
			System.out.println("X wins");
			endGame();
		}
		
		if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
		{
			System.out.println("X wins");
			endGame();
		}
		else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
		{
			System.out.println("X wins");
			endGame();
		}
		else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
		{
			System.out.println("X wins");
			endGame();
		}
	}
	
	private static void checkWinY()
	{
		for (char i[] : board)
		{
			int yCount = 0;
			for (char j : i)
			{
				if (j == 'Y')
				{
					yCount++;
				}
			}
			if (yCount == 3)
			{
				System.out.println("Y wins");
				endGame();
			}
		}
		
		if (board[0][0] == 'Y' && board[1][1] == 'Y' && board[2][2] == 'Y')
		{
			System.out.println("Y wins");
			endGame();
		}
		
		if (board[0][2] == 'Y' && board[1][1] == 'Y' && board[2][0] == 'Y')
		{
			System.out.println("Y wins");
			endGame();
		}
		
		if (board[0][1] == 'Y' && board[1][1] == 'Y' && board[2][1] == 'Y')
		{
			System.out.println("Y wins");
			endGame();
		}
	}
	
	private static void endGame()
	{
		System.out.println("Do you want to play again?");
		
		String input = scanner.next();
		if (input.equalsIgnoreCase("yes"))
		{
			playGame(0);
		}
		else
		{
			System.exit(0);
		}
	}
	
}
