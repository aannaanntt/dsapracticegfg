package arrays;

import java.util.Arrays;

public class SecondLargest {

	public static void main(String[] args) {
		int arr[] = {  5, 8, 20 };
		System.out.println(getSecondLargestOptimized(arr));
	}
	
	
	public static int getSecondLargestOptimized(int arr[]) {
		int largest=0; int secondLargest =-1;
		for(int i=1;i<arr.length;i++) {
			if(arr[largest]<arr[i]) {
				secondLargest = largest;
				largest =i;
			}else if(arr[i]!=arr[largest]) {
				if(secondLargest ==-1 || arr[i]>arr[secondLargest]) {
					secondLargest=i;
				}
			}
		}
		
		   return secondLargest == -1 ? -1 : arr[secondLargest];
	}

	
	//not good approach it require more time
	private static int getSecondLargest(int[] arr) {
		int maxElement = getLargest(arr);
		System.out.println(maxElement);
		int second_largest = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != maxElement) {
				if (second_largest == -1) {
					second_largest = i;
				} else if (arr[i] > arr[second_largest]) {
					second_largest = i;
				}
			}
		}

		return arr[second_largest];
	}

	public static int getLargest(int[] arr) {
		int maxElement = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxElement) {
				maxElement = arr[i];
			}
		}
		return maxElement;

	}

}
