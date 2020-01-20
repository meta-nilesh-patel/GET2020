import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

/**
 * 
 * @author Nilesh Patel
 * HexCalc class contain methods for perform arithmetic, logical and conversion operation on Hexadecimal Numbers,
 *         this class implement ArithmeticLogicalOpearion interface which contain respective methods.
 *         		
 */
public class HexCalc implements ArithmeticLogicalOperation 
{
	public static final int base = 16;
	
	/**
	 * 
	 * hexToDecTable store decimal representation of hexa decimal number (ex. A - 10)
	 */
	static HashMap<Character, Integer> hexToDecTable = new HashMap<Character, Integer>();
	
	/**
	 * 
	 * decToHexTable store hexadecimal representation of decimal number (ex. 10 - A)
	 */
	static HashMap<Integer, Character> decToHexTable = new HashMap<Integer, Character>();
		
	/**
	 * 
	 * to initialize hexTables
	 */
	static
	{
		hexToDecTable.put('A', 10);
		hexToDecTable.put('B', 11);
		hexToDecTable.put('C', 12);
		hexToDecTable.put('D', 13);
		hexToDecTable.put('E', 14);
		hexToDecTable.put('F', 15);
		
		decToHexTable.put(10, 'A');
		decToHexTable.put(11, 'B');
		decToHexTable.put(12, 'C');
		decToHexTable.put(13, 'D');
		decToHexTable.put(14, 'E');
		decToHexTable.put(15, 'F');
	}
	
	/**
	 * 
	 * @param operand will be convert to decimal
	 * @return decimal representation of parameter
	 */
	public long hexToDecimal(String operand) throws IOException
	{
		
		//remove initial zeros 
		operand = removeInitialZeros(operand);
		
		/**
		 * 
		 * validating parameter
		 */
		if(!(inputValidation(operand)))
		{
			throw new IOException("Invalid Input!!!");
		}
		
		long decimal = 0;
		int power = 0;
		int asciiOfCharA = 65;
		int asciiOfCharF = 70;
				
		for(int charIndex = operand.length()-1; charIndex >=0; charIndex--)
		{
			
			//@hexChar store character from given index
			char hexChar = operand.charAt(charIndex);
			
			//if  @hexChar contain A-F than taking respective decimal from HashMap @hexToDecTable
			if((int)hexChar >= asciiOfCharA && (int)hexChar <= asciiOfCharF)
			{
				int decimalOfHex = HexCalc.hexToDecTable.get(hexChar).intValue();
				decimal += decimalOfHex*(java.lang.Math.pow(base,power));
				power++;
			}
			else
			{
				decimal += Character.getNumericValue(hexChar)*(java.lang.Math.pow(base,power));
				power++;
			}
		}
		return decimal;
	}
	
	/**
	 * 
	 * @param operand will be convert to hexa decimal
	 * @return hexa decimal representation of parameter
	 */
	public String decimalToHex(String operand)throws IOException
	{
		//remove initial zeros 
		operand = removeInitialZeros(operand);
		
		/**
		 * 
		 * validating parameter
		 */
		if(!(operand.matches("[-0-9]+")))
		{
			throw new IOException("Invalid Input!!!");
		}
		
		/**
		 * 
		 *if @param == 0 return 0
		 */
		if(operand.equals("0"))
		{
			return "0";
		}
		
		int reminder;
		StringBuilder hexString = new StringBuilder();
		long decimal = Long.parseLong(operand);
		
		while(decimal != 0)
		{
			reminder = (int) decimal % base;
			decimal = decimal / base;
			if(reminder>=10 && reminder<=15)
			{
				hexString.append(HexCalc.decToHexTable.get(reminder));
			}
			else
			{
				hexString.append(reminder);
			}
			
		}
		return hexString.reverse().toString();
	}
	
	/**
	 * 
	 * @param firstOperand operand for addition
	 * @param secondOperand operand for addition
	 * @return result of addition of two operand 
	 * @throws IOException if parameter not contain legal value
	 */
	public String addOperation(String firstOperand , String secondOperand) throws IOException
	{
		
		/**
		 * 
		 * validating parameter
		 */
		if(!(inputValidation(firstOperand) && inputValidation(secondOperand)))
		{
			throw new IOException("Invalid Input!!!");
		}
		long firstOperandDecimal = hexToDecimal(firstOperand);
		long secondOperandDecimal = hexToDecimal(secondOperand);
		long additionResult = firstOperandDecimal+secondOperandDecimal;
		return decimalToHex(Long.toString(additionResult));
	}
	
	/**
	 * 
	 * @param firstOperand operand for subtraction
	 * @param secondOperand operand for subtraction
	 * @return result of subtraction of two operand
	 * @throws IOException if parameter not contain legal value 
	 */
	public String subtractOperation(String firstOperand , String secondOperand) throws IOException
	{
		/**
		 * 
		 * validating parameter
		 */
		if(!(inputValidation(firstOperand) && inputValidation(secondOperand)))
		{
			throw new IOException("Invalid Input!!!");
		}
		if(lessThanOperation(firstOperand, secondOperand))
		{
			throw new IOException("Invalid Input First Number Should Not Be Smaller");
		}
		long firstOperandDecimal = hexToDecimal(firstOperand);
		long secondOperandDecimal = hexToDecimal(secondOperand);
		long subResult = firstOperandDecimal - secondOperandDecimal;
		return decimalToHex(Long.toString(subResult));
	}
	
	/**
	 * 
	 * @param firstOperand operand for multiplication
	 * @param secondOperand operand for multiplication
	 * @return result of multiplication of two operand
	 * @throws IOException if parameter not contain legal value 
	 */
	public String multiplicationOperation(String firstOperand , String secondOperand) throws IOException
	{
		/**
		 * 
		 * validating parameter
		 */
		if(!(inputValidation(firstOperand) && inputValidation(secondOperand)))
		{
			throw new IOException("Invalid Input!!!");
		}
		long firstOperandDecimal = hexToDecimal(firstOperand);
		long secondOperandDecimal = hexToDecimal(secondOperand);
		long mulResult = firstOperandDecimal * secondOperandDecimal;
		return decimalToHex(Long.toString(mulResult));
	}
	
	/**
	 * 
	 * @param firstOperand operand for division
	 * @param secondOperand operand for division
	 * @return result of division of two operand
	 * @throws IOException if parameter not contain legal value
	 */
	public String divisonOperation(String firstOperand , String secondOperand) throws ArithmeticException, IOException
	{
		
		/**
		 * 
		 * validating parameter
		 */
		if(!(inputValidation(firstOperand) && inputValidation(secondOperand)))
		{
			throw new IOException("Invalid Input!!!");
		}
		
		/**
		 * 
		 * validating if parameter contain 0 value
		 */
		if(secondOperand.equals("0"))
		{
			throw new ArithmeticException("Divide by zero");
		}
		
		long firstOperandDecimal = hexToDecimal(firstOperand);
		long secondOperandDecimal = hexToDecimal(secondOperand);
		long divResult = firstOperandDecimal / secondOperandDecimal;
		return decimalToHex(Long.toString(divResult));
		
	}
		
	/**
	 * 
	 * @param firstOperand operand for equal operation
	 * @param secondOperand operand for equal operation
	 * @return boolean containing true if equal or false 
	 * @throws IOException if parameter not contain legal value 
	 * 
	 */
	public boolean equalsOperation(String firstOperand, String secondOperand) throws IOException
	{
		/**
		 * 
		 * validating parameter
		 */
		if(!(inputValidation(firstOperand) && inputValidation(secondOperand)))
		{
			throw new IOException("Invalid Input!!!");
		}
		
		//remove initial zeros 
		firstOperand = removeInitialZeros(firstOperand);
		secondOperand = removeInitialZeros(secondOperand);
		
		//first checking if length is equal
		if(firstOperand.length() == secondOperand.length())
		{
			
			//if length equal than comparing each character 
			for(int charIndex = 0; charIndex < firstOperand.length(); charIndex++)
			{
				char firstOperandExtractedChar = firstOperand.charAt(charIndex);
				char secondOperandExtractedChar = secondOperand.charAt(charIndex);
				
				//taking numeric value of character and comparing them 
				if(Character.getNumericValue(firstOperandExtractedChar)!=Character.getNumericValue(secondOperandExtractedChar))
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * Assuming firstOperand is greater 
	 * @param firstOperand operand for greater than operation
	 * @param secondOperand operand for greater than operation
	 * @return true if firstOperand is greater
	 * @throws IOException if parameter not contain legal value 
	 */
	public boolean greaterThanOperation(String firstOperand, String secondOperand) throws IOException
	{
		/**
		 * 
		 * validating parameter
		 */
		if(!(inputValidation(firstOperand) && inputValidation(secondOperand)))
		{
			throw new IOException("Invalid Input!!!");
		}
		//remove initial zeros 
		firstOperand = removeInitialZeros(firstOperand);
		secondOperand = removeInitialZeros(secondOperand);
		
		//first checking if length is equal
		if(firstOperand.length() > secondOperand.length())
		{
			return true;
		}
		
		if(firstOperand.length() == secondOperand.length())
		{

			//if length equal than comparing each character 
			for(int charIndex=0; charIndex < firstOperand.length(); charIndex++)
			{
				char firstOperandExtractedChar = firstOperand.charAt(charIndex);
				char secondOperandExtractedChar = secondOperand.charAt(charIndex);
				//taking numeric value of character and comparing them 
				if(Character.getNumericValue(firstOperandExtractedChar)>Character.getNumericValue(secondOperandExtractedChar))
				{
					return true;
				}
			}
			return false;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * assuming first operand is lesser
	 * @param firstOperand operand for less than operation
	 * @param secondOperand operand for less than operation
	 * @return true if firstOperand is lesser
	 * @throws IOException if parameter not contain legal value
	 */
	public boolean lessThanOperation(String firstOperand, String secondOperand) throws IOException
	{
		/**
		 * validating parameter
		 */
		if(!(inputValidation(firstOperand) && inputValidation(secondOperand)))
		{
			throw new IOException("Invalid Input!!!");
		}
		//remove initial zeros 
		firstOperand = removeInitialZeros(firstOperand);
		secondOperand = removeInitialZeros(secondOperand);
		//first checking if length is equal
		if(firstOperand.length()<secondOperand.length())
		{
			return true;
		}

		if(firstOperand.length()==secondOperand.length())
		{

			//if length equal than comparing each character 
			for(int charIndex = 0; charIndex < firstOperand.length(); charIndex++)
			{
				char firstOperandExtractedChar = firstOperand.charAt(charIndex);
				char secondOperandExtractedChar = secondOperand.charAt(charIndex);
				//taking numeric value of character and comparing them 
				if(Character.getNumericValue(firstOperandExtractedChar) < Character.getNumericValue(secondOperandExtractedChar))
				{
					return true;
				}
			}
			return false;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param operand it contain hexa decimal string that need to validate
	 * @return return true if operand contain legal hexa decimal or false
	 */
	public boolean inputValidation(String operand)
	{
		//for HexaDecimal 
		if(operand.matches("[0-9A-F]+"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * 
	 * Method to remove initial useless zeros from the paramater
	 * @param Number of any base in String type
	 * @return Number after removing Zeros
	 */
	public String removeInitialZeros(String firstOperand)
	{
		/**
		 * Loop extracts character at all Index numbers of the number and thus checks for the presence of zeros
		 *	if found then trims the stringleaves the number as it as when there is only one character in it 
		 *	and that too is 0 Raises the flag when all the zeros are ended to avoid further checking
		 */
		String updatedOperand = firstOperand;
		for(int indexNumber = 0; indexNumber < firstOperand.length(); indexNumber++)
		{
			char ch1 = firstOperand.charAt(indexNumber);
			if((ch1 == '0') && (indexNumber != (firstOperand.length() - 1)))
			{
				updatedOperand = firstOperand.substring(indexNumber + 1);
			}
			else
			{
				break;
			}
		}
		return updatedOperand;
	}
}
