import java.util.Scanner;

public class Board
{
	private char[][] board;
	
	public Board(char[][] board)
	{
		this.board = board;
		printBoard();
	}
	
	public char[][] getBoard()
	{
		return board;
	}
	
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
			System.out.print("]");
			System.out.println();
		}
	}
	
	public void changeBoardValue(int posY, int posX, char XO)
	{
		this.board[posY][posX] = XO;
	}
	
	public boolean checkBoard()
	{
		for (char[] array : board)
		{
			for (char tile : array)
			{
				if (tile == ' ')
				{
					return false;
				}
			}
		}
		
		return checkWinX() || checkWinO();
	}
	
	private boolean checkWinX()
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
				return true;
			}
		}
		
		if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
		{
			System.out.println("X wins");
			return true;
		}
		
		if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
		{
			System.out.println("X wins");
			return true;
		}
		
		if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
		{
			System.out.println("X wins");
			return true;
		}
		else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
		{
			System.out.println("X wins");
			return true;
		}
		else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
		{
			System.out.println("X wins");
			return true;
		}
		
		return false;
	}
	
	private boolean checkWinO()
	{
		for (char i[] : board)
		{
			int countO = 0;
			for (char j : i)
			{
				if (j == 'O')
				{
					countO++;
				}
			}
			if (countO == 3)
			{
				System.out.println("O wins");
				return true;
			}
		}
		
		if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
		{
			System.out.println("O wins");
			return true;
		}
		
		if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
		{
			System.out.println("O wins");
			return true;
		}
		
		if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')
		{
			System.out.println("O wins");
			return true;
		}
		else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')
		{
			System.out.println("O wins");
			return true;
		}
		else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')
		{
			System.out.println("O wins");
			return true;
		}
		
		return false;
	}
	
	public void endGame()
	{
		try (Scanner scanner = new Scanner(System.in))
		{
			System.out.println("Do you want to play again?");
			String input = scanner.nextLine();
			if (!(input.equalsIgnoreCase("yes")))
			{
				System.exit(0);
			}
		}
		System.out.println("Resetting board.");
		resetBoard();
	}
	
	private void resetBoard()
	{
		this.board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
	}
}
