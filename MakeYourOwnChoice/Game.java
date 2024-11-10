import java.util.Arrays;
import java.util.Scanner;
/**
 * This is where the game is played.
 * @author Keola Teson :)
 */
public class Game
{
	//sets up objects for game
	static Scanner gameScanner = new Scanner(System.in);
			
	public static void main(String[] args)
	{
		//calls the callSetUpClass method
		callSetUpClass();
		
		//calls the callCharactersClass method
		callCharactersClass();
		
		//closes scanner
		gameScanner.close();
	}
	
	/**
	 * this method calls the setUpOfGame class
	 */
	public static void callSetUpClass()
	{
		SetUpOfGame setUpOfGame = new SetUpOfGame();
		
		//welcomes player by calling a static method from a SetUpOfGame class
		System.out.println(SetUpOfGame.welcomePlayer());
		
		//allows the player to input their name
		String playerName = gameScanner.nextLine();
		//checks if there is a space in the name
		if (playerName.indexOf(' ') != -1)
		{
			//only stores the first name
			playerName = playerName.substring(0, playerName.indexOf(' '));
		}
		//checks if the length is 0
		if (playerName.length() == 0)
		{
			//automatically sets name to John Doe
			playerName = "John Doe";
		}
		
		//calls and prints the checkName method with the playerName object passed
		System.out.println(setUpOfGame.checkName(playerName));
		
		//calls the askQuestion method from the SetUpOfGame class
		System.out.println(SetUpOfGame.askQuestion());
		//allows the player to type an answer
		String playerYesOrNo = gameScanner.nextLine();
		//prints a response based on if the player printed yes or no
		System.out.print(setUpOfGame.answerQuestion(playerYesOrNo));
		
		/*
		 * checks if the player inputted yes or no.
		 * if the check is true, the player plays the game and continues to the giveExposition method
		 * if the check is false, the game ends.
		 */
		if(playerYesOrNo.equalsIgnoreCase("yes") || playerYesOrNo.equalsIgnoreCase("no"))
		{
			//gives exposition to help the player understand
			System.out.println(SetUpOfGame.giveExposition());
		}
	}
	
	public static void callCharactersClass()
	{
		/*
		 * *THIS IS A TEST*
		 * instantiates all my character objects and puts their occupation in the parameters
		 */
		Characters partner = new Characters("partner");
		Characters captain = new Characters("captain");
		Characters roommate = new Characters("roommate");
		Characters barista = new Characters("barista");
		Characters forensics = new Characters("forensics");
		Characters murderer = new Characters("murderer");
		Characters bum = new Characters("bum");
		Characters player = new Characters("player");
		
		/*
		 * *THIS IS A TEST*
		 * calls the getCharacterAttributes class to get the attributes of the character
		 */
		System.out.println(Arrays.toString(partner.getCharacterAttributes()));
		System.out.println(Arrays.toString(captain.getCharacterAttributes()));
		System.out.println(Arrays.toString(roommate.getCharacterAttributes()));
		System.out.println(Arrays.toString(barista.getCharacterAttributes()));
		System.out.println(Arrays.toString(forensics.getCharacterAttributes()));
		System.out.println(Arrays.toString(murderer.getCharacterAttributes()));
		System.out.println(Arrays.toString(bum.getCharacterAttributes()));
		System.out.println(Arrays.toString(player.getCharacterAttributes()));
	}
}
