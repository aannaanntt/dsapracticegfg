package linkedlist.gfg;

class Nodesss {
	int data;
	Nodesss next;
	Nodesss prev;

	Nodesss(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class DoublyCircularLinkedListDemo {

	static Nodesss indertBeg(Nodesss head, int data) {
		Nodesss newNode = new Nodesss(data);
		if (head == null) {
			newNode.prev = newNode;
			newNode.next = newNode;
			return newNode;
		}
//		newNode.next = head;
//		newNode.prev=head.prev;

		Nodesss tail = head.prev;
		newNode.next = head;
		newNode.prev = tail;
		head.prev = newNode;
		tail.next = newNode;

		return newNode;

	}

	static void printList(Nodesss head) {
		if (head == null)
			return;

		System.out.print(head.data + " ");
		Nodesss curr = head.next;
		while (curr != head) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		Nodesss head = new Nodesss(56);
		Nodesss second = new Nodesss(98);
		Nodesss third = new Nodesss(89);
		head.next = second;
		second.prev = head;
		second.next = third;
		third.prev = second;
		head.prev = third;
		third.next = head;

		printList(head);
	}
}
