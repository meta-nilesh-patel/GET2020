package graphicsLibrary;

import java.util.ArrayList;

/**
 * 
 * @author Nilesh Patel
 * This is factory class which use to create object of all shapes
 */
public class FactoryShapes extends Screen
{	
	/**
	 * 
	 * This method is use to create object of different shapes
	 * @param shape String containing name of shape that object need to be created
	 * @param startPoint object of Point Class containing details about startPoint point of shape
	 * @param list ArrayList containing values for shape
	 * @return Object of Shape
	 * @throws Exception throws Exception if required shape is not available
	 */
	public static Shapes getShape(String shape, Point startPoint, ArrayList<Integer> list) throws Exception
	{
		if(shape.equalsIgnoreCase("Rectangle"))
		{
			return new Rectangle(startPoint, list);
		}
		else if(shape.equalsIgnoreCase("Square"))
		{
			return new Square(startPoint, list);	
		}
		else if(shape.equalsIgnoreCase("Triangle"))
		{
			return new Triangle(startPoint, list);	
		}
		else if(shape.equalsIgnoreCase("Circle"))
		{
			return new Circle(startPoint, list);	
		}
		else
		{
			throw new Exception("Shape Not Found");
		}
	}
}