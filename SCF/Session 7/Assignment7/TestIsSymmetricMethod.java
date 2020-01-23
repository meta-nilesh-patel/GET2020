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
 * This class test isSymmetric method of SparseMatrix class;
 */
@RunWith(Parameterized.class)
public class TestIsSymmetricMethod
{
	int[][] inputArray1;
	Object expectedOutput;
		
	/**
	 * 
	 * Constructor for initialize instance variables.
	 * @param inputArray1
	 * @param expectedOutput
	 */
	public TestIsSymmetricMethod(int[][] inputArray1, Object expectedOutput ) 
	{
		this.inputArray1 = inputArray1;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testcases()
	{ 
		Object[][] data = new Object[][]
			{
				{new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, false},
				{new int[][] {{0, 0, 1},{0, 2, 0},{1, 0, 0}}, true},
				{new int[][] {{0, 0, 1}, {1, 0, 0}}, "It is not a square matrix!!"}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		try
		{
			SparseMatrix objectOfSparseMatrixClass = new SparseMatrix(inputArray1);
			assertEquals(expectedOutput, objectOfSparseMatrixClass.isSymmetric());
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}	
}
