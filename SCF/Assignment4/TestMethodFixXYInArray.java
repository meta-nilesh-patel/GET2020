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
 * This class designed for test fixXYInArray method of ArrOperation class.
 */
@RunWith(Parameterized.class)
public class TestMethodFixXYInArray 
{

	private int[] inputArray;
	private int x;
	private int y;
	private int[] expectedOutput;
	static ArrOperation objectOfArrOperationCalss = new ArrOperation();
	
	public TestMethodFixXYInArray(int[] input, int x, int y, int[] expectedOutput)
	{
		this.inputArray = input;
		this.expectedOutput = expectedOutput;
		this.x = x;
		this.y = y;
	}
		
	@Parameters
	public static Collection<Object[]> testCases() 
	{
		Object[][] data = new Object[][] 
			{
				{new int[] {5, 4, 9, 4, 9, 5}, 4, 5, new int[] {9, 4, 5, 4, 5, 9}}, 
				{new int[] {1, 4, 1, 5}, 4, 5, new int[] {1, 4, 5, 1}}, 
				{new int[] {1, 4, 1, 5, 5, 4, 1}, 4, 5, new int[] {1, 4, 5, 1, 1, 4, 5}}
			}; 
		
		return Arrays.asList(data);
	}
	
	@Test
	public void test()
	{
		try
		{
			assertArrayEquals(expectedOutput, objectOfArrOperationCalss.fixXYInArray(inputArray, x, y));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void test2()
	{   
		int[] inputArray = {1, 4, 1, 5, 5, 4, 5, 4};
		objectOfArrOperationCalss.fixXYInArray(inputArray, 4, 5);
	}
	
	@Test(expected = AssertionError.class)
	public void test3()
	{   
		int[] inputArray = {1, 4, 1, 5, 4, 4, 1, 5, 5};
		objectOfArrOperationCalss.fixXYInArray(inputArray, 4, 5);
	}
	
	@Test(expected = AssertionError.class)
	public void test4()
	{   
		int[] inputArray =  {1, 4, 1, 5, 4, 5, 5};
		objectOfArrOperationCalss.fixXYInArray(inputArray, 4, 5);
	}
	
	@Test(expected = AssertionError.class)
	public void test5()
	{   
		int[] inputArray = {1, 1, 1, -1};
		objectOfArrOperationCalss.fixXYInArray(inputArray, 4, 5);
	}
	
	@Test(expected = AssertionError.class)
	public void test6()
	{   
		int[] inputArray = {};
		objectOfArrOperationCalss.fixXYInArray(inputArray, 4, 5);
	}
		
}
