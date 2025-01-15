package matrix;

public class MatrixI {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2 ,3}, { 4, 5, 6 } };

		printMatRec(matrix, 0, 0);
	}

	private static void printMatRec(int[][] matrix, int row, int col) {
		if (row >= matrix.length)
			return;
		if (col < matrix[row].length) {
			System.out.print(matrix[row][col]);
			printMatRec(matrix, row, col + 1);
		} else if (row < matrix.length) {
			System.out.println();
			printMatRec(matrix, row + 1, 0);

		}

	}

	private static void printFor(int[][] matrix) {
		int row = matrix.length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void printMat(int[][] matrix) {
		int row = matrix.length;

		int row_pointer = 0;
		while (row_pointer < row) {
			int col = matrix[row_pointer].length;
			int col_pointer = 0;
			while (col_pointer < col) {
				System.out.print(matrix[row_pointer][col_pointer] + " ");
				col_pointer++;
			}

			System.out.println();
			row_pointer++;
		}

	}
}
