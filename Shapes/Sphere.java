/**
 * This class makes and tests sphere. 
 * This class was made for a project.
 * @author Keola Teson :)
 */
public class Sphere
{
	//-------------------------------------------
	//data attributes
	//-------------------------------------------
	//declares the variables "pi" and "radius"
	private final double pi = 3.14;
	private double radius;
	
	//-------------------------------------------
	//constructor
	//-------------------------------------------
	/**
	 * Sets parameter
	 * @param r
	 */
	public Sphere(double r)
	{
		//sets value of "radius" to r
		radius = r;
	}
	
	//-------------------------------------------
	//functionalities
	//-------------------------------------------
	/**
	 * Gets shape of object
	 */
	public static String getShape()
	{
		//returns the static shape of each object
		return "Sphere";
	}
	
	/**
	 * Gets diameter of object
	 */
	public double getDiameter()
	{
		//returns the diameter (2 x radius) of each object
		return 2 * radius;
	}
	
	/**
	 * Gets volume of object
	 */
	public double getVolume()
	{
		//returns the volume (4 / 3 x 3.14 x radius^3) of each object
		return 4/3 * pi * radius * radius * radius;
	}
	
	/**
	 * Gets surface area
	 */
	public double getSA()
	{
		//returns the surface area (4 x 3.14 x radius^2) of each object
		return 4 * pi * radius * radius;
	}
}
