package trie;

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	boolean isEnd = false;
}

public class TrieDemo {

	private final TrieNode node;

	public TrieDemo() {
		node = new TrieNode();
	}

	public void insert(String word) {
		TrieNode curr = node;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if (curr.children[idx] == null) {
				curr.children[idx] = new TrieNode();
			}

			curr = curr.children[idx];
		}
		node.isEnd = true;

	}
	
	
	
	
	public int countDistinctRows(int[][] mat) {
		TrieNode root = new TrieNode();
		int count =0;
		for(int [] row : mat) {
			TrieNode node = root;
			boolean isNew = false;
			for(int val : row) {
				if(node.children[val] == null) {
					node.children[val] = new TrieNode();
					isNew = true;
				}
				
				node = node.children[val];
			}
			
			if(isNew) count++;
		
		}
		return count;
	}

	public void delete(String word) {
		deleteHelper(node, word, 0);
	}

	public boolean deleteHelper(TrieNode current, String word, int idx) {
		if (idx == word.length()) {
			if (!current.isEnd)
				return false;
			current.isEnd = false;
			return isEmpty(current);

		}

		char ch = word.charAt(idx);
		int charIdx = ch - 'a';
		TrieNode child = current.children[charIdx];
		if (child == null)
			return false;
		boolean shouldDelete = deleteHelper(current, word, charIdx + 1);
		if (shouldDelete) {
			current.children[charIdx] = null;
			return !current.isEnd && isEmpty(current);
		}

		return false;
	}

	private boolean isEmpty(TrieNode node) {
		for (TrieNode child : node.children) {
			if (child != null)
				return false;
		}
		return true;
	}

	public boolean search(String word) {
		TrieNode current = node;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (current.children[index] == null) {
				return false;

			}
			current = current.children[index];
		}

		return current.isEnd;
	}

}
