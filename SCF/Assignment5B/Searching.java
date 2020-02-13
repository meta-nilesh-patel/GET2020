/**
 *
 * @author Nilesh Patel
 * This class contain two methods binarySearch and linearSearch.
 */
public class Searching 
{
	/**
	 * 
	 * This method search given element in the array.
	 * @param array : array in which we want to search it should not be empty.
	 * @param elementToBeSearched : element which we want to search.
	 * @param startIndex : index from we want to start our searching.
	 * @return index of first occurrence of element if element found else return -1.
	 */
	public int linearSearch(int[] array, int elementToBeSearched, int startIndex) throws AssertionError
	{
		if(array.length == 0)
		{	
			throw new AssertionError("Null array found!");
		}
		if(startIndex == array.length)
		{	
			return -1;
		}	
		else if(array[startIndex] == elementToBeSearched)
		{	
			return startIndex;
		}	
		return linearSearch(array, elementToBeSearched, startIndex + 1);			
	}
	
	/**
	 * 
	 * This method search given element in the array.
	 * @param array : array in which we want to search and it must be in sorted form and it should not be empty.
	 * @param elementToBeSearched : element which we want to search.
	 * @param startIndex : index from we want to start our searching and it start with 0.
	 * @param endIndex : index till we want to search our element. 
	 * @return index of element if element found else return -1.
	 */
	public int binarySearch(int[] array, int elementToBeSearched, int startIndex, int endIndex) throws AssertionError
	{
		if(array.length == 0)
		{	
			throw new AssertionError("Null array found!");
		}
		
		if(startIndex > endIndex)
		{
			return -1;
		}
		
		int middleIndex = (startIndex + endIndex) / 2;
		if(array[middleIndex] == elementToBeSearched)
		{
			return middleIndex;
		}
		else if(elementToBeSearched > array[middleIndex])
		{
			startIndex = middleIndex + 1;
			return binarySearch(array, elementToBeSearched, startIndex, endIndex);
		}
		else
		{
			endIndex = middleIndex - 1;
			return binarySearch(array, elementToBeSearched, startIndex, endIndex);
		}
	}
}
