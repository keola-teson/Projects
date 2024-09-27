/**
 * This class makes and tests rectangles.
 * This class was made for a project.
 * @author Keola Teson :)
 */
public class Rectangle
{
	//-------------------------------------------
	//data attributes
	//-------------------------------------------
	//declares the variables "length" and "width"
	private double length;
	private double width;
	
	//-------------------------------------------
	//constructor
	//-------------------------------------------
	/**
	 * Sets parameters
	 * @param l
	 * @param w
	 */
	public Rectangle(double l, double w)
	{
		//sets value of length = l and width = w
		length = l;
		width = w;
	}
	
	//-------------------------------------------
	//functionalities
	//-------------------------------------------
	/**
	 * gets shape
	 */
	public static String getShape()
	{
		//returns static shape of each object
		return "Rectangle";
	}
	
	/**
	 * finds length and width
	 */
	public String getLengthAndWidth()
	{
		//returns the length and width of each object
		return "" + length + ", " + width;
	}
	
	/**
	 * gets perimeter
	 */
	public double getPerimeter()
	{
		//returns the perimeter (2(lw)) of each object
		return 2 * (length + width);
	}
	
	/**
	 * gets area
	 */
	public double getArea()
	{
		//returns the area ( length x width) of each object
		return length * width;
	}
	
	/**
	 * This turns everything about the rectangle object into a string
	 */
	public String toString()
	{
		return "This is a rectangle with length and width" + length + "" + width + "and an area of "
				+ getArea() + " and a perimeter of" + getPerimeter();
	}
}
