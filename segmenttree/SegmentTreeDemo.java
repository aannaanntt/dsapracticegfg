package segmenttree;

public class SegmentTreeDemo {
	int[] tree;
	int size;

	public SegmentTreeDemo(int[] arr) {
		size = arr.length;
		tree = new int[4 * size];
		buildTree(arr, 0, 0, size - 1);
	}

	public void buildTree(int[] arr, int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			buildTree(arr, 2 * node + 1, start, mid);
			buildTree(arr, 2 * node + 2, mid + 1, end);
			tree[node] = tree[2 * node + 1] + tree[2 * node + 2];

		}
	}
	
	public int getSum(int left,int right) {
		return query(0,0,size-1,left,right);
	}
	private int query(int node,int start,int end,int l,int r) {
		if(r < start || l > end) return 0;
		
		if(start >= r || end <= r) return tree[node];
		
		
		//partial overlap
		int mid = (start + end )  /2 ;
		int left = query(2 * node + 1, start, mid, l, r);
		int right = query(2 * node + 2, mid+1, end, l, r);
		return left + right;
	}

	
	private void update(int node,int start,int end,int idx,int ele) {
		if(start == end) {
			tree[node] = ele;
		}else {
			int mid = (start + end )/ 2;
			if(idx <= mid) {
				update(2 * node + 1,start,mid,idx,ele);
				
			}else {
				update(2*node + 2,mid+1,end,idx,ele);
			}
			  tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
		}
	}
}
