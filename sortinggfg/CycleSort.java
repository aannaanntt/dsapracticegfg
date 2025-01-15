package sortinggfg;

import java.util.Arrays;

public class CycleSort {

	public static void main(String[] args) {
		int[] arr = { 20, 40, 50, 50, 10, 30 };

		System.out.println(cycleSortNoOfSwaps(arr));
	}

	static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	
	public static int cycleSortNoOfSwaps(int[] arr) {
	    int swaps = 0;

	    // Traverse the array to find cycles
	    for (int cs = 0; cs < arr.length - 1; cs++) {
	        int curr_ele = arr[cs];
	        int current_element_pos = cs;

	        // Find the correct position for the current element
	        for (int i = cs + 1; i < arr.length; i++) {
	            if (arr[i] < curr_ele) {
	                current_element_pos++;
	            }
	        }

	        // Skip if the current element is already in the correct position
	        if (current_element_pos == cs) continue;

	        // Skip duplicates to avoid unnecessary swaps
	        while (curr_ele == arr[current_element_pos]) {
	            current_element_pos++;
	        }

	        // If the element needs to be swapped
	        if (current_element_pos != cs) {
	            swap(arr, current_element_pos, cs);
	            swaps++;
	        }

	        // Rotate the remaining cycle
	        while (current_element_pos != cs) {
	            current_element_pos = cs;

	            // Find the correct position for the element
	            for (int j = cs + 1; j < arr.length; j++) {
	                if (arr[j] < arr[current_element_pos]) {
	                    current_element_pos++;
	                }
	            }

	            // Skip duplicates
	            while (curr_ele == arr[current_element_pos]) {
	                current_element_pos++;
	            }

	            // If the element is at the correct position, continue rotating
	            if (arr[current_element_pos] != curr_ele) {
	                swap(arr, current_element_pos, cs);
	                swaps++;
	            }
	        }
	    }

	    return swaps;
	}
	// Cycle Sort function to sort the array
	private static int[] cycleSort(int[] arr) {
		// Traverse the array to find cycles
		for (int cs = 0; cs < arr.length - 1; cs++) {
			int curr_ele = arr[cs];

			// Find the correct position for current element
			int pos = cs;
			for (int i = cs + 1; i < arr.length; i++) {
				if (arr[i] < curr_ele) {
					pos++;
				}
			}

			// If current element is already in the correct position, skip it
			if (pos == cs)
				continue;

			while (curr_ele == arr[pos])
				pos += 1;

			// Otherwise, put the current element to its correct position
			if (pos != cs) {
				swap(arr, pos, cs);
			}

			// Rotate the remaining elements in the cycle
			while (pos != cs) {
				pos = cs;

				// Find the correct position for the element
				for (int j = cs + 1; j < arr.length; j++) {
					if (arr[j] < arr[cs]) {
						pos++;
					}
				}

				// Avoid unnecessary swap if the element is already at the correct position
				while (curr_ele == arr[pos]) {
					pos++;
				}

				// Swap the element to its correct position
				if (curr_ele != arr[pos]) {
					swap(arr, pos, cs);
				}
			}
		}
		return arr;
	}
}
