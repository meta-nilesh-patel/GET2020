package question3;

import java.util.Scanner;

/**
 * @author Nilesh Patel
 * class priorityQueue will set the priority of element using heap,enqueue an dequeue elements 
 */
public class PriorityQueue implements Queue {
	public Element[] queue = new Element[this.SIZE];
	private int front = 0;
	private int rear = -1;
	private final int SIZE = 1000;

	/**
	 * enQueue method will enqueue element using heap
	 */
	@Override
	public boolean enqueue(Element element) throws Exception {
		if (!isFull()) {
			Element object = element;
			queue[++this.rear] = element;
			int position = this.rear - 1;
			while ((position >= this.front) && this.rear != 0 && object.getPriority() > queue[position].getPriority()) {
				Element tempElement = queue[position];
				queue[position] = queue[position + 1];
				queue[position + 1] = tempElement;
				position--;
			}
			return true;
		} else {
			throw new Exception("Queue Array is full");
		}
	}

	/**
	 * deQueue method will dequeue element using heap
	 */
	@Override
	public Element dequeue() throws Exception {
		if (isEmpty()) {
			throw (new Exception("queue is empty"));
		}
		return queue[this.front++];
	}

	/**
	 *
	 */
	@Override
	public boolean isEmpty() {
		if (this.rear == -1 || this.front > this.rear)
			return true;
		return false;
	}

	/**
	 *
	 */
	@Override
	public boolean isFull() {
		if (rear == this.SIZE - 1){
			return true;
		}	
		return false;
	}

	@Override
	public void display() {		
		for (int i = this.front; i <= this.rear; i++) {
			System.out.println("Element is :" + queue[i].getElementName());

		}
	}
}
