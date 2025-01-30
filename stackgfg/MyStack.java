package stackgfg;

public class MyStack {
//take a pointer top 
	int top;
	int capacity;
	int[] stack;
	public MyStack(int capacity) {
		this.stack=new int[capacity];
		this.capacity=capacity;
		this.top =-1;
	}
	
	void push(int data) {
		
		if(top == capacity -1) {
			System.out.println("Overflow ");
			return;
		}
		top++;
		stack[top]=data;
		
	}
	
	int pop() {
		if(top ==-1) {
			System.out.println("underflow");
			return -1;
		}
		int res = stack[top];
		top--;
		return res;
	}
	int peek() {
		if(top==-1) {
			System.out.println("Empty stack");
			return -1;
		}
		
		return stack[top];
	}
	
	void printStack() {
		if(top==-1) {
			System.out.println("Empty stack");
			return;
		}
		
		while(top != -1) {
			System.out.println(stack[top]);
			top--;
		}
	}
	
	public static void main(String[] args) {
		MyStack ms = new MyStack(5);
		ms.push(56);
		ms.push(78);
		System.out.println(	ms.peek());
		ms.printStack();
	}
}
