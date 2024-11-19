package arrays;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 0, 1, 0 };
		System.out.println(getMax1Count(arr));
	}

	
	
	
	public static int getMaxCountOneOpt(int[] arr) {
		int res =0; int cur=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				cur=0;
			}else {
				cur++;
				res = Math.max(res, cur);
			}
			
			
		}
		return res;
	}
	//o(n2)
	private static int getMax1Count(int[] arr) {
		int n = arr.length;
	
		int max=1;
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=i;j<n;j++) {
				if(arr[j]==1) {
					count++;
				}else {
					break;
				}
			}
			
			max = Math.max(max, count);
		}
		
		return max;
		
	}

}
