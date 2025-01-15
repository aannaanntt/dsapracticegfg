package hashing;

import java.util.HashMap;

public class CountDistinctInEveryWindow {
	
	public static void main(String[] args) {
		int arr[] = {10,20,20,10,30,40,10};
		int k = 4; 
		
		countDistInWindowOpt(arr,k);
	}
	
	
	public static void countDistInWindowOpt(int[] a, int k) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int n= a.length;
		//add every number to hashmap 
		int distCount=0;
		for(int i=0;i<k;i++) {
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
			if(map.get(a[i])==1) {
				distCount++;
			}
		}
		
		System.out.print(distCount+" ");
		
		//process the remaining window
		for(int j=k;j<n;j++) {
			int outgoing= a[j-k];
			if(map.get(outgoing)==1) {
				distCount--;
			}
			
			map.put(outgoing, map.get(outgoing)-1);
			if(map.get(outgoing)==0) {
				map.remove(outgoing);
			}
			
			int incoming = a[j];
			map.put(incoming, map.getOrDefault(incoming, 0)+1);
			if(map.get(incoming)==1) {
				distCount++;
			}
			System.out.print(distCount+" ");
		}
		
	
	}

	
		
	private static void countDistInWindow(int[] arr, int k) {
	    int n = arr.length;

	    // Loop for each window of size k
	    for (int i = 0; i <= n - k; i++) {
	        int distCount = 0; // Count of distinct elements in the current window

	        // Loop through each element in the current window
	        for (int j = i; j < i + k; j++) {
	            boolean isDistinct = true; // Assume the element is distinct

	            // Check if the element appears before in the current window
	            for (int p = i; p < j; p++) { // Only check previous elements
	                if (arr[p] == arr[j]) {  // Duplicate found
	                    isDistinct = false;
	                    break;
	                }
	            }

	            // If the element is distinct, increment the count
	            if (isDistinct) {
	                distCount++;
	            }
	        }

	        // Print distinct count for the current window
	        System.out.print(distCount + " ");
	    }
	}


}
