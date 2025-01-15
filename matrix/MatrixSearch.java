package matrix;

public class MatrixSearch {

	
	public static void main(String[] args) {
		int matrix[] [] = {
				{10,20,30,40},
				{15,25,35,45},
				{32,33,39,50}
		};
		int elementToSearch = 25;
		searchMatrix(matrix,elementToSearch);
	}

	private static void searchMatrix(int[][] matrix,int element) {
		if(matrix==null)return;
		int row= matrix.length;
		int col=matrix[0].length;
		
		//start either from top right or from bottom left 
		int i=0;int j=col-1;
		while(i<=row && j>=0) {
			if(matrix[i][j]==element) {
				System.out.println("Found at position"+" "+i+" "+j);
				return;
			}else if(matrix[i][j]>element) {
				j--;
			}else {
				i++;
			}
		}
		
		
	}
}
