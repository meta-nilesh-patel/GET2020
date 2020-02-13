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
 * This class test the evaluate method of Poly class. 
 */
@RunWith(Parameterized.class)
public class TestEvaluateMethod 
{
	private int[] inputPolynomial;
	private float valueOfVariable;
	private Object expectedOutput;
	
	/**
	 * 
	 * Constructor for initialize the instance variable.
	 * @param inputArray
	 * @param valueOfVariable
	 * @param expectedOutput
	 */
	public TestEvaluateMethod(int[] inputArray, float valueOfVariable, Object expectedOutput ) 
	{
		this.inputPolynomial = inputArray;
		this.valueOfVariable = valueOfVariable;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testcases()
	{ 
		Object[][] data = new Object[][]
			{
				{new int[] {1, 2, 0, 4, 5}, 1.5f , 42.8125f},
				{new int[] {0, 2, 3, 4, 5}, 100.5f, 514166053.0f },
				{new int[] {3, 2, 3, 4, 5}, 0.0f, 3.0f},
				{new int[] {}, 1.5f, "Null Polynomial Not Allowed"},
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		try
		{
			Poly objectOfPolyClass = new Poly(this.inputPolynomial);
			assertEquals(expectedOutput, objectOfPolyClass.evaluate(valueOfVariable));
		}
		catch(Exception e)
		{
			assertEquals(expectedOutput, e.getMessage());
		}
	}

}
