package sorting;

public class CountInversions {
	
	public static void main(String[] args) {
		int[] array = {2,4,1,3,5};
		System.out.print(countInversionsRec(array,0,array.length-1));
	}
	
	
	
	//use recursion it's same like merge sort idea is simple
	public static int countInversionsRec(int [] array,int low_pointer,int hight_pointer) {
		int res=0;
		if(low_pointer<hight_pointer) {
			int mid = low_pointer+(hight_pointer-low_pointer)/2;
			res=res + countInversionsRec(array,low_pointer,mid);
			res= res + countInversionsRec(array, mid+1, hight_pointer);
			res = res + countAndMerge(array,low_pointer,mid,hight_pointer);
		}
		
		return res;
	}
	
	
	
	private static int countAndMerge(int[] array, int low_pointer, int mid, int high_pointer) {
	    // Create temporary arrays to store left and right subarrays
	    int[] left = new int[mid - low_pointer + 1];
	    int[] right = new int[high_pointer - mid];
	    
	    // Copy data into left and right subarrays
	    for (int i = 0; i < left.length; i++) {
	        left[i] = array[low_pointer + i]; // Copy from low_pointer to mid
	    }
	    for (int j = 0; j < right.length; j++) {
	        right[j] = array[mid + 1 + j]; // Copy from mid+1 to high_pointer
	    }
	    
	    int res = 0; // To count the number of inversions
	    int i = 0, j = 0, k = low_pointer; // i: for left, j: for right, k: for original array
	    
	    // Merge the two subarrays and count inversions
	    while (i < left.length && j < right.length) {
	        if (left[i] <= right[j]) {
	            array[k] = left[i];
	            i++;
	        } else {
	            array[k] = right[j];
	            res += (left.length - i); // All remaining elements in the left array form inversions with right[j]
	            j++;
	        }
	        k++;
	    }
	    
	    // Copy remaining elements from left (if any)
	    while (i < left.length) {
	        array[k] = left[i];
	        i++;
	        k++;
	    }
	    
	    // Copy remaining elements from right (if any)
	    while (j < right.length) {
	        array[k] = right[j];
	        j++;
	        k++;
	    }
	    
	    return res;
	}



	//but this code is o(n2) we can do better than it
	private static int  countInversions(int[] array) {
		int n =array.length;
		int i=0;
		int count_inversion=0;
		while(i<n) {
			int j=i+1;
			while(j<n) {
				if(array[i]>array[j]) {
					count_inversion++;
				}
				
				j++;
			}
			i++;
		}
		
		return count_inversion;
	}

}
