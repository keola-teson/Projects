import java.util.concurrent.TimeUnit;

/**
 * Class to handle delays
 */
public class Delay
{
	/*
	 * Data attributes
	 * ---------------
	 * 
	 * string - string input
	 * delay1 - milliseconds of delay
	 */
	private String string;
	private int delay1;
	
	/**
	 * Overloaded Constructor
	 * Constructor called when user wants consistent delay
	 * @param string
	 * @param d1
	 */
	public Delay(char lw, String str, int d1)
	{
		this.string = str;
		this.delay1 = d1;
		
		switch (lw)
		{
			case 'l':
				delayLetters();
				break;
			case 'w':
				delayWords();
				break;
		}
	}
	
	/**
	 * Overloaded Constructor
	 * Constructor called when user wants inconsistent delay
	 * @param string
	 * @param d1
	 */
	public Delay(char lw, String str, int d1, int d2, int dI)
	{
		this.string = str;
		this.delay1 = d1;
		
		switch (lw)
		{
			case 'l':
				delayLetters(dI, d2);
				break;
			case 'w':
				delayWords(dI, d2);
				break;
		}
	}
	
	/**
	 * Overloaded constructor
	 * Called when user wants to have a generic delay
	 * @param delay
	 */
	public Delay(int delay)
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
	
	/**
	 * Overloaded method
	 * prints letter by letter with a delay of delay1
	 */
	public void delayLetters()
	{
		try
		{
			//loops through the length of the string
			for (int i = 0; i < string.length(); i++)
			{
				//prints the char at i
				System.out.print(string.charAt(i));
				//delay
				TimeUnit.MILLISECONDS.sleep(delay1);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Overloaded method
	 * prints letter by letter with a varied delay
	 * @param delayInterval - how many letters until delay2
	 * @param delay2 - second delay
	 */
	public void delayLetters(int delayInterval, int delay2)
	{
		try
		{
			//loops through the length of he string
			for (int i = 0; i < string.length(); i++)
			{
				//checks if i evenly goes into delayInterval
				if (i % delayInterval == 0)
				{
					//prints out the char at i and delays the next print by delay2
					System.out.print(string.charAt(i));
					TimeUnit.MILLISECONDS.sleep(delay2);
					continue;
				}
				System.out.print(string.charAt(i));
				TimeUnit.MILLISECONDS.sleep(delay1);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Overloaded method
	 * Delays each print word by word
	 */
	public void delayWords()
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
			TimeUnit.MILLISECONDS.sleep(delay1);
			for (int i = 0; i < spaceIndexes.length; i++)
			{
				try
				{
					System.out.print(string.substring(spaceIndexes[i], spaceIndexes[i + 1]));
					TimeUnit.MILLISECONDS.sleep(delay1);
				}
				catch (Exception e)
				{
					System.out.print(string.substring(spaceIndexes[i]));
				}
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Overloaded method
	 * Delays each print word by word
	 */
	public void delayWords(int delayInterval, int delay2)
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
		
		try
		{
			/*
			 * prints the first word (0 is always a constant that is why it is outside the loop)
			 * loops through the length of the array
			 * - modulo math to check if the i^th index of the array goes into delayInterval value evenly
			 *   - delays it by delay2
			 * - prints the string substring from the i^th value in the array to the next value
			 * - try-catch there for when i == the last index
			 * prints the last word (spaceIndexes.length - 1 will always be the last index that is why it is outside the loop)
			 */
			System.out.print(string.substring(0, spaceIndexes[0]));
			TimeUnit.MILLISECONDS.sleep(delay1);
			for (int i = 0; i < spaceIndexes.length; i++)
			{
				try
				{
					if (i % delayInterval == 0)
					{
						System.out.print(string.substring(spaceIndexes[i], spaceIndexes[i + 1]));
						TimeUnit.MILLISECONDS.sleep(delay2);
						continue;
					}
					System.out.print(string.substring(spaceIndexes[i], spaceIndexes[i + 1]));
					TimeUnit.MILLISECONDS.sleep(delay1);
				}
				catch (Exception e)
				{
					System.out.print(string.substring(spaceIndexes[i]));
				}
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
