/*
Problem: https://leetcode.com/problems/set-matrix-zeroes/submissions/
*/
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] sample = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeroesEfficient(sample);
        sample = sample;

    }

    static void setZeroesEfficient(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col_zero = 1;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                col_zero = 0;
            }
            for (int j = 1; j < m; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col_zero == 0) {
                matrix[i][0] = 0;
            }
        }
    }

    static void setZeroes(int[][] matrix) {
        int i = 0, j = 0;
        boolean[] iArr = new boolean[matrix.length];
        boolean[] jArr = new boolean[matrix[0].length];
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] == 0) {
                iArr[i] = true;
                jArr[j] = true;
            }
            if (j < matrix[0].length - 1) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }
        i = 0;
        j = 0;
        while (i < matrix.length && j < matrix[0].length) {
            if (iArr[i] || jArr[j]) {
                matrix[i][j] = 0;
            }
            if (j < matrix[0].length - 1) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }
        return;
    }

}
