import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Keola Teson
 * @author Daniel Bertubin (he helped a little with things I don't understand)
 */
public class Game
{
	//sets up objects for game
	static Scanner gameScanner = new Scanner(System.in);
			
	public static void main(String[] args)
	{
		//calls the callSetUpClass method
		callSetUpClass();
		
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
		
		/*
		 * allows players to type in their name.
		 * if the player has a space in their name, it prints only up to that space.
		 * if the player doesn't put anything in it, the player is automatically named "John Doe".
		 */
		String playerName = gameScanner.nextLine();
		int checkForSpace = playerName.indexOf(' ');
		if (checkForSpace > -1)
		{
			playerName = playerName.substring(0, checkForSpace);
		}
		int JohnDoe = playerName.length();
		if (JohnDoe <= 0)
		{
			playerName = "John Doe";
		}
		System.out.println(setUpOfGame.checkName(playerName));
		if (playerName.equalsIgnoreCase("Daniel") || playerName.equalsIgnoreCase("Ella")
				|| playerName.equalsIgnoreCase("Amber") || playerName.equalsIgnoreCase("Trauger")
				|| playerName.equalsIgnoreCase("Keola"))
		{
			System.out.println("Hey I think I know someone with that name...");
		}
		
		/*
		 * asks the player if they know what the game is about
		 */
		System.out.println(SetUpOfGame.askQuestion());
		String playerYesOrNo = gameScanner.nextLine();
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
	
	public static void callCharacterClass()
	{
		
	}
}
