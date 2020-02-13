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
 * This class test multiplyTwoMatrix method of SparseMatrix class;
 */
@RunWith(Parameterized.class)
public class TestMultiplyTwoSparseMatrixMethod
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
	public TestMultiplyTwoSparseMatrixMethod(int[][] inputArray1,int[][] inputArray2, int[][] expectedOutput ) 
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
					new int[][] {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}}, 
					new int[][] {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}},
					new int[][] {{10, 10, 10, 10}, {20, 20, 20, 20}, {30, 30, 30,30}, {40, 40, 40, 40}}
				},
				{
					new int[][] {{1, 0, 1}, {0, 1, 0}, {1, 0, 0}},
					new int[][] {{1, 0, 0}, {0, 0, 1}, {0, 1, 0}},
					new int[][] {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}}
				}
			};
		return Arrays.asList(data);		
	}

	@Test
	public void test() 
	{
		SparseMatrix objectOfSparseMatrixClass1 = new SparseMatrix(inputArray1);
		SparseMatrix objectOfSparseMatrixClass2 = new SparseMatrix(inputArray2);
		assertArrayEquals(expectedOutput, SparseMatrix.multiplyTwoSparseMatrix(objectOfSparseMatrixClass1, objectOfSparseMatrixClass2).sparseToNormalMatrix());
	}
	
	@Test
	public void test2()
	{
		inputArray1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; 
		inputArray2 = new int[][] {{1, 4}, {2, 5}};
		String expextedOutput = "Multiplication not possible due to first matrix's row not equal tow column of second matrix!!";
		try
		{
			SparseMatrix objectOfSparseMatrixClass1 = new SparseMatrix(inputArray1);
			SparseMatrix objectOfSparseMatrixClass2 = new SparseMatrix(inputArray2);
			assertArrayEquals(expectedOutput, SparseMatrix.multiplyTwoSparseMatrix(objectOfSparseMatrixClass1, objectOfSparseMatrixClass2).sparseToNormalMatrix());
		}
		catch(AssertionError ae)
		{
			assertEquals( expextedOutput, ae.getMessage());
		}
	}
}
