package graphicsLibrary;

import java.util.ArrayList;
import java.util.Date;

import graphicsLibrary.Point;
import graphicsLibrary.Shapes;

/**
 *
 * @author Nilesh Patel
 *  This class represent shape Rectangle
 */
public class Rectangle implements Shapes
{
	private int shapeId;
	public double length;
	public double breadth;
	public Point startPoint;
	private Date dateOfCreation;
	private String shapeType;

	/**
	 * 
	 * Parameterized constructor 
	 * @param point object of the Point Class containing details about the startPointing point of rectangle
	 * @param list contain values of length and breadth of rectangle in ArrayList
	 */
	public Rectangle (Point point, ArrayList<Integer> list)
	{
		this.startPoint = point;
		this.length = list.get(0);
		this.breadth = list.get(1);
		this.dateOfCreation = new Date();
		this.shapeType = "Rectangle";
	}

	/**
	 * 
	 * This method return the area of rectangle
	 * @return area of rectangle as double
	 */
	@Override
	public double getArea() 
	{
		return length * breadth;
	}

	/**
	 * 
	 * This method return the perimeter of rectangle
	 * @return perimeter of rectangle as double
	 */
	@Override
	public double getPerimeter() 
	{
		return 2 * (length + breadth);
	}

	/**
	 * 
	 * This method find if any given point is enclosed by rectangle
	 * @param point object of the Point Class representing the point
	 * @return true if point is enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		if(point.getxCoordinate() >= this.startPoint.getxCoordinate() && (this.startPoint.getxCoordinate() + length) >= point.getyCoordinate() && 
				point.getyCoordinate() >= this.startPoint.getyCoordinate() && (this.startPoint.getyCoordinate()+breadth) >= point.getyCoordinate())
		{
			return true;
		}
		return false;
	}

	/**
	 * 
	 * This method find the origin of rectangle]
	 * @return object of Point class containing details of the origin point
	 */
	@Override
	public Point getOrigin() 
	{
		Point point = new Point(this.startPoint.getxCoordinate(), this.startPoint.getyCoordinate());
		return point;
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
	 * This method return Type of Rectangle.
	 */
	@Override
	public String getShapeType() 
	{
		return this.shapeType;
	}
	
	/**
	 * 
	 * This method return ShapeId of the Rectangle.
	 */
	@Override
	public int getShapeId()
	{
		return this.shapeId;
	}
	
	/**
	 * To get Distance From Origin Of Rectangle
	 * @return distance from origin of Rectangle
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
