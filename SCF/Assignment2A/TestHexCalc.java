import java.io.IOException;
import java.util.Scanner;
import java.lang.*;

/**
 * 
 * @author Nilesh Patel
 * This class interact with user and provide option to perform operation on hexa decimal number.
 * 
 */
public class TestHexCalc 
{

	public static void main(String[] args) 
	{
		HexCalc hexaDecimal = new HexCalc();
		String firstOperand;
		String secondOperand;
		
		//for taking user input from keyboard
		Scanner userInput = new Scanner(System.in);
		
		while(true)
		{
		       System.out.println("Please Select choice!");
		       System.out.println("Enter 1 for HexaDecimal Addition");
		       System.out.println("Enter 2 for HexaDecimal Subtraction");
		       System.out.println("Enter 3 for HexaDecimal Division");
		       System.out.println("Enter 4 for HexaDecimal Multiplication");
		       System.out.println("Enter 5 for HexaDecimal Equal Opration");
		       System.out.println("Enter 6 for HexaDecimal GreaterThan Operation");
		       System.out.println("Enter 7 for HexaDecimal LessThan Operation");
		       System.out.println("Enter 8 for convert HexaDecimal to Decimal");
		       System.out.println("Enter 9 for convert Decimal to HexaDecimal");
		       System.out.println("Enter 10 for Exit");
		
		       //this variable store user choice
		       int choice = userInput.nextInt();
		       
		       //this terminate program
		       if(choice == 10)
		       {
		    	   System.out.println("Thank You");
		    	   System.exit(0);
		       }
		       
		       //for calling respective methods
		       switch(choice)
		       {
		       
			       case(1):
			       {
			    	   System.out.print("Please Enter First HexaDecimal Number:");
			    	   firstOperand = userInput.next().toUpperCase();
			    	   System.out.print("Please Enter Second HexaDecimal Number:");
			    	   secondOperand = userInput.next().toUpperCase();
			    	   
			    	   try
			    	   {
			    		   
			    		   /**
			    		    * 
				    	    * @addResult store addition of two hexaDecimal numbers
				    	    */
			    		   String addResult = hexaDecimal.addOperation(firstOperand, secondOperand);
			    		   
			    		   /**
			    		    * 
				    	    * Printing result of addition
				    	    */
			    		   System.out.println(firstOperand+" + " + secondOperand + " = " + addResult);
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);			    	   
			    	   break;
			           }
			       }   
			    	   
			       case(2):
			       {
			    	   System.out.print("Please Enter First HexaDecimal Number:");
			    	   firstOperand = userInput.next().toUpperCase();
			    	   System.out.print("Please Enter Second HexaDecimal Number:");
			    	   secondOperand = userInput.next().toUpperCase();
			    	   
			    	   try
			    	   {
			    		   /**
			    		    * 
				    	    * @subResult store subtraction of two hexaDecimal numbers
				    	    */
				    	   String subResult = hexaDecimal.subtractOperation(firstOperand, secondOperand);
				    	   
				    	   /**
				    	    * 
				    	    * Printing result of subtraction
				    	    */
				    	   System.out.println(firstOperand+" - " + secondOperand + " = "+subResult);
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);
			    	   }
			    	   break;
			       }
			       
			       case(3):
			       {
			    	   System.out.print("Please Enter First HexaDecimal Number:");
			    	   firstOperand = userInput.next().toUpperCase();
			    	   System.out.print("Please Enter Second HexaDecimal Number:");
			    	   secondOperand = userInput.next().toUpperCase();
			    	   
			    	   try
			    	   {
			    		   /**
			    		    * 
				    	    * @divResult store division of two hexaDecimal numbers
				    	    */
				    	   String divResult = hexaDecimal.divisonOperation(firstOperand, secondOperand);
				    	   
				    	   /**
				    	    * 
				    	    * Printing result of division
				    	    */
				    	   System.out.println(firstOperand+" / " + secondOperand + " = " + divResult);
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);
			    	   }
			    	   catch(ArithmeticException ae)
			    	   {
			    		   System.out.println(ae);
			    	   }
			    	   break;
			       }
			       
			       case(4):
			       {
			    	   System.out.print("Please Enter First HexaDecimal Number:");
			    	   firstOperand = userInput.next().toUpperCase();
			    	   System.out.print("Please Enter Second HexaDecimal Number:");
			    	   secondOperand = userInput.next().toUpperCase();
			    	     
			    	   try
			    	   {
			    		   /**
			    		    * 
				    	    * @mulResult store multiplication of two hexaDecimal numbers
				    	    */
				    	   String mulResult = hexaDecimal.multiplicationOperation(firstOperand,secondOperand);
				    	   
				    	   /**
				    	    * 
				    	    * Printing result of multiplication
				    	    */
				    	   System.out.println(firstOperand+" * "+secondOperand+" = "+mulResult);
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);
			    	   }
			    	   break;
			       }
			       
			       case(5):
			       { 
			    	   System.out.print("Please Enter First HexaDecimal Number:");
			    	   firstOperand = userInput.next().toUpperCase();
			    	   System.out.print("Please Enter Second HexaDecimal Number:");
			    	   secondOperand = userInput.next().toUpperCase();
			    	   
			    	   try
			    	   {
			    		   /**
			    		    * 
				    	    * @eqResult store result of equal operation on two hexaDecimal numbers
				    	    */
				    	   boolean isEqual = hexaDecimal.equalsOperation(firstOperand, secondOperand);
				    	   
				    	   /**
				    	    * 
				    	    * Printing result of equal operation
				    	    */
				    	   if(isEqual)
				    	   {
				    		   System.out.println(firstOperand+" == "+secondOperand);
				    	   }
				    	   else
				    	   {
				    		   System.out.println(firstOperand+" != "+secondOperand);
				    	   }
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);
			    	   }
			    	   
			    	   
			    	   break;
			       }
			       
			       case(6):
			       {
			    	   System.out.print("Please Enter First HexaDecimal Number:");
			    	   firstOperand = userInput.next().toUpperCase();
			    	   System.out.print("Please Enter Second HexaDecimal Number:");
			    	   secondOperand = userInput.next().toUpperCase();
			    	   
			    	   try
			    	   {
			    		   /**
			    		    * 
				    	    * @geResult store result of greater than operation on two hexaDecimal numbers
				    	    */
				    	   boolean isGreater = hexaDecimal.greaterThanOperation(firstOperand,secondOperand);
				    	   
				    	   /**
				    	    * 
				    	    * Printing result of greater than operation
				    	    */
				    	   if(isGreater)
				    	   {
				    		   System.out.println(firstOperand+" is greater than "+secondOperand);
				    	   }
				    	   else
				    	   {
				    		   System.out.println(firstOperand+" is not greater than "+secondOperand);
				    	   }
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);
			    	   }
			    	  
			    	   break;
			       }
			       
			       case(7):
			       {
			    	   System.out.print("Please Enter First HexaDecimal Number:");
			    	   firstOperand = userInput.next().toUpperCase();
			    	   System.out.print("Please Enter Second HexaDecimal Number:");
			    	   secondOperand = userInput.next().toUpperCase();
			    	   
			    	   try
			    	   {
			    		   /**
			    		    * 
				    	    * @geResult store result of less than operation on two hexaDecimal numbers
				    	    */
				    	   boolean isLesser = hexaDecimal.lessThanOperation(firstOperand,secondOperand);
				    	   
				    	   /**
				    	    * 
				    	    * Printing result of less than operation
				    	    */
				    	   if(isLesser)
				    	   {
				    		   System.out.println(firstOperand+" is less than "+secondOperand);
				    	   }
				    	   else
				    	   {
				    		   System.out.println(firstOperand+" is not less than "+secondOperand);
				    	   }
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);
			    	   }
			    	  
			    	   break;
			       }
			       
			       case(8):
			       {
			    	   
			    	   System.out.print("Please Enter HexaDecimal Number:");
			    	   firstOperand =userInput.next().toUpperCase();
			    	   
			    	   try
			    	   {
			    		   /**
			    		    * 
				    	    * @geResult store decimal representation of hexadecimal 
				    	    */
				    	   long geResult = hexaDecimal.hexToDecimal(firstOperand);
				    	   
				    	   /**
				    	    * Printing result of hexadecimal to decimal
				    	    */
				    	   System.out.println(firstOperand+" Decimal Representation is : "+ geResult);
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);
			    	   }
			    	  
			    	   break;
			       }
			       case(9):
			       {
			    	   
			    	   System.out.print("Please Enter Decimal Number:");
			    	   String decimal = userInput.next();
			    	   
			    	   try
			    	   {
			    		   /**
			    		    * 
				    	    * @hexNumber store hexadecimal of decimal representation
				    	    */
				    	   String hexNumber = hexaDecimal.decimalToHex(decimal);
				    	   
				    	   /**
				    	    * 
				    	    * Printing result of decimal to hexadecimal 
				    	    */
				    	   System.out.println(decimal+" Decimal Representation is : "+ hexNumber);
			    	   }
			    	   catch(IOException io)
			    	   {
			    		   System.out.println(io);
			    	   }
			    	   break;
			       }
			       
			       default:
			       {
			    	   System.out.println("Invalid Input!!!!");
			    	   break;
			       }
			  };
			      
		}
			     
	}
	

}