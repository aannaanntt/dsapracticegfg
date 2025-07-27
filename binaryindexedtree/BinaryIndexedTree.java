package binaryindexedtree;

public class BinaryIndexedTree {
	
	int [] bit;
	int n;
	public BinaryIndexedTree(int n) {
		// TODO Auto-generated constructor stub
		this.bit = new int[n+1];
	}
	public void buildTree(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			update(i,arr[i]);
		}
	}
	
	public void update(int idx,int ele) {
		idx++;
		while(idx <= n) {
			bit[idx] = ele;
			idx += (idx & -idx);
		}
	}

}
