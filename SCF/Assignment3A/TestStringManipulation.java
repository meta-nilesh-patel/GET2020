import java.io.IOException;
import java.util.*;

/**
 * 
 * @author Nilesh Patel
 * This Class used as a input class for String Manipulation Class
 * It provide user option and get the result from StringManipulation Class
 * respective methods and print them on console
 */
public class TestStringManipulation 
{
	public static void main(String[] args) 
	{	
		StringManipulation stringManipulation = new StringManipulation();
		Scanner userInput = new Scanner(System.in);

		//while loop for options
		do
		{
			System.out.println("1.Compare Two Strings");
			System.out.println("2.Reverse Of A String");
			System.out.println("3.Convert Upper Case To Lower And Vice-Versa");
			System.out.println("4.Get The Largest Word");
			System.out.println("5.Exit");

			//taking input for selecting option
			int userChoice = userInput.nextInt();
			userInput.nextLine();
			
			//while loop closing condition
			if (userChoice == 5) 
			{
				System.out.println("Thank You");
				System.exit(0);
			}
			
			switch (userChoice) 
			{
			//for comparing two strings
			case (1): 
			{	
				System.out.print("Enter First String :- ");
				String firstString = userInput.nextLine();
				System.out.print("Enter Second String :- ");
				String secondString = userInput.nextLine();
				try
				{
				int compareResult = stringManipulation.stringComparator(firstString, secondString);
				
				if(compareResult == 1){
					System.out.println(firstString+" and "+secondString+" are equal");
				}else{
					System.out.println(firstString+" and "+secondString+" are not equal");
				}
				}
				catch(IOException io)
				{
					System.out.println(io);
				}
				break;
			}
			
			//for getting reverse of a string
			case (2): 
			{
				System.out.print("Enter String :- ");
				String firstString = userInput.nextLine();
				try
				{
				String reverseString = stringManipulation.getReverse(firstString);
				System.out.println("Reverse of "+firstString+" is "+reverseString);
				}
				catch(IOException io)
				{
					System.out.println(io);
				}
				break;
			}
			
			//converting upper case character to lower case and vice-versa
			case (3): 
			{
				
				System.out.print("Enter String :- ");
				String firstString = userInput.nextLine();
				try
				{
					String convertedString = stringManipulation.getConvertedString(firstString);
					System.out.println(firstString+" after conversion "+ convertedString);
				}
				catch(IOException io)
				{
					System.out.println(io);
				}
				break;
			}
			
			//getting longest word in a string
			case (4): 
			{
				System.out.print("Enter String :- ");
				String firstString = userInput.nextLine();
				try
				{
				String longestWord = stringManipulation.findLargestWord(firstString);
				System.out.println("Longest word is "+longestWord);
				}
				catch(IOException io)
				{
					System.out.println(io);
				}
				break;
			}
			
			default: 
			{
				System.out.println("Invalid Choice!!!");
			}
			}
		}while(true);
	}
}
