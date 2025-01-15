package matrix;

import java.util.Arrays;

public class MatrixTranspose {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 },{7,8,9} };

		printTransposeEiifient(matrix);//travelk in the upper half of the matrix and swap it with lower half to get in place transpose
		printMatrix(matrix);
	}

	private static void printTransposeEiifient(int[][] matrix) {
		int row = matrix.length;
        
        // Only loop through the upper triangle excluding the diagonal (i < j)
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
	}
        
        
        public static void printMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
    }


	

	private static void swap(int[] array, int first, int second) {
		int temp =array[first];
		array[first]=array[second];
		array[second]=temp;
	}

	private static void printTransposeNaive(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		// Handle single-row matrix
		if (row == 1) {
			int[][] transpose = new int[col][1];
			for (int i = 0; i < col; i++) {
				transpose[i][0] = matrix[0][i];
			}

			// Print the transpose
			System.out.println("Transpose of the single-row matrix:");
			for (int i = 0; i < transpose.length; i++) {
				System.out.println(Arrays.toString(transpose[i]));
			}
			return;
		}

		// Handle single-column matrix
		if (col == 1) {
			int[][] transpose = new int[1][row];
			for (int i = 0; i < row; i++) {
				transpose[0][i] = matrix[i][0];
			}

			// Print the transpose
			System.out.println("Transpose of the single-column matrix:");
			System.out.println(Arrays.toString(transpose[0]));
			return;
		}

		// Handle general rectangular matrix
		int[][] transpose = new int[col][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				transpose[j][i] = matrix[i][j];
			}
		}

		// Print the transpose
		System.out.println("Transpose of the general matrix:");
		for (int i = 0; i < transpose.length; i++) {
			System.out.println(Arrays.toString(transpose[i]));
		}
	}
}