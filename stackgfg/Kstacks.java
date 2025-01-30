package stackgfg;

public class Kstacks {
	int arr[];// this will be the size
	// we will be having more than 1 top tha't's wjy we take 2 tops fpor that we
	// have array
	int top[];
	// this will keep track of empty slot in the main array;
	int next[];
	int free_top = 0;
	int k; // this is number of stacks
	int cap;

	public Kstacks(int k, int n) {
		this.k = k;
		this.cap = n;
		this.arr = new int[n];
		this.top = new int[k];
		this.next = new int[n];

		for (int i = 0; i < k; i++) {
			top[i] = -1;
		}
		for (int i = 0; i <= n - 2; i++) {
			next[i] = i + 1;
		}
		next[n - 1] = -1;
	}

	void push(int sn, int x) {
		int i = free_top; // 1. Get the first free slot index.
		free_top = next[i]; // 2. Update free_top to the next free slot.
		next[i] = top[sn]; // 3. Link the new element with the previous top of the stack.
		top[sn] = i; // 4. Update the top of the stack to the current index.
		arr[i] = x; // 5. Store the element in the array.
	}

	int pop(int sn) {
		int i = top[sn]; // 1. Get the index of the top element for stack `sn`.
		top[sn] = next[i]; // 2. Update the top of the stack to the next element in the stack.
		next[i] = free_top; // 3. Add the current index `i` back to the free list.
		free_top = i; // 4. Update `free_top` to the current index `i`.
		return arr[i]; // 5. Return the value of the popped element.
	}

	boolean isEmpty(int sn) {
		return top[sn] == -1;
	}

}
