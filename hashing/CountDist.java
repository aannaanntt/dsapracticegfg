package hashing;

import java.util.HashSet;

public class CountDist {
	
	public static int countDistOpt(int[] arr) {
		//use set only distinct elements will be entered in it
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			set.add(arr[i]);
		}
		
		System.out.println(set.size());
		return set.size();
	}
	public static void countDist(int[] arr) {
		int n = arr.length;
		int count=0;
		for(int i=0;i<n;i++) {
			boolean isRepeated=false;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					isRepeated=true;
					break;
				}
			}
			
			if(!isRepeated)
				count++;
			
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		int [] arr = {15,12,13,12,13,13,18};
		countDistOpt(arr);
	}

}
