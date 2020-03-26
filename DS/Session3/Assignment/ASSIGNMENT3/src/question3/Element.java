package question3;

/**
 * @author Nilesh Patel
 * class to define Element that is going to be added or removed from the priority queue
 */
public class Element {
	private int elementName;
	private int priority;

	/**
	 * @param ele
	 * @param prior
	 * constructor to set instance values
	 */
	public Element(int elementName, int prior) {
		this.elementName = elementName;
		this.priority = prior;
	}

	/**
	 * @return the element
	 */
	public int getElementName() {
		return this.elementName;
	}

	/**
	 * @return the priority of particular element
	 */
	public int getPriority() {
		return priority;
	}

	public void setPriority(int newPriority) {
		this.priority = newPriority;		
	}
}
