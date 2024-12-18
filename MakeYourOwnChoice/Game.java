
/**
 * This is where the game is played.
 * THIS IS NOT A COMPLETE GAME
 * @author Keola Teson :)
 */
public class Game
{
	public static void main(String[] args) throws Exception
	{	
		Dialogue.setUpGameFiles();
		
		//introduces the game to the player
		Dialogue.setUpGame();
		
		//Writes into file "scene1" (currently being unused)
		Dialogue.sessionSaver.writeIntoFile("scene1");
		//start of the game
		Dialogue.makeFirstScene();
		
		//closes scanner
		Dialogue.myScanner.close();
		
		Dialogue.deleteFiles();
	}
}
