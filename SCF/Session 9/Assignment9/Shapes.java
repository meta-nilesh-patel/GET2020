package graphicsLibrary;

import java.util.Date;

/**
 * 
 * @author Nilesh Patel
 * This interface represent shape and contain method related to it
 */
public interface Shapes  
{
	/**
	 * 
	 * This method find the area of the shape
	 * @return area of the shape as double
	 */
	public double getArea();

	/**
	 * 
	 * This method find the perimeter of the shape
	 * @return return the perimeter of the shape as double
	 */
	public double getPerimeter();

	/**
	 * 
	 * This method find the origin point of the shape
	 * @return object of Point Class containing the details about origin point
	 */
	public Point getOrigin();

	/**
	 * 
	 * This method find if given point is enclosed by the shape
	 * @param point object of Point Class containing details of point
	 * @return true if point is enclosed by the shape else false
	 */
	public boolean isPointEnclosed(Point point);

	/**
	 * 
	 * This method return Type of shape.
	 */
	public String getShapeType();

	/**
	 * 
	 * This method return Time on that shape  was created.
	 */
	public Date getDate();
	
	/**
	 * 
	 * This method return ShapeId of the shape.
	 */
	public int getShapeId();
	
	/**
	 * This method will set shapeId
	 * @param id : which shapeId we want to assign.
	 */
	public void setShapeId(int id);
	
	/**
	 * 
	 * To get Distance From Origin
	 */
	public double getOriginDistance();
}