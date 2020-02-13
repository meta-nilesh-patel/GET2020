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
 * This class test the degree method of Poly class. 
 */
@RunWith(Parameterized.class)
public class TestDegreeMethod 
{
	private int[] inputPolynomial;
	private Object expectedOutput;
	
	/**
	 * 
	 * Constructor for initialize the instance variable.
	 * @param inputArray
	 * @param valueOfVariable
	 * @param expectedOutput
	 */
	public TestDegreeMethod(int[] inputArray, Object expectedOutput ) 
	{
		this.inputPolynomial = inputArray;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testcases()
	{ 
		Object[][] data = new Object[][]
			{
				{new int[] {1, 2, 0, 4, 5}, 4},
				{new int[] {1}, 0},
				{new int[] {0, 0, 0, 0, 5}, 4},
				{new int[] {}, "Null Polynomial Not Allowed"}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		try
		{
			Poly objectOfPolyClass = new Poly(this.inputPolynomial);
			assertEquals(expectedOutput, objectOfPolyClass.degree());
		}
		catch(Exception e)
		{
			assertEquals(expectedOutput, e.getMessage());
		}
	}

}
