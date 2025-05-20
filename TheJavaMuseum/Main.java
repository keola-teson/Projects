 import java.util.Scanner;

/**
 * This is where the game is played. Methods in showcases class are called here
 * @author Keola Teson
 */
public class Main
{

	static Characters narrator = new Characters("Narrator");
	static Characters player = new Characters();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		//setUpGame();
		
		//ShowcaseUnitOne.showcase();
		
		ShowcaseUnitOne.showcase();
		
		scanner.close();
	}
	
	/**
	 * Method to set up the game. 
	 * Gives the player information about Java and it's syntax
	 */
	public static void setUpGame()
	{
		//Welcomes the player to the game
		new Delay("Hello and welcome to the Museum of Java!");
		new Delay(400);
		
		new Delay("...(Up until what we learned in APCS)");
		new Delay(500);
		
		//asks the player what their name is
		new Delay("I am " + narrator.getName() + ", and I will be your guide through the magical world of the Java language.");
		new Delay("First, I have to know. What is your name?");
		
		//allows the player to type their name and sets the player object as their inputted item
		String name = scanner.nextLine();
		player.setName(name);
		
		//asks the player if they know anything about Java
		new Delay("Hello " + player.getName() + ", do you know anything about Java?");
		
		//boolean for while loop. while loop to loop until the player put a y or n
		boolean test = true;
		while (test)
		{
			//allows the player to type and sets every char to lowercase
			String choose = scanner.nextLine().toLowerCase();
			
			//if they type an n, introduce the player to Java syntax to prepare them for the museum
			if (choose.indexOf('n') != -1)
			{
				new Delay("You've come to the right guy then.");
				new Delay("Java is an \"Object Oriented Language\". What does that mean though?");
				new Delay("That just means that every single thing you do, every single item you make, every single thing you set and get is through an object.");
				new Delay("This whole game, I mean museum, is made up of objects. How this delay is happening is through an object.\n");
				new Delay(1000);
				
				new Delay("Something you should also know is the syntax. The more you go through the museum the more you'll learn the specfics,");
				new Delay("but there are a couple of small things you should know.\n");
				new Delay(1000);
				
				new Delay("Unlike other languages like Python, to end a line in Java you use a semicolon;"); new Delay("Which does mean you could have lines of code right next to each other.");
				new Delay("Don't do that though, it's ugly.\n");
				new Delay(1500);
				
				new Delay("Another thing you should know is the naming convention.");
				new Delay("Java, unlike languages like C#, uses something called camalCasing. And it looks like that.");
				new Delay("theFirstWordInAnyName must always be lowercase. That naming convention is broken by classes though, WhichAreAlwaysUppercase.", 150);
				new Delay(1000);
				
				System.out.print("To print something you use System.out.print()");
				new Delay(500);
				System.out.println("and to print something and move to the next line use System.out.println()");
				new Delay(1000);
				
				new Delay("Now that you know the basics, let us finally start the tour.\n");
				test = false;
			}
			//else if they type a y, skips all the explanations
			else if (choose.indexOf('y') != -1)
			{
				new Delay("Oh that's perfect! We'll just start the tour then!\n");
				test = false;
			}
			//else, tells the player to type yes or no
			else
			{
				System.out.println("Please answer yes or no");
			}
		}
	}

}
