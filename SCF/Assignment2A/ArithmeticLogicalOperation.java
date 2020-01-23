import java.io.IOException;

/**
 * 
 * @author Nilesh Patel
 * This interface design for provide generic method of arithmetic and logical operations.
 */

public interface ArithmeticLogicalOperation 
{
	/**
	 * 
	 * @param firstOperand operand for addition
	 * @param secondOperand operand for addition
	 * @return result of addition of two operand 
	 * @throws IOException if parameter not contain legal value
	 */
	public String addOperation(String firstOperand , String secondOperand) throws IOException;
	
	/**
	 * 
	 * @param firstOperand operand for subtraction
	 * @param secondOperand operand for subtraction
	 * @return result of subtraction of two operand
	 * @throws IOException if parameter not contain legal value
	 */
	public String subtractOperation(String firstOperand , String secondOperand) throws IOException;
	
	/**
	 * 
	 * @param firstOperand operand for multiplication
	 * @param secondOperand operand for multiplication
	 * @return result of multiplication of two operand
	 * @throws IOException if parameter not contain legal value
	 */
	public String multiplicationOperation(String firstOperand , String secondOperand) throws IOException;
	
	/**
	 * 
	 * @param firstOperand operand for division
	 * @param secondOperand operand for division
	 * @return result of division of two operand
	 * @throws IOException if parameter not contain legal value
	 */
	public String divisonOperation(String firstOperand , String secondOperand) throws IOException, ArithmeticException;
	
	/**
	 * 
	 * @param firstOperand operand for equal operation
	 * @param secondOperand operand for equal operation
	 * @return boolean containing true if equal or false
	 * @throws IOException if parameter not contain legal value 
	 */
	public boolean equalsOperation(String firstOperand, String secondOperand) throws IOException;
	
	/**
	 * assuming first operand is greater 
	 * @param firstOperand operand for greater than operation
	 * @param secondOperand operand for greater than operation
	 * @return true if firstOperand is greater
	 * @throws IOException if parameter not contain legal value
	 */
	public boolean greaterThanOperation(String firstOperand, String secondOperand) throws IOException;
	
	/**
	 * assuming first operand is lesser
	 * @param firstOperand operand for less than operation
	 * @param secondOperand operand for less than operation
	 * @return true if firstOperand is lesser
	 * @throws IOException if parameter not contain legal value
	 */
	public boolean lessThanOperation(String firstOperand, String secondOperand) throws IOException;
	

}
