package hashing;

import java.util.HashMap;

public class LongestSubArrayWithEqual0And1 {

	
	
	public static void main(String[] args) {
		int arr[]  = {1,0,1,1,1,0,0};
		System.out.println(calculateCount(arr));
	}
	
	public static int calculateCountOpt(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				a[i]=-1;
			}
			
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		int pre_sum=0;int res =0;
		map.put(0, 1);
		for(int i=0;i<a.length;i++) {
			pre_sum+=a[i];
			 if (map.containsKey(pre_sum)) {
	                res += map.get(pre_sum); // Add the frequency of the same sum to the result
	            }
	            
	            // Add/update the frequency of the cumulative sum in the map
	            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
	        }
	        
	        return res; // Return the count o
				
		}
	

	//in this approach wwe are considering every sub array better approach will be hashing
	private static int calculateCount(int[] arr) {
		int res=0;
		for(int i=0;i<arr.length;i++) {
			int count_0=0;int count_1=0;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]==1) {
					count_1++;
				}else {
					count_0++;
				}
				
				if(count_1 == count_0) {
					res = Math.max(res, count_1+count_0);
				}
			}
		}
		
		return res;
		
	}
}
