package hashing;

import java.util.HashMap;

public class MaxLengthSubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = {10, 5, 2, 7, 1 ,-10,
				15};
		int sum=15;
		System.out.println(maxLeng(arr,sum));
	}
	
	public static int maxLeng(int[] a , int sum) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int pre_sum=0; int res =0;
		for(int i=0;i<a.length;i++) {
			pre_sum+=a[i];
			if(!map.containsKey(pre_sum)) {
				map.put(pre_sum, i);
			}
			
			if(pre_sum==sum) {
				res = i +1;
			}
			if(map.containsKey(pre_sum-sum)) {
				int len = i - map.get(pre_sum-sum);
				res = Math.max(res, len);
			}
			
		}
		
		return res;
	}

	private static int maxLenSub(int[] arr,int sum) {
		int res= 0;
		for(int i=0;i<arr.length;i++) {
			int curr_sum=0;
			for(int j=i;j<arr.length;j++) {
				curr_sum+=arr[j];
				if(curr_sum==sum) {
					res = Math.max(res, j-i+1);
				}
			}
		}
		return res;
		
	}
}
