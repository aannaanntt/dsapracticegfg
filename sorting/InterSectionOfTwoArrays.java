package sorting;

import java.util.Arrays;

public class InterSectionOfTwoArrays {

	public static void main(String[] args) {
		int array1[] = { 3, 5, 10, 10, 10, 15, 15, 20 };
		int array2[] = { 5, 10, 10, 15, 30 };
		// o/p ->5,10,15

		printUnionNaive(array1, array2);
	}

	public static void printUnionNaive(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;
		int[] temp = new int[m + n];
		for(int i=0;i<m;i++) {
			temp[i]=array1[i];
		}
		for(int j=0;j<n;j++) {
			temp[m+j]=array2[j];
		}
		
		Arrays.sort(temp);
		for(int i=0;i<temp.length;i++) {
			if(i==0 || temp[i]!=temp[i-1]) {
				System.out.print(temp[i]+" ");
			}
		}
	}

	private static void printIntersection(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (i > 0 && array1[i] == array1[i - 1]) {
				i++;
				continue;
			}
			if (array1[i] < array2[j]) {
				i++;
			} else if (array2[j] < array1[i]) {
				j++;
			} else if (array1[i] == array2[j]) {
				System.out.print(array1[i] + " ");
				i++;
				j++;
			}
		}

		while (i < m) {

			if (i > 0 && array1[i] == array1[i - 1]) {
				i++;
				continue;
			}
			System.out.print(array1[i]);
			i++;
		}
		while (j < n) {
			if (j > 0 && array2[j] == array2[j - 1]) {
				j++;
				continue;
			}
			System.out.print(array2[j]);
			j++;
		}
	}

}
