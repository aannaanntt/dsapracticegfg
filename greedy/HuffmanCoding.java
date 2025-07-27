package greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffManNode{
	char ch;
	int freq;
	
	HuffManNode left;HuffManNode right;
	public HuffManNode(char ch,int freq) {
		this.ch=ch;
		this.freq=freq;
		// TODO Auto-generated constructor stub
	}
}

class HuffManComparator implements Comparator<HuffManNode>{

	@Override
	public int compare(HuffManNode o1, HuffManNode o2) {
		// TODO Auto-generated method stub
		return o1.freq-o2.freq;
	}
	
}


public class HuffmanCoding {

	   static Map<Character, String> huffmanCodes = new HashMap<>();
	    static Map<String, Character> reverseCodes = new HashMap<>();
	
	//Build huffman tree
	public static HuffManNode buildTree(Map<Character,Integer> freqMap) {
		PriorityQueue<HuffManNode> pq = new PriorityQueue<HuffManNode>(new HuffManComparator());
		
		for(Map.Entry<Character,Integer> en :freqMap.entrySet()) {
			pq.add(new HuffManNode(en.getKey(), en.getValue()));
		}
		
		while(pq.size() > 1) {
			HuffManNode left = pq.poll();
			HuffManNode right = pq.poll();
			
			
			HuffManNode node = new HuffManNode('-', left.freq + right.freq);
			node.left = left;
			node.right=right;
			pq.add(node);
		}
		
		return pq.poll();
 		
	}
	
	public static void generateCodes(HuffManNode root,String code) {
		if(root ==null) return;
		if(root.ch != '-') {
			huffmanCodes.put(root.ch, code);
			reverseCodes.put(	code, root.ch);
		}

        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
	}
	
	


    // Step 4: Decode the binary string
    public static String decode(String encodedStr, HuffManNode root) {
        StringBuilder decoded = new StringBuilder();
        HuffManNode current = root;

        for (char bit : encodedStr.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;

            if (current.left == null && current.right == null) {
                decoded.append(current.ch);
                current = root;
            }
        }

        return decoded.toString();
    }
    
    public static String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encoded.append(huffmanCodes.get(ch));
        }
        return encoded.toString();
    }
    
    
    
 // Driver Code
    public static void main(String[] args) {
        String text = "huffman coding example";

        // Count character frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        HuffManNode root = buildTree(freqMap);
        generateCodes(root, "");

        System.out.println("Character Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String encoded = encode(text);
        System.out.println("\nEncoded String: " + encoded);

        String decoded = decode(encoded, root);
        System.out.println("Decoded String: " + decoded);
    }

}
