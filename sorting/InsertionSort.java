package sorting;

import java.util.Arrays;

public class InsertionSort {

	//3,5,4,1,2
	//3,4,5,1,2
	//3,4,1,5,2
	//3,1,4,5,2
	//1,3,4,5,2
	//1,2,3,4,5
	public static void main(String[] args) {
		int[] arr = {5,3,4,1,2};
		System.out.println(Arrays.toString(insertionSort(arr)));
	}
	
	static void swap(int arr[], int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second]=temp;
	}

	private static int[] insertionSort(int[] arr) {
		for(int i=0;i<=arr.length-2;i++) {
			for(int j=i+1; j>0;j--) {
				if(arr[j]<arr[j-1]) {
					swap(arr,j,j-1);
				}else {
					break;
				}
			}
		}
		return arr;
	}
}
