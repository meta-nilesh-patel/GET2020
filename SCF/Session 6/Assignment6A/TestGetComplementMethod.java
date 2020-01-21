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
 * This class test getComplement method of IntSet class;
 */

@RunWith(Parameterized.class)
public class TestGetComplementMethod
{
	int[] inputArray1;
	Object expectedOutput;
	
	/**
	 * 
	 * Constructor for initialize instance variables.
	 * @param inputArray1
	 * @param inputArray2
	 * @param inputElement
	 * @param expectedOutput
	 */
	public TestGetComplementMethod(int[] inputArray1, Object expectedOutput ) 
	{
		this.inputArray1 = inputArray1;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testcases()
	{ 
		Object[][] data = new Object[][]
			{
				{new int[] {1,2,3,4,5}, false},
				{new int[] {}, true},
				{new int[] {1,2,3,-1}, "Invalid Inputs! Input should in range of (1 to 1000)"}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		try
		{
			IntSet objectOfInstSetClass = new IntSet(inputArray1);
			IntSet complementSet = objectOfInstSetClass.getComplement();
			//will get false for elements of input array.
			for (int index = 0; index < inputArray1.length; index++) {
				assertEquals(expectedOutput, complementSet.isMember(inputArray1[index]));
			}
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}
