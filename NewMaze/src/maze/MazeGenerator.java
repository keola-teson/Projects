package maze;

import java.util.concurrent.TimeUnit;

public class MazeGenerator
{
	
	private char[][] maze =
		{{'|', '|', '|', '|', '|', '|', '|', '|', '|', '|'},
		 {'|', '|', '|', '|', '|', '|', '|', '|', '|', '|'},
		 {'|', '|', '|', '|', '|', '|', '|', '|', '|', '|'},
		 {'|', '|', '|', '|', '|', '|', '|', '|', '|', '|'},
		 {'|', '|', '|', '|', '|', '|', '|', '|', '|', '|'}};
	
	
	public char[][] buildMaze()
	{
		int startY = (int)(Math.random() * 5);
		int endY = (int)(Math.random() * 5);
		
		System.out.println(startY + " " + endY);
		
		buildPath(startY, 0, endY, maze[endY].length - 1);
		
		return maze;
	}
	
	private void buildPath(int startY, int startX, int endY, int endX)
	{
		maze[startY][startX] = ' ';
		maze[endY][endX] = 'O';
		
		int count = 1;
		while (startY != endY || startX != endX)
		{
			int rand = (int)(Math.random() * 2); // 0 == y; 1 == x
			
			if (startY > endY && count == 3)
			{
				if (startY - 1 > -1)
					startY--;
			}
			else
			{
				if (rand == 0 && startY + 1 < maze.length)
					startY++;
				else if (rand == 1 && startX + 1 < maze[startY].length)
					startX++;
			}
			
			maze[startY][startX] = ' ';
			count++;
			
			try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
			
			printMaze();
			System.out.println();
		}
	}
	
	private void printMaze()
	{
		for (char[] i : maze)
		{
			System.out.print("[");
			for (char j : i)
			{
				System.out.print(j);
			}
			System.out.println("]");
		}
	}
}
