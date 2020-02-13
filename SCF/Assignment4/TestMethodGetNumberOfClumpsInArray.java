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
public class TestMethodGetNumberOfClumpsInArray 
{
	private int[] inputArray;
	private Object expectedOutput;
	static ArrOperation objectOfArrOperationCalss = new ArrOperation();
	
	public TestMethodGetNumberOfClumpsInArray(int[] input, Object expectedOutput)
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
				{new int[] {1, 2, 2, 3, 4, 4}, 2}, 
				{new int[] {1, 1, 2, 1, 1}, 2},
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
			assertEquals(expectedOutput, objectOfArrOperationCalss.getNumberOfClumpsInArray(inputArray));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}
		
}
