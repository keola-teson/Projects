import java.util.Scanner;

import objects.ConsoleColors;
import objects.FileManager;

/**
 * Class to allow the player to stop and start the game where they left off
 * CURRENTLY UNUSED CLASS
 */
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
				data = fileReader.next();
			}
		
		Dialogue.setUpGameFiles();
		
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
				System.out.println("scene 1");
				Dialogue.makeFirstScene();
				
				Dialogue.sessionSaver.writeIntoFile("scene2");
				
			case "scene2":
				if (Dialogue.precinct.isInside())
				{
					Dialogue.tourPlayer();
				}
				else
				{
					Dialogue.goOutside();
				}
				break;
		
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
				if (Dialogue.precinct.isInside())
				{
					Dialogue.tourPlayer();
				}
				else
				{
					Dialogue.goOutside();
				}
				break;
		}
		System.out.println(ConsoleColors.RESET);
		System.out.println("Thank you for playing :)");
	}
}
