
/**
 * This is where the game is played.
 * @author Keola Teson :)
 */
public class Game
{
			
	public static void main(String[] args) throws Exception
	{	
		//calls readSessionFile method
		SessionSaver.readSessionFile();
		//closes scanner
		Dialogue.myScanner.close();
	}
}
