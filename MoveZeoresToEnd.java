package arrays;

import java.util.Arrays;

public class MoveZeoresToEnd {
	
	public static void main(String[] args) {
		int arr[] = {8,5,0,10,20,0};
		System.out.println(Arrays.toString(removeZeroesToEnd(arr)));
	}

	
	
	public static int[] removeZeroesToEnd(int[] arr) {
		int count =0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				swap(arr,i,count);
				count++;
			}
		}
		
		return arr;
	}
	private static int[] removezeroestoEnd(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int curr= arr[i];
			if(curr==0) {
				for(int j=i+1;j<arr.length;j++) {
					if(arr[j]!=0) {
						swap(arr,i,j);
					}
				}
			}
		}
		return arr;
	}

	private static void swap(int arr[],int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

}
