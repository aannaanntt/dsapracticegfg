package hashing;

import java.util.HashSet;

public class IntersectionOfUnsortedArray {
	
	
	public static void main(String[] args) {
		int[] a= {10,15,20,25,30,50};
		int[] b = {30,5,15,80};
		//o/p=> 15,30
		
		printInterOpt(a,b);
	}
	
	//we are using hashing to optimize it
	
	public static void printInterOpt(int[] a,int [] b) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<a.length;i++) {
			set.add(a[i]);
		}
		for(int i=0;i<b.length;i++) {
			if(set.contains(b[i])) {
				System.out.print(b[i]+" ");
			}
		}
	}

	private static void printIntersection(int[] a, int[] b) {
		//print the common element in both the array
		for(int i=0;i<a.length;i++) {
			boolean flag = false;
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j]) {
					flag=true;
					break;
				}
			}
			if(flag) {
				System.out.print(a[i]+" ");
			}
		}
	}
}
