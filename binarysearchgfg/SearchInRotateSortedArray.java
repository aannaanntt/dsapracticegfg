package binarysearchgfg;

public class SearchInRotateSortedArray {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 5, 8, 9 };
		int element = 40;
		System.out.println(getIndexInRotatedBS(arr, element));
	}

	public static int getIndexInRotatedBS(int[] arr, int element) {
		int n = arr.length;
		int start = 0;
		int end = n - 1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(arr[mid]==element)return mid;
			if(arr[mid]>=arr[start]) {
				if(element>=arr[start] && element<arr[mid]) {
					end=mid-1;
				}else {
					start = mid+1;
				}
			}else if(element>arr[mid]&&  element<arr[end]) {
				start =mid+1;
			}else {
				end=mid-1;
			}
		}
		
		return -1;
	}

	private static int getIndexInRotated(int[] arr, int element) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element) {
				return i;
			}
		}

		return -1;
	}
}
