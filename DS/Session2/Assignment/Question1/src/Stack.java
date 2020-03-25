/**
 * @author Nilesh Patel
 * stack interface defines the methods of stack
 *
 */
public interface Stack<T> {

	/**
	 * @return the popped element from stack
	 * pop will remove element from the top of the stack
	 * @throws Exception 
	 */
	public T pop() throws Exception;

	/**
	 * @param <T>
	 * @param c is the element to be pushed into the stack
	 * @return true if successfully inserted
	 */
	public boolean push(T object) throws Exception;

	/**
	 * @return true if the stack is empty
	 */
	public boolean isEmpty();

	/**
	 * @return the top most element of the stack
	 */
	public T peek()throws Exception;
	
	/**
	 * display all the element of stack;
	 */
	public void display();

}