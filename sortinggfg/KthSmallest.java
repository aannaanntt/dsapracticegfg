package sortinggfg;

import java.util.Arrays;

public class KthSmallest {
	
	public static void main(String[] args) {
		int[] array = {12, 3, 5, 7, 19, 4, 2};
	    int k = 3;
		System.out.println(getKthLargestOpt(array,k));
	}
	
	
	public static int getKthLargestOpt(int[] array, int k) {
	    int low = 0;
	    int high = array.length - 1;
	    int target =  array.length-k; // Convert k-th largest to (n-k)-th smallest

	    while (low <= high) {
	        // Perform Lomuto partition and get pivot index
	        int p = lomuto_partition(array, low, high);

	        // Check if the pivot index is the (n-k)-th smallest element
	        if (p == target) {
	            return array[p];  // Return the k-th largest element
	        } else if (p > target) {
	            high = p - 1;  // Search the left side
	        } else {
	            low = p + 1;   // Search the right side
	        }
	    }

	    return -1;  // If k is out of bounds
	}

	
	
	static void swap(int[] array , int first_element,int second_element) {
		int temp = array[first_element];
		array[first_element]=array[second_element];
		array[second_element]=temp;
	}
	
	public static int lomuto_partition(int[] array , int low_pointer,int high_pointer) {
		int i = low_pointer-1;
		int pivot = array[high_pointer];
		for(int j=low_pointer;j<high_pointer;j++) {
			if(array[j]<=pivot) {
				i++;
				swap(array,i,j);
			}
			
		}
		
		swap(array,i+1,high_pointer);
		System.out.println(Arrays.toString(array));
		return i+1;
		
	}
	// partition the array use Lomuto partiton to find kthsmallest
	public static int getKthSmallestOpt(int[] array, int k) {
		int low=0; int high = array.length-1;
		while(low<=high) {
			int p = lomuto_partition(array,low,high);
			if(p==k-1) {
				return p;
			}else if(p>k-1) {
				high=p-1;
			}else {
				low =p+1;
			}
		}
		return -1;
	}

	private static int getKethSmallest(int[] array, int k) {
		Arrays.sort(array);
		return array[k-1];
	}

}
