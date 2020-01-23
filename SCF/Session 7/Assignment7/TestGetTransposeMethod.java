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
 * This class test getTranspose method of SparseMatrix class;
 */
@RunWith(Parameterized.class)
public class TestGetTransposeMethod
{
	int[][] inputArray1;
	int[][] expectedOutput;
		
	/**
	 * 
	 * Constructor for initialize instance variables.
	 * @param inputArray1
	 * @param expectedOutput
	 */
	public TestGetTransposeMethod(int[][] inputArray1, int[][] expectedOutput ) 
	{
		this.inputArray1 = inputArray1;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testcases()
	{ 
		Object[][] data = new Object[][]
			{
				{new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}},
				{new int[][] {{0, 0, 1},{0, 2, 4},{2, 0, 7}}, new int[][] {{0, 0, 2},{0, 2, 0},{1, 4, 7}}}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		SparseMatrix objectOfSparseMatrixClass = new SparseMatrix(inputArray1);
		assertArrayEquals(expectedOutput, objectOfSparseMatrixClass.getTranspose().sparseToNormalMatrix());
	}

}
