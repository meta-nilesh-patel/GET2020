package triangle;

/**
 * 
 * @author Nilesh Patel
 * This class contain getArea method for find area of a triangle. 
 */
public class Triangle
{
	/**
	 * 
	 * This function compute area of triangle.
	 * @param firstSide
	 * @param secondSide
	 * @param thirdSide
	 * @return String type object of area.
	 */
	public String getArea(int firstSide, int secondSide, int thirdSide)
	{
		double halfPerimeter = (firstSide + secondSide + thirdSide) / 2.0;
		double areaSquare = halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide);	
		double area = Math.sqrt(areaSquare);
		return String.valueOf(area);
	}
}