import java.util.Scanner;

import objects.Characters;
import objects.ConsoleColors;
import objects.Delay;
import objects.FileManager;
import objects.Location;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	//Character Objects:							 Name		   	 Age		   Occupation				Hobby			Favorite						Color
	static Characters player 	= new Characters(""					,25			,"Detective"			,""			  	,""								);
	static Characters partner   = new Characters("Harry Freeman"	,27       	,"Detective"			,"Photography"	,"Sunsets"						);	//Green
	static Characters captain   = new Characters("Steven Anders"	,50       	,"Police Captain"		,"Fishing"		,"Beaches"						);	//Light Blue
	static Characters roommate  = new Characters("Wallice West"		,22			,"Unemployed"			,"Collecting"	,"Mint Condition Miku Figure"	);	//Yellow
	static Characters barista   = new Characters("Ruby Hesser"		,24			,"Barista"				,"Dancing"		,"Cats"							);	//Pink
	static Characters forensics = new Characters("Alex Payne"		,31			,"Forensics Scientist"	,"Gardening"	,"Begonia"						);	//Salmon
	static Characters murderer  = new Characters("Unknown"			,"Unknown"	,"Unknown"				,"Unknown"		,"Unknown"						);	//Red
	static Characters bum       = new Characters("Tritan Nesto"		,25			,"Bum"					,"Exploring"	,"His Camera"					);	//Black Background
	
	//Location Objects:						  Location			Inside?
	static Location coffee   = new Location("Coffee Shop"		,false);
	static Location precinct = new Location("Police Precinct"	,false);
	static Location apt	   	 = new Location("Apartment"			,false);
	static Location outside	 = new Location("Street"			,false);	
	
	static Scanner myScanner = new Scanner(System.in);
	
	static private ArrayList<String> choices = new ArrayList<>();
	
	static FileManager characterList = new FileManager("Character_List.txt");
	
	static FileManager sessionSaver = new FileManager("Session_Saver");
	
	static private String endings = "";
	static FileManager endingsTracker = new FileManager("Endings_Tracker.txt");
	
	static HashMap<String, String> relationships = new HashMap<>();
	static private String relationshipData = "";
	static FileManager relationshipTracker = new FileManager("Relationship_Tracker.txt");
	
	static private String playerData = "";
	static FileManager playerFile = new FileManager("Player_File");

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
		relationshipTracker.writeIntoFile(hashMapValues());
		
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
	 * method to set and change values in the hashmap
	 * @return relationshipData
	 */
	public static String hashMapValues()
	{
		/*
		 * puts a key and value into the hashmap
		 * key is the character name
		 * value is the relationship the player has with the characters (starts at good)
		 */
		relationships.put("Partner", partner.getCharacterAttributes()[5]);
		relationships.put("Captain", captain.getCharacterAttributes()[5]);
		relationships.put("Roommate", roommate.getCharacterAttributes()[5]);
		relationships.put("Barista", barista.getCharacterAttributes()[5]);
		relationships.put("Forensics", forensics.getCharacterAttributes()[5]);
		relationships.put("Murderer", "");
		relationships.put("Bum", bum.getCharacterAttributes()[5]);
		
		/*
		 * loops through the size of the hashmap
		 * - for each loop to loop through the keys
		 *   - adds the keys to the string relationshipData by turning the keyset to an array and calling the i^th index of the array
		 *   - breaks the for each loop
		 * - for each loop to loop through the values
		 *   - adds " - [value]" to the string relationshipData by doing the exact same thing as I did to add the keys to the string
		 *   - breaks the for each loop
		 */
		for (int i = 0; i < relationships.size(); i++)
		{
			for (String j : relationships.keySet())
			{
				if (!(j.equals(relationships.get(j))))
				{
					relationshipData += relationships.keySet().toArray()[i];
					break;
				}
			}
			
			for (String k : relationships.values())
			{
				if (!(k.equals(relationships.values().toArray()[i])))
				{
					relationshipData += " - " + relationships.values().toArray()[i] + "\n";
					break;
				}
			}
		}
		
		//returns the relationshipData string
		return relationshipData;
	}
	
	/**
	 * Method to delete the files when the game ends
	 */
	public static void deleteFiles()
	{
		characterList.deleteFile();
		sessionSaver.deleteFile();
		endingsTracker.deleteFile();
		relationshipTracker.deleteFile();
		playerFile.deleteFile();
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
		player.setName(name);
		
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
			
			new Delay('l', "You know what...", 300);
			System.out.print("\n");
			new Delay(1800);
			System.out.print(ConsoleColors.ITALICS);
			System.out.println("\nThe game is over... \nthe murderer killed you on your first day. you rot in hell.");
			System.out.print(ConsoleColors.RESET);
			throw new DontDoThatException();
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
		
		//loop that only iterates once LOL
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
			 * sets the text to normal italics
			 */
			System.out.print(ConsoleColors.ITALICS);
			System.out.println("What do you want to do now?");
			System.out.print("""
					-----------------------
					A) Explore the precinct
					B) Look at the papers
					C) Leave the precinct
					D) Wait for Harry to come back
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
				choose = myScanner.nextLine().toLowerCase();
				if (choose.length() != 1)
				{
					System.out.print(ConsoleColors.ITALICS);
					System.out.println("Please. A, B, C, or D");
				}
				else
				{
					//leaves loop
					test = false;
				}
			}
			//adds your choice to the choices arraylist
			choices.add(choose);
			System.out.println(ConsoleColors.ITALICS);
			
			/*
			 * GIANT IF STATEMENT
			 * checks if the player inputted a or explore
			 * - gives the player information about the precinct
			 */
			if (choose.toLowerCase().equals("a") || choose.toLowerCase().indexOf("explore") != -1)
			{
				System.out.print("The presinct is small. Your coworkers are moving all over the place. The noise is deafening. It's all so");
				
				new Delay(2600);
				
				System.out.print("\n" + ConsoleColors.CAPTAIN);
				System.out.println("Chaotic right?");
			}
			/*
			 * checks if the player inputted b or papers
			 * - gives information about the player
			 */
			else if (choose.toLowerCase().equals("b") || choose.toLowerCase().indexOf("papers") != -1)
			{
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
				//lets the player input their hobby
				String setHobby = myScanner.nextLine();
				player.setHobby(setHobby);
				
				System.out.print(ConsoleColors.ITALICS + "What is your favorite thing in the whole word: " + ConsoleColors.RESET);
				//lets the player input their favorite
				String setFavorite = myScanner.nextLine();
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
				System.out.print("" + ConsoleColors.CAPTAIN);
				System.out.println("Not much of a talker... I see.");
			}
			/*
			 * checks if the player inputted c or leave
			 * - changes your relationship with the captain to bad and adds it to the file
			 */
			else if (choose.toLowerCase().equals("c") || choose.toLowerCase().indexOf("leave") != -1)
			{
				System.out.println("You leave the precinct. First day on the job and you're already ditching. You take one step out the door and here a voice.");
				System.out.println(ConsoleColors.CAPTAIN + "Where do you think you're going?");
				captain.setRelationship("Bad");
				relationshipTracker.writeIntoFile(hashMapValues());
			}
			/*
			 * checks if the player inputted d or wait
			 * - introduces the player to the captain
			 */
			else if (choose.toLowerCase().equals("d") || choose.toLowerCase().indexOf("wait") != -1)
			{
				System.out.println("" + ConsoleColors.RESET + ConsoleColors.ITALICS + "While you wait for Harry to come back, the captain spots you.");
				System.out.println("" + ConsoleColors.CAPTAIN + "Hello Detective. You look new. What's your name? \n");
				new Delay(7000);
				
				System.out.println(player.getCharacterAttributes()[0] + "? What an interesting name.");
				System.out.println("Nice to meet you. I'm Captain " + captain.getCharacterAttributes()[0]);
				System.out.println("" + ConsoleColors.RESET + ConsoleColors.ITALICS + "Behind the captain you can hear footsteps coming up.");
				System.out.println(ConsoleColors.PARTNER + "Hey captain. I see you met my new partner.\n" + ConsoleColors.RESET);
				new Delay(12000);
				
				System.out.println(ConsoleColors.ITALICS + "The captain turns to you.");
				new Delay(1500);
			}
			
			/*
			 * checks if your relationship with the captain is good
			 * - starts a tour of the precinct
			 * if the check was false, ends the scene
			 */
			if (captain.getCharacterAttributes()[5] == "Good")
			{
				System.out.print(ConsoleColors.CAPTAIN);
				System.out.println("Let me give you a tour around the precinct. This place is a lot bigger than it looks.");
				System.out.print(ConsoleColors.RESET);
			}
			else if (captain.getCharacterAttributes()[5] == "Bad")
			{
				System.out.print(ConsoleColors.CAPTAIN);
				System.out.println("You know, it's tradition for the captain to give a tour of the precinct to the newest recruits but I don't wanna do that now.");
				precinct.setInside(false);
				//break to end the loop and leave the method
				break;
			}
			
			//finalizes the dialogue for the tour
			System.out.print(ConsoleColors.ITALICS);
			System.out.println("Captain Anders gives the tour to us. The energy in his voice you notice immediately. \nDespite being in his 50s he surprisingly energetic, "
					+ "especially about the precinct. You notice a familiar face during the tour.");
			System.out.print(ConsoleColors.CAPTAIN);
			System.out.println("Hello Detective Freeman, have you met your newest partner?");
			
			System.out.print(ConsoleColors.PARTNER);
			System.out.println("I have yes");
			//break to end the loop and leave the method
			break;
		}
	}
	
	/**
	 * Method for scene two main path
	 */
	public static void tourPlayer()
	{
		System.out.println("test");
	}
	
	/**
	 * Method for scene two outside path
	 */
	public static void goOutside()
	{
		outside.setInside(true);
		System.out.print("" + ConsoleColors.RESET + ConsoleColors.ITALICS);
		System.out.println("The captain walks away and your relationship with your captain is shattered. You debate whether you should continue with your choice or go back inside");
		//asks the player if they wants to go inside
		System.out.println(ConsoleColors.RESET + "Do you want to go back inside?");
		//yN = yesNo
		String yN = myScanner.nextLine();
		
		/*
		 * response based on answer
		 * if yes
		 * - sets precinct to true and outside to false
		 * - goes to tour player method
		 * 
		 * if no
		 * - continues on the path
		 */
		if (yN.indexOf("yes") != -1)
		{
			System.out.print(ConsoleColors.ITALICS);
			System.out.println("Smart Choice" + ConsoleColors.RESET);
			precinct.setInside(true);
			outside.setInside(false);
			tourPlayer();
		}
		else if (yN.indexOf("no") != -1)
		{
			System.out.print(ConsoleColors.ITALICS);
			System.out.println("Whatever you say.");
			new Delay(500);
		}
		
		//checks if the player is outside or not (because I don't want code to run after the method I call is finished)
		if (outside.isInside())
		{
			//asks the player where they want to go
			System.out.println("Where do you wanna go?");
			System.out.print(ConsoleColors.RESET);
			System.out.println(
					"""
					a) Your apartment
					b) The coffee shop
					c) Back to the precinct
					""");
			
			//allows player to type
			String choose = myScanner.nextLine();
			
			/*
			 * Gives a response based on where they want to go
			 * (currently empty as I have not finished this part)
			 */
			if (choose.equalsIgnoreCase("a") || choose.toLowerCase().indexOf("apartment") != -1)
			{
				System.out.print(ConsoleColors.ITALICS);
				System.out.println("The apartment is the most logical choice. You left the precinct and immediately went home. You don't wanna be there, you wanna be at home where your "
						+ "roommate is.");
			}
			else if (choose.equalsIgnoreCase("b") || choose.toLowerCase().indexOf("coffee") != -1)
			{
				System.out.print(ConsoleColors.ITALICS);
			}
			else if (choose.toLowerCase().indexOf("precinct") != -1)
			{
				System.out.print(ConsoleColors.ITALICS);
			}
			//else for when the player wants to be funny
			//gives them the coffee shop dialogue but changes "coffee shop" to whatever they typed
			else
			{
				System.out.print(ConsoleColors.ITALICS);
				System.out.println("Oh ya I know that place. I used to go there all the time! You go to " + choose + ".");
			}
		}
	}
}
