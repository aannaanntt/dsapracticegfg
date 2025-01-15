package binarysearchgfg;

import java.util.Arrays;

public class RepeatingElement {

	public static void main(String[] args) {
		int[] arr = { 0,2, 1, 3, 2, 2, };
		System.out.println(cycleDetectionWith0InInput(arr));
	}
	
	// duplicates
		public static int cycleDetectionWith0InInput(int[] arr) {
			int slow = arr[0]+1;
			int fast = arr[0]+1;
			do {
				slow = arr[slow]+1;
				fast = arr[arr[fast]+1]+1;
			} while (slow != fast);
			slow = arr[0]+1;
			while (slow != fast) {
				slow = arr[slow]+1;
				fast = arr[fast]+1;
			}

			return slow-1;
		}


	// usefloyd detection mechanism if array sorted and all the elements from 1to
	// mac(arr) are present
	// take 2 pointers slow and fast
	// move slow one step at a timne and fast steps if they meet than we have
	// duplicates
	public static int cycleDetection(int[] arr) {
		int slow = arr[0];
		int fast = arr[0];
		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
		} while (slow != fast);
		slow = arr[0];
		while (slow != fast) {
			slow = arr[slow];
			fast = arr[fast];
		}

		return slow;
	}

	// make a boolean array of same size
	// traverse throught aray and mark true if elment is present on that elements
	// index on boolean array
	// ifg already true returne;
	public static int getRepeatedSortedNaive(int[] arr) {
		boolean[] isVisited = new boolean[arr.length];
		Arrays.fill(isVisited, false);
		for (int i = 0; i < arr.length; i++) {
			if (isVisited[arr[i]]) {
				return arr[i];
			}
			isVisited[arr[i]] = true;
		}
		return -1;
	}

	public static int getRepeatedSorted(int[] arr) {
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				return arr[i];
			}
		}
		return -1;
	}

	// negate it
	public static int repeatedElement(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// Check if the value at index Math.abs(arr[i]) has already been negated
			if (arr[Math.abs(arr[i])] < 0) {
				return Math.abs(arr[i]); // Return the absolute value of the repeated element
			} else {
				// Negate the value at index Math.abs(arr[i])
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
		}
		return -1; // Return -1 if no repeated element is found
	}

	private static int repeatedElements(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return arr[j];
				}
			}
		}
		return -1;
	}

}
