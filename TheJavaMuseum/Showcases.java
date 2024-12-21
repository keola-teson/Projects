import java.util.Scanner;

/**
 * Where the logic is handled in the game
 * @author Keola Teson :)
 */
public class Showcases
{
	/*
	 * Data attributes
	 * ---------------
	 * narrator
	 * player
	 * scanner - to allow the player to type
	 */
	private static Characters narrator = new Characters("Narrator");
	private static Characters player = new Characters();
	private static Scanner scanner = new Scanner(System.in);
	
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
		new Delay("Hello, " + player.getName() + ", do you know anything about Java?");
		
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
	
	/**
	 * This showcase teaches the player about variabls and data types
	 * *INCOMPLETE*
	 */
	public static void showcaseUnit1()
	{
		
		//gives the player important terms
		new Delay("""
				Important terms:
					declare - to create a variable by assigning it a data type
					initialize - to assign the variable a value based on the data type declared
					literal - the value assigned to the data type
				""");
		new Delay(1000);
		
		/*
		 * Talks about variables and data types and gives the player information about the important ones
		 */
		new Delay("The first thing I would like to do is to introduce to you variables and data types.");
		new Delay("A variable is like a container.\n");
		new Delay(1000);
		
		new Delay("It can contain many items: numbers, words, individual letters and characters on a keyboard.");
		new Delay("Those items are called literals, and those literals get sorted and stored into a container, or data types\n");
		new Delay(1000);
		
		new Delay("There are many data types but the most important ones you should know are:");
		new Delay("""
					int - stores whole numbers (up to 2,147,483,647)
					double - stores fractional (decimal) numbers up to 16 decimal digits
					char - stores characters on the keyboard (as either ascii codes or as the actual character surrounded in ' ')
					boolean - stores a true or false value
					String* - stores a string of text surrounded by quotes ("")
				""");
		new Delay(1000);
		
		//talks about the assignment operator
		new Delay("To store a value into the variable, you use something called an assignment operator.");
		new Delay("The assignment operator is denoted by an '='");
		new Delay(1000);
		
		//teaches the player how to initialize a variable
		new Delay("This is how you write a variable:");
		new Delay("""
				(the data type you will be using) (the name of the variable in camelCasing) = (the value you want to give it);
				
				so it looks like:
				int nameHere = 17;
				""", 100);
		
		//allows the player to try it for themselves
		new Delay("Try it for yourself.");
		System.out.println("-----------------------------------------------------");
		
		/*
		 * empty strings to be used for inputs
		 */
		String dataType = "";
		String varName = "";
		String assignmentOperator = "";
		String value = "";
		
		//boolean for while loop. while loop for detecting syntax errors
		boolean test = true;
		while (test)
		{
			/*
			 * allows the player to type
			 * ------
			 * dataType
			 * varName
			 * assignmentOperator
			 * value
			 */
			dataType = scanner.next();
			varName = scanner.next();
			assignmentOperator = scanner.next();
			value = scanner.next();
			
			/*
			 * checks for if there is a missing semicolon at the end of a line
			 * - tells the player to add the semicolon and resets the loop
			 */
			if (value.indexOf(';') != value.length() - 1)
			{
				System.out.println("You need a semicolon at the end of the line. Please try again.");
				continue;
			}
			
			/*
			 * checks if the player didn't input int, double, char, or boolean
			 * - informs the player that what they inputted wasn't a data type and resets the loop
			 */
			if (!(dataType.equals("int")) && !(dataType.equals("double")) && 
			   !(dataType.equals("char")) && !(dataType.equals("boolean")))
			{
				System.out.println("That is not a data type. Please try again.");
				continue;
			}
			
			/*
			 * declares i for loops
			 * loops through the ascii codes for the capitolized verion of the english alphebet
			 * - checks if there is a capitolized letter in varName
			 *   - breaks loop
			 * checks if the for loop was never broken
			 * - informs the player about the need for descriptive names and resets the while loop
			 */
			int i;
			for (i = 65; i < 91; i++)
			{
				if (varName.indexOf(i) != -1)
				{
					break;
				}
			}
			if (i == 90)
			{
				System.out.println("It is better to have your variable names be descriptive to what it does. Please try again.");
				continue;
			}
			
			/*
			 * loops through the ascii codes for the capitolized verion of the english alphebet
			 * - checks if the beginning letter is capitolized
			 *   - tells the player to follow naming convention and breaks the for loop
			 * checks if the for loop was broken and resets the while loop
			 */
			for (i = 65; i < 91; i++)
			{
				if (varName.charAt(0) == i)
				{
					System.out.println("Please follow naming convention. Please try again.2");
					break;
				}
			}
			if (i < 90)
			{
				continue;
			}
			
			/*
			 * checks if the player didn't input an '='
			 * - tells the player they need one and resets the loop
			 */
			if (assignmentOperator.indexOf('=') == -1)
			{
				System.out.println("You need an assignment operator. Please try again.");
				continue;
			}
			
			//checks if the data type the player chose was an int
			if (dataType.equals("int"))
			{
				/*
				 * parses the value they inputted into an int
				 * if any error occurs, catch it
				 * - tells the player they need to put a whole number and resets the loop
				 * if there wasn't
				 * - changes test to false to leave the loop
				 */
				try
				{
					Integer.parseInt(value.substring(0, value.indexOf(';')));
					test = false;
				}
				catch (Exception e)
				{
					System.out.println("This data type requires a whole number value. Please try again");
					continue;
				}
			}
			//checks if the data type the player chose was a double
			else if (dataType.equals("double"))
			{
				/*
				 * parses the value they inputted into a double
				 * if any error occurs, catch it
				 * - tells the player to input a decimal number and resets the loop
				 * if there wasn't
				 * - checks the player inputted a whole number
				 *   - adds .0 to the string
				 * - changes test to false to leave the loop
				 */
				try
				{
					Double.parseDouble(value.substring(0, value.indexOf(';')));
					
					if (value.indexOf('.') == -1)
					{
						value = value.substring(0, value.length() - 1) + ".0";
						value += ";";
					}
					
					test = false;
				}
				catch (Exception e)
				{
					System.out.println("This data type requires a decimal number value. Please try again.");
					continue;
				}
			}
			//checks if the player chose the data type char
			else if (dataType.equals("char"))
			{
				/*
				 * parses the input into an Integer
				 * if any error ocurrs, catch it
				 * - check if the length of the value is not 3
				 *   - tells the player they can only store one character and resets the loop
				 * - check if the char they inputted isn't surrounded by apostrophes
				 *   - tells the player that it should and resets the loop
				 * - if all checks fail change test to false to leave the loop
				 * if no errors occur
				 * - check if the ascii code they inputted was greater than 256 and less than 0
				 *   - tells the player the ascii code isn't available and resets the loop
				 * - if the check was false change test to false to leave the loop
				 */
				try
				{
					int ascii = Integer.parseInt(value.substring(0, value.indexOf(';')));
					if (ascii > 256 && ascii < 0)
					{
						System.out.println("That ascii code isn't available. Please try again.");
						continue;
					}
					test = false;
				}
				catch (Exception e)
				{	
					if (value.substring(0, value.indexOf(';')).length() > 3)
					{
						System.out.println("You can only store one character. Please try again.");
						continue;
					}
					
					if (value.charAt(0) != '\'' || value.charAt(2) != '\'')
					{
						System.out.println("The inputted char must be surrounded by apostrophes (' ')");
						continue;
					}
					
					test = false;
				}
			}
			//checks if the data type the player chose was a boolean
			else if (dataType.equals("boolean"))
			{
				/*
				 * checks if the input wasn't true; or false;
				 * - tells the player booleans store true and false only and resets the loop
				 * if the check was false, change test to false to leave the loop
				 */
				if (!(value.equals("true;")) && !(value.equals("false;")))
				{
					System.out.println("This data type requires a true or false. Please try again.");
					continue;
				}
				test = false;
			}
		}
		//prints out the final inputted line of code
		System.out.println(dataType + " " + varName + " = " + value);
	}
}
