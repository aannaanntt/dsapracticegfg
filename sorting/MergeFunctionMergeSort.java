package sorting;

import java.util.Arrays;

public class MergeFunctionMergeSort {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 20, 11, 30 };
		int low = 0;
		int high = arr.length - 1;
		int mid = low + high / 2;
		System.out.println(Arrays.toString(mergeFunc(arr, low, mid, high)));
	}

	// make two arrays left and right such that left contains values less than right
	private static int[] mergeFunc(int[] arr, int low, int mid, int high) {
		int[] left = new int[mid - low + 1];
		int[] right = new int[high - mid];
		for (int i = 0; i < left.length; i++) {
			left[i] = arr[low + i];
		}
		for (int j = 0; j < right.length; j++) {
			right[j] = arr[mid + j + 1];
		}

		int i = 0;
		int j = 0;
		int k = low;
		while (i < left.length && j < right.length) {
			if(left[i]<=right[j]) {
				arr[k] = left[i];
				i++;
				k++;
			}else {
				arr[k]=right[j];
				j++;k++;
			}
		}
		
		while(i<left.length) {arr[k]=left[i]; i++;k++;}
		while(j<right.length) {arr[k]=right[j];j++;k++;}

		return arr;
	}

}
