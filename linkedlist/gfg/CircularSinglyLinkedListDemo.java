package linkedlist.gfg;

class Nodess {
	int data;
	Nodess next;

	Nodess(int data) {
		this.data = data;
		this.next = null;
	}
}

public class CircularSinglyLinkedListDemo {

	static Nodess deleteKthNode(Nodess head, int k) {
		if (head == null)
			return head;
		if (k == 1) {
			Nodess curr = head;
			while (curr.next != head) {
				curr = curr.next;
			}

			if (curr == head) {
				return null;
			}
			curr.next = head.next;
			head = head.next;

			return head;

		}

		Nodess curr = head;
		int i = 1;
		while (i < k - 1) {
			if (curr.next == head) {
				return head;
			}
			curr = curr.next;
			i++;
		}
		curr.next = curr.next.next;
		return head;
	}

	static Nodess insertLast(Nodess head, int data) {
		Nodess newNode = new Nodess(data);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}

		Nodess curr = head;
		while (curr.next != head) {
			curr = curr.next;

		}

		newNode.next = head;
		curr.next = newNode;

		return head;
	}

	static Nodess insertBeg(Nodess head, int data) {
		Nodess newNode = new Nodess(data);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}

		Nodess curr = head;
		newNode.next = curr;
		while (curr.next != head) {
			curr = curr.next;
		}
		curr.next = newNode;

		return newNode;
	}

	static void printList(Nodess head) {
		if (head == null)
			return;
		System.out.println(head.data);
		Nodess curr = head.next;
		while (curr != head) {
			System.out.print(curr.data);
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		Nodess head = new Nodess(25);
		Nodess second = new Nodess(26);
		Nodess third = new Nodess(27);
		Nodess fourth = new Nodess(28);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = head;
		head = insertBeg(head, 24);
		head = insertLast(head, 900);
		printList(head);
	}
}
