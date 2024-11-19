/**
 * This class is made for setting up the game by asking what the player's name is, 
 * asking if the player knows what the game is about, and 
 * gives exposition to help the player understand what the player's character is
 * @author Keola Teson
 */
public class SetUpOfGame
{
	private String name;

	public SetUpOfGame() {}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Welcomes the player to the game
	 * @return "Welcome, new player, what is your name?"
	 */
	public static String welcomePlayer()
	{
		return "\033[3mWelcome, new player, what is your name?\033[0m";
	}
	
	/**
	 * restates the players input
	 * @param name
	 * @return "You're name is " + name + "? What an interesting name."
	 */
	public String checkName(String name)
	{
		return "\033[3mYou're name is " + name + "? What an interesting name.";
	}
	
	/**
	 * asks the player if they know how to play the game
	 * @return "Do you know what your job is? (yes or no)"
	 */
	public static String askQuestion()
	{
		return "\033[3mDo you know what your job is? (yes or no)\033[0m";
	}
	
	/**
	 * returns an answer based on if the user inputted "yes" or "no"
	 * if the user inputs something that isn't "yes" or "no", just call the method again with the string 
	 * value "no"
	 * @param answer
	 * @return "You don't! How did you even get hired? You're a detective and ";   
	 * "Wow. You're better than the last guy we hired... Anyway, "
	 * @throws Exception 
	 */
	public static String answerQuestion(String answer) throws Exception
	{
		if (answer.indexOf("yes") != -1 && answer.indexOf("no") != -1)
		{
			System.out.print("\n\033[3mbro really... you know what... \n");
			return forTheJokers();
		}
		else if (answer.indexOf("no") != -1)
		{
			return "\n\033[3mYou don't! How did you even get hired? Well, you're a detective and ";
		}
		else if (answer.indexOf("yes") != -1)
		{
			return "\n\033[3mWow. You're better than the last guy we hired... Anyway, ";
		}
		return "\033[3moh you're tryna be funny?\n" + forTheJokers();
	}
	
	/**
	 * gives the player some exposition to help the player understand what the game is about
	 * @return "you have a new case assignment. 
	 * A murderer is running rampant and you have to bring them in."
	 */
	public static String giveExposition()
	{
		return "\033[3myou have a new case assignment. " +
				"\nA murderer is running rampant and you have to bring them in.";
	}
	
	/**
	 * This method is for the people that think they're funny and input something that I don't like
	 * @return a not so nice string
	 * @throws Exception 
	 */
	private static String forTheJokers () throws Exception
	{
		System.out.println("\033[3mthe game is over... \nthe murderer killed you on your first day. you rot in hell.");
		throw new Exception("don't do that.");
	}
}
