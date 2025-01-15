package mathmaticsfordsa;

public class ProductOFFactors {

	public static void main(String[] args) {
		int num = 5013;
		long prod = 1;
		for (int i = 1; i * i <= num; i++) { // Loop through numbers from 1 to sqrt(num)
			if (num % i == 0) { // If i is a divisor of num
				prod = prod * i; // Print i (the divisor)

				if (i != num / i) { // If the paired divisor is different (to avoid duplicates)
					prod = prod * (num / i); // Print the paired divisor
				}

//		System.out.println(prod);
			}
		}
		
		System.out.println(prod);
		
	}
}
