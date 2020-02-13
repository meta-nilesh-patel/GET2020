package graphicsLibrary;

import java.util.ArrayList;
import java.util.Date;

import graphicsLibrary.Point;
import graphicsLibrary.Shapes;

/**
 *
 * @author Nilesh Patel
 * This class represent shape circle
 */
public class Circle implements Shapes
{	
	public int shapeId;
	public Point startPoint;
	public double radius;
	private Date dateOfCreation;
	private String shapeType;
	/**
	 * 
	 * This is parameterized constructor
	 * @param startPoint object of Point Class representing center of of circle
	 * @param list ArrayList containing radius of circle
	 */
	public Circle(Point startPoint, ArrayList<Integer> list)
	{
		this.startPoint = startPoint;
		this.radius = list.get(0);
		this.dateOfCreation = new Date();
		this.shapeType = "Circle";
	}

	/**
	 * 
	 * This method find the area of circle
	 * @return area of circle
	 */
	@Override
	public double getArea() 
	{
		return (Math.PI * radius * radius);
	}

	/**
	 * 
	 * This method find the perimeter of circle
	 * @return perimeter of cirlce
	 */
	@Override
	public double getPerimeter() 
	{
		return 2 * Math.PI * radius;
	}

	/**
	 * 
	 * This method find the origin points of the circle
	 * @return origin point of circle as object of Point Class
	 */
	@Override
	public Point getOrigin() 
	{
		Point point=new Point(this.startPoint.getxCoordinate(), this.startPoint.getyCoordinate());
		return point;
	}

	/**
	 * 
	 * This method find if any given point is enclosed by circle
	 * @param point object of Point Class containing details about the point
	 * @return true if point is enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		if(Math.sqrt((Math.pow((point.getxCoordinate() - this.startPoint.getxCoordinate()), 2)) + 
				(Math.pow((point.getyCoordinate() - this.startPoint.getyCoordinate()), 2))) <= radius)
		{
			return true;
		}
		return false;
	}

	/**
	 * 
	 * This method return Time on that shape  was created.
	 */
	@Override
	public Date getDate() 
	{
		return dateOfCreation;
	}

	/**
	 * 
	 * This method return Type of Circle.
	 */
	@Override
	public String getShapeType() 
	{
		return this.shapeType;
	}
	
	/**
	 * 
	 * This method return ShapeId of the Circle.
	 */
	@Override
	public int getShapeId()
	{
		return this.shapeId;
	}
	
	/**
	 * To get Distance From Origin Of Circle
	 * @return distance from origin of Circle
	 */
	@Override
	public double getOriginDistance() 
	{
		return Math.pow( (Math.pow(this.getOrigin().getxCoordinate(), 2) + Math.pow(this.getOrigin().getyCoordinate(), 2) ),  0.5);	
	}
	
	/**
	 * This method will set shapeId
	 * @param id : which shapeId we want to assign.
	 */
	public void setShapeId(int id)
	{
		this.shapeId = id;
	}
}