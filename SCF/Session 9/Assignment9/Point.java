package graphicsLibrary;

/**
 * 
 * @author Nilesh Patel
 * This class represent point on the screen
 * This store x and y coordinates
 */
public class Point 
{
	private double xCoordinate;
	private double yCoordinate;
	/**
	 * 
	 * Parameterized constructor
	 * @param x represent value of x axis
	 * @param y represent value of y axis
	 */
	public Point(double x, double y)
	{
		this.xCoordinate = x;
		this.yCoordinate = y;
	}

	/**
	 * 
	 * This method return value of xCoordinate
	 * @return value of xCoordinate
	 */
	public double getxCoordinate() 
	{
		return xCoordinate;
	}

	/**
	 * This method return value of yCoordinate
	 * @return value of yCoordinate
	 */
	public double getyCoordinate() 
	{
		return yCoordinate;
	}

}
