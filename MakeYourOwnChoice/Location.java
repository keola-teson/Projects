
/**
 * This is where the locations of the game are generated
 * @author Keola Teson :)
 */
public class Location
{
	private String location;
	private boolean isInside;
	
	public Location(String location, boolean isInside)
	{
		this.location = location;
		this.isInside = isInside;
	}

	/**
	 * Getters and setters to determine if the player is inside the location
	 * @return isInside
	 */
	public boolean isInside()
	{
		return isInside;
	}
	public void setInside(boolean isInside)
	{
		this.isInside = isInside;
	}

	/**
	 * Gets the location object name
	 * @return
	 */
	public String getLocation()
	{
		return location;
	}
}
