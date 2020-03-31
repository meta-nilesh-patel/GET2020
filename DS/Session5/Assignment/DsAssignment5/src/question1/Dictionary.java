package question1;

import java.util.List;

public interface Dictionary {
	
	/**
	 * This function will add new key-value to dictionary.
	 */
	public boolean addKey(Integer key, Object value);
	
	/**
	 * This function will delete a key from dictionary.
	 * @param key
	 * @return
	 */
	public boolean deleteKey(Integer key);
	
	/**
	 * This function will return value corresponding key.
	 * @param key
	 * @return
	 */
	public Object getValue(Integer key);
	
	/**
	 * This function will return sorted key-value pair list.
	 * @return
	 */
	public List<Object[]> getSorted();
	
	/**
	 * This function will return slice of sorted key-value pairs.
	 * @param key1
	 * @param key2
	 * @return
	 */
	public List<Object[]> getSlice(Integer key1, Integer key2);
	
	/**
	 * 
	 * @param root
	 */
	void display(Node root);

	public BinarySearchTree getMyDictionary();
}
