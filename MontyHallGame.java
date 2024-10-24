import java.util.*;
public class MontyHallGame
{
    private static int choice;
    private static int wrongDoor;
    private static Scanner myScanner = new Scanner(System.in);
    private static String input;
    private static int winDoor;

    public static void main(String[] args)
    {
        System.out.println("Welcome to the Monty Hall problem. Pick a number from 1-3:");

        pickPlayerDoor();
        askSwitch();

        myScanner.close();
    }

    public static int pickPlayerDoor()
    {
        input = new String(myScanner.next());
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

    public static int setWinningDoor()
    {
        winDoor = (int)(Math.random() * 3 + 1);
        return winDoor;
    }

    public static int setWrongDoor()
    {
        wrongDoor = (int)(Math.random() * 3 + 1);
        boolean differentNum = false;
        while (differentNum == false)
        {
            if (wrongDoor == winDoor)
            {
                wrongDoor = (int)(Math.random() * 3 + 1);
            }
            else
            {
                differentNum = true;
            }
        }
        return wrongDoor;
    }

    public static void askSwitch()
    {
        System.out.println("The door with no prize is " + setWrongDoor());
        System.out.println("Would you like the switch doors?");

        boolean switchDoor = false;
        while (switchDoor == false)
        {
            input = new String(myScanner.next());

            if (input.equalsIgnoreCase("yes"))
            {
                System.out.println("Please pick a new door.");
                pickPlayerDoor();
                winOrLose();
                switchDoor = true;
            }
            else if (input.equalsIgnoreCase("no"))
            {
                winOrLose();
                switchDoor = true;
            }
            else
            {
                System.out.println("Please answer with a yes or no.");
            }
        }
    }

    public static void winOrLose()
    {
        if (choice == winDoor)
        {
            System.out.println("You win! :)");
        }
        else
        {
            System.out.println("You lose. :(");
            System.out.println("The winning door was " + setWinningDoor());
        }
    }
}
