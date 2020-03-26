package question2;
/**
 * @author Nilesh Patel
 * interface Queue defines the methods of Queue that are to
 *         be implemented.
 * @param <T> queue store generic data type
 */
public interface Queue<T> {

	/**
	 * @param object is the object to be inserted
	 * @return true if successfully inserted the element
	 * @throws Exception 
	 */
	public boolean enqueue(Element object) throws Exception;

	/**
	 * @return the removed element
	 */
	public Element dequeue() throws Exception;

	/**
	 * @return true if the queue is empty else return false
	 * @throws Exception
	 */
	public boolean isEmpty();

	/**
	 * @return true if the queue is full else return false
	 */
	public boolean isFull();
	
	public void display();
}
