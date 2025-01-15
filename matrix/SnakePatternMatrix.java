package matrix;

public class SnakePatternMatrix {
	
	public static void main(String[] args) {
		int [][] matrix = {
				{1,2,3},//row=0
				{4,5,6},//row=1
				{7,8,9}//row=2
		};
		
		printSnake(matrix);
	}
		
		
		public static void printSnake(int[][] matrix) {
			int rowsNo=matrix.length;
			int row_pointer=0;
			while(row_pointer<rowsNo) {
				if(row_pointer%2==0) {
					int colNo= matrix[row_pointer].length;
					int col_pointer=0;
					while(col_pointer<colNo) {
						System.out.print(matrix[row_pointer][col_pointer]+" ");
						col_pointer++;
					}
					System.out.println();
				}
					
				else {
					int col_pointer = matrix[row_pointer].length-1;
					while(col_pointer>=0) {
						System.out.print(matrix[row_pointer][col_pointer]+" ");
						col_pointer--;
					}
					System.out.println();
				}
				
				row_pointer++;
			}
		
	}
}
