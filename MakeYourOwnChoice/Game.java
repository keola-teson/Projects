import java.util.Scanner;

/**
 * This is where the game is played.
 * @author Keola Teson :)
 */
public class Game
{
	//sets up objects for game
	static Scanner gameScanner = new Scanner(System.in);
			
	public static void main(String[] args) throws Exception
	{
		//calls the callSetUpClass method
		Dialogue.callSetUpClass();
		
		Dialogue.makeFirstScene();
		
		//closes scanner
		gameScanner.close();
	}
}
