/**
 * This class makes and tests square.
 * This class was made for a project.
 * @author Keola Teson :)
 */
public class Square
{
	//-------------------------------------------
	//data attributes
	//-------------------------------------------
	//declares the variable "side"
	private double side;
	
	//-------------------------------------------
	//constructor
	//-------------------------------------------
	/**
	 * Sets parameters
	 * @param s
	 */
	public Square(double s)
	{
		//sets value of "side" to s
		side = s;
	}
	
	//-------------------------------------------
	//functionalities
	//-------------------------------------------
	/**
	 * Gets the static shape
	 */
	public static String getShape()
	{
		//returns static shape of each object
		return "Square";
	}
	
	public void setSide(double side)
	{
		this.side = side;
	}

	/**
	 * Gets the side lengths of each square
	 */
	public double getSide()
	{
		//returns the sides of each object
		return side;
	}
	
	/**
	 * Gets the area of each square
	 */
	public double getArea()
	{
		//returns the area (side^2) of each object
		return side * side;
	}
	
	/**
	 * Gets the perimeter of each square
	 */
	public double getPerimeter()
	{
		//returns the perimeter (4 x side) of each object
		return 4 * side;
	}
}
