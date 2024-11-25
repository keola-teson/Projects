import java.util.Scanner;


public class SessionSaver
{	
	public static void readSessionFile() throws Exception
	{
		//creates a new session file
		Dialogue.sessionSaver.createNewFile();
		
		//Scanner object to read the passed file
		Scanner fileReader = new Scanner(FileManager.tempFile(Dialogue.sessionSaver.getPath() + Dialogue.sessionSaver.getFileName()));
		//String variable to instantiated for future use
		String data = "";
		
		//while loop to loop through every word in the file
		while(fileReader.hasNext())
			{
				//stores the data in the file to data String
				data = fileReader.nextLine();
			}
		
		/*
		 * GIANT SWITCH STATEMENT
		 * *NOT FINISHED*
		 */
		switch (data)
		{
			/*
			 * case "scene1"
			 * 
			 * calls every scene after the set up scene
			 */
			case "scene1":
				Dialogue.makeFirstScene();
		
			/*
			 * default
			 * 
			 * creates the files
			 * calls every scene
			 * (only gets called when you first start the game because there is nothing in the session_saver file
			 */
			default:
				Dialogue.setUpGameFiles();
				Dialogue.setUpGame();
				Dialogue.sessionSaver.writeIntoFile("scene1");
				Dialogue.makeFirstScene();
				Dialogue.sessionSaver.writeIntoFile("scene2");
		}
	}
}
