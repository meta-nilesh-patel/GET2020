package graphicsLibrary;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Nilesh Patel
 * Implements The Shape Interface For Triangle
 */
public class Triangle implements Shapes
{
	public int shapeId;
	private Point startPoint;
	private double base;
	private double leftSide;
	private double rightSide;
	private Date dateOfCreation;
	private String shapeType;

	/**
	 * 
	 * Parameterized constructor for initialize instance variables.
	 * @param startPoint
	 * @param listOfParameter
	 */
	public Triangle(Point startPoint, List<Integer> listOfParameter)
	{
		this.startPoint = startPoint;
		this.base = listOfParameter.get(0);
		this.leftSide = listOfParameter.get(1);
		this.rightSide = listOfParameter.get(2);
		this.dateOfCreation = new Date();
		this.shapeType = "Triangle";
	}

	/**
	 * 
	 * This method find the area of the shape
	 * @return area of the shape as double
	 */
	@Override
	public double getArea() 
	{
		/**
		 * s is the Heron's Parameter
		 */
		double s = getPerimeter() / 2;
		double areaOfCircle = Math.pow(s * (s - this.base) * (s - this.leftSide) * (s - this.rightSide), 2);
		return areaOfCircle;
	}

	/**
	 * 
	 * This method find the perimeter of the shape
	 * @return return the perimeter of the shape as double
	 */
	@Override
	public double getPerimeter() 
	{
		return this.base + this.leftSide + this.rightSide;
	}

	/**
	 * 
	 * This method find the origin points of the shape
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
	 * This method find if given point is enclosed by the shape
	 * @param point object of Point Class containing details of point
	 * @return true if point is enclosed by the shape else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		/**
		 * A Triangle has three Points
		 */ 
		double xCordinateOfFirstPoint = this.startPoint.getxCoordinate();
		double yCordinateOfFirstPoint = this.startPoint.getyCoordinate();
		double xCordinateOfSecondPoint = xCordinateOfFirstPoint + this.base;
		double yCordinateOfSecondPoint = yCordinateOfFirstPoint;
		double xCordinateOfThirdPoint = ( Math.pow(this.leftSide, 2) - Math.pow(this.rightSide, 2) + Math.pow(xCordinateOfSecondPoint, 2) - Math.pow(xCordinateOfFirstPoint, 2) ) / 2 * this.base;
		double yCordinateOfThirdPoint = Math.pow(this.leftSide, 2) + Math.pow(yCordinateOfFirstPoint, 2) - Math.pow(( xCordinateOfSecondPoint - xCordinateOfFirstPoint ), 2);

		/**
		 * take the mode of 3rd points coordinates
		 */
		xCordinateOfThirdPoint = Math.abs(xCordinateOfThirdPoint);
		yCordinateOfThirdPoint = Math.abs(yCordinateOfThirdPoint);

		double areaOfTrianglePAB = areaOfTriangle(xCordinateOfFirstPoint, yCordinateOfFirstPoint, xCordinateOfSecondPoint, yCordinateOfSecondPoint, point.getxCoordinate(), point.getyCoordinate());
		double areaOfTrianglePBC = areaOfTriangle(xCordinateOfSecondPoint, yCordinateOfSecondPoint, xCordinateOfThirdPoint, yCordinateOfThirdPoint, point.getxCoordinate(), point.getyCoordinate());
		double areaOfTrianglePCA = areaOfTriangle(xCordinateOfThirdPoint, yCordinateOfThirdPoint, xCordinateOfFirstPoint, yCordinateOfFirstPoint, point.getxCoordinate(), point.getyCoordinate());

		if(this.getArea() == areaOfTrianglePAB + areaOfTrianglePBC + areaOfTrianglePCA)
		{
			return true;
		}	
		return false;
	}

	/**
	 * 
	 * To get the area of triangle using coordinates
	 * @param x1 : xCordinateOfFirstPoint 
	 * @param y1 : yCordinateOfFirstPoint
	 * @param x2 : xCordinateOfSecondPoint
	 * @param y2 : yCordinateOfSecondPoint
	 * @param x3 : xCordinateOfThirdPoint
	 * @param y3 : yCordinateOfThirdPoint
	 * @return Area of triangle
	 */
	private double areaOfTriangle(double x1, double y1, double x2, double y2, double x3, double y3) 
	{ 
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0); 
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
	 * This method return Type of Tringle.
	 */
	@Override
	public String getShapeType() 
	{
		return this.shapeType;
	}
	
	/**
	 * 
	 * This method return ShapeId of the Tringle.
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
