package graphicsLibrary;

import java.util.ArrayList;
import java.util.Date;

import graphicsLibrary.Point;

/**
 * 
 * @author Nilesh Patel
 * This class represent shape Square
 */
public class Square implements Shapes
{
	public int shapeId;
	public Point start;
	public double side;
	private Date dateOfCreation;
	private String shapeType;

	/**
	 * 
	 * Parameterized constructor
	 * @param point object of Point Class containing details of point
	 * @param list ArrayList containing start and side values
	 */
	public Square(Point point, ArrayList<Integer> list)
	{
		this.start = point;
		this.side = list.get(0);
		this.dateOfCreation = new Date();
		this.shapeType = "Square";
	}

	/**
	 * 
	 * This method find the area of square
	 * @return area of square as double
	 */
	@Override
	public double getArea() 
	{
		return side * side;
	}

	/**
	 * 
	 * This method find the perimeter of square
	 * @return perimeter of square as double
	 */
	@Override
	public double getPerimeter() 
	{
		return 4 * side;
	}

	/**
	 * 
	 * This method return the origin point of square
	 * @return object of Point Class containing details of point
	 */
	@Override
	public Point getOrigin() 
	{
		Point point = new Point(this.start.getxCoordinate(), this.start.getyCoordinate());
		return point;
	}

	/**
	 * This method find if given point is enclosed by square
	 * @return true if point is enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		if(point.getxCoordinate() >= this.start.getxCoordinate() && ((this.start.getxCoordinate() + side) >= point.getxCoordinate()) && 
				point.getyCoordinate() >= this.start.getyCoordinate() && ((this.start.getyCoordinate() + side) >= point.getyCoordinate()))
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
	 * This method return Type of Square.
	 */
	@Override
	public String getShapeType() 
	{
		return this.shapeType;
	}
	
	/**
	 * 
	 * This method return ShapeId of the Square.
	 */
	@Override
	public int getShapeId()
	{
		return this.shapeId;
	}
	
	/**
	 * To get Distance From Origin Of Square
	 * @return distance from origin of Square
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
