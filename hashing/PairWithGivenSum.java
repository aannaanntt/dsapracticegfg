package hashing;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {
	
	
	public static void main(String[] args) {
		int[] a= {3,2,8,15,-8};
		int sum = 17;
		System.out.print(isPair(a,sum));
	}
	
	//use hashset
	public static boolean isPair(int[] a,int sum) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<a.length;i++) {
			if(set.contains(sum-a[i]))
				return true;
			else
				set.add(a[i]);
		}
		return false;
		
	}

	private static boolean checkSum(int[] a, int sum) {
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]+a[j]==sum) {
					return true;
				}
			}
		}
		return false;
		
	}
}
