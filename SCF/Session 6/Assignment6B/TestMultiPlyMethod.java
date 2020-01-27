import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Nilesh Patel
 * This class test multiplyPoly method of Poly class;
 */
@RunWith(Parameterized.class)
public class TestMultiPlyMethod
{
	int[] inputArray1;
	int[] inputArray2;
	int[] expectedOutput;
	
	/**
	 * 
	 * Constructor for initialize instance variables.
	 * @param inputArray1
	 * @param inputArray2
	 * @param inputElement
	 * @param expectedOutput
	 */
	public TestMultiPlyMethod(int[] inputArray1, int[] inputArray2, int[] expectedOutput ) 
	{
		this.inputArray1 = inputArray1;
		this.inputArray2 = inputArray2;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testcases()
	{ 
		Object[][] data = new Object[][]
			{	
				{new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5}, new int[] {3, 10, 22, 34, 46, 40, 25}},
				{new int[] {1, 2}, new int[] {-7, 8, 9},new int[] {-7, -6, 25, 18}}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		try
		{
			Poly objectOfPolyClass1 = new Poly(inputArray1);
			Poly objectOfPolyClass2 = new Poly(inputArray2);
			int[] actualOutput = Poly.multiplyPoly(objectOfPolyClass1, objectOfPolyClass2).getPolynomialArray();
			assertArrayEquals(expectedOutput, actualOutput);
		}
		catch(Exception e)
		{
			assertEquals("Null Polynomial Not Allowed", e.getMessage());
		}
	}
	
	@Test
	public void test2()
	{	try
		{
			Poly objectOfPolyClass1 = new Poly(new int[]{});
			Poly objectOfPolyClass2 = new Poly(new int[]{4, 5, 6});
			int[] actualOutput = Poly.multiplyPoly(objectOfPolyClass1, objectOfPolyClass2).getPolynomialArray();
		}
		catch(Exception e)
		{
			assertEquals("Null Polynomial Not Allowed", e.getMessage());
		}
	}
}
