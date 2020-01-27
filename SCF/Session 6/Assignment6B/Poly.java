import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * @author Nilesh Patel
 * Immutable class for Polynomial Operations
 */	
public final class Poly
{
	private final HashMap<Integer, Integer> polynomial = new HashMap<>();
	private int degreeOfPolynomial;
	
	/**
	 * 
	 * Parameterized Constructor of class
	 * @param int array of Polynomial
	 * @throws IOException if the poly array is null
	 */
	Poly(int[] poly) throws Exception	
	{	
		//inputValidation
		if(poly.length == 0)
		{
			throw new Exception("Null Polynomial Not Allowed");
		}
		for (int indexOfPoly = 0; indexOfPoly < poly.length; indexOfPoly++)
		{
			if(poly[indexOfPoly] != 0)
			{
				this.polynomial.put(indexOfPoly, poly[indexOfPoly]);
				this.degreeOfPolynomial = indexOfPoly;
			}
		}	
	}
	
	/**
	 * 
	 * getter method for getting int array from polynomial
	 * @return int array of polynomials.
	 */
	public int[] getPolynomialArray() 
	{	
		int[] polynomialArray = new int[this.degreeOfPolynomial + 1];
		for (int exponent = 0; exponent < polynomialArray.length; exponent++)
		{
			if(this.polynomial.containsKey(exponent))
			{
				polynomialArray[exponent] = this.polynomial.get(exponent);
			}
			else
			{
				polynomialArray[exponent] = 0;
			}
		}
		return polynomialArray;
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
		 for (Entry<Integer, Integer> entry : this.polynomial.entrySet())   
		{
			solution += (entry.getValue() * Math.pow(valueOfVariable, entry.getKey()));
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
		return this.degreeOfPolynomial;
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
		if(poly2.degreeOfPolynomial > poly1.degreeOfPolynomial)
		{
			Poly p3 = poly1;
			poly1 = poly2;
			poly2 = p3;
		}
		
		int[] poly1Array = poly1.getPolynomialArray();
		int[] poly2Array = poly2.getPolynomialArray();
		int[] result = new int[poly1.degreeOfPolynomial + 1];
		for(int index = 0; index < poly1.degreeOfPolynomial + 1; index++)
		{
			if((poly2.degreeOfPolynomial + 1)>index)
			{
				result[index] = poly1Array[index] + poly2Array[index];
			}
			else
			{
				result[index] = poly1Array[index];
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
		int[] poly1Array = poly1.getPolynomialArray();
		int[] poly2Array = poly2.getPolynomialArray();
		int[] result = new int[poly1.degreeOfPolynomial + poly2.degreeOfPolynomial + 1];
		for(int indexFirst = poly1.degreeOfPolynomial; indexFirst >= 0; indexFirst--) 
		{
			for(int indexSecond = poly2.degreeOfPolynomial; indexSecond >= 0; indexSecond--) 
			{
				result[indexFirst + indexSecond] += poly1Array[indexFirst] * poly2Array[indexSecond];		
			}
		}
		return new Poly(result);
	}
}
