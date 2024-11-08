/**
 * This class is for player 2
 * This class was originally meant for the computer the player plays against, but I need to finish this project, so I
 * just decided to make it a player 2 class
 * @author Keola Teson :)
 */
public class Opponent extends Main
{
    //constructor to allow the Main class to call this class
    public Opponent() {}

    /**
     * Class to allow player 2 to play
     * called after playGame method in Main class is finished with all the code inside it
     */
    public void playOpp()
    {
        //calls the printBoard method in the Main class to print the board
        printBoard();
        //tells player 2 it's their turn
        System.out.println("Player Two's Turn \n-----------------");

        System.out.println("Select a row: 1 | 2 | 3");
        //calls the rowCheck method to check if what the player inputted was a valid input
        rowInput = rowCheck(myScanner.nextLine());

        /*
         * allows the player to select what column they want to place an O in and adds that value to the rowInputHistory
         * array list
         */
        System.out.println("Select a column: a | b | c");
        //calls the columnCheck method to check if what the player inputted was a valid input
        columnInput = columnCheck(myScanner.nextLine().toLowerCase());
        //columnInput.charAt(0) - 97 turns the char into a number between 0 and 2

        //calls the modifyArrays method
        modifyArrays(rowInput, columnInput);
    }

    /**
     * This method modified the different arrays by replacing the ' ' char with 'O'
     * @param row (for the row input declared in the playGame method)
     * @param column (for the column input instantiated in the playGame method)
     */
    public static void modifyArrays(int row, String column)
    {
        /*
         * calls the 2D array. The first set of brackets decides which array it will store the 'O' in (bases it on the
         * row variable passed in the method) and the second set of brackets decides which value in the array chosen
         * by the first set of brackets will be changed to an 'O' char
         */
        rows[row - 1][column.charAt(0) - 97] = 'O';
    }

    /**
     * This method is awful. You could probably do this sooooo much easier, but I don't care.
     * This method does a bunch of checks and tells you "you win" if any of them are 10
     */
    public static void youWin()
    {
        /*
         * checks if the first char in the first array, the second char in the first array, and the third char in the
         * first array are all 'O'
         * If they are print the final table and tell the player they won
         */
        if (rowOne[0] == 'O' && rowOne[1] == 'O' && rowOne[2] == 'O')
        {
            printBoard();
            System.out.println("Player Two Won!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the first char in the second array, the second char in the second array, and the third char in the
         * second array are all 'O'
         * If they are print the final table and tell the player they won
         */
        else if (rowTwo[0] == 'O' && rowTwo[1] == 'O' && rowTwo[2] == 'O')
        {
            printBoard();
            System.out.println("Player Two Won!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the first char in the third array, the second char in the third array, and the third char in the
         * third array are all 'O'
         * If they are print the final table and tell the player they won
         */
        else if (rowThree[0] == 'O' && rowThree[1] == 'O' && rowThree[2] == 'O')
        {
            printBoard();
            System.out.println("Player Two Won!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the first char in the first array, the first char in the second array, and the first char in the
         * third array are all 'O'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[0] == 'O' && rowTwo[0] == 'O' && rowThree[0] == 'O')
        {
            printBoard();
            System.out.println("Player Two Won!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the second char in the first array, the second char in the second array, and the second char in the
         * third array are all 'O'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[1] == 'O' && rowTwo[1] == 'O' && rowThree[1] == 'O')
        {
            printBoard();
            System.out.println("Player Two Won!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the third char in the first array, the third char in the second array, and the third char in the
         * third array are all 'O'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[2] == 'O' && rowTwo[2] == 'O' && rowThree[2] == 'O')
        {
            printBoard();
            System.out.println("Player Two Won!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the first char in the first array, the second char in the second array, and the third char in the
         * third array are all 'O'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[0] == 'O' && rowTwo[1] == 'O' && rowThree[2] == 'O')
        {
            printBoard();
            System.out.println("Player Two Won!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
        /*
         * checks if the third char in the first array, the second char in the second array, and the first char in the
         * third array are all 'O'
         * If they are print the final table and tell the player they won
         */
        else if (rowOne[2] == 'O' && rowTwo[1] == 'O' && rowThree[0] == 'O')
        {
            printBoard();
            System.out.println("Player Two Won!");
            //sets i variable to 10 to end the for loop
            i = 10;
        }
    }
}
