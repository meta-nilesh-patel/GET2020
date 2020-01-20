import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Nilesh Patel
 * This class designed to test method getHCF and getLCM methods.
 */
@RunWith(Parameterized.class)
public class TestMethodGetLCM 
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
	public TestMethodGetLCM(int firstNumber, int secondNumber, Object expectedOutput) 
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
				//cases for calculate LCM.
				{1, 9, 9},
				{9, 9, 9},
				{6, 8, 24},
				{0, 7, "found invalid input!!, Both input should greater than 0."},
				{1,-7,"found invalid input!!, Both input should greater than 0."}
			};
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		try
		{
			assertEquals(expectedOutput, objectOfLcmHcfClass.getLCM(firstNumber, secondNumber));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}
