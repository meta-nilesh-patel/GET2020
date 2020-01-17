import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Nilesh Patel
 * This class designed for test getNumberOfClumpsInArray method of ArrOperation class.
 */
@RunWith(Parameterized.class)
public class TestMethodGetSizeOfLargestMirrorSectionSizeInArray 
{

	private int[] inputArray;
	private Object expectedOutput;
	static ArrOperation objectOfArrOperationCalss = new ArrOperation();
	
	public TestMethodGetSizeOfLargestMirrorSectionSizeInArray(int[] input, Object expectedOutput)
	{
			this.inputArray = input;
			this.expectedOutput = expectedOutput;
	}
		
	@Parameters
	public static Collection<Object[]> testCases() 
	{
		Object[][] data = new Object[][] 
			{
				{new int[] {1, 2, 3, 8, 9, 3, 2, 1}, 3}, 
				{new int[] {7, 1, 4, 9, 7, 4, 1}, 2}, 
				{new int[] {1, 2, 1, 4}, 3},
				{new int[] {1, 4, 5, 3, 5, 4, 1}, 7},
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
			assertEquals(expectedOutput, objectOfArrOperationCalss.getSizeOfLargestMirrorSectionSizeInArray(inputArray));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}
		
}
