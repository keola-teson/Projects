import java.util.*;

/**
 * This is my Monty Hall game. This game is an interactive version of the monty hall problem. Very hard, not fun
 * @author Keola Teson :)
 */
public class MontyHallGame
{
    /*
     * the following variables and objects are used in the game:
     *  - choice (used to store the value the player inputs)
     *  - myScanner (scanner object)
     *  - input (used to allow the player to input a word)
     *  - winDoor (used to store the value of the win door generated)
     */
    private static int choice;
    private static final Scanner myScanner = new Scanner(System.in);
    private static String input;
    private static int winDoor;
    private static int wrongDoor;
    private static int remainingDoor;

    public static void main(String[] args)
    {
        //welcomes the player to the game
        System.out.println("Welcome to the Monty Hall problem. Pick a number from 1-3:");

        //calls method setWinningDoor to allow the method to store a value into winDoor
        setWinningDoor();
        //calls method pickPlayerDoor to allow the user to pick a number and store that choice in choice variable
        pickPlayerDoor();
        //calls method setWrongDoor to allow the variable wrongDoor to be used in different classes
        setWrongDoor();
        //calls method setRemainingDoor to allow the method to store a value into remainingDoor variable
        setRemainingDoor();
        //calls method askSwitch to ask the player if they want to switch
        askSwitch();
        
        
        //closes the scanner object instantiated in the data attributes
        myScanner.close();
    }

    /**
     * allows the player to type an input and stores that input as an int
     * @return choice variable
     */
    public static int pickPlayerDoor()
    {
        //allows the player to type
        input = myScanner.next();

        /*
         * checks if the player inputs "one" or "1"
         * - if the check returns true, store 1 in the choice variable
         * - returns the choice variable
         * if that check is false, checks if the player inputs "two" or "2"
         * - if the check returns true, store 2 in the choice variable
         * - returns the choice variable
         * if that check is false, checks if the player inputs "three" or "3"
         * - if the check returns true, store 3 in the choice variable
         * - returns the choice variable
         * if all checks return false, prompts the player to reinput something. calls the method again
         */
        if (input.equalsIgnoreCase("one") || input.equals("1"))
        {
            choice = 1;
            return choice;
        }
        else if (input.equalsIgnoreCase("two") || input.equals("2"))
        {
            choice = 2;
            return choice;
        }
        else if (input.equalsIgnoreCase("three") || input.equals("3"))
        {
            choice = 3;
            return choice;
        }
        System.out.println("That's not what I wanted. Give me \"one\", \"two\", or \"three\".");
        return pickPlayerDoor();
    }

    /**
     * creates a random number generator and assigns the number it generates to winDoor
     */
    public static void setWinningDoor()
    {
        winDoor = (int)(Math.random() * 3 + 1);
        System.out.println(winDoor);
    }

    /**
     * sets the wrong door that is revealed in a later method
     */
    public static void setWrongDoor()
    {
        /*
         * sets the value of the variable wrongDoor to a random number between 1 and 3
         * checks if wrongDoor is the same as variables winDoor and choice
         * - if the check is true, randomizes the number again and recalls this method to loop it
         * if the check is false, return wrongDoor
         */
        wrongDoor = (int)(Math.random() * 3 + 1);
        if (wrongDoor == winDoor || wrongDoor == choice)
        {
            setWrongDoor();
        }
    }
    
    public static void setRemainingDoor()
    {
    	/*
         * sets the value of the variable remainingDoor to a random number between 1 and 3
         * checks if remainingDoor is the same as variables winDoor, wrongDoor, and choice
         * - if the check is true, randomizes the number again and recalls this method to loop it
         * if the check is false, return remainingDoor
         */
    	remainingDoor = (int)(Math.random() * 3 + 1);
    	if (remainingDoor == wrongDoor || remainingDoor == choice)
    	{
    		setRemainingDoor();
    	}
    }

    /**
     * asks the player if they want to switch numbers
     */
    public static void askSwitch()
    {
        //tells the player which door is wrong
        System.out.println("The door with no prize is " + wrongDoor);
        //asks the player if they want to switch doors
        System.out.println("Would you like the switch doors?");

        //boolean for while statement
        boolean switchDoor = false;
        //while statement to check if the user gave a yes or no
        while (!switchDoor)
        {
            //allows the user to type yes or no
            input = myScanner.next();

            /*
             * checks if the player inputted "yes"
             * - if the check is true, goes to method winOrLoseYes and switches switchDoor variable to 
             *   true to leave the while statement
             * if the check is false, checks if the player inputted "no"
             * - if the check is true, goes to method winOrLoseNo and switches switchDoor variable to 
             *   true to leave the while statement
             * if all checks fail, prompts the user to input yes or no
             */
            if (input.equalsIgnoreCase("yes"))
            {
                winOrLoseYes();
            	switchDoor = true;
            }
            else if (input.equalsIgnoreCase("no"))
            {
                switchDoor = true;
                winOrLoseNo();
            }
            else
            {
                System.out.println("Please answer with a yes or no.");
            }
        }
    }

    /**
     * method to tell the user if they won or lost
     */
    public static void winOrLoseNo()
    {
    	if (choice == winDoor)
        {
            System.out.println("You win! :)");
            System.out.println("The winning door was " + winDoor);
        }
        else
        {
            System.out.println("You lose. :(");
            System.out.println("The winning door was " + winDoor);
        }
    }
    
    private static void winOrLoseYes()
    {
    	if (remainingDoor == winDoor)
    	{
    		System.out.println("You win! :)");
            System.out.println("The winning door was " + winDoor);
    	}
    	else
        {
            System.out.println("You lose. :(");
            System.out.println("The winning door was " + winDoor);
        }
    }
}
