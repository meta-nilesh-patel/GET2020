/**
 * 
 * @author Nilesh Patel
 * This class implement an immutable object IntSet and provide basic method's which are  
 *      isMember,getSize, isSubset and union and complement.
 */
final class IntSet 
{
	private final int MAX_SIZE_OF_SET = 1000;
	private final int[] set;
	private int[] arrayForTrackingElements = new int[1000];
	
	/**
	 * 
	 * Parameterized constructor to initialize integerArray.
	 * It also initialize arrayForTrackingElements by 0's.
	 * @param integerArray : 1D array containing value between 1-1000.
	 * @exception when got invalid inputs. 
	 */
	public IntSet(int[] integerArray) throws AssertionError 
	{
		for (int index = 0; index < MAX_SIZE_OF_SET; index++)
		{
			arrayForTrackingElements[index] = 0;
		}
		
		set = new int[integerArray.length];
		int integerArrayIndex =0;
		int setIndex = 0;
		while(integerArrayIndex < integerArray.length)
		{
			int currentElementOfIntegerArray = integerArray[integerArrayIndex];
			if(currentElementOfIntegerArray < 1 || currentElementOfIntegerArray > 1000)
			{
				throw new AssertionError("Invalid Inputs! Input should in range of (1 to 1000)");
			}
			if(arrayForTrackingElements[currentElementOfIntegerArray - 1] == 0)
			{
				this.set[setIndex] = integerArray[integerArrayIndex];
				arrayForTrackingElements[currentElementOfIntegerArray-1] = 1;
				integerArrayIndex++;
				setIndex++;
			}
			else
			{
				integerArrayIndex++;
			}
		}
	}
	
	/**
	 * 
	 * This method check if given value is the member of set or not.
	 * @param elementToBeChecked : integer value which we want to check.
	 * @return true of element is member of the set.  
	 */
	public boolean isMember(int elementToBeChecked)
	{
		if(this.arrayForTrackingElements[elementToBeChecked - 1] == 1)
		{
			return true;
		}
		return false;		
	}
	
	/**
	 * 
	 * This method return size of the set.
	 * @return size of the current set. 
	 */
	public int getSize()
	{
		return this.set.length;
	}
	
	/**
	 * 
	 * This method check if given set is subset of current set or not.
	 * @param inputSet : IntSet type object which we want to check subset or not.
	 * @return true if given set is subset of current set.
	 */
	public boolean isSubSet(IntSet inputSet)
	{   
		int[] setItems = inputSet.getItems();
		for (int index = 0; index < setItems.length; index++)
		{
			int currentItem = setItems[index];
			if(this.arrayForTrackingElements[currentItem - 1] != 1)
			{
				return false;
			}	
		}
		return true;
	}
	
	/**
	 * 
	 * This method provide complement of set.
	 * @return InsSet type object which is complement of current set.
	 */
	public IntSet getComplement()
	{
		int[] complementItems = new int[MAX_SIZE_OF_SET - this.getSize()];
		int indexOfTrackingArray = 0;
		int indexOfComplementItems =0;
				
		while(indexOfTrackingArray < MAX_SIZE_OF_SET)
		{
			if(arrayForTrackingElements[indexOfTrackingArray] == 0)
			{
				complementItems[indexOfComplementItems] = indexOfTrackingArray + 1;
				indexOfComplementItems++;
				indexOfTrackingArray++;
			}
			else
			{
				indexOfTrackingArray++;
			}			
		}
		return new IntSet(complementItems);
	}
	
	/**
	 * 
	 * This method compute union of two sets.
	 * @param firstSet : first set for compute union.
	 * @param secondSet : second set for compute union.
	 * @return IntSet type object which is union of input sets;
	 */
	public static IntSet union(IntSet firstSet, IntSet secondSet)
	{
		int[] unionArray = new int[firstSet.getSize() + secondSet.getSize()];
		int[] firstSetItems = firstSet.getItems();
		int[] secondSetItems = secondSet.getItems();
		int indexOfUnionArray;
		for ( indexOfUnionArray = 0; indexOfUnionArray < firstSetItems.length; indexOfUnionArray++)
		{
			unionArray[indexOfUnionArray] = firstSetItems[indexOfUnionArray];
		}
		for (indexOfUnionArray = firstSetItems.length; indexOfUnionArray < unionArray.length; indexOfUnionArray++)
		{
			unionArray[indexOfUnionArray] = secondSetItems[indexOfUnionArray - firstSetItems.length];
		}
		return new IntSet(unionArray);
	}
	
	/**
	 * 
	 * This method help for access set element.
	 * @return 1D array which contain setItems.
	 */
	public int[] getItems()
	{
		int[] setItems = this.set;
		return setItems;
	}
}
