package sortinggfg;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] array1 = { 10, 15, 20 };
		int[] array2 = { 5, 6, 6, 15 };

		// O/P 5,6,6,10,15,15,20
		//System.out.println(Arrays.toString(mergedArray(array1, array2)));
		getMergedArrayOpt(array1,array2);
	}

	public static void getMergedArrayOpt(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (array1[i] <= array2[j]) {
				System.out.print(array1[i]+" ");
				i++;
			} else if (array1[i] >= array2[j]) {
				System.out.print(array2[j]+" ");
				j++;
			}
			
			
		}
		
		while(i<m) {System.out.println(array1[i]);i++;}
		while(j<n) {System.out.println(array2[j]); j++;}
	}

	// this is o(m+n) * log(m+n)
	private static int[] mergedArray(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;
		int[] temp = new int[m + n];
		for (int i = 0; i < m; i++) {
			temp[i] = array1[i];
		}
		for (int j = 0; j < n; j++) {
			temp[m + j] = array2[j];
		}
		Arrays.sort(temp);
		return temp;
	}

}
