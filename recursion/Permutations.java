package recursion;

public class Permutations {
    public static void main(String[] args) {
        String str = "ABC";
     //   generatePermutations(str, "");
        understand();
    }

    
    static void understand() {
    	String str="Anant";
        String remainingStr = str.substring(0, 0) + str.substring(0 + 1);
        System.out.println(remainingStr);

    }
    
    // Recursive function to generate permutations
    static void generatePermutations(String str, String ans) {
        // Base case: if the input string is empty, print the current permutation
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Loop through each character in the input string
        for (int i = 0; i < str.length(); i++) {
            // Get the current character
            char ch = str.charAt(i);

            // Form the remaining string by excluding the current character
            String remainingStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call with the remaining string and current character added to 'ans'
            generatePermutations(remainingStr, ans + ch);
        }
    }
}
