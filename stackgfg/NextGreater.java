package stackgfg;

import java.util.ArrayDeque;

public class NextGreater {
	
	public static void main(String[] args) {
		int [] arr = {5,15,10,8,6,12,9,18};
		printNextGreaterArrayDeque(arr);
	}

	private static void printNextGreaterArrayDeque(int[] arr) {
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		for(int i=arr.length-1;i>=0;i--) {
			
			while(!ad.isEmpty() && arr[i] >= ad.peek()) {
				ad.pop();
			}
			
			int ng = ad.isEmpty() ? -1 : ad.peek();
			System.out.print(ng+" ");
			 
			ad.push(arr[i]);
		}
		
	}

	private static void printNextGreater(int[] arr) {
		int n =arr.length;
		for(int i=n-1;i>=0;i--) {
			int next_greater=-1;
			for(int j=i+1;j<n;j++) {
				if(arr[j] > arr[i]) {
					next_greater = arr[j];
					break;
				}
			}
			
			System.out.print(next_greater+" ");
		}
		
	}

}
