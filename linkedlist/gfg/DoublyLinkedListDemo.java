package linkedlist.gfg;

class Nodes {
	int data;
	Nodes next;
	Nodes prev;

	Nodes(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class DoublyLinkedListDemo {
	static Nodes delLast(Nodes head) {
//		if(head != null) {
//			
//			
//		}else {
//			return head;
//		}
		
		if(head==null) return head;
		if(head.next ==null) return null;
		else {
			Nodes curr = head;
			while(curr.next !=null) {
				curr = curr.next;
			}
			Nodes prev = curr.prev;
			prev.next=null;
			
		}
		
		return head;
	}

	static Nodes delHead(Nodes head) {
		if (head == null)
			return head;
		Nodes curr = head;
		head = head.next;
		curr.next = null;
		head.prev = null;

		return head;

	}

	static Nodes reverseList(Nodes head) {
		if (head == null || head.next == null) {
			return head;
		}

		// We will maintain 2 pointers: one for the previous node and one for the
		// current node
		Nodes previous = null;
		Nodes curr = head;

		while (curr != null) {
			previous = curr.prev; // Save the previous node
			curr.prev = curr.next; // Reverse the prev pointer
			curr.next = previous;
//            head=curr;// Reverse the next pointer
			curr = curr.prev; // Move to the next node (which was previously prev)
		}

		return previous.prev; // prev will be the new head after reversal
	}

	static Nodes insertLast(Nodes head, int data) {
		Nodes newNode = new Nodes(data);
		if (head == null) {
			return newNode;
		}
		Nodes temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.prev = temp;

		return head;
	}

	static Nodes insertBeg(Nodes head, int data) {
		Nodes newNode = new Nodes(data);
		if (head == null)
			return newNode;
		newNode.next = head;
		head.prev = newNode;
		return newNode;
	}

	static void printList(Nodes head) {
		Nodes curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Nodes head = new Nodes(52);
		Nodes second = new Nodes(25);
		Nodes third = new Nodes(89);
		Nodes fourth = new Nodes(87);
		head.next = second;
		second.prev = head;
		second.next = third;
		third.prev = second;
		third.next = fourth;
		fourth.prev = third;

		System.out.println("Original List:");
		printList(head);

		// Insert at beginning and end
		head = insertBeg(head, 91);
		head = insertLast(head, 800);

		System.out.println("List after insertions:");
		printList(head);

		// Reverse the list
//		    head = reverseList(head);
//
//		    System.out.println("Reversed List:");

		head = delLast(head);
		printList(head);
	}
}
