import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Nilesh Patel
 * This class test linearSearch method of Searching class.
 */
@RunWith(Parameterized.class)
public class TestLinearSearch 
{
	private int[] inputArray;
	private int elementToBeSearched;
	private int startIndex;
	private Object expectedOutput;
	static Searching objectOfSearchingClass = new Searching();
	
	/**
	 * 
	 * Constructor for initialize object with inputArray, elementToBeSearched and startIndex and expectedOutput.
	 * @param inputArray : array in which we want to search.
	 * @param elementToBeSearched : element which we want to search.
	 * @param startIndex : starting index for searching.
	 * @param expectedOutput : expected result of searching.
	 */
    public TestLinearSearch(int[] inputArray, int elementToBeSearched, int startIndex, Object expectedOutput) 
	{
		this.inputArray = inputArray;
		this.elementToBeSearched = elementToBeSearched;
		this.startIndex = startIndex;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases()
	{
		Object[][] data = new Object[][]
			{
				{new int[] {1, 2, 3, 4, 5, 6, 7}, 4, 0, 3},
				{new int[] {1, 2, 3, 4, 5, 6, 7}, 1, 0, 0},
				{new int[] {1, 2, 3, 4, 5, 6, 7}, 7, 0, 6},
				{new int[] {1, 2, 3, 4, 5, 6, 7}, 0, 0, -1},				
				{new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 4, 0, 3},
				{new int[] {}, 1, 0, "Null array found!"}
			};
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		try
		{
			assertEquals(expectedOutput, objectOfSearchingClass.linearSearch(inputArray, elementToBeSearched, startIndex));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}
