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
 * This class design for test the method of NQueen solve.
 */
@RunWith(Parameterized.class)
public class NQueenProblemTest 
{
	private int noOfQueens;
	private int[][] board;
	Object expectedOutput;
	static NQueenProblem objectOfNQueenClass = new NQueenProblem();
	
	public NQueenProblemTest(int noOfQueens, Object expectedOutput)
	{
		this.noOfQueens = noOfQueens;
		this.board = new int[noOfQueens][noOfQueens];
		
		/**
		 * Initializing board with all 0 values.
		 */
		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) 
		{
			for (int columnIndex = 0; columnIndex < board.length; columnIndex++) 
			{
				board[rowIndex][columnIndex] = 0;
			}
		}
		
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testcases()
	{ 
		Object[][] data = new Object[][]
			{
				{1, true},
				{2, false},
				{3, false},
				{4, true},
				{0, "No of Queens should be positive!"}
			};
		return Arrays.asList(data);		
	}
	
	@Test
	public void test() 
	{
		try
		{
			assertEquals(expectedOutput, objectOfNQueenClass.solveNQueen(board, 0, noOfQueens) );
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}
