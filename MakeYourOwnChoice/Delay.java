import java.util.concurrent.TimeUnit;

/**
 * Class to delay strings I want to delay
 * @author Keola Teson :)
 */
public class Delay
{
	/**
	 * Constructor called when you make the Delay object
	 * Used for if you want to pass a string
	 * @param string - this inputted sentence is what gets delayed
	 * @param delay - the amount of milliseconds each word or letter gets delayed
	 * @param bool - determines if you are delaying letter by letter or word by word
	 */
	Delay(String string, int delay, boolean bool)
	{
		/*
		 * checks if bool is true
		 * - try-catch necessary
		 * - for loop (iterates through the entire string
		 *   - prints out eat character with a delay after print
		 */
		if (bool)
		{
			try
			{
				for (int i = 0; i < string.length(); i++)
				{
					System.out.print(string.charAt(i));
					TimeUnit.MILLISECONDS.sleep(delay);
				}
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		//checks if bool is false
		if (!bool)
		{
			/*
			 * keeps track of the amount of spaces in the string
			 * loops through the string
			 * - checks if the i^th index is a space. adds one to the counter
			 */
			int spaceCount = 0;
			for (int i = 0; i < string.length(); i++)
			{
				if (string.charAt(i) == ' ')
				{
					spaceCount++;
				}
			}
			
			/*
			 * array to keep track of the indexes of the spaces (length is determined by space counter)
			 * loops through string
			 * - checks if the i^th index is a space
			 *   - loops through the length of the array
			 *     - checks if the j^th index of the array is a 0. changes the value to i and breaks the loop
			 */
			int[] spaceIndexes = new int[spaceCount];
			for (int i = 0; i < string.length(); i++)
			{
				if (string.charAt(i) == ' ')
				{
					for (int j = 0; j < spaceIndexes.length; j++)
					{
						if (spaceIndexes[j] == 0)
						{
							spaceIndexes[j] = i;
							break;
						}
					}
				}
			}
			
			//try-catch necessary
			try
			{
				/*
				 * prints the first word (0 is always a constant that is why it is outside the loop)
				 * loops through the length of the array
				 * - prints the string substring from the i^th value in the array to the next value
				 * - try-catch there for when i == the last index
				 *   - breaks the loop
				 * prints the last word (spaceIndexes.length - 1 will always be the last index that is why it is outside the loop)
				 */
				System.out.print(string.substring(0, spaceIndexes[0]));
				TimeUnit.MILLISECONDS.sleep(delay);
				for (int i = 0; i < spaceIndexes.length; i++)
				{
					try
					{
						System.out.print(string.substring(spaceIndexes[i], spaceIndexes[i + 1]));
						TimeUnit.MILLISECONDS.sleep(delay);
					}
					catch (Exception e)
					{
						break;
					}
				}
				System.out.print(string.substring(spaceIndexes[spaceIndexes.length - 1]));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Overloaded constructor
	 * Used for if you want to just have a delay between code
	 * @param delay - the amount of milliseconds between each action
	 */
	Delay(int delay)
	{
		try
		{
			TimeUnit.MILLISECONDS.sleep(delay);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
