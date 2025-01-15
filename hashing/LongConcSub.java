package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongConcSub {

	
	
	public static void main(String[] args) {
		int [] arr = {1,9,3,4,2,20};
		//o/p ->4 1,2,3,4
		System.out.println(getLongSubOpt(arr));
	}
	
	public static int getLongSubOpt(int[] a) {
		HashSet<Integer> set = new HashSet<>();
		for(int no : a) {
			set.add(no);
		}
		int res =1;
		for(int no : set) {
			if(!set.contains(no-1)) {
				int curr =1;
				while(set.contains(no+curr)) {
					curr ++;
				}
				
				res = Math.max(curr, res);
			}
		}
		
		return res;
	}

	private static void getLongSub(int[] arr) {
		// use sorting so all the elements will come adjacent to each other
		Arrays.sort(arr);
		int res = 1; int curr =1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1]+1) {
				curr++;
			}else if(arr[i]!=arr[i-1]) {
				res = Math.max(res, curr);
				curr =1;
			}
		}
		
		System.out.println(Math.max(res,curr));
		
		
	}
}
