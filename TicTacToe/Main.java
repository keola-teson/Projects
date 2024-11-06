import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is a recreation of the game tic-tac-toe
 * This game contains three arrays for the nine positions on the board, a jagged array to store those arrays in,
 * two array lists to store the moves that were played (separated out by row and column), and code to allow the player
 * to modify what is in the arrays
 * @author Keola Teson :)
 */
public class Main
{
    /*
     * Data Attributes
     * ---------------
     * Scanner - object to allow the player type in the console
     * char[] rowOne - stores the first row of the game and sets each value to the ascii code of space
     * char[] rowTwo - stores the second row of the game and sets each value to the ascii code of space
     * char[] rowThree - stores the third row of the game and sets each value to the ascii code of space
     * char[][] rows - jagged array to store the three arrays
     * rowInput - stores the player's row choice
     * columnInput - stores the player's column choice
     * rowInputHistory - array list to store the row that the player inputs
     * columnInputHistory - array list to store the column that the player inputs
     */
    static Scanner myScanner = new Scanner(System.in);
    static char[] rowOne = {32, 32, 32};
    static char[] rowTwo = {32, 32, 32};
    static char[] rowThree = {32, 32, 32};
    static char[][] rows = {rowOne, rowTwo, rowThree};
    static int rowInput;
    static String columnInput;
    static ArrayList<Integer> rowInputHistory = new ArrayList<>();
    static ArrayList<Integer> columnInputHistory = new ArrayList<>();
    static int i;
    static Opponent opponent = new Opponent();

    /**
     * Main method
     * runs all the code
     */
    public static void main(String[] args)
    {
        //welcomes the player to the game
        System.out.println("Welcome to Tic-Tac-Toe");

        //to let the players play until either someone wins or they tie
        for (i = 1; i < 9; i++)
        {
            /*
             * tie check.
             * small enough to put into the main method (I couldn't make it work outside)
             */
            if (rowOne[0] != 32 && rowOne[1] != 32 && rowOne[2] != 32 &&
                    rowTwo[0] != 32 && rowTwo[1] != 32 && rowTwo[2] != 32 &&
                    rowThree[0] != 32 && rowThree[1] != 32 && rowThree[2] != 32)
            {
                System.out.println("Tie. You both suck.");
                break;
            }
            //calls the playGame method and runs the code in it. also stores the value of rowInput and columnInput vars
            playGame();
            //checks if player one won
            youWin();
        }
        //closes the scanner
        myScanner.close();
    }

    public static void printBoard()
    {
        /*
         * wraps the arrays in the .toString class to print out each array into the console
         */
        System.out.println("   a  b  c");
        System.out.println("1 " + Arrays.toString(rowOne));
        System.out.println("2 " + Arrays.toString(rowTwo));
        System.out.println("3 " + Arrays.toString(rowThree));
        System.out.print("\n");
    }

    /**
     * method runs code that stores values in data attributes
     */
    public static void playGame()
    {
        //calls the printBoard method to print the board
        printBoard();

        //says whose turn it is
        System.out.println("Player One's Turn \n-----------------");

        /*
         * allows the player to select a row they want to place an X in and adds that value to the rowInputHistory
         * array list
         */
        System.out.println("Select a row: 1 | 2 | 3");
        //calls the rowCheck method to check if what the player inputted was a valid input
        rowInput = rowCheck(myScanner.nextLine());
        rowInputHistory.add(rowInput);

        /*
         * allows the player to select what column they want to place an X in and adds that value to the rowInputHistory
         * array list
         */
        System.out.println("Select a column: a | b | c");
        //calls the columnCheck method to check if what the player inputted was a valid input
        columnInput = columnCheck(myScanner.nextLine().toLowerCase());
        //columnInput.charAt(0) - 97 turns the char into a number between 0 and 2
        columnInputHistory.add(columnInput.charAt(0) - 97);

        //calls the modifyArrays method
        modifyArrays(rowInput, columnInput);

        //calls the opponent class and lets player 2 play
        opponent.playOpp();
    }

    /**
     * This method checks if the player inputted a number from 1-3
     * @param input (for the rowInput string in the playGame method)
     * @return rowCheck
     */
    public static int rowCheck(String input)
    {
        //declares rowCheck variable for return statement
        int rowCheck;
        /*
         * tries to turn the String input into an int and catches any errors to stop the code from stopping
         */
        try
        {
            //parses the input into an Integer object
            rowCheck = Integer.parseInt(input);

            //checks if the rowCheck is greater than 3
            if (rowCheck > 3)
            {
                //tells the player to input 1, 2, or 3
                System.out.println("Please input: 1 | 2 | 3");
                //calls the method with the scanner passed into it to loop it back to the top
                return rowCheck(myScanner.nextLine());
            }
            //returns the rowCheck variable if the check is false
            return rowCheck;
        }
        catch (Exception e)
        {
            //tells the player to input 1, 2, or 3
            System.out.println("Please input: 1 | 2 | 3");
            //calls the method with the scanner passed into it to loop it back to the top
            return rowCheck(myScanner.nextLine());
        }
    }

    /**
     * This method checks if the player inputted a, b, or c
     * @param input (for the columnInput string in the playGame method)
     * @return input
     */
    public static String columnCheck(String input)
    {
        //checks if the length of the input is 1
        if (input.length() == 1)
        {
            //checks if the input is not a, b, or c
            if (!(input.equals("a") || input.equals("b") || input.equals("c")))
            {
                //tells the player to input a, b, or c
                System.out.println("Please input: a | b | c");
                //calls the method again with the scanner passed inside to allow the player to type again
                return columnCheck(myScanner.nextLine());
            }
            //returns the input if false
            return input;
        }
        //calls the method again with the scanner passed inside to allow the player to type again if the check is false
        return columnCheck(myScanner.nextLine());
    }

    /**
     * This method modified the different arrays by replacing the ' ' char with 'X'
     * @param row (for the row input declared in the playGame method)
     * @param column (for the column input instantiated in the playGame method)
     */
    public static void modifyArrays(int row, String column)
    {
        /*
         * calls the 2D array. The first set of brackets decides which array it will store the 'X' in (bases it on the
         * row variable passed in the method) and the second set of brackets decides which value in the array chosen
         * by the first set of brackets will be changed to an 'X' char
         */
        rows[row - 1][column.charAt(0) - 97] = 'X';
    }

    /**
     * This method is awful. You could probably do this sooooo much easier, but I don't care.
     * This method does a bunch of checks and tells you "you win" if any of them are true
     */
    public static void youWin()
    {
        /*
         * checks if the first char in the first array, the second char in the first array, and the third char in the
         * first array are all 'X'
         * If they are print the final table and tell the player they won
         */
        if (rowOne[0] == 'X' && rowOne[1] == 'X' && rowOne[2] == 'X')
        {
            printBoard();
            System.out.println("You Win!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the first char in the second array, the second char in the second array, and the third char in the
         * second array are all 'X'
         * If they are print the final table and tell the player they won
         */
        else if (rowTwo[0] == 'X' && rowTwo[1] == 'X' && rowTwo[2] == 'X')
        {
            printBoard();
            System.out.println("You Win!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the first char in the third array, the second char in the third array, and the third char in the
         * third array are all 'X'
         * If they are print the final table and tell the player they won
         */
        else if (rowThree[0] == 'X' && rowThree[1] == 'X' && rowThree[2] == 'X')
        {
            printBoard();
            System.out.println("You Win!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the first char in the first array, the first char in the second array, and the first char in the
         * third array are all 'X'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[0] == 'X' && rowTwo[0] == 'X' && rowThree[0] == 'X')
        {
            printBoard();
            System.out.println("You Win!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the second char in the first array, the second char in the second array, and the second char in the
         * third array are all 'X'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[1] == 'X' && rowTwo[1] == 'X' && rowThree[1] == 'X')
        {
            printBoard();
            System.out.println("You Win!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the third char in the first array, the third char in the second array, and the third char in the
         * third array are all 'X'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[2] == 'X' && rowTwo[2] == 'X' && rowThree[2] == 'X')
        {
            printBoard();
            System.out.println("You Win!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the first char in the first array, the second char in the second array, and the third char in the
         * third array are all 'X'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[0] == 'X' && rowTwo[1] == 'X' && rowThree[2] == 'X')
        {
            printBoard();
            System.out.println("You Win!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the third char in the first array, the second char in the second array, and the first char in the
         * third array are all 'X'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[2] == 'X' && rowTwo[1] == 'X' && rowThree[0] == 'X')
        {
            printBoard();
            System.out.println("You Win!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
    }
}
