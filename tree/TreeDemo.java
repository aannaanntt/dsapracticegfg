package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int key;
	Node left;
	Node right;

	Node(int data) {
		this.key = data;
	}
}

class LLNode {
	int data;
	LLNode right;
	LLNode left;
	public LLNode(int data) {
		
		this.data = data;
		this.right=this.left=null;
	}
}

class Distance{
	int val;
	public Distance(int val) {
		this.val=val;
	}
}

public class TreeDemo {
	static Node root;
	
	static int preIdx =0;
	
	static int  diameter=0;
	
	static int maxTime=0;
	  static final int Empty = -1;
	    static int idx = 0;

	    
	    void iterativeIO(Node root) {
	    	Stack<Node> st = new Stack<>();
	    	Node curr = root;;
	    	while(curr !=null) {
	    		st.push(curr);
	    		curr = curr.left;
	    	}
	    	curr = st.pop();
	    	System.out.println(curr.key);
	    	curr=curr.right;
	    }
	    
	    void preOrderI(Node root) {
	    	Stack<Node> st = new Stack<>();
	    	st.push(root);
	    	while(st.isEmpty() == false) {
	    		Node curr = st.pop();
	    		System.out.println(curr.key);
	    		if(curr.right !=null) st.push(curr.right);
	    		if(curr.left !=null) st.push(curr.left);
	    	}
	    }
	    static Node deserialize(ArrayList<Integer> al) {
	        if (idx == al.size()) return null;

	        int val = al.get(idx);
	        idx++;

	        if (val == Empty) return null;

	        Node root = new Node(val);
	        root.left = deserialize(al);
	        root.right = deserialize(al);

	        return root;
	    }
	
	void serialize(Node root, ArrayList<Integer> arr) {
		if(root == null) {
			arr.add(null);
			return;
		}
		arr.add(root.key);
		serialize(root.left, arr);
		serialize(root.right, arr);
		
	}
	
	
	
	static int countNodesE(Node root) {
		int lh=0; int rh=0;
		Node curr = root;
		while(curr != null) {
			lh++;
			curr=curr.left;
		}
		curr = root;
		while(curr != null) {
			rh++;
			curr= curr.right;
		}
		if(lh == rh) return (int) (Math.pow(2, lh)-1);
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	static int countNodes(Node root) {
		if(root == null) return 0;
		else 
		return	1 + countNodes(root.left) + countNodes(root.right);
	}
	static int burnTree(Node root, int leaf,Distance dist) {
		if(root ==null) return 0;
		if(root.key == leaf) {
			dist.val =0;
			return 1;
		}
		Distance lDist = new Distance(-1);
		Distance rDist= new Distance(-1);
		int lh = burnTree(root.left, leaf, lDist);
		int rh = burnTree(root.right, leaf, rDist);
		if(lDist.val != -1) {
			dist.val = lDist.val +1;
			maxTime = Math.max(maxTime, rh+dist.val);
		}else if(rDist.val != -1) {
			dist.val = rDist.val+1;
			maxTime = Math.max(maxTime, dist.val+lh);
		}
		return Math.max(lh, rh)+1;
	}	

	
	
	Node lcaE(Node root,int n1,int n2) {
		if(root ==null) return null;
		if(root.key ==n1 || root.key ==n2) {
			return root;
		}
		Node lca1 = lcaE(root.left,n1,n2);
		Node lca2 = lca(root.right, n1, n2);
		if(lca1 != null && lca2!=null) {
			return root;
		}
		return lca1!=null ? lca2 : lca1;
	}
	
	boolean findPath(Node root,ArrayList<Node> al , int n) {
		if(root==null) return false;
		al.add(root);
		if(root.key==n) return true;
		if(findPath(root.left,al,n) || findPath(root.right,al,n)) {
			return true;
		}
		al.remove(al.size()-1);
		return false;
		
	}
	
	Node lca(Node root ,int n1,int n2) {
		ArrayList<Node> al = new ArrayList<Node>();
		ArrayList<Node> al2 = new ArrayList<Node>();
		if(!findPath(root,al,n1) || !findPath(root,al2,n2)) {
			return null;
		}
		int i;
		for(i=0;i<=al.size()-1&& i<=al2.size()-1;i++) {
			if(al.get(i) != al2.get(i)) {
				break;
			}
		}
		
		return al.get(i-1);
	}
	static int treeDiaEff(Node root) {
		if(root==null) return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		diameter = Math.max(diameter, 1 + lh + rh);
		return 1 + Math.max(lh, rh);
	}
	
	static int treeDia(Node root) {
		if(root ==null) return 0;
		int d1 = 1 + height(root.left) + height(root.right);
		int d2 =treeDia(root.left);
		
		int d3=treeDia(root.right);
		return Math.max(d1, Math.max(d2, d3));
	}
	
	static void treeTraversalEff(Node root) {
		if(root ==null) return;
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		st1.push(root);
		while(st1.isEmpty() == false) {
			Node curr = st1.pop();
			System.out.println(curr.key);
			if(curr.left != null) st2.push(curr.left);
			if(curr.right !=null) st2.push(curr.right);
		}
		
		while(st2.isEmpty() ==false) {
			Node pop = st2.pop();
			System.out.println(pop.key);
			if(pop.right !=null) st1.push(pop.right);
			if(pop.left !=null) st1.push(pop.left);
		}
	}
	
	static void treeTravserseSpiral(Node root) {
		if(root == null) return;
		Queue<Node> q = new LinkedList<Node>();
		Stack<Integer> st = new Stack<>();
		boolean reverse = false;
		q.add(root);
		while(q.isEmpty() == false) {
			int count  = q.size();
			for(int i=0;i<count;i++) {
				Node curr = q.poll();
				if(reverse) {
					st.push(curr.key);
				}else {
					System.out.println(curr.key);
				}
				
				if(curr.left != null) q.add(curr.left);
				if(curr.right !=null) q.add(curr.right);
			}
			
			if(reverse) {
				while(st.isEmpty() ==false) {
					System.out.println(st.pop());
				}
			}
			reverse = !reverse;
			System.out.println();
			
		}
	}
	Node  cTree(int in[] , int pre[] , int is,int ie ) {
		if(is > ie) return null;
		Node root = new Node(pre[preIdx++]);
		int idx=-1; ;
		for(int i=is;i<=ie;i++) {
			if(in[i]==root.key) {
				idx =i;
				break;
			}
		}
		
		root.left = cTree(in,pre,is,idx -1);
		root.right = cTree(in,pre,idx+1,ie);
		return root;
		
	}
	
	
	
//	static LLNode prev = null;
//	static LLNode head =null;
//	 
//	static Node convertLL(Node root) {
//	
//		if(root == null) return root;
//		 convertLL(root.left);
//		if(prev == null) prev = head;
//		else {
//			root.left = prev;
//			prev.right=root;
//				
//		}
//			prev =root;
//			convertLL(root.right);
//			return head;
//	}
	
	static int maxWidthOfBT(Node root) {
		if(root ==null) return 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int res=0;
		while(q.isEmpty() == false) {
			int count = q.size();
			res= Math.max(res, count);
			for(int i=0;i<count;i++) {
				Node curr = q.poll();
				if(curr.left !=null) q.add(curr.left);
				if(curr.right !=null) q.add(curr.right);
			}
		}
		return res;
	}

	static int isBalancedroot(Node root) {
		if (root == null)
			return 0;
		int lh = isBalancedroot(root.left);
		if (lh == -1)
			return -1;
		int rh = isBalancedroot(root.right);
		if (rh == -1)
			return -1;
		if (Math.abs(lh - rh) > 1)
			return -1;
		else
			return Math.max(lh, rh) + 1;
	}

	static boolean isBalanced(Node root) {
		if (root == null)
			return true;
		int lh = height(root.left);
		int rh = height(root.right);
		return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	static boolean childSum(Node root) {
		if (root == null)
			return true; // last m aa gye correct
		if (root.left == null && root.right == null)
			return true; // leaf node
		int sum = 0;
		if (root.left != null)
			sum += root.left.key;
		if (root.right != null)
			sum += root.right.key;

		return (root.key == sum && childSum(root.left) && childSum(root.right));
	}

	static void printLeftViewIter(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (q.isEmpty() == false) {
			int c = q.size();
			for (int i = 0; i < c; i++) {
				Node curr = q.poll();
				if (i == 0) // mtlb level ka pehla node
				{
					System.out.print(root.key);

				}
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
		}
	}

	static void printLeftView(Node root) {
		int[] max_level = new int[] { 0 }; // Using an array to hold max_level
		printView(root, 1, max_level);
	}

	private static void printView(Node root, int curr_level, int[] max_level) {
		if (root == null)
			return;

		if (curr_level > max_level[0]) {
			System.out.println(root.key);
			max_level[0] = curr_level; // Update max_level
		}

		printView(root.left, curr_level + 1, max_level);
		printView(root.right, curr_level + 1, max_level);
	}

	static int height(Node root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		// calculate left height by left recursive call
		int rh = height(root.right);
		return Math.max(rh, lh) + 1;
	}

	static int getMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
	}

	static int getSizeOfBT(Node root) {
		if (root == null)
			return 0;
		else
			return 1 + getSizeOfBT(root.left) + getSizeOfBT(root.right);
	}

	static void printNodesKdist(Node root, int k) {
		if (root == null)
			return;
		if (k == 0)
			System.out.print(root.key);
		printNodesKdist(root.left, k - 1);
		printNodesKdist(root.right, k - 1);

	}

	static void print_level_order_line_by_line(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (q.isEmpty() == false) {
			int count = q.size();
			for (int i = 0; i <= count; i++) {
				Node curr = q.poll();
				System.out.print(curr.key);
				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}
			System.out.println();
		}
	}

	static void level_orderTraversal_Line(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null); // Marker for end of current level

		while (q.size() > 1) {
			Node curr = q.poll();
			if (curr == null) {
				System.out.println();
				q.add(null);
				continue;
			}
			System.out.print(curr.key + " ");
			if (curr.left != null)
				q.add(curr.left);
			if (curr.right != null)
				q.add(curr.right);
		}
	}

	static void levelOrderT(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (q.isEmpty() == false) {
			Node curr = q.poll();
			System.out.print(curr.key + " ");
			if (curr.left != null) {
				q.add(curr.left);
			}
			if (curr.right != null) {
				q.add(curr.right);
			}
		}
	}

	static void in_order(Node root) {
		if (root != null) {
			in_order(root.left);
			System.out.println(root.key);
			in_order(root.right);
		}
	}

	static void pre_order(Node root) {
		if (root != null) {
			System.out.println(root.key);
			pre_order(root.left);
			pre_order(root.right);
		}
	}

	static void post_order(Node root) {
		if (root != null) {
			post_order(root.left);
			post_order(root.right);
			System.out.println(root.key);
		}
	}

	static Node createTree(Node root, int value) {
		if (root == null) {
			return new Node(value);
		}

		if (value < root.key) {
			root.left = createTree(root.left, value);
		} else {
			root.right = createTree(root.right, value);
		}
		return root;
	}

	public static void main(String[] args) {
//		Node root = new Node(10);
//		root.left = new Node(30);
//		root.right = new Node(40);
//		root.left.right = new Node(50);
//		root.left.left = new Node(60);

		root = createTree(TreeDemo.root, 10);
		createTree(root, 20);
		createTree(root, 30);
		createTree(root, 40);
		createTree(root, 50);
		createTree(root, 70);

//		in_order(root);
//		pre_order(root);

		// post_order(root);
		// System.out.println(height(root));

		// printNodesKdist(root,3);

//		print_level_order_line_by_line(root);
		// System.out.println(getMax(root));
//		printLeftView(root);
//		System.out.println(maxWidthOfBT(root));
		System.out.println(	treeDia(root));
	}

}
