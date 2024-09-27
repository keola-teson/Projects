/**
 * This class makes and tests circles.
 * This was made in class as practice for the main project.
 * @author Keola Teson :)
 */
public class Circle 
{
	//-------------------------------------------
	//data attributes
	//-------------------------------------------
	//declares the variables of "pi" and "radius"
	private final double pi = 3.14;
	private double radius;
	
	//-------------------------------------------
	//constructor
	//-------------------------------------------
	/**
	 * Sets parameters
	 * @param r
	 */
	public Circle(double r)
	{
		//sets variable radius to r
		radius = r;
	}
	
	//-------------------------------------------
	//functionalities
	//-------------------------------------------
	/**
	 * gets static shape of the object
	 */
	public static String getShape()
	{
		//returns the name of the shape
		return "Circle";
	}
	
	/**
	 * gets radius of each object
	 */
	public double getRadius()
	{
		//returns the radius of the object
		return radius;
	}
	
	/**
	 * gets diameter of each object
	 */
	public double getDiameter()
	{
		//returns diameter (2 x radius) of the object
		return 2 * radius;
	}
	
	/**
	 * gets circumference of each object
	 */
	public double getCircum()
	{
		//gets circumference (2 x 3.14 x radius) of each object
		return 2 * pi * radius;
	}
	
	/**
	 * gets area of each object
	 */
	public double getArea()
	{
		//gets area (3.14 x radius^2) of each object
		return pi * radius * radius;
	}
	
	/**
	 * setter to change attribute in class
	 * @param r
	 */
	public void setRadius(double r)
	{
		this.radius = r;
	}
}
