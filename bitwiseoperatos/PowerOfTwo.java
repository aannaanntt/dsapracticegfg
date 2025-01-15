package bitwiseoperatos;
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        // Check if n is positive and satisfies the condition n & (n - 1) == 0
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int number = 16;
        if (isPowerOfTwo(number)) {
            System.out.println(number + " is a power of 2.");
        } else {
            System.out.println(number + " is not a power of 2.");
        }
    }
}
