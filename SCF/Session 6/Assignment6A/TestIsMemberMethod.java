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
 * This class test isMember method of IntSet class;
 */

@RunWith(Parameterized.class)
public class TestIsMemberMethod
{
	int inputElement;
	int[] inputArray;
	Object expectedOutput;
	
	/**
	 * 
	 * Constructor for initialize instance variables.
	 * @param inputArray
	 * @param inputElement
	 * @param expectedOutput
	 */
	public TestIsMemberMethod(int[] inputArray, int inputElement, Object expectedOutput ) 
	{
		this.inputArray = inputArray;
		this.inputElement = inputElement;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testcases()
	{ 
		Object[][] data = new Object[][]
			{
				{new int[] {1,2,3,4,5}, 5, true},
				{new int[] {1, 2, 3, 4, 5}, 6, false},
				{new int[] {}, 1, false},
				{new int[] {1,2,3,-1}, 1, "Invalid Inputs! Input should in range of (1 to 1000)"}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		try
		{
			IntSet objectOfInstSetClass = new IntSet(inputArray);
			assertEquals(expectedOutput, objectOfInstSetClass.isMember(inputElement));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}
