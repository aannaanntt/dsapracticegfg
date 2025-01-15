package matrix;

import java.util.Arrays;
import java.util.Collections;

public class MedianInRowWiseSortedMatrix {
	//odd sized matrix all elements are distinct
	public static void main(String[] args) {
		int[][] matrix = {
				{1,10,20},
				{15,25,35},
				{5,30,40}
		};
		
		
		printMedianEffi(matrix);
	}
	
	public static void printMedianEffi(int[][] matrix) {
		int rowNo=matrix.length;
		int colNo=matrix[0].length;
		int min = matrix[0][0];int max=matrix[0][colNo-1];
		int i=1;
		while(i<rowNo) {
			if(matrix[i][0]>min) min=matrix[i][0];
			if(matrix[i][colNo-1]>max)max=matrix[i][colNo-1];
			i++;
		}
		//we can find median position by below formula
		int medianPos=(rowNo * colNo+1)/2;
		while(min<max) {
			int mid = (min+max) /2; int midPos=0;
			for(int j=0;j<rowNo;j++) {
				int pos= Arrays.binarySearch(matrix[j], mid)+1;
				midPos+=Math.abs(pos);
			}
			
			if(midPos<medianPos) {
				min=min+1;
			}else {
				max=mid;
			}
		}
		
		System.out.println(min);
	}

	private static void printMedianNaive(int[][] matrix) {
		//put all the elements in array
		int row = matrix.length;
		int col = matrix[0].length;
		int [] array = new int [row * col];
		int idx=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				array[idx]=matrix[i][j];
				idx++;
			}
		}
		
		Arrays.sort(array);
		
		System.out.println(array[array.length/2]);
		
	}

}
