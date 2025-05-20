
/**
 * Where the logic is handled in the game
 * @author Keola Teson :)
 */
public class ShowcaseUnitOne
{
	/*
	 * Data attributes
	 * ---------------
	 * dataType - stores the dataType the player decided to choose
	 * varName - stores the name of the variable
	 * assignmentOperator - stores the '='
	 * value - stores the value (based on the data type)
	 */
	private static String dataType;
	private static String varName;
	private static String assignmentOperator;
	private static String value;
	
	private static void createVariable()
	{
		/*
		 * empty strings to be used for inputs
		 */
		dataType = "";
		varName = "";
		assignmentOperator = "";
		value = "";
		
		/*
		 * allows the player to type
		 * ------
		 * dataType
		 * varName
		 * assignmentOperator
		 * value
		 */
		dataType = Main.scanner.next();
		varName = Main.scanner.next();
		assignmentOperator = Main.scanner.next();
		value = Main.scanner.next();
		
		/*
		 * checks for if there is a missing semicolon at the end of a line
		 * - tells the player to add the semicolon and resets the loop
		 */
		if (value.indexOf(';') != value.length() - 1)
		{
			System.out.println("You need a semicolon at the end of the line. Please try again.");
			createVariable();
		}
		
		/*
		 * checks if the player didn't input int, double, char, or boolean
		 * - informs the player that what they inputted wasn't a data type and resets the loop
		 */
		if (!(dataType.equals("int")) && !(dataType.equals("double")) && 
		   !(dataType.equals("char")) && !(dataType.equals("boolean")))
		{
			System.out.println("That is not a data type. Please try again.");
			createVariable();
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
		if (i == 91)
		{
			System.out.println("It is better to have your variable names be descriptive to what it does. Please try again.");
			createVariable();
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
				System.out.println("Please follow naming convention. Please try again.");
				break;
			}
		}
		if (i < 90)
		{
			createVariable();
		}
		
		/*
		 * checks if the player didn't input an '='
		 * - tells the player they need one and resets the loop
		 */
		if (assignmentOperator.indexOf('=') == -1)
		{
			System.out.println("You need an assignment operator. Please try again.");
			createVariable();
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
				return;
			}
			catch (Exception e)
			{
				System.out.println("This data type requires a whole number value. Please try again");
				createVariable();
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
				
				return;
			}
			catch (Exception e)
			{
				System.out.println("This data type requires a decimal number value. Please try again.");
				createVariable();
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
					createVariable();
				}
				return;
			}
			catch (Exception e)
			{	
				if (value.substring(0, value.indexOf(';')).length() > 3)
				{
					System.out.println("You can only store one character. Please try again.");
					createVariable();
				}
				
				if (value.charAt(0) != '\'' || value.charAt(2) != '\'')
				{
					System.out.println("The inputted char must be surrounded by apostrophes (' ')");
					createVariable();
				}
				
				return;
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
				createVariable();
			}
			return;
		}
	}
	
	private static Object createVariable(String type, String name)
	{
		/*
		 * empty strings to be used for inputs
		 */
		String dataType = "";
		String varName = "";
		String assignmentOperator = "";
		String value = "";

		/*
		 * allows the player to type
		 * ------
		 * dataType
		 * varName
		 * assignmentOperator
		 * value
		 */
		dataType = Main.scanner.next();
		varName = Main.scanner.next();
		assignmentOperator = Main.scanner.next();
		value = Main.scanner.next();
		
		/*
		 * checks for if there is a missing semicolon at the end of a line
		 * - tells the player to add the semicolon and resets the loop
		 */
		if (value.indexOf(';') != value.length() - 1)
		{
			System.out.println("You need a semicolon at the end of the line. Please try again.");
			createVariable(type, name);
		}
		
		/*
		 * checks if the player didn't input int, double, char, or boolean
		 * - informs the player that what they inputted wasn't a data type and resets the loop
		 */
		if (!(dataType.equals(type)))
		{
			System.out.println("That is not a data type. Please try again.");
			createVariable(type, name);
		}
		
		if (!(varName.equals(name)))
		{
			System.out.println("Please use the name " + name + ".");
			createVariable(type, name);
		}
		
		/*
		 * checks if the player didn't input an '='
		 * - tells the player they need one and resets the loop
		 */
		if (assignmentOperator.indexOf('=') == -1)
		{
			System.out.println("You need an assignment operator. Please try again.");
			createVariable(type, name);
		}
		
		//checks if the data type the player chose was an int
		if (type.equals("int"))
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
				int parsedInt = Integer.parseInt(value.substring(0, value.indexOf(';')));
				return parsedInt;
			}
			catch (Exception e)
			{
				System.out.println("This data type requires a whole number value. Please try again");
				createVariable(type, name);
			}
		}
		//checks if the data type the player chose was a double
		else if (type.equals("double"))
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
				double parsedDouble = Double.parseDouble(value.substring(0, value.indexOf(';')));
				
				if (value.indexOf('.') == -1)
				{
					value = value.substring(0, value.length() - 1) + ".0";
					value += ";";
				}
				
				return parsedDouble;
			}
			catch (Exception e)
			{
				System.out.println("This data type requires a decimal number value. Please try again.");
				createVariable(type, name);
			}
		}
		//checks if the player chose the data type char
		else if (type.equals("char"))
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
					createVariable(type, name);
				}
				return (char)ascii;
			}
			catch (Exception e)
			{	
				if (value.substring(0, value.indexOf(';')).length() > 3)
				{
					System.out.println("You can only store one character. Please try again.");
					createVariable(type, name);
				}
				
				if (value.charAt(0) != '\'' || value.charAt(2) != '\'')
				{
					System.out.println("The inputted char must be surrounded by apostrophes (' ')");
					createVariable(type, name);
				}
			}
			return value.charAt(1);
		}
		//checks if the data type the player chose was a boolean
		else if (type.equals("boolean"))
		{
			/*
			 * checks if the input wasn't true; or false;
			 * - tells the player booleans store true and false only and resets the loop
			 * if the check was false, change test to false to leave the loop
			 */
			if (!(value.equals("true;")) && !(value.equals("false;")))
			{
				System.out.println("This data type requires a true or false. Please try again.");
				createVariable(type, name);
			}
			if (value.equals("true;"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return -1;
	}
	
	/**
	 * This showcase teaches the player about variabls and data types
	 * *INCOMPLETE*
	 */
	public static void showcase()
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
		
		boolean test = true;
		while (test)
		{
			//allows the player to create a variable
			createVariable();
			
			/*
			 * calls a method based on the datat type the player chose
			 */
			switch (dataType)
			{
				case "int":	
					test = false;
					modifyInt(value, varName);
					break;
				
				case "double":
					test = false;
					modifyDouble(value, varName);
					break;
					
				case "char":
					new Delay("Chars are much more simpler than ints or doubles.");
					new Delay(1000);
					
					new Delay("Chars are stored as either an individual character on a keyboard like 'a' or '$' surrounded as apostrophes, ");
					new Delay("Or a number that is later converted, or casted, into an char.");
					new Delay(1000);
					
					new Delay("Before I talk about casting though, I first want to teach you what you could do with ints and doubles.");
					new Delay(1000);
					
					new Delay("Please create an int or double.");
					System.out.println("-----------------------------------------------------");
					break;
					
				case "boolean":
					new Delay("Booleans can store two values, true or false.");
					new Delay("These values will be important in a future showcase and are a little complicated right now.");
					new Delay(1000);
					
					new Delay("Please create a new variable with a different data type.");
					System.out.println("-----------------------------------------------------");
					break;
			}
			
			new Delay("Now that you've created a new variable, let's turn it into something else.");
			explainCasting();
		}
	}
	
	/**
	 * Method about modifying ints
	 * Talks about math operations and simplifying the assignment operator to change a value
	 * @param value
	 * @param name
	 */
	public static void modifyInt(String value, String name)
	{
		//stores the int value the player inputted into an actual variable to use later
		int parsedValue = Integer.parseInt(value.substring(0, value.indexOf(';')));
		
		new Delay("Amazing job! Now that you've created an int, let's do something with it.\n");
		new Delay(1000);
		
		//talks about the math operations you can do
		new Delay("Because it's a number, mathematics can come into play.");
		new Delay("You could add, subtract, multiply, divide, and even find the remainder of two numbers.");
		new Delay("""
				The operation signs looks like this:
					+: addition
					-: subtraction
					*: multiplication
					/: division
					%: modulo (remainder)
				""");
		new Delay(1000);
		
		//teaches the player how to modify a value within a variable
		new Delay("Now declare and initialize an int variable called \"x\" and give it a value of 5.");
		new Delay(1000);

		//allows the player to try it themselves
		new Delay("Try it yourself.");
		System.out.print("\n");
		
		new Delay("Create a new int variable called \"x\" and give it a value");
		System.out.println("-----------------------------------------------------");
		
		//allows the player to create var x and stores the value they give it
		Object x = createVariable("int", "x");
		System.out.print("\n");
		
		//relays information about the current variables
		new Delay("System.out.println(" + name + ");");
		new Delay("   Output: " + parsedValue);
		new Delay("System.out.println(x)");
		new Delay("   Output: " + x);
		System.out.print("\n");
		
		new Delay("With \"x\", add it to " + name + " by doing: " + name + " = " + name + " + x;");
		new Delay("Try it out.");
		
		//allows the player to apply what they just learned
		new Delay("Change the value of " + name + " by adding it to x");
		System.out.println("-----------------------------------------------------");
		
		//empty strings for future use
		String varOne = "";
		String varTwo = "";
		String operation = "";
		int finalOperation = 0;
		
		//while loop to allow the player to have multiple attemps
		boolean test = true;
		while (test)
		{
			varOne = Main.scanner.next();
			assignmentOperator = Main.scanner.next();
			varOne = Main.scanner.next();
			operation = Main.scanner.next();
			varTwo = Main.scanner.next();
			
			if (varTwo.indexOf(';') == -1)
			{
				System.out.println("You need a semicolon to end the line. Please try again.");
				continue;
			}
			
			if (!(varOne.equals(name)))
			{
				System.out.println("Please use variables that have been declared and initialized.");
				continue;
			}
			
			if (!(assignmentOperator.equals("=")))
			{
				System.out.println("You need the assignment operator. Please try again.");
				continue;
			}
			
			if (!(operation.equals("+")) && !(operation.equals("-")) && !(operation.equals("*")) && 
				!(operation.equals("/")) && !(operation.equals("%")))
			{
				System.out.println("That isn't a valid operation. Please try again.");
				continue;
			}
			
			if (!(varTwo.equals("x;")))
			{
				System.out.println("Please use a variable that has been declared and initialized.");
				continue;
			}
			
			if (operation.equals("+"))
			{
				finalOperation = parsedValue + (int)x;
				test = false;
			}
			else if (operation.equals("-"))
			{
				finalOperation = parsedValue - (int)x;
				test = false;
			}
			else if (operation.equals("*"))
			{
				finalOperation = parsedValue * (int)x;
				test = false;
			}
			else if (operation.equals("/"))
			{
				finalOperation = parsedValue / (int)x;
				test = false;
			}
			else
			{
				finalOperation = parsedValue % (int)x;
				test = false;
			}
		}
		new Delay("System.out.println(" + name + ");");
		new Delay("   Output: " + finalOperation);
		System.out.print("\n");
		
		new Delay("Now that you've changed the value of your variable " + name + "");
		new Delay("I want to teach you a way to simplify what you've just done.\n");
		new Delay(1000);
		
		new Delay("By simply doing " + name + " " + operation + "= x;");
		new Delay("You get the exact same result as doing what you just did.\n");
		new Delay(1000);
		
		new Delay("Try it yourself. All values for x and " + name + " have been reset.");
		System.out.println("-----------------------------------------------------");
		
		varOne = "";
		varTwo = "";
		operation = "";
		finalOperation = 0;
		
		test = true;
		while (test)
		{
			varOne = Main.scanner.next();
			assignmentOperator = Main.scanner.next();
			varTwo = Main.scanner.next();
			
			if (varTwo.indexOf(';') == -1)
			{
				System.out.println("You need a semicolon to end the line. Please try again.");
				continue;
			}
			
			if (varTwo.equals(name + ";"))
			{
				System.out.println("Change the value of " + name + ". Please try again.");
				continue;
			}
			
			if (!(varOne.equals(name)))
			{
				System.out.println("Please use variables that have been declared and initialized.");
				continue;
			}
			
			if (!(assignmentOperator.equals("+=")) && !(assignmentOperator.equals("-=")) && 
				!(assignmentOperator.equals("*=")) && !(assignmentOperator.equals("/=")) && !(assignmentOperator.equals("%=")))
			{
				System.out.println("Please utilize the simplified math operation to change " + name);
				continue;
			}
			
			if (!(varTwo.equals("x;")))
			{
				System.out.println("Please use variables that have been declared and initialized.");
				continue;
			}
			
			if (assignmentOperator.equals("+="))
			{
				finalOperation = parsedValue + (int)x;
				test = false;
			}
			else if (assignmentOperator.equals("-="))
			{
				finalOperation = parsedValue - (int)x;
				test = false;
			}
			else if (assignmentOperator.equals("*="))
			{
				finalOperation = parsedValue * (int)x;
				test = false;
			}
			else if (assignmentOperator.equals("/="))
			{
				finalOperation = parsedValue / (int)x;
				test = false;
			}
			else
			{
				finalOperation = parsedValue % (int)x;
				test = false;
			}
		}
		new Delay("System.out.println(" + name + ");");
		new Delay("   Output: " + finalOperation);
		System.out.print("\n");
	}
	
	/**
	 * Method about modifying ints
	 * Talks about math operations and simplifying the assignment operator to change a value
	 * @param value
	 * @param name
	 */
	public static void modifyDouble(String value, String name)
	{
		//stores the int value the player inputted into an actual variable to use later
		double parsedValue = Double.parseDouble(value.substring(0, value.indexOf(';')));
		
		new Delay("Amazing job! Now that you've created an double, let's do something with it.\n");
		new Delay(1000);
		
		//talks about the math operations you can do
		new Delay("Because it's a number, mathematics can come into play.");
		new Delay("You could add, subtract, multiply, divide, and even find the remainder of two numbers.");
		new Delay("""
				The operation signs looks like this:
					+: addition
					-: subtraction
					*: multiplication
					/: division
					%: modulo (remainder)
				""");
		new Delay(1000);
		
		//teaches the player how to modify a value within a variable
		new Delay("Now declare and initialize a double variable called \"x\" and give it a value of 5.5");
		new Delay(1000);

		//allows the player to try it themselves
		new Delay("Try it yourself.");
		System.out.print("\n");
		
		new Delay("Create a new double variable called \"x\" and give it a value");
		System.out.println("-----------------------------------------------------");
		
		//allows the player to create var x and stores the value they give it
		Object x = createVariable("double", "x");
		System.out.print("\n");
		
		//relays information about the current variables
		new Delay("System.out.println(" + name + ");");
		new Delay("   Output: " + parsedValue);
		new Delay("System.out.println(x)");
		new Delay("   Output: " + x);
		System.out.print("\n");
		
		new Delay("With \"x\", add it to " + name + " by doing: " + name + " = " + name + " + x;");
		new Delay("Try it out.");
		
		//allows the player to apply what they just learned
		new Delay("Change the value of " + name + " by adding it to x");
		System.out.println("-----------------------------------------------------");
		
		//empty strings for future use
		String varOne = "";
		String varTwo = "";
		String operation = "";
		double finalOperation = 0;
		
		//while loop to allow the player to have multiple attemps
		boolean test = true;
		while (test)
		{
			varOne = Main.scanner.next();
			assignmentOperator = Main.scanner.next();
			varOne = Main.scanner.next();
			operation = Main.scanner.next();
			varTwo = Main.scanner.next();
			
			if (varTwo.indexOf(';') == -1)
			{
				System.out.println("You need a semicolon to end the line. Please try again.");
				continue;
			}
			
			if (!(varOne.equals(name)))
			{
				System.out.println("Please use variables that have been declared and initialized.");
				continue;
			}
			
			if (!(assignmentOperator.equals("=")))
			{
				System.out.println("You need the assignment operator. Please try again.");
				continue;
			}
			
			if (!(operation.equals("+")) && !(operation.equals("-")) && !(operation.equals("*")) && 
				!(operation.equals("/")) && !(operation.equals("%")))
			{
				System.out.println("That isn't a valid operation. Please try again.");
				continue;
			}
			
			if (!(varTwo.equals("x;")))
			{
				System.out.println("Please use a variable that has been declared and initialized.");
				continue;
			}
			
			if (operation.equals("+"))
			{
				finalOperation = parsedValue + (double)x;
				test = false;
			}
			else if (operation.equals("-"))
			{
				finalOperation = parsedValue - (double)x;
				test = false;
			}
			else if (operation.equals("*"))
			{
				finalOperation = parsedValue * (double)x;
				test = false;
			}
			else if (operation.equals("/"))
			{
				finalOperation = parsedValue / (double)x;
				test = false;
			}
			else
			{
				finalOperation = parsedValue % (double)x;
				test = false;
			}
		}
		new Delay("System.out.println(" + name + ");");
		new Delay("   Output: " + finalOperation);
		System.out.print("\n");
		
		new Delay("Now that you've changed the value of your variable " + name + "");
		new Delay("I want to teach you a way to simplify what you've just done.\n");
		new Delay(1000);
		
		new Delay("By simply doing " + name + " " + operation + "= x;");
		new Delay("You get the exact same result as doing what you just did.\n");
		new Delay(1000);
		
		new Delay("Try it yourself. All values for x and " + name + " have been reset.");
		System.out.println("-----------------------------------------------------");
		
		varOne = "";
		varTwo = "";
		operation = "";
		finalOperation = 0;
		
		test = true;
		while (test)
		{
			varOne = Main.scanner.next();
			assignmentOperator = Main.scanner.next();
			varTwo = Main.scanner.next();
			
			if (varTwo.indexOf(';') == -1)
			{
				System.out.println("You need a semicolon to end the line. Please try again.");
				continue;
			}
			
			if (varTwo.equals(name + ";"))
			{
				System.out.println("Change the value of " + name + ". Please try again.");
				continue;
			}
			
			if (!(varOne.equals(name)))
			{
				System.out.println("Please use variables that have been declared and initialized.");
				continue;
			}
			
			if (!(assignmentOperator.equals("+=")) && !(assignmentOperator.equals("-=")) && 
				!(assignmentOperator.equals("*=")) && !(assignmentOperator.equals("/=")) && !(assignmentOperator.equals("%=")))
			{
				System.out.println("Please utilize the simplified math operation to change " + name);
				continue;
			}
			
			if (!(varTwo.equals("x;")))
			{
				System.out.println("Please use variables that have been declared and initialized.");
				continue;
			}
			
			if (assignmentOperator.equals("+="))
			{
				finalOperation = parsedValue + (double)x;
				test = false;
			}
			else if (assignmentOperator.equals("-="))
			{
				finalOperation = parsedValue - (double)x;
				test = false;
			}
			else if (assignmentOperator.equals("*="))
			{
				finalOperation = parsedValue * (double)x;
				test = false;
			}
			else if (assignmentOperator.equals("/="))
			{
				finalOperation = parsedValue / (double)x;
				test = false;
			}
			else
			{
				finalOperation = parsedValue % (double)x;
				test = false;
			}
		}
		new Delay("System.out.println(" + name + ");");
		new Delay("   Output: " + finalOperation);
		System.out.print("\n");
	}
	
	public static void explainCasting()
	{
		new Delay("Casting is what it's called and what it is really simple. It is converting a value from one type to another.");
		new Delay(1000);
		
		new Delay("Casting in Java can either be done implicitly or explicitly.");
		new Delay("Explicitly casting of types looks like (int), (double), or (char) and then the variable name you want to cast.");
		if (dataType.equals("int"))
		{
			new Delay("Example: double castedNum = (double)" + varName + ";");
			new Delay("System.out.println(" + varName + ");");
			new Delay("     Output: " + value);
			new Delay("System.out.println(castedNum);");
			new Delay("     Output: " + (double)Integer.parseInt(value.substring(0, value.indexOf(';'))));
			
			new Delay("You can also cast an int to a char.");
		}
		else
		{
			new Delay("Example: int castedNum = (int)" + varName + ";");
			new Delay("System.out.println(" + varName + ");");
			new Delay("     Output: " + value);
			new Delay("System.out.println(castedNum);");
			new Delay("     Output: " + (int)Double.parseDouble(value.substring(0, value.indexOf(';'))));
			
			new Delay("You can also cast a double to a char.");
		}
		new Delay(1000);
		
		new Delay("You cannot cast a value into a boolean.");
		new Delay(1000);
		
		new Delay("This concept of casting will be important when you start to code bigger and better projects.");
	}
}
