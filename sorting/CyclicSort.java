package sorting;

import java.util.Arrays;

public class CyclicSort {
	
	
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1 };
		System.out.println(Arrays.toString(cycleSort(arr)));
	}
	
	static void swap(int arr[], int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second]=temp;
	}

	private static int[] cycleSort(int[] arr) {
		
		//i=0
		//element=3
		//5-(0-1)
		int i=0;
		while(i<arr.length) {
			int correctIndex=arr[i] - 1;
			if(arr[i] != arr[correctIndex]) {
				swap(arr,i,correctIndex);
			}else {
				i++;
			}
		}
		return arr;
	}

}
