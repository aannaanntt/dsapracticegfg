package disjointset;

public class DisjointSetUnionByRankAndPath {
	int[] parent;
	int[] rank;
	int[] sizes;
	
	public DisjointSetUnionByRankAndPath(int size) {
		this.parent = new int[size];
		this.rank = new int[size];
		this.sizes = new int[size];
		
		for(int i=0;i<size;i++) {
			parent[i] = i;
			rank[i] = 0;
			sizes[i] = 1;
		}
	}
	
	public int findPar(int node) {
		if(node == parent[node]) {
			return node;
		}
		return parent[node] = findPar(parent[node]);
		
	}
	
	public void unionByRank(int u,int v) {
		int pu = findPar(u);
		int pv = findPar(v);
		if(pv == pu) return;
		if(rank[pu] < rank[pv]) {
			parent[pu] = pv;
		}else if(rank[pv] < rank[pu]) {
			parent[pv] = pu;
		}else {
			parent[pv] = pu;
			rank[pu]++;
		}
		
	}
	
	public void unionBySize(int u,int v) {
		int pu = findPar(u);
		int pv = findPar(v);
		if(pu == pv) return;
		if(sizes[pu] < sizes[pv]) {
			parent[pu] = pv;
			sizes[pv]+=sizes[pu];
		}else {
			parent[pv]= pu;
			sizes[pu] += sizes[pv];
		}
		
	}
	
	
    public static void main(String[] args) {
        DisjointSetUnionByRankAndPath ds = new DisjointSetUnionByRankAndPath(7); // 0 to 6

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 5);
        ds.unionByRank(3, 6);

        // After all unions, 1 and 5 should be connected
        System.out.println(ds.findPar(1) == ds.findPar(5)); // true
   }

}





