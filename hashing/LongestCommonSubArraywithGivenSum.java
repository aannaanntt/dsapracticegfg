package hashing;

import java.util.HashMap;

public class LongestCommonSubArraywithGivenSum {
	
	public static void main(String[] args) {
		int a[] = {0,1,0,0,0,0};
		int b[] = {1,0,1,0,0,1};
		System.out.print(maxCommonOpt(a,b));
		
	}
	
	public static int maxCommonOpt(int[] a,int[] b) {
		//compute a difference array 
		int [] temp = new int[a.length];
		for(int i=0;i<temp.length;i++) {
			temp[i]= a[i]- b[i];
		}
		// now return the length of longest subarray with 0 sum
		
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		int pre_sum=0; int res = 0; 
		for(int i =0;i<temp.length;i++) {
			pre_sum+=temp[i];
			
			if(map.containsKey(pre_sum)) {
				int len = i - map.get(pre_sum);
				res = Math.max(res, len);
			}
			
			map.putIfAbsent(pre_sum, i);
		}
		
		return res;
	}

	private static int maxCommon(int[] a, int[] b) {
	 int res =0;
		for(int i=0;i<a.length;i++) {
			int sum1=0;int sum2=0;
			for(int j=i;j<b.length;j++) {
				sum1+=a[j];
				sum2+=b[j];
				
				if(sum1==sum2) {
					res = Math.max(res, j-i+1);
				}
			}
		}
		return res;
		
	}

}
