import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Nilesh Patel
 * This class test isSubSet method of IntSet class;
 */

@RunWith(Parameterized.class)
public class TestIsSubSetMethod
{
	int[] inputArray1;
	int[] inputArray2;
	Object expectedOutput;
	
	/**
	 * 
	 * Constructor for initialize instance variables.
	 * @param inputArray1
	 * @param inputArray2
	 * @param inputElement
	 * @param expectedOutput
	 */
	public TestIsSubSetMethod(int[] inputArray1, int[] inputArray2, Object expectedOutput ) 
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
				{new int[] {1,2,3,4,5}, new int[] {3, 4, 5}, true},
				{new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 6}, false},
				{new int[] {}, new int[] {1}, false},
				{new int[] {1,2,3,-1}, new int[] {1, 2, 3}, "Invalid Inputs! Input should in range of (1 to 1000)"}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		try
		{
			IntSet objectOfInstSetClass = new IntSet(inputArray1);
			assertEquals(expectedOutput, objectOfInstSetClass.isSubSet(new IntSet(inputArray2)));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}
