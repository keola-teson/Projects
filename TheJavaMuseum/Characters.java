
/**
 * Characters class to create the character objects
 */
public class Characters
{
	//data attribute to store the name of the object
	private String name;
	
	/**
	 * Overloaded constructor
	 * empty constructor for player
	 */
	public Characters() {}
	
	/**
	 * Overloaded constructor
	 * Gives the data attribute name the value of the parameter name
	 * @param name
	 */
	public Characters(String name)
	{
		this.name = name;
	}
	
	/**
	 * Getter for name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Setter for name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
