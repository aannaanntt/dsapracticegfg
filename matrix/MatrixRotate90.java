package matrix;

import java.util.Arrays;

public class MatrixRotate90 {

	public static void main(String[] args) {
		int[][] matrix = { { 1,2,3 }, {4,5,6},{7,8,9}// 3-1/-0
				 };

		rotate90Efficient(matrix);

	}
	
	
	
	// a better solution will be is to find the transpose of the matrix and than reverse every column
 static	void rotate90Efficient(int[][] matrix) {

		  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            System.out.println("Matrix is empty or invalid.");
	            return;
	        }
		  //first find transpose of the matrix provided 
		  int rowNo = matrix.length;
	        int colNo = matrix[0].length;

	        // Step 1: Transpose the matrix
	        for (int i = 0; i < rowNo; i++) {
	            for (int j = i + 1; j < colNo; j++) {
	                // Swap the elements at [i][j] and [j][i] to transpose the matrix
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	            }
	        }
		  //printing transposed matrix
//		  System.out.println("printing transposed matrix");
//		  for(int i=0;i<matrix.length;i++) {
//			  System.out.println(Arrays.toString(matrix[i]));
//		  }
		  
	        for (int i = 0; i < colNo; i++) {
	            int low = 0;
	            int high = rowNo - 1;
	            while (low < high) {
	                // Swap elements to reverse the row
	                int temp = matrix[low][i];
	                matrix[low][i] = matrix[high][i];
	                matrix[high][i] = temp;
	                low++;
	                high--;
	            }
	        }
		  
		  System.out.println("printing rotated  matrix");
		  for(int i=0;i<matrix.length;i++) {
			  System.out.println(Arrays.toString(matrix[i]));
		  }
		  
		  
	}





	//this is a naive solution 
	private static void matrixRotate90(int[][] matrix) {
		
		  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            System.out.println("Matrix is empty or invalid.");
	            return;
	        }
		  

		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		  if (rowCount == 1 && colCount == 1) {
	            System.out.println("Matrix is 1x1, no rotation needed.");
	            System.out.println(matrix[0][0]);
	            return;
	        }
		  
		  if (rowCount == 1) {
	            // Single row, rotate into a column
	            System.out.println("Rotated matrix:");
	            for (int i = 0; i < colCount; i++) {
	                System.out.print(matrix[0][i] + " ");
	            }
	            System.out.println();
	            return;
	        }
		  
		  if (colCount == 1) {
	            // Single column, rotate into a row
	            System.out.println("Rotated matrix:");
	            for (int i = 0; i < rowCount; i++) {
	                System.out.print(matrix[i][0] + " ");
	            }
	            System.out.println();
	            return;
	        }

		// construct a temporary mwtrix to copy every row of orig matrix to last column
		// and all set
		int[][] temp = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				temp[colCount - j - 1][i] = matrix[i][j];
			}
		}

		// copy it back to orig array
		System.out.println("Rotated matrix");
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}

}
