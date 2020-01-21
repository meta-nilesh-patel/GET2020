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
 * This class test union method of IntSet class;
 */

@RunWith(Parameterized.class)
public class TestUnionMethod
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
	public TestUnionMethod(int[] inputArray1, int[] inputArray2, int[] expectedOutput ) 
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
				{new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5}, new int[] {1, 2, 3, 4, 5}},
				{new int[] {1, 2, 3, 4, 5}, new int[] {7, 8, 9, 6},new int[] {1, 2, 3, 4, 5, 7, 8, 9, 6}},
				{new int[] {}, new int[] {1}, new int[] {1}}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		try
		{
			IntSet objectOfInstSetClass1 = new IntSet(inputArray1);
			IntSet objectOfInstSetClass2 = new IntSet(inputArray2);
			int[] actualOutput = IntSet.union(objectOfInstSetClass1, objectOfInstSetClass2).getItems();
			for (int index = 0; index < expectedOutput.length; index++)
			{
				assertEquals(expectedOutput[index], actualOutput[index]);
			}
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}
	
	@Test
	public void test2()
	{	try
		{
			IntSet objectOfInstSetClass1 = new IntSet(new int[]{1,2,3,-1});
			IntSet objectOfInstSetClass2 = new IntSet(new int[]{4, 5, 6});
			int[] actualOutput = IntSet.union(objectOfInstSetClass1, objectOfInstSetClass2).getItems();
		}
		catch(AssertionError ae)
		{
			assertEquals("Invalid Inputs! Input should in range of (1 to 1000)", ae.getMessage());
		}
	}
	

}
