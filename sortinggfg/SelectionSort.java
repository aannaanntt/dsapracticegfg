package sortinggfg;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 8, 20, 2, 18};
		
		System.out.println(Arrays.toString(selectionSort(arr)));
	}

	private static int[] selectionSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int mid_idx=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[mid_idx]) {
					swap(arr,mid_idx,j);
				}
			}
		}
		return arr;
	}
	
	

	
	public static void swap(int[] arr,int first,int second) {
		int temp = arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
	}
}
