/**
 * 
 * @author Nilesh Patel
 * Area class contains methods to calculate area of different shapes like Triangle, Rectangle, Circle, Square.
 *
 */
public class Area
{
	
	/**
	 * Find area of right angle triangle
	 * Assuming triangle is right angle triangle
	 * Assuming height and width value will greater than zero
	 * @param height : represent height of a right angle triangle
	 * @param base : represent width of a right angle triangle
	 * @return area of triangle
	 */
	public double getAreaOfTriangle(double height, double base)
	{
		double areaOfTriangle = (base * height) / 2;
		return areaOfTriangle;
	}
	
	/**
	 * Find area of rectangle
	 * Assuming height and width value will greater than zero
	 * @param height : represent height of a rectangle
	 * @param base : represent width of a rectangle
	 * @return area of triangle
	 */
	public double getAreaOfRectangle(double height, double base)
	{
		double areaOfRectangle = height * base;
		return areaOfRectangle;
	}
	
	/**
	 * Find area of circle
	 * Assuming radius value will greater than zero
	 * @param radius : represent radius of a circle
	 * @return area of a circle
	 */
	public double getAreaOfCircle(double radius)
	{
		double areaOfCircle = java.lang.Math.PI * java.lang.Math.pow(radius, 2);
		return areaOfCircle;
	}
	
	/**
	 * Find area of square
	 * Assuming height and width value will greater than zero
	 * @param base : represent width of a square
	 * @return area of a square
	 */
	public double getAreaOfSquare(double base)
	{
		double areaOfSquare = java.lang.Math.pow(base, 2);
		return areaOfSquare;
	}
	
	
}