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
 * This class designed to test method getHCF method.
 */
@RunWith(Parameterized.class)
public class TestGetHCfMethod 
{
	private int firstNumber;
	private int secondNumber;
	private Object expectedOutput;
	static LcmHcf objectOfLcmHcfClass = new LcmHcf();
	
	/**
	 * 
	 * Constructor for initialize object with firstNumber, secondNumber and expectedOutput.
	 * @param firstNumber : firstNumber for perform operations.
	 * @param secondNumber : secondNumber for perform operations.
	 * @param expectedOutput : expected result of method.
	 */
	public TestGetHCfMethod(int firstNumber, int secondNumber, Object expectedOutput) 
	{
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases()
	{
		Object[][] data = new Object[][]
			{
				//cases for calculate HCF.
				{1, 2, 1},
				{7, 7, 7},
				{7, 9, 1},
				{0, 7, "found invalid input!!, Both input should greater than 0."},
				{1, -7, "found invalid input!!, Both input should greater than 0."}
			};
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		try
		{
			assertEquals(expectedOutput, objectOfLcmHcfClass.getHCF(firstNumber, secondNumber));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}
