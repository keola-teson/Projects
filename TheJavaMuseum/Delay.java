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
	 * Constructor called when user wants consistent delay for letters
	 * @param string
	 * @param d1
	 */
	public Delay(String str, int delay1)
	{
		this.string = str;
		this.delay1 = delay1;
		
		delayLetters();
	}
	
	/**
	 * Overloaded Constructor
	 * Constructor called when user wants consistent delay for letters
	 * @param string
	 * @param d1
	 */
	public Delay(String str)
	{
		this.string = str;
		this.delay1 = 50;
		
		delayLetters();
	}
	
	/**
	 * Overloaded Constructor
	 * Constructor called when user wants consistent delay for words
	 * @param string
	 * @param d1
	 */
	public Delay(char w, String str, int delay1)
	{
		this.string = str;
		this.delay1 = delay1;
		
		delayWords();
	}
	
	/**
	 * Overloaded Constructor
	 * Constructor called when user wants inconsistent delay for letters
	 * @param string
	 * @param d1
	 */
	public Delay(String str, int delay1, int delay2, int delayInterval)
	{
		this.string = str;
		this.delay1 = delay1;
		
		delayLetters(delayInterval, delay2);
	}
	
	/**
	 * Overloaded Constructor
	 * Constructor called when user wants inconsistent delay for words
	 * @param string
	 * @param d1
	 */
	public Delay(char w, String str, int delay1, int delay2, int delayInterval)
	{
		this.string = str;
		this.delay1 = delay1;
		
		delayWords(delayInterval, delay2);
			
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
			System.out.print("\n");
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
			System.out.print("\n");
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
		try
		{
			for (int i = 0; i < string.length(); i++)
			{
				System.out.print(string.charAt(i));
				if (string.charAt(i) == ' ')
				{
					TimeUnit.MILLISECONDS.sleep(delay1);
				}
			}
			System.out.print("\n");
		}
		catch (InterruptedException e)
		{
			
		}
	}
	
	/**
	 * Overloaded method
	 * Delays each print word by word
	 */
	public void delayWords(int delayInterval, int delay2)
	{
		try
		{
			/*
			 * loops through the length of the string
			 * checks if the i^th char is a space and the index of it evenly divides into delayInterval
			 * - delays it by delay2 milliseconds
			 * checks if the i^th char is a space
			 * - delays it by delay1 milliseconds
			 * prints the char at i
			 */
			for (int i = 0; i < string.length(); i++)
			{
				if (string.charAt(i) == ' ' && i % delayInterval == 0)
				{
					TimeUnit.MILLISECONDS.sleep(delay2);
				}
				else if (string.charAt(i) == ' ')
				{
					TimeUnit.MILLISECONDS.sleep(delay1);
				}
				System.out.print(string.charAt(i));
			}
			System.out.print("\n");
		}
		catch (InterruptedException e)
		{
			
		}
	}
}
