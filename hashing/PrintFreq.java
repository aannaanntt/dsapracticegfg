package hashing;

import java.util.HashMap;
import java.util.Map;

public class PrintFreq {
	
	
	public static void main(String[] args) {
		int[] arr= {10,12,10,15,10,20,12,12};
		printFreqOpt(arr);
	}

	private static void printFreqOpt(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i : arr) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
	}

	private static void printFreq(int[] arr) {
		//one lo
		int n = arr.length;
	
		for(int i=0;i<arr.length;i++) {
			boolean flag = false;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					flag =true;
					break;
				}
			}
			if(flag)
				continue;
			int freq=1;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					freq++;
				}
			
				
			}
			
			System.out.println(arr[i]+" "+freq);
		}
		

	}

}
