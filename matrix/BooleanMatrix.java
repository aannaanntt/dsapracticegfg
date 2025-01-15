package matrix;
import java.util.Arrays;
//this is wrong implementation so please check it again on GFG
public class BooleanMatrix {
    private static void manipulateMat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        // Store the original first column
        int[] firstCol = new int[row];
        for (int i = 0; i < row; i++) {
            firstCol[i] = mat[i][0];
        }

        // Update matrix based on the first column
        for (int i = 0; i < row; i++) {
            if (firstCol[i] == 1) {
                Arrays.fill(mat[i], 1);  // Set entire row to 1
            }
        }

        // Print updated matrix
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 1, 0}
        };
        manipulateMat(mat);
    }
}
