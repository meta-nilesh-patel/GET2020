import java.io.IOException;

/**
 * 
 * @author Nilesh Patel
 * Immutable class for Polynomial Operations
 */	
final class Poly
{
	private final int[] polynomial;
	
	/**
	 * 
	 * Parameterized Constructor of class
	 * @param int array of Polynomial
	 * @throws IOException if the poly array is null
	 */
	Poly(int[] poly)throws IOException	
	{	
		//inputValidation
		if(poly.length == 0)
		{
			throw new IOException("Null Polynomial Not Allowed");
		}
		this.polynomial = poly;
	}
	
	/**
	 * 
	 * getter method for getting int array from polynomial
	 * @return int array of polynomials.
	 * @throws IOException if the polynomial is null.
	 */
	public int[] getPolynomial() throws IOException 
	{	
		Poly poly = new Poly(polynomial);
		return poly.polynomial;
	}
	
	/**
	 * 
	 * This method evaluate polynomial equation
	 * @param valueOfVariable : float value of which evaluation is to be done
	 * @return float type solution.
	 */
	public float evaluate(float valueOfVariable) 
	{	
		float solution = 0.0f;
		for(int indexValue = polynomial.length - 1; indexValue >= 0; indexValue--) 
		{
			solution += (polynomial[indexValue] * Math.pow(valueOfVariable, indexValue));
		}
		return solution;
	}
	
	/**
	 * 
	 * This method return degree of polynomial
	 * @return int value of degree.
	 */
	public int degree() 
	{
		return (polynomial.length-1);
	}
	
	/**
	 * 
	 * This method add two polynomial
	 * @param poly1 : Object of Poly Class of First Value
	 * @param poly2 : Object of Poly Class of Second Value
	 * @return Poly type object of sum of polynomials
	 * throws IOException if array of polynomial is null
	 */
	public static Poly addPoly(Poly poly1, Poly poly2) throws IOException
	{	
		if(poly2.polynomial.length > poly1.polynomial.length)
		{
			Poly p3 = poly1;
			poly1 = poly2;
			poly2 = p3;
		}
		
		int[] result = new int[Math.max(poly1.polynomial.length, poly2.polynomial.length)];
		for(int index = 0; index < poly1.polynomial.length; index++)
		{
			if(poly2.polynomial.length>index)
			{
				result[index] = poly1.polynomial[index] + poly2.polynomial[index];
			}
			else
			{
				result[index] = poly1.polynomial[index];
			}
		}
		return new Poly(result);
	}
	
	/**
	 * 
	 * This method multiply two polinomial
	 * @param poly1 : Object of Poly Class of First Value
	 * @param poly2 : Object of Poly Class of Second Value
	 * @return Poly type of product of polynomials
	 * throws IOException if array of polynomial is null
	 */
	public static Poly multiplyPoly(Poly poly1, Poly poly2)throws IOException 
	{
		int[] result = new int[poly1.polynomial.length + poly2.polynomial.length - 1];
		for(int indexFirst = poly1.polynomial.length - 1; indexFirst >= 0; indexFirst--) 
		{
			for(int indexSecond = poly2.polynomial.length - 1;indexSecond >= 0; indexSecond--) 
			{
				result[indexFirst + indexSecond] += poly1.polynomial[indexFirst] * poly2.polynomial[indexSecond];		
			}
		}
		return new Poly(result);
	}
}