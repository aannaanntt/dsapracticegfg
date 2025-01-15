package matrix;

public class MatBoundaryTraversal {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		printBoundaryTraversal(matrix);
	}

	private static void printBoundaryTraversal(int[][] matrix) {
	    int rowNo = matrix.length;
	    int colNo = matrix[0].length;

	    // Special case: Single row
	    if (rowNo == 1) {
	        int col = 0;
	        while (col < colNo) {
	            System.out.print(matrix[0][col] + " ");
	            col++;
	        }
	        System.out.println();
	        return;
	    }

	    // Special case: Single column
	    if (colNo == 1) {
	        int row = 0;
	        while (row < rowNo) {
	            System.out.print(matrix[row][0] + " ");
	            row++;
	        }
	        System.out.println();
	        return;
	    }

	    int rowPointer = 0, colPointer = 0;

	    // 1. Top row
	    while (colPointer < colNo) {
	        System.out.print(matrix[rowPointer][colPointer] + " ");
	        colPointer++;
	    }

	    // 2. Right column
	    colPointer = colNo - 1;
	    rowPointer++;
	    while (rowPointer < rowNo) {
	        System.out.print(matrix[rowPointer][colPointer] + " ");
	        rowPointer++;
	    }

	    // 3. Bottom row
	    rowPointer = rowNo - 1;
	    colPointer = colNo - 2;
	    while (colPointer >= 0) {
	        System.out.print(matrix[rowPointer][colPointer] + " ");
	        colPointer--;
	    }

	    // 4. Left column
	    colPointer = 0;
	    rowPointer = rowNo - 2;
	    while (rowPointer > 0) {
	        System.out.print(matrix[rowPointer][colPointer] + " ");
	        rowPointer--;
	    }

	    System.out.println();
	}

}
