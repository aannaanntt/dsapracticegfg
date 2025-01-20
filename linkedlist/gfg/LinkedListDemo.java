package linkedlist.gfg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

class Node {
	Node next;
	int data;

	Node(int data) {
		this.data = data;
		this.next = null;// this is optional in java
	}
}

public class LinkedListDemo {

	static boolean isPalindromeEff(Node head) {
		if (head == null)
			return false;
		// find middle of list
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		Node rev = reverseList(slow.next);
		Node curr = head;
		while (rev != null) {
			if (curr.data != rev.data) {
				return false;
			}

			rev = rev.next;
			curr = curr.next;
		}

		return false;
	}

//	static boolean isPalindromeNaive(Node head) {
//		Deque<Character> stack = new ArrayDeque<Character>();
//		Node curr =head;
//		while(curr != null) {
//			stack.push(curr.data);
//			curr=curr.next;
//		}
//		
//		// just take everything out of stack and match it with the input
//		for(Node currr = head; currr != null;currr=currr.next) {
//			if(stack.pop() != currr.data) {
//				return false;
//			}
//		}
//		
//		return true;
//	}

	static Node mergeTwoSortedList(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		Node head = null;
		Node tail = null;
		if (head1.data < head2.data) {
			head = tail = head1;
			head1 = head1.next;
		} else {
			head = tail = head2;
			head2 = head2.next;
		}

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				tail.next = head1;
				tail = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				tail = head2;
				head2 = head2.next;
			}
		}

		if (head1 == null)
			tail.next = head2;
		else
			tail.next = head1;

		return head;

	}

	static Node cloneLinkedListwithRandom(Node head) {
		if (head == null)
			return null; // Handle empty list

		// Step 1: Create clone nodes and insert them next to the original nodes
		Node curr = head;
		while (curr != null) {
			Node next = curr.next;
			curr.next = new Node(curr.data);
			curr.next.next = next;
			curr = next;
		}

		// Step 2: Assign random pointers to the clone nodes
//	    for (curr = head; curr != null; curr = curr.next.next) {
//	        if (curr.random != null) {
//	            curr.next.random = curr.random.next;
//	        }
//	    }

		// Step 3: Separate the interleaved list into original and cloned lists
		Node original = head; // Pointer to the original list
		Node clone = head.next; // Pointer to the cloned list
		Node cloneHead = clone; // Save the head of the cloned list

		while (original != null) {
			original.next = original.next.next;
			clone.next = (clone.next != null) ? clone.next.next : null;
			original = original.next;
			clone = clone.next;
		}

		return cloneHead; // Return the head of the cloned list
	}

	static Node cloneLinkedListwithRandoms(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		Node curr = head;
		while (curr != null) {
			map.put(curr, new Node(curr.data));
			curr = curr.next;
		}
		curr = head;
		while (curr != null) {
			Node clone = map.get(curr);
			clone.next = map.get(curr.next);
			// clone.random = map.get(curr.random);
			curr = curr.next;
		}

		return map.get(head);
	}

	static Node pairwiseSwapEff(Node head) {
		if (head == null || head.next == null)
			return null;
		// take a ppointer ahead of head 2 nodes;
		Node curr = head.next.next;
		Node prev = head;
		head = head.next;
		head.next = prev;
		// now start loop from the current
		while (curr != null) {
			if (curr.next == null) {
				break;

			}

			prev.next = curr.next;
			prev = curr;
			Node next = curr.next.next;
			curr.next.next = curr;
			curr = next;
		}
		prev.next = curr;
		return head;
	}

	static Node pairwiseSwap(Node head) {
		Node curr = head;
		while (curr != null) {
			if (curr.next == null)
				break;
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;
			curr = curr.next.next;

		}
		return head;
	}

	static Node getInterSectionOfTwoList(Node head1, Node head2) {
		int cnt1 = 0;
		int cnt2 = 0;
		Node curr1 = head1;
		while (curr1 != null) {
			cnt1++;
			curr1 = curr1.next;
		}
		Node curr2 = head2;
		while (curr2 != null) {
			cnt2++;
			curr2 = curr2.next;
		}

		// traverse the bigger list
		curr1 = head1;
		curr2 = head2;
		if (cnt1 > cnt2) {
			int diff = cnt1 - cnt2;
			while (diff > 0)
				curr1 = curr1.next;
			diff--;
		} else if (cnt2 > cnt1) {
			int diff = cnt2 - cnt1;
			while (diff > 0) {
				curr2 = curr2.next;
				diff--;
			}

			// now traverse both the list simultaneously
			while (curr1 != null && curr2 != null) {
				if (curr1 == curr2) {
					return curr1;
				}
				curr1 = curr1.next;
				curr2 = curr2.next;
			}

		}

		return null;
	}

	static Node getIntersectionOfTwoList(Node head1, Node head2) {
		HashSet<Node> hs = new HashSet<Node>();
		Node curr1 = head1;
		while (curr1 != null) {
			hs.add(curr1);
			curr1 = curr1.next;
		}

		Node curr2 = head2;
		while (curr2 != null) {
			if (hs.contains(curr2)) {
				return curr2;
			}
			hs.add(curr2);
			curr2 = curr2.next;
		}

		return null;

	}

	static Node segEvenOdd(Node head) {
		if (head == null)
			return head;
		// take 4 pointers
		Node evenEnd = null;
		Node evenStart = null;
		Node oddEnd = null;
		Node oddStart = null;
		Node curr = head; // to keep track of head;
		while (curr != null) {
			int x = curr.data;
			if (x % 2 == 0) {
				if (evenStart == null) {
					evenStart = evenEnd = curr;
				} else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			} else {
				if (oddStart == null) {
					oddStart = oddEnd = curr;
				} else {
					oddEnd.next = curr;
					oddEnd = oddEnd.next;
				}
			}

			curr = curr.next;
		}

		if (oddStart == null || evenStart == null)
			return head;
		evenEnd.next = oddStart;
		oddEnd.next = null;
		return evenStart;

	}
//	static Node segEvenOdd(Node head) {
//		if(head ==null) return null;
//		//find the last node 
//		Node lastNode = head;
//		while(lastNode.next != null) {
//			lastNode=lastNode.next;
//		}
//		
//		Node curr = head;
//		while(curr != null) {
//			if(curr.data % 2 !=0) {
//				lastNode.next=curr;
//				lastNode = curr;
//			}
//			
//			curr = curr.next;
//		}
//		
//		return curr;
//	}
//	

	static void deleteNoderefrence(Node ref) {
		ref.data = ref.next.data;
		ref.next = ref.next.next;
	}

	static void removeLoop(Node head, Node loopNode) {
		Node ptr1 = head;
		Node ptr2 = loopNode;
		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		Node last = ptr2;
		while (last.next != ptr2) {
			last = last.next;
		}
		last.next = null;

	}

	static void detectAndRemoveLoop(Node head) {
		if (head == null)
			return;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {

			if (slow == fast) {
				removeLoop(head, slow);
			}

			slow = slow.next;
			fast = fast.next.next;
		}
	}

	static boolean hasLoopEfficient(Node head) {
		if (head == null)
			return false;
		Node slwPtr = head;
		Node fastPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			if (slwPtr == fastPtr) {
				return true;
			}

			slwPtr = slwPtr.next;
			fastPtr = fastPtr.next.next;
		}

		return false;
	}

	static boolean hasLoopHashing(Node head) {
		HashSet<Node> set = new HashSet<>();
		Node curr = head;
		while (curr != null) {
			if (set.contains(curr)) {
				return true;
			}

			set.add(curr);
			curr = curr.next;

		}

		return false;
	}

	static boolean hasLoop(Node head) {
		// Naive approach o(n2)

		if (head == null)
			return false; // Base case: Empty list has no loop

		Node current = head;

		// Outer loop traverses each node in the list
		while (current != null) {
			Node temp = head;

			// Inner loop checks if 'current' is pointed to by any node
			while (temp != null) {
				if (temp.next == current) {
					return true; // Loop detected
				}
				temp = temp.next; // Move to the next node
			}

			current = current.next; // Move 'current' to the next node
		}

		return false;
	}

	static Node reverseKNodesIterative(Node head, int k) {
		if (head == null || k <= 1)
			return head;

//		Node temp = head; Node prev =null;int count =0;
//		while(temp !=null && count <k) { //k =3
//			Node front = temp.next;
//			temp.next=prev;
//			prev = temp;
//			temp = front;
//			count++;
//			
//		}
//		
//		return prev;

		Node current = head;
		Node prevTail = null;
		Node newHead = null;
		while (current != null) {
			Node segmentedHead = current;
			Node prev = null;
			int count = 0;
			while (current != null && count < k) {
				Node next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				count++;
			}

			if (newHead == null) {
				newHead = prev;
			}

			if (prevTail != null) {
				prevTail.next = prev;
			}
			prevTail = segmentedHead;
		}

		return newHead;
	}

	static Node reverseListInGroupsOfK(Node head, int k) {
		if (head == null || k <= 1)
			return head;

		Node curr = head;
		Node prev = null;
		Node next = null;
		int count = 0;
		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null) {
			Node rest_head = reverseListInGroupsOfK(next, k);
			head.next = rest_head;
		}

		return prev;
	}

	static Node removeDups(Node head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;

		Node curr = head;

		while (curr != null && curr.next != null) {
			if (curr.data == curr.next.data) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}

		return head;
	}

	static Node reverseList(Node head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;

		Node node = reverseList(head.next);
		Node tail = head.next;
		tail.next = head;
		head.next = null;

		return node;
	}

	// use 2 pointers
	static int getNthNodeFromLast(Node head, int n) {
		if (head == null)
			return -1;
		Node first = head;
		int i = 0;
		while (i < n) {
			if (first == null)
				return -1;
			first = first.next;
			i++;
		}
		Node second = head;
		while (first != null) {
			second = second.next;
			first = first.next;
		}

		return second.data;

	}

	static int getNethNodezFromEnd(Node head, int n) {
		if (head == null)
			return -1;
		// calculate length first
		int len = 0;
		Node curr = head;
		while (curr != null) {
			len++;
			curr = curr.next;
		}

		int iter = (len - n);
		curr = head;
		int i = 1;
		while (i < iter) {
			curr = curr.next;
			i++;
		}

		return curr.data;
	}

	static int middleListOpt(Node head) {
		if (head == null)
			return -1;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	static int middleList(Node head) {
		if (head == null)
			return -1;

		// calculate length
		int len = 0;
		Node curr = head;
		while (curr != null) {
			len++;
			curr = curr.next;
		}
		curr = head;
		int i = 0;
		while (i < (len / 2)) {
			curr = curr.next;
			i++;
		}

		return curr.data;
	}

	static Node sortedInsert(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			return newNode;

		}

		if (head.data < newNode.data) {
			Node curr = head;
			while (curr.next != null && curr.next.data < data) {
				curr = curr.next;
			}

			curr.next = newNode.next;
			curr.next = newNode;

		} else {
			newNode.next = head;
			return newNode;
		}
		return head;

	}

	static int searchRec(Node head, int data) {
		if (head == null)
			return -1;
		// we can return 0 as well for 0 based coubt
		if (head.data == data)
			return 1;
		else {
			int res = searchRec(head.next, data);
			if (res == -1)
				return -1;
			else
				return res + 1;
		}
	}

	static int isPresentPos(Node head, int data) {
		if (head == null)
			return -1;
		Node curr = head;
		int pos = 0;
		while (curr != null) {
			if (curr.data == data) {
				return pos;
			} else {
				pos++;
				curr = curr.next;
			}
		}

		return -1;
	}

	static boolean isPresent(Node head, int data) {
		if (head == null)
			return false;
		Node curr = head;
		while (curr != null) {
			if (curr.data == data) {
				return true;
			}

			curr = curr.next;
		}

		return false;

	}

	static Node deleteLast(Node head) {
		if (head == null)
			return null;
		Node curr = head;

		// second last ka hold lena h na
		while (curr.next != null && curr.next.next != null) {
			curr = curr.next;
		}

		curr.next = null;
		return head;
	}

	static Node deleteFirst(Node head) {
		if (head == null)
			return null;

		head = head.next;

		return head;
	}

	static Node insertAtPos(Node head, int pos, int data) {
		Node newNode = new Node(data);

		// Case 1: If inserting at the head (pos == 0)
		if (pos == 0) {
			newNode.next = head;
			return newNode;
		}

		// Case 2: Traverse to the node just before the desired position
		Node curr = head;
		int i = 0;

		// Traverse the list until the (pos - 1)th node
		while (i < pos - 2 && curr != null) {
			curr = curr.next;
			i++;
		}

		// Case 3: If the position is out of range
		if (curr == null) {
			System.out.println("Position out of range");
			return head; // Return the unchanged list
		}

		// Case 4: Insert the new node at the desired position
		newNode.next = curr.next;
		curr.next = newNode;

		return head; // Return the updated list
	}

	static Node insertLastRec(Node head, int data) {
		if (head == null)
			return new Node(data);
		if (head.next == null) {
			// means last node p aa gye
			head.next = new Node(data);
			return head;
		}

		head.next = insertLastRec(head.next, data);
		return head;

	}

	static Node insertLast(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null)
			return newNode;
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;

		return head;

	}

	static Node insertBeg(Node head, int data) {
		Node newNode = new Node(data);
//		if(head ==null) return newNode;//jab head null hga to naya node seedhe null p point krwao na
//		if(head.next==null) {
//			newNode.next=head;//same cheeze hi to kr rhe h to if lgane ki kia need h 
//			return newNode;
//		}
//		
		newNode.next = head;

		return newNode;

	}

	static void printListRec(Node head) {
		if (head == null)
			return;
		if (head.next != null) {
			System.out.print(head.data + "->");
		} else {
			System.out.print(head.data);
		}
		printListRec(head.next);
	}

	static void printList(Node head) {
		if (head == null)
			return;

		Node curr = head;
		while (curr != null) {
			if (curr.next != null) {
				System.out.print(curr.data + "->");
			} else {
				System.out.print(curr.data);
			}

			curr = curr.next;
		}

	}

	public static void main(String[] args) {
		// create a single linked list
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = null;
//		Node node = insertBeg(head, 4);
//		Node last = insertLastRec(head, 90);
//		Node atPos = insertAtPos(last, 1, 56);
		// printList(atPos);
		// Node deleteFirst = deleteFirst(atPos);
//		printList(atPos);
//		Node deleteLast = deleteLast(atPos);
//		printListRec(deleteLast);
		// printList(head);
		// Node deleteLast = deleteLast(head);
//		printList(deleteLast);
		// System.out.println(searchRec(head, 4));

		// head = sortedInsert(head, 0);
		// printList(head);
		// head =removeDups(head);
//	head=reverseKNodesIterative(head, 2);
//		printList(head);

		// System.out.println(hasLoopEfficient(head));
		// detectAndRemoveLoop(head);
		// deleteNoderefrence(third);
		head = pairwiseSwapEff(head);
		printList(head);

	}

}
