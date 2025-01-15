package hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithGivenSum {
	
	public static void main(String[] args) {
		int a[] = {5,8,6,13,3,-1};
		int sum = 22; 
		
		System.out.println(isSum(a,sum));
	}
	
	//use hashing and pre_sum top find subarray with goven sum
	public static boolean isSum(int[] a,int sum) {
		Set<Integer> set = new HashSet<>();
		int pre_sum=0;
		for(int i: a) {
			pre_sum+=i;
			if(pre_sum==sum) return true;
			if(set.contains(pre_sum-sum)) {
				return true;
			}
			set.add(pre_sum);
		}
		
		return false;
	}

	private static boolean checkSubArray(int[] a, int sum) {
		for(int i=0;i<a.length;i++) {
			int pre_sum=0;
			for(int j=i;j<a.length;j++) {
				pre_sum+=a[j];
				if(pre_sum==sum)return true;
				
			}
		}
		
		return false;
		
	}

}
