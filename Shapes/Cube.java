/**
 * This class makes and tests a cube.
 * This class was made for a project.
 * @author Keola Teson :)
 */
public class Cube
{
	//-------------------------------------------
	//data attributes
	//-------------------------------------------
	//declares the variable "edge"
	private double edge;
	
	//-------------------------------------------
	//construcor 
	//-------------------------------------------
	/**
	 * Sets parameters
	 * @param e
	 */
	public Cube(double e)
	{
		//sets variable "edge" to e
		edge = e;
	}
	
	//-------------------------------------------
	//functionalities
	//-------------------------------------------
	/**
	 * Gets shape of object
	 */
	public static String getShape()
	{
		//returns the static name of each object
		return "Cube";
	}
	
	/**
	 * Gets volume of object
	 */
	public double getVolume()
	{
		//returns the volume (edge^3) of each object
		return edge * edge * edge;
	}
	
	/**
	 * Gets surface area of object
	 */
	public double getSA()
	{
		//returns the surface area (6 x edge^2) of each object
		return 6 * edge * edge;
	}
}
