package question1;

public class Node {
	private Integer key = null;
	private Object value = null;
	private Node left = null;
	private Node right = null;
	
	public Node(Integer key, Object value) {
		this.key = key;
		this.value = value;
	}
	public Integer getKey() {
		return key;
	}
	
	public void setKey(Integer key) {
		this.key = key;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return this.key + " : " + this.value;
	}
}
