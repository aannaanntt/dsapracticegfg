package sortinggfg;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] arr = { -1, 4, 4, 1, 0, 1 };
		int k = 5;

		countSortNegative(arr);

		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
	
	public static String countingSortString(String arr) {
		
		        int[] count =new int[256];
		        // code here
		        
		  
		        
		        //count occurences of each character
		        for(int i=0;i<arr.length();i++){
		            count[arr.charAt(i)]++;
		        }
		        
		       //sorted String
		       StringBuilder sb = new StringBuilder();
		        for(int i=0;i<256;i++){
		            while(count[i]>0){
		                sb.append((char)i);
		                count[i]--;
		            }
		        }
		        
		        return sb.toString();
		    }
		
	

	public static void countSortNegative(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// +1 kioki ndexing 0
		int range = max - min + 1;
		int shift = -min;
		int count[] = new int[range];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] + shift]++;
		}

		int idx = 0;
		for (int i = 0; i < range; i++) {
			while (count[i] > 0) {
				arr[idx] = i - shift;
				idx++;
				count[i]--;
			}
		}

	}

	// count sort for arbitrary range
	public static void countSortRange(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// +1 kioki ndexing 0
		int range = max - min + 1;
		int count[] = new int[range];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}

		int output[] = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}

		for (int i = 0; i < output.length; i++) {
			arr[i] = output[i];
		}
	}

	public static void countSortEff(int[] arr, int k) {
		int[] count = new int[k]; // Frequency array

		// Initialize count array
		for (int i = 0; i < k; i++) {
			count[i] = 0;
		}

		// Count occurrences of each element
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		// Compute cumulative sums in the count array
		for (int i = 1; i < k; i++) {
			count[i] = count[i] + count[i - 1];
		}

		// Build the output array
		int[] output = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--; // Decrement count for duplicate handling
		}

		// Copy sorted elements back into original array
		for (int i = 0; i < output.length; i++) {
			arr[i] = output[i];
		}
	}

	// naive approach->its inefficient
	private static void countSort(int[] arr, int k) {
		int[] count = new int[k];
		for (int i = 0; i < k; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < arr.length; i++) {
			int ele = arr[i];
			count[ele]++;
		}
		int idx = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < count[i]; j++) {
				arr[idx] = i;
				idx++;
			}
		}

	}

}
