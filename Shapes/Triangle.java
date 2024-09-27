/**
 * This class makes and tests triangles.
 * This class makes me wanna die.
 * @author Keola Teson :)
 */
public class Triangle
{
	//-------------------------------------------
	//data attributes
	//-------------------------------------------
	//declares the variables "base", "height", and "gamma"
	private double base;
	private double height;
	private double gamma;
	
	//-------------------------------------------
	//constructor
	//-------------------------------------------
	/**
	 * Sets parameters
	 * @param b
	 * @param h
	 * @param d
	 */
	public Triangle(double b, double h, double g)
	{
		//sets value of "base" to b, "height" to h, and "gamma" to g
		base = b;
		height = h;
		gamma = g;
	}
	
	//-------------------------------------------
	//functionality
	//-------------------------------------------
	/**
	 * Gets shape of object
	 */
	public static String getShape()
	{
		//returns the static shape of each object
		return "Triangle";
	}
	
	/**
	 * Gets side A of object
	 */
	public double getSideA()
	{
		/* finds area (base x height), assigns the variable "rad" to variable "gamma", and 
		 * solves for a (2 x area / base x sinY)
		 */
		double area = base * height;
		double rad = Math.toRadians(gamma);
		double sideA = 2 * area / base * Math.sin(rad);
		return sideA;
	}
	
	/**
	 * Gets side C of object
	 */
	public double getSideC()
	{
		/*
		 * FINDING C WAS SO STUPID I HATE TRIANGLES!!!
		 * first I solved for area (base x height), then I set the variable "rad" to "gamma",
		 * then I sovled for side a (2 x area / base x sinY)
		 * after that I looked online for ways to solve for C without perimeter and after some digging
		 * I found the equation. I calculate side c (c^2 = a^2 + b^2 - 2 ab cosY).
		 * After I solved for c^2 I square rooted it and found side c. I return side C
		 */
		double area = base * height;
		double rad = Math.toRadians(gamma);
		double sideA = 2 * area / base * Math.sin(rad);
		double sideC = sideA * sideA + base * base - 2 * sideA * base * Math.cos(rad);
		sideC = Math.sqrt(sideC);
		return sideC;
	}
	
	/**
	 * Gets perimeter of object
	 */
	public double getPerimeter()
	{
		/*
		 * to find perimeter (a + b + c) I needed to find side a and side c first. Once I did that
		 * I returned the perimeter formula
		 */
		double area = base * height;
		double rad = Math.toRadians(gamma);
		double sideA = 2 * area / base * Math.sin(rad);
		double sideC = sideA * sideA + base * base - 2 * sideA * base * Math.cos(rad);
		return sideA + base + sideC;
	}
	
	/**
	 * Gets area of object
	 */
	public double getArea()
	{
		//return the area (base x height) of each object
		return base * height;
	}
}
