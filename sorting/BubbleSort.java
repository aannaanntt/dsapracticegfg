package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {41 ,9 ,9 ,48, 11, 2 ,11 ,12 ,28 ,10 ,15 ,4 ,16, 48};
		System.out.println(Arrays.toString(bubbleSort(arr)));
	}

	private static int[] bubbleSort(int[] arr) {
		boolean swapped;

		for (int i = 0; i < arr.length; i++) {
			swapped = false;
			// for each step, max item will come at last of the index

			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					swapped = true;
				}

				// if you didnt swapped for a particular value of i it means array is soted
				
				}
			
			// hence stop the program
			if (!swapped) {
				break;

			}

		}
		return arr;
	}

}
