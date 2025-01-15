package binarysearchgfg;

import java.util.Arrays;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int[] array1 = { 10, 20, 30, 40, 50 };
		int[] array2 = { 5, 15, 25, 35, 45 };
		System.out.println(medianOfBothArray(array1, array2));

	}

	public static int getMedianBS(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;

		// Ensure the first array is the smaller one for simplicity
		if (m > n) {
			return getMedianBS(array2, array1);
		}

		int begin = 0;
		int end = m;

		while (begin <= end) {
			int partitionA = begin + (end - begin) / 2;
			int partitionB = (m + n + 1) / 2 - partitionA;

			// Handle edge cases for array boundaries
			int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : array1[partitionA - 1];
			int minRightA = (partitionA == m) ? Integer.MAX_VALUE : array1[partitionA];

			int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : array2[partitionB - 1];
			int minRightB = (partitionB == n) ? Integer.MAX_VALUE : array2[partitionB];

			// Check if we've found the correct partitions
			if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
				// If total length is even, return the average of the middle two elements
				if ((m + n) % 2 == 0) {
					return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
				}
				// If total length is odd, return the max of the left side
				else {
					return Math.max(maxLeftA, maxLeftB);
				}
			}
			// Adjust partitions based on conditions
			else if (maxLeftA > minRightB) {
				end = partitionA - 1; // Move left in array1
			} else {
				begin = partitionA + 1; // Move right in array1
			}
		}

		// If arrays are not valid, return an error (shouldn't occur with valid input)
		throw new IllegalArgumentException("Input arrays are not sorted or are invalid.");
	}

	private static int medianOfBothArray(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;
		int temp[] = new int[m + n];
		int tmplngth = temp.length;
		for (int i = 0; i < m; i++) {
			temp[i] = array1[i];
		}
		int start = m; // Start where array1 ends
		int k = 0;
		for (int j = start; j < tmplngth; j++) {
			temp[j] = array2[k];
			k++; // Increment k to copy subsequent elements
		}

		Arrays.sort(temp);
		if (temp.length % 2 != 0) {
			return temp[temp.length / 2];
		}
		int mid = temp[temp.length / 2];
		int midsepehla = temp[temp.length / 2 - 1];
		return (mid + midsepehla) / 2;
	}

}
