/**
 * @author Nilesh Patel
 * @param <T> queue store generic data type CircularQueue class creates a
 *            circular queue with some functions of circular queue
 */
public class CircularQueue<T> implements Queue<T> {

	private int front;
	private int rear;
	private int size;
	private T[] queue;

	/**
	 * @param size is the max size of the Circular queue Constructor assign the
	 *             values of front, rear and size of the queue
	 */
	public CircularQueue(int size) {
		try {
			front = -1;
			rear = -1;
			this.size = size;
			queue = ((T[]) new Object[this.size]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param element insert method inserts the element to the queue if the queue is
	 *                not empty returns true if successfully inserted else return
	 *                false
	 */
	@Override
	public boolean enqueue(T element) {
		try {
			if (element == null) {
				throw new Exception("null element");
			}
			if (!isFull()) {
				if (front == -1) {
					front = 0;
				}
				rear = (rear + 1) % size;
				queue[rear] = element;
				return true;
			} else {
				throw new Exception("queue is full");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @return the removed element remove method removes an element from rear
	 *         returns the removed element
	 */
	@Override
	public T dequeue() {
		T element = null;
		try {
			if (isEmpty()) {
				throw new AssertionError("Queue is Empty");
			}
			element = queue[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				front = (front + 1) % size;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * 
	 * @return true if the queue is empty else false
	 */
	@Override
	public boolean isEmpty() throws Exception {

		return (front == -1) ? true : false;
	}

	/**
	 * @return true if the queue is Full else false
	 */
	@Override
	public boolean isFull() {
		try {
			if ((front == 0 && rear == size - 1) || (front - rear == 1)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}