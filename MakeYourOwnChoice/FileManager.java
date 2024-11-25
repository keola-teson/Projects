import java.io.*;
import java.util.Scanner;

/**
 * This class was made to make files for my MYC game
 * @author Keola Teson :)
 */
public class FileManager
{
	/*
	 * Data attributes
	 * ---------------
	 * 
	 * fileName - the name of the file
	 * path - the path where the file gets saved
	 * file - File object
	 */
	private String fileName;
	private String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator;
	
	/**
	 * Constructor for fileName
	 */
	public FileManager(String fn)
	{
		this.fileName = fn;
	}
	
	/**
	 * Getter and Setter for fileName data attribute
	 * @return fileName
	 */
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	/**
	 * Getter and Setter for path data attribute
	 * @return
	 */
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}

	/**
	 * Method to create a new file
	 */
	public void createNewFile()
	{	
		File file = new File(path + fileName);
		
		//try catch is necessary for creating a file
		try
		{
			//creates new file with createNewFile method
			file.createNewFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Overloaded method
	 * Method for when I need a temp file with just a file name passed into it
	 * @param fileName
	 * @return a temporary file to use in other classes
	 */
	public static File tempFile(String fileName)
	{
		File tempFile = new File(fileName);
		return tempFile;
	}
	
	/**
	 * Overloaded method
	 * Method for when I need a temp file with the path and file name passed into it
	 * @param path
	 * @param fileName
	 * @return a temporary file to use in other classes
	 */
	public static File tempFile(String path, String fileName)
	{
		File tempFile = new File(path + fileName);
		return tempFile;
	}
	
	/**
	 * Method to write into a file
	 * @param data (what is stored into the txt file)
	 */
	public void writeIntoFile(String data)
	{
		//try catch is necessary for writing into a file
		try
		{
			/*
			 * created a new FileWriter object and passed into it the file object created as a data attribute
			 * calling the write method and passed it the String parameter
			 * closed the writer
			 */
			FileWriter writer = new FileWriter(path + fileName);
			writer.write(data);
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to create a usable scanner in different classes
	 * @param file
	 * @return scanner with passed File
	 * @throws FileNotFoundException
	 */
	public Scanner readFile() throws FileNotFoundException
	{
		File readFile = new File(path + fileName);
		Scanner reader = new Scanner(readFile);
		return reader;
	}
	
	/**
	 * method to delete the file
	 */
	public void deleteFile()
	{
		File deleteFile = new File(path + fileName);
		deleteFile.delete();
	}
}
