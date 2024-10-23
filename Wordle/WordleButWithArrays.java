import java.util.Scanner;
/**
 * This is my wordle game I made for class. The player inputs a five letter word and the code compares that
 * word to the answer string. A bunch of stuff that my teacher didn't yet teach like while loops and arrays lol.
 * @author Keola Teson :)
 */
public class WordleButWithArray
{
	public static void main(String[] args)
	{
		//instantiates scanner for game
		Scanner myScanner = new Scanner(System.in);
		
		//creates an array to randomize the answer of the wordle
		String[] wordleWordArray = {"HALVE", "SHELL", "PRONE", "STAIN", "MOMMY", "JOINT", "STERN", "MODEM"};
		int randomGenerator = (int)(Math.random() * wordleWordArray.length);
		String wordleAnswer = wordleWordArray[randomGenerator];
		wordleAnswer = wordleAnswer.toLowerCase();
		
		//welcomes player to wordle and allows them to type in their first guess
		System.out.println("Welcome to Wordle! Guess a 5 letter word (no repeating letters): ");
		
		/*
		 * creates boolean (isCorrect) and sets it to false for while loop
		 * while loop to return to the top if the player didn't get the answer correct
		 */
		int isCorrect = 0;
		while (isCorrect < 6)
		{
			//instantiates string object to allow the player to type
			String playerInput = new String(myScanner.next());
			
			/*
			 * sets up boolean (checkLength) for while loop
			 * sets up while loop to allow the player to reinput a word if the input is not a length of 5
			 * - checks if the length of the word is not 5
			 *   - tells the player to input a new word that is 5 letters
			 *   - calls the string input again
			 * - if the check is false, set the boolean (checkLength) to false to leave the while loop
			 */
			boolean checkLength = true;
			while (checkLength == true)
			{
				if (playerInput.length() != 5)
				{
					System.out.println("Please input a 5 letter word (no repeating letters).");
					playerInput = myScanner.next();
				}
				else
				{
					checkLength = false;
				}
			}
			
			//runs the code in the playGame method
			playGame(playerInput, wordleAnswer);
			
			/*
			 * if statement to check if the input is equal to the string object wordleAnswer
			 * - congratulates the player and asks them if they want to play again
			 *   - if the player types no, the boolean variable (isCorrect) is set to true and the while loop
			 *     gets exitted
			 *   - no else statement needed
			 * no else statement needed. loops back to the top until the user inputs the right word
			 */
			if (playerInput.equals(wordleAnswer))
			{
				System.out.println("Congratulations! You beat this wordle game! Play again?");
				playerInput = myScanner.next();
				if (playerInput.equalsIgnoreCase("no"))
				{
					isCorrect = 7;
				}
				else if (playerInput.equalsIgnoreCase("yes"))
				{
					isCorrect = 0;
					String[] wordleWordArrayTwo = {"HALVE", "SHELL", "PRONE", "STAIN", "MOMMY", "JOINT", 
												   "STERN", "MODEM"};
					randomGenerator = (int)(Math.random() * wordleWordArray.length);
					wordleAnswer = wordleWordArrayTwo[randomGenerator];
					wordleAnswer = wordleAnswer.toLowerCase();
				}
			}
			
			/*
			 * adds one to variable isCorrect
			 * checks if the variable has the value of 6 and if the playerInput string object doesn't equal
			 * to the wordleAnswer string variable
			 * - tells the player they lost and to try again next time. :(
			 * doesn't need an else statement
			 */
			isCorrect++;
			if (isCorrect == 6 && !(playerInput.equals(wordleAnswer)))
			{
				System.out.println("You have lost. Better luck next time. :(");
			}
		}
		
		//closes scanner
		myScanner.close();
	}
	
	/**
	 * where most of the game actually happens. very long, very cool
	 * @param soln
	 * @param answer
	 */
	public static void playGame(String soln, String answer)
	{
		
		/*
		 * sets up char variables (first; second; third; fourth; fifth) to use in if statements
		 */
		char first = answer.charAt(0);
		char second = answer.charAt(1);
		char third = answer.charAt(2);
		char fourth = answer.charAt(3);
		char fifth = answer.charAt(4);
		
		/*
		 * sets up char variables (firstSoln; secondSoln; thirdSoln; fourthSoln; fifthSoln) to compare to
		 * answer chars
		 */
		char firstSoln = soln.charAt(0);
		char secondSoln = soln.charAt(1);
		char thirdSoln = soln.charAt(2);
		char fourthSoln = soln.charAt(3);
		char fifthSoln = soln.charAt(4);
		
		/*
		 * checks if the first char of your input is not the same as the first char of the answer
		 * - checks if the other letters match any letter in the answer
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the first letter in the input and the first letter in the answer are the
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
		 * checks if the second char of your input is not the same as the second char of the answer
		 * - checks if the other letters match any letter in the answer
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the second letter in the input and the second letter in the answer are
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
		 * checks if the third char of your input is not the same as the third char of the answer
		 * - checks if the other letters match any letter in the answer
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the third letter in the input and the third letter in the answer are the
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
		 * checks if the fourth char of your input is not the same as the fourth char of the answer
		 * - checks if the other letters match any letter in the answer
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the fourth letter in the input and the fourth letter in the answer are 
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
		 * checks if the fifth char of your input is not the same as the fifth char of the answer
		 * - checks if the other letters match any letter in the answer
		 * - if the check is true, prints '?'
		 * - if the check is false, prints 'x'
		 * if the check is false and the fifth letter in the input and the fifth letter in the answer are the
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
	}
}
