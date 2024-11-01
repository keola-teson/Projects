import java.util.Scanner;

/**
 * This class is a simplified recreation of wordle. This is a project for my AP Comp Sci class
 * @author Keola Teson :)
 */
public class WordleGame
{
	/*
	 * Data Attributes
	 * ---------------
	 * 
	 * myScanner = a scanner object to allow the player to type in the console
	 * soln = the solution the input is compared to
	 * input = the input the player types
	 */
	static Scanner myScanner = new Scanner(System.in);
	static String soln;
	static String input;
	
	public static void main(String[] args)
	{
		//welcomes the player to wordle
		System.out.println("Welcome to Wordle! Guess a 5 letter word (no repeating letters): ");
		
		//calls solnChooser method to randomizer the word the player has to guess
		solnChooser();
		
		//calls checkReps class to allow the player to type
		checkReps();
	}
	
	/**
	 * This method allows the player to type and checks if any character in the input is the same as another in
	 * the same input
	 */
	public static void checkReps()
	{
		//String object to store what the player types
		input = new String(myScanner.nextLine());
		
		//char variables for each char in the input
		char firstChar  = input.charAt(0);
		char secondChar = input.charAt(1);
		char thirdChar  = input.charAt(2);		
		char fourthChar = input.charAt(3);
		char fifthChar  = input.charAt(4);
		
		/*
		 * compares every char to another char
		 * - if the check is true, tells the player to type again and calls the method again
		 * - if the check is false, calls the checkLength method with the value stored in input
		 */
		if (firstChar  == secondChar || firstChar  == thirdChar  || firstChar  == fourthChar  || 
			firstChar  == fifthChar  || secondChar == thirdChar  || secondChar == fourthChar  || 
			secondChar == fifthChar  || thirdChar  == fourthChar || thirdChar  == fifthChar   ||
			fourthChar == fifthChar)
		{
			System.out.println("Please reinput a word. No repeating letters!");
			checkReps();
		}
		else
		{
			checkLength(input);
		}
	}
	
	/**
	 * Checks if the input the player typed is longer or shorter than 5 letters
	 * @param input
	 */
	public static void checkLength(String input)
	{
		//checks if the length is not 5
		if (input.length() != 5)
		{
			//tells the player to reinput a 5 letter word
			System.out.println("Please input a (5) letter word.");
			//calls the checkReps method again to allow the player to type
			checkReps();
		}
		else
		{
			//if the check is false, move on to the playGame method
			playGame(soln, input);
		}
	}
	
	/**
	 * Where the player actually plays the game
	 * @param soln
	 * @param input
	 */
	public static void playGame(String soln, String input)
	{
		
		/*
		 * sets up char variables (first; second; third; fourth; fifth) to use in if statements
		 */
		char first = input.charAt(0);
		char second = input.charAt(1);
		char third = input.charAt(2);
		char fourth = input.charAt(3);
		char fifth = input.charAt(4);
		
		/*
		 * sets up char variables (firstSoln; secondSoln; thirdSoln; fourthSoln; fifthSoln) to compare to
		 * input chars
		 */
		char firstSoln = soln.charAt(0);
		char secondSoln = soln.charAt(1);
		char thirdSoln = soln.charAt(2);
		char fourthSoln = soln.charAt(3);
		char fifthSoln = soln.charAt(4);
		
		/*
		 * checks if the first char of your input is not the same as the first char of the input
		 * - checks if the other letters match any letter in the input
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the first letter in the input and the first letter in the input are the
		 * same
		 */
		if (firstSoln != first)
		{
			if (firstSoln == second|| firstSoln == third || firstSoln == fourth || firstSoln == fifth)
			{
				System.out.print('?');
			}
			else
			{
				System.out.print('x');
			}
		}
		else
		{
			System.out.print(firstSoln);
		}
		
		
		/*
		 * checks if the second char of your input is not the same as the second char of the input
		 * - checks if the other letters match any letter in the input
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the second letter in the input and the second letter in the input are
		 * the same
		 */
		if (secondSoln != second)
		{
			if (secondSoln == first || secondSoln == third || secondSoln == fourth || secondSoln == fifth)
			{
				System.out.print('?');
			}
			else
			{
				System.out.print('x');
			}
		}
		else
		{
			System.out.print(secondSoln);
		}
		
		/*
		 * checks if the third char of your input is not the same as the third char of the input
		 * - checks if the other letters match any letter in the input
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the third letter in the input and the third letter in the input are the
		 * same
		 */
		if (thirdSoln != third)
		{
			if (thirdSoln == first || thirdSoln == second || thirdSoln == fourth || thirdSoln == fifth)
			{
				System.out.print('?');
			}
			else
			{
				System.out.print('x');
			}
		}
		else
		{
			System.out.print(thirdSoln);
		}
		
		/*
		 * checks if the fourth char of your input is not the same as the fourth char of the input
		 * - checks if the other letters match any letter in the input
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the fourth letter in the input and the fourth letter in the input are 
		 * the same
		 */
		if (fourthSoln != fourth)
		{
			if (fourthSoln == first || fourthSoln == second || fourthSoln == third || fourthSoln == fifth)
			{
				System.out.print('?');
			}
			else
			{
				System.out.print('x');
			}
		}
		else
		{
			System.out.print(fourthSoln);
		}
		
		/*
		 * checks if the fifth char of your input is not the same as the fifth char of the input
		 * - checks if the other letters match any letter in the input
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the fifth letter in the input and the fifth letter in the input are the
		 * same
		 */
		if (fifthSoln != fifth)
		{
			if (fifthSoln == first || fifthSoln == second || fifthSoln == third || fifthSoln == fourth)
			{
				System.out.println('?');
			}
			else
			{
				System.out.println('x');
			}
		}
		else
		{
			System.out.println(fifthSoln);
		}
		
		/*
		 * instantiates a new String object (ifCorrect) that concatinates the char variables with the string
		 * checks if the String object (ifCorrect) is equal to the value of soln
		 * if the check is true, tells the player they won
		 * else, calls the checkReps() method again to start the loop over
		 */
		String ifCorrect = new String("" + first + second + third + fourth + fifth);
		if (ifCorrect.equals(soln))
		{
			System.out.println("You win!");
		}
		else
		{
			checkReps();
		}
	}
	
	/**
	 * This method randomizes the solution for the word
	 */
	public static void solnChooser()
	{
		//makes an array variable with different words to choose from
		String[] array = {"CRANE", "SWAMP", "MATCH", "CANOE", "POINT", "CREAM", "FREAK"};
		
		//randomly chooses a number between 0 and the length of the array and stores it as an int
		int randomizer = (int)(Math.random() * array.length);
		
		//gives the soln variables instantiated as a data attribute a value of a random word in the array
		soln = array[randomizer];
		
		//sets soln to lowercase
		soln = soln.toLowerCase();
	}
}
