/**
 * 
 * @author Nilesh Patel
 * This class implements method to solve n queen problem.
 * @see https://en.wikipedia.org/wiki/Eight_queens_puzzle
 */
public class NQueenProblem
{     
     /**
      * 
      * An utility function to check if a queen can be placed on board[row][startColumn].
      * @param board : board on which we want to place queen.
      * @param row : row number.
      * @param startColumn : startColumn number
      * @return true if possible to place queen in this box. 
      */
     boolean isInAttack(int board[][], int row, int startColumn, int noOfQueens) 
     {    
          /**
           * Check this row on left side. 
           */
          for (int startColumnIndex = 0; startColumnIndex < startColumn; startColumnIndex++)
          {
               if (board[row][startColumnIndex] == 1)
               {
                    return false;
               }
          }   
  
          /**
           * Check upper diagonal on left side.
           */ 
          for (int rowIndex = row, startColumnIndex = startColumn; rowIndex >= 0 && startColumnIndex >= 0; rowIndex--, startColumnIndex--)
          {
               if (board[rowIndex][startColumnIndex] == 1)
               {
                    return false; 
               }
          }
        
          /**
           * Check lower diagonal on left side 
           */
          for (int rowIndex = row, startColumnIndex = startColumn; startColumnIndex >= 0 && rowIndex < noOfQueens; rowIndex++, startColumnIndex--)
          {
               if (board[rowIndex][startColumnIndex] == 1)
               {
                    return false; 
               }
          }
          return true; 
     } 
  
     /**
      * 
      * A recursive function to solve N Queen problem at initial startColumn value should be 0.
      * @startColumn : in which startColumn we are placing queen.
      */ 
     boolean solveNQueen(int[][]board, int startColumn, final int noOfQueens) throws AssertionError 
     { 
          if(noOfQueens < 1)
          {
    	          throw new AssertionError("No of Queens should be positive!");
          }
          /**
           * base case: If all queens are placed then return true
           */
          if(startColumn >= noOfQueens)
          {
               return true;
          }   
  
          /**
           * Consider this startColumn and try placing this queen in all rows one by one 
           */
          for(int rowIndex = 0; rowIndex < noOfQueens; rowIndex++) 
          { 
               /**
                * Check if the queen can be placed on board[rowIndex][startColumn] 
                */
               if(isInAttack(board, rowIndex, startColumn, noOfQueens)) 
               { 
                    /**
                     * Place this queen in board[rowIndex][startColumn] 
                     */
                    board[rowIndex][startColumn] = 1; 
                   
                    /**
                     * recur to place rest of the queens 
                     */
                    if(solveNQueen(board, startColumn + 1, noOfQueens) == true)
                    {
                         return true; 
                    }
                    /**
                     * If placing queen in board[rowIndex][startColumn] doesn't lead to a solution then remove queen from board[rowIndex][startColumn] 
                     */
                    board[rowIndex][startColumn] = 0;
               } 
          } 
  
          /** 
           * If the queen can not be placed in any row in this startColumn, then return false 
           */
          return false; 
     }   
} 
