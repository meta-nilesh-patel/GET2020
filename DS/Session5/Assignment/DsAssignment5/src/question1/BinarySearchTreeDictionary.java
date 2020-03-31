package question1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BinarySearchTreeDictionary implements Dictionary {

	private BinarySearchTree myDictionary = new BinarySearchTree();
	
	public BinarySearchTreeDictionary(JSONObject listOfkeyValuePairs) {
		JSONArray keys = listOfkeyValuePairs.names();
		for(int i = 0; i < keys.length(); i++) {
			try {
				this.addKey(keys.getInt(i), listOfkeyValuePairs.get(keys.getString(i)));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addKey(Integer key, Object value) {
		Node tempNode = myDictionary.search(myDictionary.getRoot(), key);
		if(tempNode != null) {
			tempNode.setValue(value);
		}
		else {
			Node newNode = new Node(key, value);
			myDictionary.insert(newNode);
		}
		return true;
	}

	@Override
	public boolean deleteKey(Integer key) {
		Node tempNode = myDictionary.search(myDictionary.getRoot(), key);
		if(tempNode == null) {
			return false;
		}
		myDictionary.deleteKey(key);
		return true;
	}

	@Override
	public Object getValue(Integer key) {
		Node tempNode = myDictionary.search(myDictionary.getRoot(), key);
		try {
			if (tempNode != null) {
				return tempNode.getValue();
			}
			else {
				throw new Exception("Key not found");
			}
		} 
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Object[]> getSorted() {
		List<Node> sortedList = new ArrayList<Node>();
		sortedList = myDictionary.inorderRec(myDictionary.getRoot(), sortedList);
		List<Object[]> sortedKeyValue = new ArrayList<Object[]>();
		for (Node tempNode : sortedList) {
			Object[] tempObj = new Object[2];
			tempObj[0] = tempNode.getKey();
			tempObj[1] = tempNode.getValue();
			sortedKeyValue.add(tempObj);
		}
		return sortedKeyValue;
	}

	@Override
	public List<Object[]> getSlice(Integer key1, Integer key2) {
		List<Node> sortedList = new ArrayList<Node>();
		sortedList = myDictionary.inorderRec(myDictionary.getRoot(), sortedList);
		List<Object[]> slicedKeyValue = new ArrayList<Object[]>();
		for (Node tempNode : sortedList) {
			Object[] tempObj = new Object[2];
			tempObj[0] = tempNode.getKey();
			tempObj[1] = tempNode.getValue();
			if(tempNode.getKey() >= key1 && tempNode.getKey() <= key2) {
				slicedKeyValue.add(tempObj);
			}	
		}
		return slicedKeyValue;	
	}

	@Override
	public void display(Node root) {
		if (root != null) { 
			display(root.getLeft());
			System.out.println(root);
			display(root.getRight()); 
		} 
	}
	
	public BinarySearchTree getMyDictionary() {
		return myDictionary;
	}
	
	/*public static void main(String[] args) {

		JSONObject jobj = new JSONObject();
		try {
			jobj.append("31", "sample3");
			jobj.append("21", "sample2");
			jobj.append("41", "sample4");
			jobj.append("11", "sample1");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Dictionary mydict = new BinarySearchTreeDictionary(jobj);
		mydict.addKey(1, "Nilesh");
		mydict.addKey(2, "Ni");
		mydict.addKey(3, "Nil");
		mydict.addKey(4, "Nile");
		mydict.addKey(5, "Niles");
		mydict.addKey(6, "Nilesh Patel");
		mydict.display(mydict.getMyDictionary().getRoot());
		List<Object[]> l = mydict.getSlice(3, 5);
		for (Object[] objects : l) {
			System.out.println(objects[0] + " : " + objects[1]);
		}
	}
*/
	
}
