package stringgfg;

//### **Rabin-Karp Algorithm**  
//
//**Step 1:** Calculate the hash value of the pattern and the first substring of the text with the same length as the pattern.  
//
//**Step 2:** Slide the window over the text one character at a time and:  
//- Update the hash value for the new substring using a rolling hash technique.  
//- Compare the hash value of the current substring with the hash value of the pattern.  
//
//**Step 3:** If the hash values match, perform a character-by-character comparison to confirm a match.  
//
//**Step 4:** If a match is found, record the position; otherwise, continue sliding the window.  
//
//**Step 5:** Repeat steps until the end of the text is reached.  
//
//**Step 6:** Return all the starting indices where the pattern matches the text.

class RabinKarpSearch {
    private static final int d = 256; // Number of characters in the alphabet
    private static final int q = 101; // A large prime number

    // Rabin-Karp Algorithm for Pattern Searching
    private static void rabinKarpSearch(String text, String pat) {
        int m = text.length();
        int n = pat.length();

        // Calculate the initial hash values
        int patHash = getHash(pat, n); // Hash of the pattern
        int textHash = getHash(text.substring(0, n), n); // Hash of the first window of text
        int h = 1; // Value of d^(n-1)

        // Precompute h = d^(n-1) % q
        for (int i = 0; i < n - 1; i++) {
            h = (h * d) % q;
        }

        // Slide the pattern over text
        for (int i = 0; i <= m - n; i++) {
            // Check if hash values match
            if (patHash == textHash) {
                // Confirm by checking characters
                if (text.substring(i, i + n).equals(pat)) {
                    System.out.println("Pattern found at index: " + i);
                }
            }

            // Calculate the hash for the next window
            if (i < m - n) {
                textHash = (d * (textHash - text.charAt(i) * h) + text.charAt(i + n)) % q;

                // Ensure positive hash value
                if (textHash < 0) {
                    textHash += q;
                }
            }
        }
    }

    // Method to calculate hash value
    private static int getHash(String str, int len) {
        int hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * d + str.charAt(i)) % q;
        }
        return hash;
    }

    public static void main(String[] args) {
        String text = "ababcabcab";
        String pat = "abc";

        rabinKarpSearch(text, pat);
    }
}
