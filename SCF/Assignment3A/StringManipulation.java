import java.io.IOException;

/**
 * 
 * @author Nilesh Patel
 * This class designed for provide methods of string manipulation.
 * This class contain stringComparator, getReverse, replaceLowerCaseWithUpperCase and getLargestWord methods.
 */
public class StringManipulation 
{	
	/**
	 * 
	 * @param firstString : first string which we want to compare.
	 * @param secondString : second string which we want to compare.
	 * @fisrtString or @secondString should not be null.
	 * @return 1 if both string are equal else 0. 
	 */
	public int stringComparator(String firstString, String secondString) throws IOException
	{
		/*
		 * Input Validation.
		 */
		if(firstString == null || secondString == null)
		{
			throw new IOException("Invalid input! found Null string ");
		}
		
		if(firstString.length() != secondString.length())
		{
			return 0;
		}
		else
		{
			/*
			 * comparing both strings by one by one character. 
			 */
			for (int charIndex = 0; charIndex < firstString.length(); charIndex++)
			{
				if(firstString.charAt(charIndex) != secondString.charAt(charIndex))
				{
					return 0;
				}
			}
			return 1;
		}
	}
	
	/**
	 * 
	 * @param stringToBeReversed : string we want to reverse.
	 * @return reverse of @stringToBeReversed.
	 * @stringToBeReversed should not be null;
	 */
	public String getReverse(String stringToBeReversed) throws IOException
	{
		/*
		 * Input Validation.
		 */
		if(stringToBeReversed == null)
		{
			throw new IOException("Invalid input! found Null string ");
		}
		
		/**
		 * @reversedString will store reverse string.
		 */
		StringBuilder reversedString = new StringBuilder();
		
		/**
		 * Traverse string form last index to start index.  
		 */
		for (int charIndex = stringToBeReversed.length() - 1; charIndex >= 0; charIndex--) 
		{
			reversedString.append(stringToBeReversed.charAt(charIndex));
		}
		
		/**
		 * making @reversedString immutable.
		 */
		String finalreversedString = reversedString.toString();
		return finalreversedString;
	}
	
	/**
	 * 
	 * @param stringToBeConverted : string we want to convert.
	 * @return string which have all the lower case character converted into upper case and vice-versa.
	 * @stringToBeConverted should not be null;
	 */
	public String getConvertedString(String stringToBeConverted) throws IOException
	{
		/**
		 * Input Validation.
		 */
		if(stringToBeConverted == null)
		{
			throw new IOException("Invalid input! found Null string ");
		}
		
		/**
		 * @upperCaseString will store reversed string.
		 */
		StringBuilder convertedString = new StringBuilder();
		
		/**
		 * using ASCII value of characters to convert lower case to upper case.
		 */
		int asciiValueOfA = 65;
		int asciiValueOfZ = 90;
		int asciiValueOfa = 97;
		int asciiValueOfz = 122;
		int differenceOfAsciiValueofUppercaseAndLowerCase = asciiValueOfa - asciiValueOfA;
		
		for (int charIndex = 0 ; charIndex < stringToBeConverted.length(); charIndex++) 
		{			
			int asciiValueOfCurrentCharacter = (int)stringToBeConverted.charAt(charIndex);
			
			if(asciiValueOfCurrentCharacter >= asciiValueOfA && asciiValueOfCurrentCharacter <= asciiValueOfZ)
			{
				convertedString.append((char)(asciiValueOfCurrentCharacter + differenceOfAsciiValueofUppercaseAndLowerCase));
			}
			else if(asciiValueOfCurrentCharacter >= asciiValueOfa && asciiValueOfCurrentCharacter <= asciiValueOfz)
			{
				convertedString.append((char)(asciiValueOfCurrentCharacter - differenceOfAsciiValueofUppercaseAndLowerCase));
			}
			else
			{
				convertedString.append((char)(asciiValueOfCurrentCharacter));
			}
		}
		
		/**
		 * making @reversedString immutable.
		 */
		String finalConvertedString = convertedString.toString();
		return finalConvertedString;
	}
	
	/**
	 * 
	 * Find largest Word from string.
	 * @param inputString : string in which we find largest word.
	 * @return largest word of string if more than one word have maximum length than return last word.
	 * @inputString should not be null.
	 */
	public String findLargestWord(String inputString) throws IOException
	{
		/**
		 * Input Validation.
		 */
		if(inputString == null)
		{
			throw new IOException("Invalid input! found Null string ");
		}
		
		String largestString = "";
		String currentString = "";
		
		for (int charIndex = 0; charIndex < inputString.length(); charIndex++) 
		{
			char currentChar = inputString.charAt(charIndex);
			if(currentChar == ' ' || currentChar == ',' || currentChar == '.' )
			{
				if(largestString.length() <= currentString.length())
				{
					largestString = currentString;
				}
				currentString = "";
			}
			else
			{
				currentString += currentChar;
			}
		}
		
		return largestString;
	}

}
