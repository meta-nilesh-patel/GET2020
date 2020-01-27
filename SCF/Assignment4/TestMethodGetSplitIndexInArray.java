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
 * This class designed for test getNumberOfClumpsInArray method of ArrOperation class.
 */
@RunWith(Parameterized.class)
public class TestMethodGetSplitIndexInArray 
{
	private int[] inputArray;
	private Object expectedOutput;
	static ArrOperation objectOfArrOperationCalss = new ArrOperation();
	
	public TestMethodGetSplitIndexInArray(int[] input, Object expectedOutput)
	{
		this.inputArray = input;
		this.expectedOutput = expectedOutput;
	}
		
	@Parameters
	public static Collection<Object[]> testCases() 
	{
		Object[][] data = new Object[][] 
			{
				{new int[] {11, 11}, 1}, 
				{new int[] {2, 2, 2, 4, 2}, 3}, 
				{new int[] {1, 1, 2, 1, 1}, -1},
				{new int[] {1, 1, 1, -1}, "Array contain negative integer"},
				{new int[] {}, "Null Array"}
			}; 
		
		return Arrays.asList(data);
	}
	
	@Test
	public void test()
	{
		try
		{
			assertEquals(expectedOutput, objectOfArrOperationCalss.getSplitIndexInArray(inputArray));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}
		
}
