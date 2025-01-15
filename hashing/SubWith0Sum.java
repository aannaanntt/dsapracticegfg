package hashing;

import java.util.HashSet;

public class SubWith0Sum {
	
	public static void main(String[] args) {
		int [] a = {4,-3,2,1};
		System.out.println(subWith0Sum1(a));
	}
	
	
	//use prefix sum and hashing  to get the answer
	public static boolean subWith0Sum1(int[] a) {
		HashSet<Integer> set = new HashSet<>();
		int pre_sum=0;
		for(int integer : a) {
			pre_sum+=integer;
			if(pre_sum==0)return true;
			if(set.contains(pre_sum))
				return true;
			
			set.add(pre_sum);
			
		}
		
		return false;
	}

	private static boolean subWith0Sum(int[] a) {
		//consider every sub array and take sum if it reaches 0 than return true
		for(int i=0;i<a.length;i++) {
			int curr_sum =0 ;
			for(int j=i;j<a.length;j++) {
				curr_sum+=a[j];
				
				if(curr_sum==0)return true;
			}
		}
		return false;
		
	}
}
