import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Handles the text shown in the console. Handles logic. Seperated out by scenes
 * scenes are started by switching the isInside boolean value in a location object to true
 * scenes are ended by switching the isInside boolean value in a location object to false 
 * I hope to god that this is what he wanted.
 * @author Keola Teson :)
 */
public class Dialogue
{
	/*
	 * Data Attributes
	 * ---------------
	 * 
	 * Character objects:
	 * - player
	 * - partner
	 * - captain
	 * - roommate
	 * - barista
	 * - forensics
	 * - murderer
	 * - bum
	 * 
	 * Location objects:
	 * - coffee
	 * - precinct
	 * - apt
	 * - road
	 * * more to come *
	 * 
	 * Scanner for input
	 * 
	 * ArrayList to store the choices the player makes (for doing a *character* remembered that function like in TellTale games)(maybe)
	 * 
	 * File Objects:
	 * - characterList
	 * - .sessionSaver (hidden)
	 * - endingsTracker
	 *   - endings string object to store all the saved endings
	 * - relationshipTracker
	 *   - relationship array for each character (will change to HashMap in the future)(maybe)
	 *   - relationshipData string to store the array into the file
	 * - .playerFile (hidden)
	 *   - playerData to store the array into the file
	 */
	
	//Character Objects:							 Name		   	 Age		   Occupation				Hobby			Favorite				Relationship	Color
	static Characters player 	= new Characters(""					,"25"		,"Detective"			,""			  	,""								,"good");
	static Characters partner   = new Characters("Harry Freeman"	,"27"       ,"Detective"			,"Photography"	,"Sunsets"						,"good");	//Green
	static Characters captain   = new Characters("Steven Anders"	,"50"       ,"Police Captain"		,"Fishing"		,"Beaches"						,"good");	//Light Blue
	static Characters roommate  = new Characters("Wallice West"		,"22"		,"Unemployed"			,"Collecting"	,"Mint Condition Miku Figure"	,"good");	//Yellow
	static Characters barista   = new Characters("Ruby Hesser"		,"24"       ,"Barista"				,"Dancing"		,"Cats"							,"good");	//Pink
	static Characters forensics = new Characters("Alex Payne"		,"31"       ,"Forensics Scientist"	,"Gardening"	,"Begonia"						,"good");	//Salmon
	static Characters murderer  = new Characters("Unknown"			,"Unknown"  ,"Unknown"				,"Unknown"		,"Unknown"						,"good");	//Red
	static Characters bum       = new Characters("Tritan Nesto"		,"25"       ,"Bum"					,"Exploring"	,"His Camera"					,"good");	//Black Background
	
	//Location Objects:						  Location			Inside?
	static Location coffee   = new Location("Coffee Shop"		,false);
	static Location precinct = new Location("Police Precinct"	,false);
	static Location apt	   	 = new Location("Apartment"			,false);
	static Location outside	 = new Location("Road"				,false);	
	
	static Scanner myScanner = new Scanner(System.in);
	
	static private ArrayList<String> choices = new ArrayList<>();
	
	static FileManager characterList = new FileManager("Character_List.txt");
	
	static FileManager sessionSaver = new FileManager(".Session_Saver");
	
	static private String endings = "";
	static FileManager endingsTracker = new FileManager("Endings_Tracker.txt");
	
	static private String[] relationship = {"Partner - Good", "Captain - Good", "Roommate - Good", "Barista - Good", "Forensics - Good", " ", "Bum - Good"};
	static private String relationshipData = "";
	static FileManager relationshipTracker = new FileManager("Relationship_Tracker.txt");
	
	static private String playerData = "";
	static FileManager playerFile = new FileManager(".Player_File");

	/**
	 * Method to set up game files
	 * @throws FileNotFoundException
	 */
	public static void setUpGameFiles() throws FileNotFoundException
	{
		/*
		 * Creates a new Character_List file by calling the createNewFile method
		 * Writes each character into with their respective colors into the file with the writeIntoFile method
		 */
		characterList.createNewFile();
		characterList.writeIntoFile(
				"""
				Partner - Green
				Captain - Light Blue
				Roommate - Yellow
				Barista - Pink
				Forensics - Salmon
				Murderer - Red
				Bum - Black Background
				""");
		
		//Creates a new Endings_Tracker file
		endingsTracker.createNewFile();
		
		/*
		 * Creates a new Relationship_Tracker file
		 * loops through relationship array
		 * - adds every item in the array into relationshipData String
		 * writes relationshipData into file
		 */
		relationshipTracker.createNewFile();
		for (String i : relationship)
		{
			relationshipData += i + "\n";
		}
		relationshipTracker.writeIntoFile(relationshipData);
		
		/*
		 * Creates a new Player_File file
		 * loops through player attributes
		 * - adds every item in the array into playerData String
		 * writes playerData into file
		 */
		playerFile.createNewFile();
		playerData = "";
		for (String i : player.getCharacterAttributes())
		{
			playerData += i + "\n";
		}
		playerFile.writeIntoFile(playerData);
	}
	
	/**
	 * Simply calls the setUp class to set up the game with and allows them to input their name
	 * @throws Exception
	 */
	public static void setUpGame() throws Exception
	{	
		
		//welcomes the player and lets them type their name
		System.out.print(ConsoleColors.ITALICS);
		System.out.println("Welcome, new player, what is your name?" + ConsoleColors.RESET);
		String name = myScanner.nextLine();
		//sets the subname to name for future use
		
		//checks if the player didn't input anything and automatically sets their name to "John Doe"
		if (name.length() == 0)
		{
			player.setName("John Doe");
		}
		System.out.println("");
		
		playerData = "";
		for (String i : player.getCharacterAttributes())
		{
			playerData += i + "\n";
		}
		playerFile.writeIntoFile(playerData);
		
		player.setName(playerFile.readFile().nextLine());
		
		//tells the player their name again
		System.out.print(ConsoleColors.ITALICS);
		System.out.println("Hello " + ConsoleColors.RESET + player.getCharacterAttributes()[0] + ConsoleColors.ITALICS + ". I am your narrator. "
				+ "I will be your guide through this text adventure.");
		System.out.println("");
		
		//asks the player if they know what the game is about and allows them to type yes or no
		System.out.println("Do you know what this game is about?");
		System.out.println(ConsoleColors.RESET);
		
		//while loop for input checker. You could do a free response like "yes I do" or "no I don't" or "adsfafhadfyes" or "uedjuedhjuhdjno"
		int i = 0;
		while (i < 5)
		{
			//allows the player to type and sets what they typed to lowercase
			String choose = myScanner.nextLine().toLowerCase();
			
			/*
			 * if there is a yes that appears in the input
			 * - sends them straight into the game and breaks the for loop
			 * if there is a no that appears in the input
			 * - gives the player information about the file system and where each file is located. Also gives a little information about the game without spoiling.
			 * else (the player didn't put yes or no)
			 * - tells the player to put a yes or no answer and increments the i variable
			 */
			if (choose.indexOf("yes") != -1)
			{
					System.out.println(ConsoleColors.ITALICS);
					System.out.println("Oh? You aren't a new player? Welcome back then. I'll just send you into the game.\n");
					break;
			}		
			else if (choose.indexOf("no") != -1)
			{
					System.out.println(ConsoleColors.ITALICS);
					System.out.println("""
							Information you should know before the game: Each character–including me–has their own unique text color. 
							Although, that may get a little confusing to keep track of, so I thought of a solution. 
							If you take a look into your documents folder, you should see a file called “Character_List”. 
							Inside that file you should see every character and its corresponding color. 
							In your Document folder, you should also see two other files called “Endings Tracker” and “Relationship_Tracker”.
							
							If you ever need to stop playing, the game will automatically start at the beginning of the scene you were just in.
							""");
					System.out.println("");
					System.out.println("About the game: You are a new detective. You’ve been tasked to gather information and ultimately take down a murderer "
							+ "terrorizing your town.\n");
					new Delay(20000);
					break;
			}
				System.out.print(ConsoleColors.ITALICS);
				System.out.println("Please answer the yes or no question.");
				i++;
		}
		
		/*
		 * if i was fully iterated through, it ends the game
		 * adds one ending to your ending tracker
		 */
		if (i == 5)
		{
			endings += "The Error Ending\n	Obtained when the player didn't answer a simple yes or no question";
			endingsTracker.writeIntoFile(endings);
			
			sessionSaver.deleteFile();
			
			System.out.print("bro");
			new Delay(700);
			new Delay('l', "...", 700);
			
			System.out.println(" Really...");
			new Delay(2000);
			
			new Delay('w', "You know what...", 300);
			System.out.print("\n");
			new Delay(1800);
			System.out.print(ConsoleColors.ITALICS);
			System.out.println("\nThe game is over... \nthe murderer killed you on your first day. you rot in hell.");
			System.out.print(ConsoleColors.RESET);
			throw new Exception("don't do that.");
		}
	}
	
	/**
	 * Makes the first scene of the game. Called later in the Game class
	 * * unfinished 
	 * @throws FileNotFoundException *
	 */
	public static void makeFirstScene() throws FileNotFoundException
	{
		player.setName(playerFile.readFile().nextLine());
		
		//sets precinct location to true to check if you're inside
		precinct.setInside(true);
		
		while (precinct.isInside())
		{
			/*
			 * introduces your partner "Harry Freeman" in green text- Esc[0;92m
			 * calls the getCharacterAttributes method of the player object for easy attribute calling
			 */
			System.out.print(ConsoleColors.PARTNER);
			System.out.println("Hey! You must be new here.\n" + player.getCharacterAttributes()[0] + ", right?");
			System.out.println("Welcome to the precinct. I'm your partner, " + partner.getCharacterAttributes()[0] + ". Nice to meet you.");
			System.out.println("I got a some paper work for you. I know it's not any detective work but don't worry, this is important for the case.");
			System.out.println(ConsoleColors.RESET);
			
			/*
			 * Asks the player to make a choice between A, B, and C
			 * sets the text to normal italics- Esc[3m
			 */
			System.out.print(ConsoleColors.ITALICS);
			System.out.println("What do you want to do now?");
			System.out.print("""
					-----------------------
					A) Explore the precinct
					B) Look at the papers
					C) Leave the precinct
					""");
			
			//empty string for future use
			String choose = "";
			
			/*
			 * loops until you give a one letter response
			 */
			boolean test = true;
			while (test)
			{
				System.out.print(ConsoleColors.RESET);
				choose = myScanner.next().toLowerCase();
				if (choose.length() != 1)
				{
					System.out.print(ConsoleColors.ITALICS);
					System.out.println("Please. A, B, or C");
				}
				else
				{
					//leaves loop
					test = false;
				}
			}
			choices.add(choose);
			System.out.println(ConsoleColors.ITALICS);
			
			/*
			 * GIANT SWITCH STATEMENT FOR EACH OPTION GIVEN
			 */
			switch (choose)
			{
				/*
				 * "a"
				 * 
				 * Gives more information about the precinct to the player
				 * Introduces the captain
				 */
				case "a":
					System.out.print("The presinct is small. Your coworkers are moving all over the place. The noise is deafening. It's all so");
					System.out.println(ConsoleColors.RESET);
					
					new Delay(2600);
					
					System.out.print("\n" + ConsoleColors.CAPTAIN);
					System.out.println("Chaotic right?");
					break;
				
				/*
				 * "b"
				 * 
				 * Gives more information about the main character to the player
				 * Also incorperates a way to fill out the two final attributes the player has to fill out
				 * Introduces the captain
				 */
				case "b":
					System.out.println("The papers in from of you look boring. You skim through them, not really taking much in as you read, "
							+ "until you come across a paper that catches your eye. It's you. What it reads is: ");
					System.out.println(ConsoleColors.BOLD);
					System.out.println("Name: " + player.getCharacterAttributes()[0] + "\n" +
							"""
							--------------
							Hobbies: _____________
							Favorites: _____________
							Parents: [Unknown], [Unknown]
							Medical History: Amnesia, Multiple Personalities Disorder, Attention Deficit/Hyperactivity Disorder
							Date of Birth: [Unknown]
							Join Date: November 11, 2011
							""");
					System.out.println("" + ConsoleColors.RESET + ConsoleColors.ITALICS);
					System.out.println("You quickly fill in the blank spots.");
					
					System.out.print("What is your hobby: " + ConsoleColors.RESET);
					String setHobby = myScanner.next();
					player.setHobby(setHobby);
					
					System.out.print(ConsoleColors.ITALICS + "What is your favorite thing in the whole word: " + ConsoleColors.RESET);
					String setFavorite = myScanner.next();
					player.setFavorite(setFavorite);
					System.out.println("");
					
					/*
					 * adds the hobby and favorite attributes to the player file
					 */
					playerData = "";
					for (String i : player.getCharacterAttributes())
					{
						playerData += i + "\n";
					}
					playerFile.writeIntoFile(playerData);
					
					player.setName(playerFile.readFile().nextLine());
					
					/*
					 * DRAMA :)
					 */
					System.out.print(ConsoleColors.ITALICS + "You hear thumping from behind you. It gets louder ");
					
					new Delay('w', "and louder, and louder, and louder until", 700, 500, 2);
					new Delay(1800);
					System.out.println("");
	
					
					System.out.println("\n" + ConsoleColors.CAPTAIN);
					System.out.println("You're Harry's newest partner right?");
					System.out.println("Thanks for filling the rest of your file out.");
					System.out.println("How are you liking the precinct?");
					System.out.print("" + ConsoleColors.RESET + ConsoleColors.ITALICS);
					
					new Delay(700);
					
					/*
					 * he didn't like that very much :(
					 */
					System.out.print("" + ConsoleColors.RESET + ConsoleColors.CAPTAIN);
					System.out.println("Not much of a talker... I see.");
					break;
					
				/*
				 * case "c"
				 * 
				 * Why would you want to leave...
				 * A quick way to introduce the captain with blue text- Esc[0;94m
				 */
				case "c":
					System.out.println("You leave the precinct. First day on the job and you're already ditching. You take one step out the door and here a voice." + 
							ConsoleColors.RESET);
					System.out.println(ConsoleColors.CAPTAIN + "Where do you think you're going?");
					captain.setRelationship("bad");
					break;
			}
			System.out.println(ConsoleColors.RESET);
			
			/*
			 * checks if your relationship with the captain is good
			 * - starts a tour of the precinct
			 * if the check was false, ends the scene
			 */
			if (captain.getCharacterAttributes()[5] == "good")
			{
				System.out.println("Let me give you a tour around the precinct. This place is a lot bigger than it looks.");
			}
			else if (captain.getCharacterAttributes()[5] == "bad")
			{
				System.out.print(ConsoleColors.CAPTAIN);
				System.out.println("You know, it's tradition for the captain to give a tour of the precinct to the newest recruits but I don't wanna do that now.");
				precinct.setInside(false);
				break;
			}
			
			//finalizes the dialogue for the tour
			System.out.println("" + ConsoleColors.RESET + ConsoleColors.ITALICS);
			System.out.println("Captain Anders gives the tour to us. The energy in his voice you notice immediately. Despite being in his 50s he surprisingly energetic, "
					+ "especially about the precinct. You notice a familiar face during the tour.");
			System.out.println("" + ConsoleColors.RESET + ConsoleColors.CAPTAIN);
			System.out.println("Hello Detective Freeman, have you met your newest partner?");
			
			System.out.println("" + ConsoleColors.RESET + ConsoleColors.PARTNER);
			System.out.println("I have yes ");
			break;
		}
	}
	
	public static void makeSceneTwoInside()
	{
		
	}
	
	public static void makeSceneTwoOutside()
	{
		
	}
}
