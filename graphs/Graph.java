package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Pair {
	int node;
	int dist;

	Pair(int node, int dist) {
		this.dist = dist;
		this.node = node;
	}
}

class Pair2{
	int vertex;
	int weight;
	public Pair2(int vertex,int weight) {
		// TODO Auto-generated constructor stub
		this.vertex=vertex;
		this.weight = weight;
	}
}

class Edge{
	int vertex;
	int weight;
	 Edge(int vertex,int weight) {
		// TODO Auto-generated constructor stub
		this.vertex=vertex;
		this.weight = weight;
	}
}

class PairDij{
	int vertex;
	int weight;
	public PairDij(int vertex,int weight) {
		// TODO Auto-generated constructor stub
		this.vertex=vertex;
		this.weight = weight;
	}
}

public class Graph {
	
	static int timer =1;
	
	static int timerAp=1;
	
	
	private static int timeTar = 0;
    private static int sccCountTar = 0;
	
	
	
	private List<List<Integer>> adjList;
	private int vertices;

	public Graph(int numOfVertices) {
		this.vertices = numOfVertices;
		adjList = new ArrayList<List<Integer>>();
		for (int i = 0; i < numOfVertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}

	public void printGraph() {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print(i + "->");
			for (int nei : adjList.get(i)) {
				System.out.print(nei);
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	

	public void bfs(int source) {
		boolean[] visited = new boolean[this.vertices];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[source] = true;
		q.add(source);

		System.out.println("BFS Traversal");
		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr);
			for (int nei : adjList.get(curr)) {
				if (!visited[nei]) {
					visited[nei] = true;
					q.offer(nei);
				}
			}
		}

	}

	public static void bfdDis(List<List<Integer>> graph, int n) {
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				bfsDisc(graph, i, visited);
			}
		}

	}

	private static void bfsDisc(List<List<Integer>> graph, int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.println(node);
			for (int nei : graph.get(node)) {
				if (!visited[nei]) {
					visited[nei] = true;
					q.offer(nei);
				}
			}
		}

	}

	public static void dfs(List<List<Integer>> graph, int start, boolean[] visited) {
		visited[start] = true;
		System.out.println(start + " ");
		for (int nei : graph.get(start)) {
			dfs(graph, nei, visited);

		}
	}

	static boolean hasCycleDir(int n, List<List<Integer>> graph) {
		boolean[] visited = new boolean[n];
		boolean[] recStack = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (hasCycleDIRDFS(i, visited, graph, recStack)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean hasCycleDIRDFS(int start, boolean[] visited, List<List<Integer>> graph, boolean[] recStack) {

		visited[start] = true;
		recStack[start] = true;
		for (int nei : graph.get(start)) {
			if (!visited[nei]) {
				if (hasCycleDIRDFS(start, visited, graph, recStack)) {
					return true;
				} else if (recStack[nei] == true) {
					return true;
				}
			}

		}
		recStack[start] = false;
		return false;
	}
	
	
	static void primsAlgo(List<List<Edge>> graph, int V) {
	    boolean[] visited = new boolean[V];
	    PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
	    int sum = 0;

	    pq.add(new Edge(0, 0));  // Start from vertex 0 with weight 0

	    while (!pq.isEmpty()) {
	        Edge curr = pq.poll();
	        int u = curr.vertex;

	        if (visited[u]) continue;

	        visited[u] = true;
	        sum += curr.weight;

	        for (Edge nei : graph.get(u)) {
	            if (!visited[nei.vertex]) {
	                pq.add(new Edge(nei.vertex, nei.weight));  // add neighbor to PQ
	            }
	        }
	    }

	    System.out.println("Total weight of MST: " + sum);
	}
	
	
	
	  public static void bridgeInGraph(List<List<Integer>> connections, int n) {
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            adj.add(new ArrayList<>());
	        }

	        for (List<Integer> con : connections) {
	            int u = con.get(0);
	            int v = con.get(1);
	            adj.get(u).add(v);
	            adj.get(v).add(u);
	        }

	        int[] vis = new int[n];
	        int[] tin = new int[n];
	        int[] low = new int[n];
	        List<List<Integer>> bridges = new ArrayList<>();

	        for (int i = 0; i < n; i++) {
	            if (vis[i] == 0) {
	                depth_first_search(i, -1, vis, tin, low, bridges, adj);
	            }
	        }

	        System.out.println("Bridges: " + bridges);
	    }
	  
	  static void dfssTarj(int node,List<List<Integer>> graph,int[] disc,int[] low,boolean[] inStack,Stack<Integer> st) {
		  disc[node]=low[node] =timeTar++;
		  st.push(node);
		  inStack[node] =true;
		  for(int nei : graph.get(node)) {
			  if(disc[nei] == -1) {
				  dfssTarj(nei, graph, disc, low, inStack, st);
				  low[node] = Math.min(low[nei], low[node]);
				  
			  }else if(inStack[nei]) {
				  low[node] = Math.min(low[node], disc[nei]);
			  }
			  
			  if(low[node] == disc[nei]) {
				  sccCountTar++;
				  while(true) {
					  int v = st.pop();
					  inStack[v] = false;
					  if(v == nei) break;
				  }
			  }
		  }
	  }
	  
	  static void countSCC(int V, List<List<Integer>> adj) {
		  int[] disc = new int[V];
		  int low[] = new int[V];
		  boolean[] inStack = new boolean[V];
		  Stack<Integer> st = new Stack<>();
		  Arrays.fill(disc, -1);
		  Arrays.fill(low, -1);
		  
		  
		  for(int i=0;i<V;i++) {
			  if(disc[i] == -1) {
				  dfssTarj(i,adj,disc,low,inStack,st);
			  }
		  }
		  
	  }
	  
	  static void dfsAP(int node,int parent,int[] vis,int[] tin,int[] low,int[] mark,ArrayList<ArrayList<Integer>> adj) {
		  vis[node] =1;
		  low[node] = tin[node] = timer;
		  timer++;
		  
		  int child =0;
		  for(Integer it : adj.get(node)) {
			  if(vis[it] == 0) {
				  child++;
				  dfsAP(it,node,vis,tin,low,mark,adj);
				  low[node] = Math.min(low[node], low[it]);
				  
				  if(low[it] >= tin[node] && parent != -1) {
					  mark[node] =1;
				  }
			  }else {
				  low[node] = Math.min(low[node], tin[it]);
			  }
		  }
		  
		  if(child > 1 && parent ==-1) {
			  mark[node] =1;
		  }
			  
		  
	  }
	  
	  static void ap(int V,ArrayList<ArrayList<Integer>> adj) {
		  int[] vis = new int[V];
		  int[] tin = new int[V];
		  int low[] = new int[V];
		  int mark[] = new int[V];
		  for(int i=0;i<V;i++) {
			  dfsAP(i,-1,vis,tin,low,mark,adj);
		  }
	  }
	  

	    static void depth_first_search(int node, int parent, int[] vis, int[] tin, int[] low,
	                                   List<List<Integer>> bridges, List<ArrayList<Integer>> adj) {
	        vis[node] = 1;
	        tin[node] = low[node] = timer++;
	        for (Integer it : adj.get(node)) {
	            if (it == parent) continue;

	            if (vis[it] == 0) {
	                depth_first_search(it, node, vis, tin, low, bridges, adj);
	                low[node] = Math.min(low[node], low[it]);

	                if (low[it] > tin[node]) {
	                    bridges.add(Arrays.asList(node, it));
	                }
	            } else {
	                low[node] = Math.min(low[node], tin[it]);
	            }
	        }
	    }
	
	 static int[] bellManFord(int V, List<List<Integer>> edges, int source) {
	        int[] dis = new int[V];
	        Arrays.fill(dis, (int) 1e8);
	        dis[source] = 0;

	        // Relax edges V - 1 times
	        for (int i = 0; i < V - 1; i++) {
	            for (List<Integer> edge : edges) {
	                int u = edge.get(0);
	                int v = edge.get(1);
	                int wt = edge.get(2);

	                if (dis[u] != (int) 1e8 && dis[u] + wt < dis[v]) {
	                    dis[v] = dis[u] + wt;
	                }
	            }
	        }

	        // Check for negative weight cycle
	        for (List<Integer> edge : edges) {
	            int u = edge.get(0);
	            int v = edge.get(1);
	            int wt = edge.get(2);
	            if (dis[u] != (int) 1e8 && dis[u] + wt < dis[v]) {
	                return new int[]{-1}; // Negative cycle detected
	            }
	        }

	        return dis;
	    }
	
	
	static void dfss(int node,int[] vis,List<List<Integer>> graph,Stack<Integer> st) {
		vis[node] =1;
		for(int nei : graph.get(node)) {
			if(vis[nei] == 0) {
				dfss(nei,vis,graph,st);
			}
		}
		st.push(node);
	}
	
	static void dfsss(int node , int[] vis, ArrayList<ArrayList<Integer>> adjT) {
		vis[node] =1;
		for(int nei : adjT.get(node)) {
			if(vis[nei] == 0) {
				dfsss(nei,vis,adjT);
			}
		}
	}
	
	static void kosaRaju(int V,List<List<Integer>> graph) {
		int vis[] = new int[V];
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<V;i++) {
			if(vis[i] == 0) {
				dfss(i,vis,graph,st);
			}
		}
		
		// now we need another adjacency to store the graph
		ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<V;i++) {
			adjT.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<V;i++) {
			vis[i]=0;
			for(int nei : graph.get(i)) {
				adjT.get(nei).add(i);
			}
		}
		
		int scc =0 ;
		
		//do dfs on the basis of finishing time
		while(!st.isEmpty()) {
			int node = st.peek();
			st.pop();
			if(vis[node]==0) {
				scc++;
				dfsss(node,vis,adjT);
			}
		}
	}


	
	//check dijkstra with set as well
	
	static void dijAlgo(List<List<PairDij>> graph,int V,int source) {
		
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] =0;
		PriorityQueue<PairDij> pq = new PriorityQueue<PairDij>((x,y)->x.weight-y.weight);
		pq.add(new PairDij(source, 0));
		while(!pq.isEmpty()) {
			PairDij pair = pq.poll();
			int u = pair.vertex;
			for(PairDij nei : graph.get(u)) {
				int v = nei.vertex;
				int weight = nei.weight;
				if(dist[u]+ weight<dist[v]) {
					dist[v] = dist[u] + weight;
					pq.add(new PairDij(v, weight));
					
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
            System.out.println("Distance from source " + source + " to " + i + " is " + dist[i]);
        }
		
	}
		
	

	
	
	static void shortestPathINDAG(int V, List<List<Pair2>> adj, int source) {
		boolean[] visited = new boolean[V];
		Stack<Integer> st = new Stack<>();
		
		// topo sort
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				topoSort(i,visited,st,adj);
			}
		}
		
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] =0;
		while(!st.isEmpty()) {
			int u = st.pop();
			if(dist[u] != Integer.MAX_VALUE) {
				for(Pair2 nei : adj.get(u)) {
					int v = nei.vertex;
					int wt = nei.weight;
					if(dist[u] + wt< dist[v]) {
						dist[v] = dist[u] + wt;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(visited));
		
	}
	
	
	private static void topoSort(int node, boolean[] visited, Stack<Integer> st, List<List<Pair2>> adj) {
		// TODO Auto-generated method stub
		visited[node] = true;
		for(Pair2 p : adj.get(node)) {
			if(!visited[p.vertex]) {
				topoSort(p.vertex, visited, st, adj);
			}
			
			st.push(node);
		}
		
	}

	static void topologicalSort(int V,List<List<Integer>> graph) {
		int[] inDegree = new int[V];
		//get the indegree
		for(int u=0;u<V;u++) {
			for(int v : graph.get(u)) {
				inDegree[v]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int u=0;u<V;u++) {
			if(inDegree[u]==0) {
				q.add(u);
			}
		}
		
		//step3 perform BFS
		List<Integer> topOrder = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			int u = q.poll();
			topOrder.add(u);
			for(int v : graph.get(u)) {
				inDegree[v]--;
				if(inDegree[v] ==0) {
					q.add(v);
				}
			}
		}
		
		  if (topOrder.size() != V) {
	            System.out.println("Graph has a cycle. Topological sort not possible.");
	        } else {
	            System.out.println("Topological Order: " + topOrder);
	        }
				
		
	}

	static boolean cycleDetectionBFS(int start, List<List<Integer>> graph, boolean[] visited) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { start, -1 });
		visited[start] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int node = curr[0];
			int parent = curr[1];

			for (int nei : graph.get(node)) {
				if (!visited[nei]) {
					visited[nei] = true;
					q.add(new int[] { nei, node });
				} else if (nei != parent) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean hasCycle(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
		visited[node] = true;

		for (int nei : graph.get(node)) {
			if (!visited[nei]) {
				if (hasCycle(nei, parent, visited, graph)) {
					return true;
				} else if (nei != parent) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean detectCycle(List<List<Integer>> graph, int nodes) {
		boolean[] visited = new boolean[nodes];

		for (int i = 0; i < nodes; i++) {
			if (!visited[i]) {
				if (hasCycle(i, -1, visited, graph)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void bfsShortestPath(List<List<Integer>> graph, int n, int source) {
		int[] distance = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(distance, -1);
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(source, 0));
		visited[source] = true;
		distance[source] = 0;
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			int node = curr.node;
			int dis = curr.dist;

			for (int nei : graph.get(node)) {
				if (!visited[nei]) {
					visited[nei] = true;
					distance[nei] = dis + 1;
					q.offer(new Pair(nei, dis + 1));
				}

			}
		}
	}

	public static void dfsDisconnected(List<List<Integer>> graph, int n) {
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(graph, i, visited);
			}
		}

	}

	public static void main(String[] args) {
		int n = 6; // Number of nodes
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		// First component: 0 - 1 - 2
		graph.get(0).add(1);
		graph.get(1).add(0);
		graph.get(1).add(2);
		graph.get(2).add(1);

		// Second component: 3 - 4 - 5
		graph.get(3).add(4);
		graph.get(4).add(3);
		graph.get(4).add(5);
		graph.get(5).add(4);

		System.out.println("BFS traversal of disconnected graph:");
		bfdDis(graph, n);
	}

}
