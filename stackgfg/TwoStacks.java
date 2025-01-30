package stackgfg;

public class TwoStacks {

	int arr[];
	int top1;
	int top2;
	int cap;

	TwoStacks(int cap) {
		this.arr = new int[cap];
		this.top1 = -1;
		this.top2 = cap;
		this.cap = cap;
	}
	// naive is we divide the array from mid and than use it as a stack
	// the idea is to push the array elements from both the sides and

	boolean push1(int data) {
		if (top1 < top2 - 1) {
			top1++;
			arr[top1] = data;
			return true;
		}
		return false;
	}

	boolean push2(int data) {
		if (top1 < top2 - 1) {
			top2--;
			arr[top2] = data;
			return true;
		}
		return false;
	}

	Integer pop1() {
		if (top1 >= 0) {
			int data = arr[top1];
			top1--;
			return data;
		}
		return null;
	}

	Integer pop2() {
		if (top2 < top1) {
			int data = arr[top2];
			top2--;
			return data;
		}
		return null;
	}

	Integer size1() {
		return top1 + 1;
	}

	Integer size2() {
		return cap - top2;
	}
	
	void printStacksBoth() {
	    // Check if both stacks have elements to print
	    if (top1 >= 0) {
	        System.out.print("Stack 1: ");
	        for (int i = 0; i <= top1; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }

	    if (top2 < cap) {
	        System.out.print("Stack 2: ");
	        for (int i = cap - 1; i >= top2; i--) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	}

	
	public static void main(String[] args) {
        TwoStacks stacks = new TwoStacks(10);

        // Push elements to stack1
        stacks.push1(10);
        stacks.push1(20);

        // Push elements to stack2
        stacks.push2(30);
        stacks.push2(40);
//
//        // Pop elements from stack1
//        System.out.println(stacks.pop1()); // 20
//        System.out.println(stacks.pop1()); // 10
//
//        // Pop elements from stack2
//        System.out.println(stacks.pop2()); // 40
//        System.out.println(stacks.pop2()); // 30
//
//        // Check the sizes
//        System.out.println("Size of stack1: " + stacks.size1()); // 0
//        System.out.println("Size of stack2: " + stacks.size2()); // 0
        
        stacks.printStacksBoth();
    }

}
