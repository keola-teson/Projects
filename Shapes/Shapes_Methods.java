/**
 * This class calls different classes and creates print statements
 * This class was made cuz I was bored lol
 * @author Keola Teson :)
 */
public class Shapes_Methods
{
	/**
	 * Makes and tests circles to print in a different class
	 */
	public static void printCircleStats()
	{
		//circle object values (radius):
		double circOneVar = 3.0;
		double circTwoVar = 20.0;
		double circThreeVar = -4.0;
		
		//creates three circle objects:
		Circle circOne = new Circle(circOneVar);
		Circle circTwo = new Circle(circTwoVar);
		Circle circThree = new Circle(circThreeVar);
		
		//Shape 0: prints the shape of each object with the "getShape()" method
		String shape0 = Circle.getShape();
		System.out.println(shape0);
		System.out.println("--------");
		//-------------------------------------------
		
		//prints the radius of each object with the "getRadius()" method 
		System.out.println("The radius of the following circles are:");
		System.out.println(circOne.getRadius());
		System.out.println(circTwo.getRadius());
		System.out.println(circThree.getRadius());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the diameter of each object with the "getDiameter()" method
		System.out.println("The diameter of the following circles are:");
		System.out.println(circOne.getDiameter());
		System.out.println(circTwo.getDiameter());
		System.out.println(circThree.getDiameter());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the circumference of each object with the "getCircum()" method
		System.out.println("The circumference of the following circles are:");
		System.out.println(circOne.getCircum());
		System.out.println(circTwo.getCircum());
		System.out.println(circThree.getCircum());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the area of each object with the "getArea()" method
		System.out.println("The area of the following circles are:");
		System.out.println(circOne.getArea());
		System.out.println(circTwo.getArea());
		System.out.println(circThree.getArea());
		System.out.println(" ");
		System.out.println(" ");
		//******************************************
	}
	
	/**
	 * Makes and tests squares to print in a different class
	 */
	public static void printSquareStats()
	{
		//square object values (side):
		double squOneVar = 7.0;
		double squTwoVar = 17.0;
		double squThreeVar = -3.0;
		
		//creates three square objects:
		Square squOne = new Square(squOneVar);
		Square squTwo = new Square(squTwoVar);
		Square squThree = new Square(squThreeVar);
		
		//Shape 1: prints the shape of each object with the "getShape()" method
		String shape1 = Square.getShape();
		System.out.println(shape1);
		System.out.println("--------");
		//-------------------------------------------
		
		//prints the side lengths of each object from with "getSide()" method
		System.out.println("The side lengths of the following squares are:");
		System.out.println(squOne.getSide());
		System.out.println(squTwo.getSide());
		System.out.println(squThree.getSide());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the perimeter of each object with the "getPerimeter()" method
		System.out.println("The perimeter of the following squares are:");
		System.out.println(squOne.getPerimeter());
		System.out.println(squTwo.getPerimeter());
		System.out.println(squThree.getPerimeter());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the area of each object from with "getArea()" method
		System.out.println("The area of the following squares are:");
		System.out.println(squOne.getArea());
		System.out.println(squTwo.getArea());
		System.out.println(squThree.getArea());
		System.out.println(" ");
		System.out.println(" ");
		//******************************************
	}
	
	/**
	 * Makes and tests rectangles to print in a different class
	 */
	public static void printRectangleStats()
	{
		//rectangle object values (length and width):
		double recOneVarOne = 14.0;
		double recOneVarTwo = 41.0;
				
		double recTwoVarOne = 44.0;
		double recTwoVarTwo = 21.0;
				
		double recThreeVarOne = 26.0;
		double recThreeVarTwo = 6.0;
		
		//creates three rectangle objects:
		Rectangle recOne = new Rectangle(recOneVarOne, recOneVarTwo);
		Rectangle recTwo = new Rectangle(recTwoVarOne, recTwoVarTwo);
		Rectangle recThree = new Rectangle(recThreeVarOne, recThreeVarTwo);
		
		//Shape 2: prints the shape of each object with the "getShape()" method
		String shape2 = Rectangle.getShape();
		System.out.println(shape2);
		System.out.println("--------");
		//-------------------------------------------
		
		//prints the lengths and width of each object with the "getLengthAndWidth()" method
		System.out.println("The side lengths of the following rectangles are:");
		System.out.println(recOne.getLengthAndWidth());
		System.out.println(recTwo.getLengthAndWidth());
		System.out.println(recThree.getLengthAndWidth());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the perimeter of each object with the "getPerimeter()" method
		System.out.println("The perimeter of the following rectangles are:");
		System.out.println(recOne.getPerimeter());
		System.out.println(recTwo.getPerimeter());
		System.out.println(recThree.getPerimeter());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the area of each object with the "getArea()" method
		System.out.println("The area of the following rectangles are:");
		System.out.println(recOne.getArea());
		System.out.println(recTwo.getArea());
		System.out.println(recThree.getArea());
		System.out.println(" ");
		System.out.println(" ");
		//******************************************
		
		//prints everything above in one print statement
		System.out.println(recOne.toString());
	}
	
	/**
	 * Makes and tests triangles to print in a different class
	 */
	public static void printTriangleStats()
	{
		//triangle object values (base, height, and gamma):
		double triOneVarOne = 9.0;
		double triOneVarTwo = 44.0;
		double triOneVarThree = 16.0;
		
		double triTwoVarOne = 9.0;
		double triTwoVarTwo = 44.0;
		double triTwoVarThree = 16.0;
		
		double triThreeVarOne = 9.0;
		double triThreeVarTwo = 44.0;
		double triThreeVarThree = 16.0;
		
		//creates three triangle objects:
		Triangle triOne = new Triangle(triOneVarOne, triOneVarTwo, triOneVarThree);
		Triangle triTwo = new Triangle(triTwoVarOne, triTwoVarTwo, triTwoVarThree);
		Triangle triThree = new Triangle(triThreeVarOne, triThreeVarTwo, triThreeVarThree);
		
		//Shape 3: prints the shape of each object with the "getShape()" method
		String shape3 = Triangle.getShape();
		System.out.println(shape3);
		System.out.println("--------");
		//-------------------------------------------
		
		//prints side a of each object with the "getSideA()" method
		System.out.println("Side a of the following triangles are:");
		System.out.println(triOne.getSideA());
		System.out.println(triTwo.getSideA());
		System.out.println(triThree.getSideA());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints side c of each object with the "getSideC()" method
		System.out.println("Side C of the following triangles are:");
		System.out.println(triOne.getSideC());
		System.out.println(triTwo.getSideC());
		System.out.println(triThree.getSideC());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the perimeter of each object with the "getPerimeter()" mothod
		System.out.println("The perimeter of the following triangles are:");
		System.out.println(triOne.getPerimeter());
		System.out.println(triTwo.getPerimeter());
		System.out.println(triThree.getPerimeter());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the area of each object with the "getArea()" method
		System.out.println("The area of the following triangles are:");
		System.out.println(triOne.getArea());
		System.out.println(triTwo.getArea());
		System.out.println(triThree.getArea());
		System.out.println(" ");
		System.out.println(" ");
		//******************************************
	}
	
	/**
	 * Makes and tests shperes to print in a different class
	 */
	public static void printSphereStats()
	{
		//sphere object values (radius):
		double sphOneVar = 6.0;
		double sphTwoVar = 49.0;
		double sphThreeVar = 44.0;
		
		//creates three sphere objects:
		Sphere sphOne = new Sphere(sphOneVar);
		Sphere sphTwo = new Sphere(sphTwoVar);
		Sphere sphThree = new Sphere(sphThreeVar);
		
		//Shape 4: prints the shape of each object with the "getShape()" method
		String shape4 = Sphere.getShape();
		System.out.println(shape4);
		System.out.println("--------");
		//-------------------------------------------
		
		//prints the diameter of each object with the "getDiameter()" method
		System.out.println("The diameter of the following spheres are:");
		System.out.println(sphOne.getDiameter());
		System.out.println(sphTwo.getDiameter());
		System.out.println(sphThree.getDiameter());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the volume of each object with the "getVolume()" method
		System.out.println("The volume of the following spheres are:");
		System.out.println(sphOne.getVolume());
		System.out.println(sphTwo.getVolume());
		System.out.println(sphThree.getVolume());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the surface area of each object with the "getSA()" method
		System.out.println("The surface area of the following spheres are:");
		System.out.println(sphOne.getSA());
		System.out.println(sphTwo.getSA());
		System.out.println(sphThree.getSA());
		System.out.println(" ");
		System.out.println(" ");
		//******************************************
	}
	
	/**
	 * Makes and tests cubes to print in a different class
	 */
	public static void printCubeStats()
	{
		//cube object values (edge):
		double cubeOneVar = 33.0;
		double cubeTwoVar = 23.0;
		double cubeThreeVar = 38.0;
		
		//creates three cube objects:
		Cube cubeOne = new Cube(cubeOneVar);
		Cube cubeTwo = new Cube(cubeTwoVar);
		Cube cubeThree = new Cube(cubeThreeVar);
		
		//Shape 5: prints the shape of each object with the "getShape()" method
		String shape5 = Cube.getShape();
		System.out.println(shape5);
		System.out.println("--------");
		//-------------------------------------------
		
		//prints the volume of each object with the "getVolume()" method
		System.out.println("The volume of the following spheres are:");
		System.out.println(cubeOne.getVolume());
		System.out.println(cubeTwo.getVolume());
		System.out.println(cubeThree.getVolume());
		System.out.println(" ");
		//-------------------------------------------
		
		//prints the surface area of each object with the "getSA()" method
		System.out.println("The surface area of the following spheres are:");
		System.out.println(cubeOne.getSA());
		System.out.println(cubeTwo.getSA());
		System.out.println(cubeThree.getSA());
		System.out.println(" ");
		System.out.println(" ");	
	}
}

