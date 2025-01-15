package binarysearchgfg;

public class SearchInfiniteArray {

	
	public static void main(String[] args) {
		int[] arr= {1,10,15,20,40,80,90,100,120,500};
		int element=10;
		System.out.println(getFromInfiniteArray(arr,element));
		
	}

	private static int getFromInfiniteArray(int[] arr, int element) {
		if(arr[0]==element) return 0;
		int i=1;
		while(arr[i]<element)
			i=2*i;
		if(arr[i]==element)return i;
			
		return binarySearch(arr, element, (i/2)+1, i);
	}
	
	public static int binarySearch(int[]arr,int target,int start,int end) {
		while(start<=end) {
			int mid = start + (end - start)/2;
			if(arr[mid]==target)return mid;
			if(arr[mid]>target) end=mid-1;
			if(arr[mid]<target)start=mid+1;
		}
		
		return-1;
	}
}
