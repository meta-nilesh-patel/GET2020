/**
 * 
 * @author Nilesh Patel
 * This class is implemented Euclid algorithm for compute LCM and HCF of two numbers.
 */
public class LcmHcf
{
	/**
	 * 
	 * This method will compute HCF of two given numbers.
	 * @param firstNumber : first number for compute HCF and it should be greater than zero.
	 * @param secondNumber : second number for compute HCF and it should be greater than zero.
	 * @return HCF of firstNumber and secondNumber.
	 */
	public int getHCF(int firstNumber, int secondNumber) throws AssertionError
	{
		if(firstNumber < 1 || secondNumber < 1)
		{
			throw new AssertionError("found invalid input!!, Both input should greater than 0.");
		}
		
		int remainder;
		if(firstNumber > secondNumber)
		{
			remainder = firstNumber % secondNumber;
			if(remainder == 0)
			{
				return secondNumber;
			}
			else
			{
				return getHCF(remainder, secondNumber);
			}
		}
		else
		{
			remainder = secondNumber % firstNumber;
			if(remainder == 0)
			{
				return firstNumber;
			}
			else
			{
				return getHCF(firstNumber, remainder);
			}
			
		}
	}
	
	/**
	 * 
	 * This method will compute LCM of two given numbers.
	 * @param firstNumber : first number for compute LCM and it should be greater than zero.
	 * @param secondNumber : second number for compute LCM and it should be greater than zero.
	 * @return LCM of firstNumber and secondNumber.
	 */
	public int getLCM(int firstNumber, int secondNumber)
	{
		if(firstNumber < 1 || secondNumber < 1)
		{
			throw new AssertionError("found invalid input!!, Both input should greater than 0.");
		}
		int lcm = 0;
		return helperGetLCM(firstNumber, secondNumber, lcm);
	}
	
	/**
	 * 
	 * Utility method for getLCM.
	 * @param firstNumber : first number for compute LCM and it should be greater than zero.
	 * @param secondNumber : second number for compute LCM and it should be greater than zero.
	 * @param lcm : initially lcm will be 0;
	 * @return LCM of first number and second number.
	 */
	public int helperGetLCM(int firstNumber, int secondNumber, int lcm)
	{
		lcm += secondNumber;
		
		if(lcm % firstNumber == 0)
		{
			return lcm;
		}
		return helperGetLCM(firstNumber, secondNumber, lcm);		
	}
}

