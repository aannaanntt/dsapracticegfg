package recursion;

public class Main {
	static int a=0;
	static int b=1;
	static int sum=0;
	public static void main(String[] args) {
	//fun3(0);
	
	// print1toN(4, 1);
		//System.out.println(fibo(50));
		//System.out.println(sumOFN(3));
//		String str ="akbar";
//	System.out.print(isPalindrome(str, 0, str.length()-1));
		
		//sumOfDigits(253);
		//System.out.println(cutRope(21,7,16,19));
		//getSubsequences("ABC", 0,"");
		//toh(3,'A','B','c');
		System.out.print(jos(5,3));
	}
	static int jos(int n,int k) {
		if(n==1) {
			return 0;
		}
		else
			return (jos(n-1,k)+k)%n;
	}
	static void toh(int n,char A,char B,char c) {
		if(n==1) {
			System.out.println("Move 1 from"+ A+ "to"+ c);
			return;
		}
		toh(n-1,A,c,B);
		System.out.println("Move"+n+"from"+A+"to"+c);
		toh(n-1,B,A,c);
		
	}
	static void getSubsequences(String str, int i, String curr) {
	    if (i == str.length()) {
	        System.out.println(curr);  
	        return;
	    }

	    getSubsequences(str, i + 1, curr + str.charAt(i));  

	    System.out.print("This is cuurr"+curr);
	    getSubsequences(str, i + 1, curr);  
	   
	}

	
	
	static void sumOfDigits(int n) {
		int sum=0;
		while(n!=0) {

			sum=sum+n%10;//get you the last digit
			System.out.print("---->"+sum);
			n=n/10;//remove last digit
		}
		System.out.print(sum);
		
	}
	
	static int cutRope(int n,int a,int b,int c) {
		if(n==0) return 0;
		if(n<0) return -1;
		int res = Math.max(Math.max(cutRope(n - a, a, b, c), cutRope(n - b, a, b, c)), cutRope(n - c, a, b, c));
		if (res==-1) {
			return -1;
		}
		return res;
		
	}
	
	static int sumOfDigitsRec(int n) {
		if(n==0)
			return 0;
		
		return n%10 +sumOfDigitsRec(n/10);
		
	}
	static boolean isPalindrome(String str,int start,int end) {
		if(start>=end)
			return true;
		if(str.charAt(start)==str.charAt(end)) {
			return isPalindrome(str, start+1, end-1);
		}
		return false;
		
	}
	
//	static void fun(int n) {
//		if(n==0) return;
//		System.out.println(n);
//		fun(n-1);
//		System.out.println(n);
//	}
	static int fibo(int n) {
		if(n<2) {
			return n;
		}
		return fibo(n-1) + fibo(n-2);
	}
	
	static void printFib(int n) {
		if(n>=1) {
			sum=a+b;
			System.out.println(sum);
			b=a;
			a=sum;
			printFib(n-1);
		}
	}
	
	static int sumOFN(int n) {
		if(n<0) {
			return 0;
		}
		return n + sumOFN(n-1);
	}
	
	
	
	
//	
//	
	static void print1toN(int n,int k) {
		
		if(k==n) {
			System.out.println(k);
			return;
		}
		System.out.println(k);
		print1toN(n, k+1);
	
		
				
		
		
	}
	static void fun(int n) {
		if(n==0)return;
		fun(n-1);
		System.out.println(n);
		fun(n-1);
	}
	static void fun3(int n) {
		if(n==0)
			return ;
		System.out.println(n);
		fun3(n-1);
	}
	static int fun1(int n) {
	    if (n == 1) 
	        return 0;
	    else
	        return 1 + fun1(n / 2);
	}

	
	

}
