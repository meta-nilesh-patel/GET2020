import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Nilesh Patel
 * This Class implements methods to perform operation on positive integer array
 */
public class ArrOperation 
{
	/**
	 * 
	 * Find size of largest mirror section in positive integer array
	 * @param inputArray an array of positive integer
	 * @return size of largest mirror section in the array
	 * @throws AssertionError when array is empty 
	 * @throws AssertionError when array contain negative number
	 */
	public int getSizeOfLargestMirrorSectionSizeInArray(int inputArray[]) throws AssertionError
	{	
		//input validation
		if(inputArray.length == 0)
		{
			throw new AssertionError("Null Array");
		}
		else
		{
			boolean validInput = inputValidation(inputArray);
			if(validInput == false)
			{
				throw new AssertionError("Array contain negative integer");
			}
		}
		
		//variable assignments
		int arrayLength = inputArray.length;
		
		//first mirror sequence start and end index
		int firstMirrorStartIndex = 0;
		int firstMirrorEndIndex = 0;
		
		//second mirror sequence start and end index
		int secondMirrorStartIndex = (arrayLength -1);
		int secondMirrorEndIndex =(arrayLength -1);
		
		//mirror sequence size
		int currentMirrorSize = 0;
		//max mirror sequence size
		int maxMirrorSize = 0;
		
		/**
		 * 
		 * firstMirrorStartIndex is starting from front of array 
		 * secondMirrorStartIndex is staring from back of array
		 * firstMirrorEndIndex is iterating forward in array
		 * secondMirrorEndIndex is iterating backward in array
		 * loop terminate when first sequence start index cross second sequence start index
		 */
		while(firstMirrorStartIndex < secondMirrorStartIndex)
		{
			//checking if first mirror sequence first integer is equal to second mirror sequence first integer
			if(inputArray[firstMirrorStartIndex] == inputArray[secondMirrorStartIndex])
			{
				//if first element of both sequence are equal than initialize the end indexes of both sequence
				firstMirrorEndIndex = firstMirrorStartIndex;
				secondMirrorEndIndex = secondMirrorStartIndex;
				
				/**
				 * 
				 * when first element of both sequence matched than checking next elements until mismatch found
				 * loop will run until first sequence end index cross second sequence start index or vice-versa or elements at those indexes are same.
				 */
				while((firstMirrorEndIndex <=  secondMirrorStartIndex  || secondMirrorEndIndex >= firstMirrorStartIndex) && 
					  (inputArray[firstMirrorEndIndex] == inputArray[secondMirrorEndIndex]))
				{
						currentMirrorSize++;
						firstMirrorEndIndex++;
						secondMirrorEndIndex--;
				}
				
				//checking if mirrorSize is greater than maxMirrorSize if it is than changing value of maxMirrorSize
				if(currentMirrorSize > maxMirrorSize)
				{
					maxMirrorSize = currentMirrorSize;
				}
				currentMirrorSize = 0;
			}
			/*
			 * first sequence start index cross all element and did'nt match 
			 * so again starting from first element of array and also decreasing second sequence start index
			 */
			if(secondMirrorStartIndex - firstMirrorStartIndex == 1)
			{
				firstMirrorStartIndex ++;
				secondMirrorStartIndex = arrayLength - 1;
			}
			else
			{
				//element didn't match so increasing first sequence start index
				secondMirrorStartIndex--;
			}						
		}
		return maxMirrorSize;
	}
	
	/**
	 * 
	 * Find number of clumps in positive integer array
	 * @param inputArray an array of positive integer
	 * @return number of clumps in positive integer array
	 * @throws AssertionError when array is empty 
	 * @throws AssertionError when array contain negative number
	 */
	public int getNumberOfClumpsInArray(int inputArray[]) throws AssertionError
	{
		//input validation
		if(inputArray.length == 0)
		{
			throw new AssertionError("Null Array");
		}
		else
		{
			//validating if array contain negative integer
			boolean validInput = inputValidation(inputArray);
			if(validInput == false)
			{
				throw new AssertionError("Array contain negative integer");
			}
		}
		
		int numberOfClumps = 0;
		int elementForCheckCurrentClump = inputArray[0];
		int arrayIndex = 1;
		while(arrayIndex < inputArray.length)
		{
			if(elementForCheckCurrentClump == inputArray[arrayIndex])
			{
				numberOfClumps++;
				while(arrayIndex < inputArray.length && elementForCheckCurrentClump == inputArray[arrayIndex])
				{
					arrayIndex++;
				}
			}
			if(arrayIndex < inputArray.length)
			{
				elementForCheckCurrentClump = inputArray[arrayIndex];
			}
			arrayIndex++;
		}
		return numberOfClumps;
	}
	
	/**
	 * 
	 * Change position of Y corresponding to X 
	 * @param inputArray an array of positive integer
	 * @param x positive integer value
	 * @param y positive integer value
	 * @return integer array with every X followed by Y
	 * @throws AssertionError when array is empty 
	 * @throws AssertionError when array contain negative number
	 * @throws AssertionError when number of x and y is not equal
	 * @throws AssertionError when x occurred at last position in array
	 * @throws AssertionError when two x occurred continuously  
	 */
	public int[] fixXYInArray(int inputArray[],int x, int y)throws AssertionError
	{
		//input validation
		if(inputArray.length == 0)
		{ 
			throw new AssertionError("Null Array"); 
		}
		else
		{
			//checking if array contain negative number
			boolean validInput = inputValidation(inputArray);
			if(validInput == false)
			{ 
				throw new AssertionError("Array contain negative integer"); 
			}
		}
		//checking if x is present in the last position
		if(inputArray[inputArray.length -1] == x)
		{ 
			throw new AssertionError("X is at invalid index"); 
		}
		//this indexOfY ArrayList stores indexes of misplaced y values in the array
		List<Integer> indexesOfWrongPlacedY = new ArrayList<Integer>();
		int numberOfY = 0;
		int numberOfX = 0;
		
		//iterating array
		for(int arrayIndex = 0; arrayIndex < inputArray.length; arrayIndex++)
		{
			//checking if two x occur continuously 
			if(inputArray[arrayIndex] == x && inputArray[arrayIndex+1] == x)
			{ 
				throw new AssertionError("Two continues X");
			}
			//checking if y occur in array at first position
			if(inputArray[arrayIndex] == y && arrayIndex == 0)
			{
				indexesOfWrongPlacedY.add(arrayIndex);
				numberOfY++;
				continue;
			}
			//checking if y occur in array and not after x than storing index in indexOfY list
			if(inputArray[arrayIndex] == y && inputArray[arrayIndex-1] != x)
			{
				indexesOfWrongPlacedY.add(arrayIndex);
				numberOfY++;
				continue;
			}
			//counting number of x
			if(inputArray[arrayIndex] == x)
			{ 
				numberOfX++; 
			}
			//counting number of y
			if(inputArray[arrayIndex] == y)
			{ 
				numberOfY++; 
			}
		}
		//checking if number of x is equal to y
		if(numberOfX != numberOfY)
		{ 
			throw new AssertionError("Number of X not equals to number of Y"); 
		}
		
		int fixedXYArray[] = inputArray;
		int indexOfArrayOfIndexesOfWrongPlacedY = 0;
		
		//placing every misplaced y right next to x
		for(int arrayIndex = 0; arrayIndex < inputArray.length; arrayIndex++)
		{
			//checking if x occur and next is not y
			if(fixedXYArray[arrayIndex] == x && fixedXYArray[arrayIndex + 1] != y)
			{
				//taking index of misplaced y and replacing with the wrong placed integer
				fixedXYArray[indexesOfWrongPlacedY.get(indexOfArrayOfIndexesOfWrongPlacedY)] = fixedXYArray[arrayIndex + 1];
				fixedXYArray[arrayIndex + 1] = y;
				indexOfArrayOfIndexesOfWrongPlacedY++;
			}
		}
		return fixedXYArray;
	}
	
	/**
	 * 
	 * Splitting integer array such that sum of both side is equal
	 * @param inputArray an array of positive integer
	 * @return index from which sum of both side of array is equal or return -1,
	 *         like if @inputArray = [1,1,1,2,1] then output will be 3.
	 * @throws AssertionError when array is empty 
	 * @throws AssertionError when array contain negative number
	 */
	public int getSplitIndexInArray(int inputArray[]) throws AssertionError
	{
		//input validation
		if(inputArray.length == 0)
		{
			throw new AssertionError("Null Array");
		}
		else
		{
			boolean validInput = inputValidation(inputArray);
			if(validInput == false)
			{ 
				throw new AssertionError("Array contain negative integer"); 
			}
		}
		
		int arraySum = 0;
		//getting array sum.
		for(int arrayIndex = 0; arrayIndex < inputArray.length; arrayIndex++)
		{
			arraySum += inputArray[arrayIndex];
		}
		
		int leftSideSum = 0;
		int rightSideSum = arraySum;		
		int arrayIndex = 0;
		while(leftSideSum < rightSideSum)
		{	
			leftSideSum += inputArray[arrayIndex];
			rightSideSum -= inputArray[arrayIndex];
					
			if(leftSideSum == rightSideSum)
			{    
				return arrayIndex + 1;
			}
			arrayIndex++;
		}
		
		return -1;
	}
	
	/**
	 * 
	 * For validating input array is not empty and contain only positive integer
	 * @param inputArray positive integer array
	 * @return true if array contain only positive integer
	 *         false if array contain negative integer
	 */
	private boolean inputValidation(int inputArray[])
	{
		for(int arrayIndex =0; arrayIndex < inputArray.length; arrayIndex++)
		{
			if(inputArray[arrayIndex] < 0)
			{ 
				return false; 
			}
		}
		return true;
	}
}
