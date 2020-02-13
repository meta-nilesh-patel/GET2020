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
 * This class test addTwoSparseMatrix method of SparseMatrix class;
 */
@RunWith(Parameterized.class)
public class TestAddTwoSparseMatrixMethod
{
	int[][] inputArray1;
	int[][] inputArray2;
	int[][] expectedOutput;
		
	/**
	 * 
	 * Constructor for initialize instance variables.
	 * @param inputArray1
	 * @param expectedOutput
	 */
	public TestAddTwoSparseMatrixMethod(int[][] inputArray1,int[][] inputArray2, int[][] expectedOutput ) 
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
				{
					new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 
					new int[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}},
					new int[][] {{2, 6, 10}, {6, 10, 14}, {10, 14, 18}}
				},
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		SparseMatrix objectOfSparseMatrixClass1 = new SparseMatrix(inputArray1);
		SparseMatrix objectOfSparseMatrixClass2 = new SparseMatrix(inputArray2);
		assertArrayEquals(expectedOutput, SparseMatrix.addTwoSparseMatrix(objectOfSparseMatrixClass1, objectOfSparseMatrixClass2).sparseToNormalMatrix());
	}
	
	@Test
	public void test2()
	{
		inputArray1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; 
		inputArray2 = new int[][] {{1, 4, 7}, {2, 5, 8}};
		String expextedOutput = "Order of both matrix are different";
		try
		{
			SparseMatrix objectOfSparseMatrixClass1 = new SparseMatrix(inputArray1);
			SparseMatrix objectOfSparseMatrixClass2 = new SparseMatrix(inputArray2);
			assertArrayEquals(expectedOutput, SparseMatrix.addTwoSparseMatrix(objectOfSparseMatrixClass1, objectOfSparseMatrixClass2).sparseToNormalMatrix());
		}
		catch(AssertionError ae)
		{
			assertEquals( expextedOutput, ae.getMessage());
		}
	}
}
