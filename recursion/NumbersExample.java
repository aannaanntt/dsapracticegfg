package recursion;

public class NumbersExample {

	public static void main(String[] args) {
		printNum(1);
	}

	static int printNum(int n) {
		if (n == 6)
			return 0;// base condition
		System.out.print(n);
		
		int res=printNum(n + 1);
		System.out.print("------------>"+res);
		return res;

	}

}
