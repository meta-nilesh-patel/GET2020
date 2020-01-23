import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Nilesh Patel
 * This class design for implement sparse matrix and it's operation method like add, multiply, transpose, isSymmetrical.  
 */
final class SparseMatrix 
{
	private final int[][] sparseMatrix;
	private final int totalRow;
	private final int totalColumn;
	
	/**
	 * 
	 * Parameterized constructor for initialize instance variables.
	 * @param matrix : 2D matrix for generate sparse matrix.
	 */
	public SparseMatrix(int[][] inputMatrix)
	{
		this.totalRow = inputMatrix.length;
		this.totalColumn = inputMatrix[0].length;
		this.sparseMatrix = this.matrixToSparseMatrix(inputMatrix);	
	}
	
	/**
	 *
	 * This utility function generate sparse matrix for given matrix.
	 * @param inputMatrix : 2D array which contain original matrix.
	 * @return 2D array which is sparse matrix of inputMatrix
	 */
	public int[][] matrixToSparseMatrix(int[][] inputMatrix)
	{
		int noOfNonZeroElements = 0;
		for (int row = 0; row < this.totalRow; row++)
		{
			for (int column = 0; column < this.totalColumn; column++)
			{
				if(inputMatrix[row][column] != 0)
				{
					noOfNonZeroElements++;
				}
			}	
		}
		//total column will be 3 in sparse matrix.
		int[][] localSparseMatrix = new int[noOfNonZeroElements][3];
		int indexOfLocalSparseMatrix = 0;
		for (int row = 0; row < this.totalRow; row++)
		{
			for (int column = 0; column < this.totalColumn; column++)
			{
				if(inputMatrix[row][column] != 0)
				{
					localSparseMatrix[indexOfLocalSparseMatrix][0] = row;
					localSparseMatrix[indexOfLocalSparseMatrix][1] = column;
					localSparseMatrix[indexOfLocalSparseMatrix][2] = inputMatrix[row][column];
					indexOfLocalSparseMatrix++;
				}
			}	
		}
		return localSparseMatrix;
	}
	
	/**
	 * 
	 * This utility method convert sparse matrix into normal matrix;
	 * @param sparseMatrix : 2D array which is a sparse matrix.
	 * @return 2D array which is a normal matrix with respect of given sparse matrix;
	 */
	public int[][] sparseToNormalMatrix()
	{
		int[][] normalMatrix = new int[this.totalRow][this.totalColumn];
		for (int sparseIndex = 0; sparseIndex < this.sparseMatrix.length; sparseIndex++)
		{
			normalMatrix[this.sparseMatrix[sparseIndex][0]][this.sparseMatrix[sparseIndex][1]] = this.sparseMatrix[sparseIndex][2];
		}
		return normalMatrix;
	}
	
	/**
	 * 
	 * This method compute transpose of a matrix
	 * @return SparseMatrix type object of transpose matrix.
	 */
	public SparseMatrix getTranspose()
	{
		int[][] transposeMatrix = new int[this.totalColumn][this.totalRow];
		for (int sparseIndex = 0; sparseIndex < this.sparseMatrix.length; sparseIndex++)
		{
			transposeMatrix[this.sparseMatrix[sparseIndex][1]][this.sparseMatrix[sparseIndex][0]] = this.sparseMatrix[sparseIndex][2];
		}
		return new SparseMatrix(transposeMatrix);
	}
	
	/**
	 * 
	 * This method check whether matrix is symmetric or not.
	 * @return true is matrix is symmetric.
	 * @throws AssertionError when matrix is not Square.
	 */
	public boolean isSymmetric() throws AssertionError
	{
		if(this.totalRow != this.totalColumn)
		{
			throw new AssertionError("It is not a square matrix!!");
		}
		int[][] transposeMatrix = SparseMatrix.sortSparseMatrixByRowColumn(this.getTranspose().sparseMatrix);
		for (int index = 0; index < sparseMatrix.length; index++)
		{
			if(this.sparseMatrix[index][0] != transposeMatrix[index][0] || this.sparseMatrix[index][1] != transposeMatrix[index][1] || 
			   this.sparseMatrix[index][2] != transposeMatrix[index][2])
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * This method will add two sparse matrix.
	 * @param firstMatrix 
	 * @param secondMatrix
	 * @return SparseMatrix type object respect of addition matrix.
	 * @throws AssertionError when Order of both matrix are not equal.
	 */
	public static SparseMatrix addTwoSparseMatrix(SparseMatrix firstMatrix, SparseMatrix secondMatrix)
	{
		if(firstMatrix.totalRow != secondMatrix.totalRow || firstMatrix.totalColumn != secondMatrix.totalColumn)
		{
			throw new AssertionError("Order of both matrix are different");
		}
		int[][] additionMatrix = new int[firstMatrix.totalRow][firstMatrix.totalColumn];
		for (int index = 0; index < firstMatrix.sparseMatrix.length; index++)
		{
			additionMatrix[firstMatrix.sparseMatrix[index][0]][firstMatrix.sparseMatrix[index][1]] += firstMatrix.sparseMatrix[index][2];
		}
		for (int index = 0; index < secondMatrix.sparseMatrix.length; index++)
		{
			additionMatrix[secondMatrix.sparseMatrix[index][0]][secondMatrix.sparseMatrix[index][1]] += secondMatrix.sparseMatrix[index][2];
		}
		return new SparseMatrix(additionMatrix);
	}
	
	/**
	 * 
	 * This method will multiply two sparse matrix.
	 * @param firstMatrix 
	 * @param secondMatrix
	 * @return SparseMatrix type object respect of multiplication matrix.
	 * @throws AssertionError when total column of first matrix is not equal to total row of second matrix.
	 */
	public static SparseMatrix multiplyTwoSparseMatrix(SparseMatrix firstMatrix, SparseMatrix secondMatrix)
	{
		if(firstMatrix.totalColumn != secondMatrix.totalRow)
		{
			throw new AssertionError("Order of both matrix are different");
		}
		int[][] multiplicationMatrix = new int[firstMatrix.totalRow][secondMatrix.totalColumn];
		int[][] firstSparseMatrix = SparseMatrix.sortSparseMatrixByRowColumn(firstMatrix.sparseMatrix);
		int[][] transposeOfsecondSparseMatrix = SparseMatrix.sortSparseMatrixByRowColumn(secondMatrix.getTranspose().sparseMatrix);
		for(int indexOfFirstSparse = 0; indexOfFirstSparse < firstSparseMatrix.length; indexOfFirstSparse++)
        	{
            		for(int indexOfTransposeOfSecondSparse = 0; indexOfTransposeOfSecondSparse < transposeOfsecondSparseMatrix.length; indexOfTransposeOfSecondSparse++)
            		{
                		if(firstSparseMatrix[indexOfFirstSparse][1] == transposeOfsecondSparseMatrix[indexOfTransposeOfSecondSparse][1])
                		{                
                    			multiplicationMatrix[firstSparseMatrix[indexOfFirstSparse][0]][transposeOfsecondSparseMatrix[indexOfTransposeOfSecondSparse][0]] += firstSparseMatrix[indexOfFirstSparse][2] * transposeOfsecondSparseMatrix[indexOfTransposeOfSecondSparse][2];      
                		}
            		}
        	}
		return new SparseMatrix(multiplicationMatrix);
	}
	
	/**
	 * 
	 * This method will sort the array by their row and column time.
	 * @see {@link https://codippa.com/how-to-sort-a-two-dimensional-array-on-column-values-in-java/}
	 * @param matrix : two dimension integer array which is a sparseMatrix.
	 * @return 2D array which contain sorted by row and column.
	 */
	private static int[][] sortSparseMatrixByRowColumn(int[][] matrix)
	{
		int[][] sortedMatrix = matrix;
		Arrays.sort(sortedMatrix, new Comparator<int[]>()
				{    
	        @Override              
	        public int compare(final int[] entry1, final int[] entry2)
	        { 
	            if(entry1[0] > entry2[0])
	            {
	            	return 1;
	            } 
	            else if(entry1[0] == entry2[0] && entry1[1] >= entry2[1])
	            {
	            	return 1;
	            }
	            else
	            {
	            	return -1;
	            }
	        } 
	        });
		return sortedMatrix;
	}	
}
