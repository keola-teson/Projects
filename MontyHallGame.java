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

    public static void main(String[] args)
    {
        //welcomes the player to the game
        System.out.println("Welcome to the Monty Hall problem. Pick a number from 1-3:");

        //calls method pickPlayerDoor() and askSwitch()
        setWinningDoor();
        setWrongDoor();
        pickPlayerDoor();
        askSwitch();
        winOrLose();

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
        if (input.equals("one") || input.equals("1"))
        {
            choice = 1;
            return choice;
        }
        else if (input.equals("two") || input.equals("2"))
        {
            choice = 2;
            return choice;
        }
        else if (input.equals("three") || input.equals("3"))
        {
            choice = 3;
            return choice;
        }
        System.out.println("That's not what I wanted. Give me \"one\", \"two\", or \"three\".");
        return pickPlayerDoor();
    }

    /**
     * creates a random number generator and assigns the number it generates to winDoor
     * @return winDoor variable
     */
    public static int setWinningDoor()
    {
        winDoor = (int)(Math.random() * 3 + 1);
        return winDoor;
    }

    /**
     * sets the wrong door that is revealed in a later method
     * @return wrongDoor variables
     */
    public static int setWrongDoor()
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
        return wrongDoor;
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
             * - if the check is true, prompts the user to pick a new door and calls the pickPlayerDoor method.
             *   switches switchDoor variable to true to leave the while statement
             * if the check is false, checks if the player inputted "no"
             * - if the check is true, switches switchDoor variable to true to leave the while statement
             * if all checks fail, prompts the user to input yes or no
             */
            if (input.equalsIgnoreCase("yes"))
            {
                System.out.println("Please pick a new door.");
                pickPlayerDoor();
                switchDoor = true;
            }
            else if (input.equalsIgnoreCase("no"))
            {
                switchDoor = true;
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
    public static void winOrLose()
    {
        /*
         * checks if the value in the choice variable is the same as the value in the winDoor variable
         * - if yes, tells the player they won :)
         * if the check is false, tells the player they lost :(
         */
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
}
