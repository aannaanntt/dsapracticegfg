package sortinggfg;

import java.util.Arrays;

public class MeetingMaxGuest {
	
	public static void main(String[] args) {
		int[] arr= {800,700,600,500};
		int[] dep= {840,820,830,530};
		
		System.out.println(meetMaxGuest(arr,dep));
	}
	
	
	

	private static int meetMaxGuest(int[] arr, int[] dep) {
		Arrays.sort(arr);;
		Arrays.sort(dep);;
		int res =1; int i=1; int j=0;int curr_guest=1;
		while(i<arr.length && j<dep.length) {
			if(arr[i]<=dep[j]) {
				curr_guest++;
				i++;
			}else {
				curr_guest--;
				j++;
			}
			
			res = Math.max(res, curr_guest);
		}
		
		return res;
	}

}
