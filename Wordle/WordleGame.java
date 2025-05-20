import java.util.Scanner;

public class WordleGame
{
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Wordle! ");
		String soln = solnChooser();
		playGame(soln);
	}
	
	public static void playGame(String soln)
	{
		for (int rounds = 0; rounds <= 7; rounds++)
		{
				System.out.println("Round: " + rounds);
				String input = checkWord();
				
				String result = displayResult(soln, input);
				System.out.println(result);
				
				if (result.equals(input))
				{
					System.out.println("You win!");
					endGame();
					break;
				}
		}
		System.out.println("You lose.");
		System.out.println("The solution was " + soln);
		System.out.println();
		endGame();
			
	}
	
	private static String checkWord()
	{
		String input = "";
		
		boolean test = true;
		while (test)
		{
			input = scanner.nextLine();
			if (input.length() != 5)
			{
				System.out.println("Please input a 5 letter word.");
				continue;
			}
			if (input.indexOf(' ') != -1)
			{
				System.out.println("Please input a 5 letter word with no spaces.");
				continue;
			}
			test = false;
		}
		
		return input;
	}
	
	private static String displayResult(String soln, String input)
	{
		char[] resultCharArray = {'X', 'X', 'X', 'X', 'X'};
		
		//turning soln and input into char arrays
		char[] inputArray = input.toCharArray();
		Character[] solnArray = new Character[soln.length()];
		for (int i = 0; i < soln.length(); i++)
			solnArray[i] = soln.charAt(i);
		
		//checks if there are any letters in input and soln that have the same position in the array
		for (int i = 0; i < solnArray.length; i++)
		{
			if (inputArray[i] == solnArray[i])
			{
				resultCharArray[i] = solnArray[i]; 
				solnArray[i] = null; //removes that letter found
			}
		}
		
		//checks if any letter in input show up in soln
		int resultIndex = 0;
		for (int i = 0; i < inputArray.length; i++)
		{
			for (int j = 0; j < solnArray.length; j++)
			{
				if (solnArray[j] == null) continue;
				
				if (inputArray[i] == solnArray[j])
				{
					resultCharArray[resultIndex] = '?';
					solnArray[j] = null;
					break;
				}
			}
			resultIndex++;
		}
		
		return convertToString(resultCharArray);
	}
	
	private static String convertToString(char[] array)
	{
		String newString = "";
		
		for (char i : array)
			newString += i;
		
		return newString;
	}
	
	private static void endGame()
	{
		System.out.println("Do you want to play again?");
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("yes"))
		{
			System.out.println("Okay. Choosing a new word.");
			System.out.println("Word chosen.");
			playGame(solnChooser());
		}
		else
		{
			scanner.close();
			System.exit(0);
		}
	}

	private static String solnChooser()
	{
		String[] array = {"CRANE", "SWAMP", "MATCH", "CANOE", "POINT", "CREAM", "FREAK"};

		int randomizer = (int)(Math.random() * array.length);
		
		String soln = array[randomizer];
		
		return soln.toLowerCase();
	}
}
