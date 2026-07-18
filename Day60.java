// Cut Matrix
// Difficulty: HardAccuracy: 43.64%Submissions: 19K+Points: 8Average Time: 45m
// Given a matrix of 0s and 1s and an integer k, divide the matrix into k pieces such that each piece has at least one 1 in it. A cut can be made in the following way:

// Choose a direction: vertical or horizontal.
// Choose an index to cut the matrix into two pieces.
// If the cut is horizontal, only the bottom part can be cut further.
// If the cut is vertical, only the right part can be cut further.
// Return the number of different ways to divide the matrix modulo 1e9 + 7.

// Examples:

// Input: matrix = [[1, 0, 0], [1, 1, 1], [0, 0,0]], k = 3 
// Output: 3
// Explanation: There are 3 valid ways to divide the matrix into 3 pieces each having at least one 1 - horizontal cut after row 0 then vertical cut after col 0 on bottom, horizontal cut after row 0 then vertical cut after col 1 on bottom, and vertical cut after col 0 then vertical cut after col 1 on the right part.
 
// Input: matrix = [[0, 0], [1, 1]], k = 2
// Output: 1
// Explanation: Only way is to cut vertically in the middle since the top half has no 1.
// Input: matrix = [[1, 0], [0, 0]], k = 1
// Output: 1
// Explanation: No cut needed as k = 1, the whole matrix is one piece with at least one 1.
// Constraints:
// 1 <= n, m, k <= 200


class Solution {
    public int findWays(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        final int MOD = 1_000_000_007;

        int[][] suf = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--)
                suf[i][j] = matrix[i][j] + suf[i + 1][j] + suf[i][j + 1] - suf[i + 1][j + 1];

        if (k == 1) return suf[0][0] > 0 ? 1 : 0;

        boolean[][] rowHasOne = new boolean[n][m + 1];
        for (int t = 0; t < n; t++)
            for (int j = m - 1; j >= 0; j--)
                rowHasOne[t][j] = rowHasOne[t][j + 1] || matrix[t][j] == 1;

        boolean[][] colHasOne = new boolean[m][n + 1];
        for (int c = 0; c < m; c++)
            for (int i = n - 1; i >= 0; i--)
                colHasOne[c][i] = colHasOne[c][i + 1] || matrix[i][c] == 1;

        int[][] lastRow = new int[n][m];
        for (int j = 0; j < m; j++) {
            int last = -1;
            for (int r = 0; r < n; r++) {
                if (rowHasOne[r][j]) last = r;
                lastRow[r][j] = last;
            }
        }

        int[][] lastCol = new int[n][m];
        for (int i = 0; i < n; i++) {
            int last = -1;
            for (int c = 0; c < m; c++) {
                if (colHasOne[c][i]) last = c;
                lastCol[i][c] = last;
            }
        }

        long[][] dp = new long[n][m];
        dp[0][0] = 1;

        for (int p = 1; p < k; p++) {
            long[][] dpNext = new long[n][m];

            for (int j = 0; j < m; j++) {
                long cum = 0;
                int upto = -1;
                for (int r = 0; r < n - 1; r++) {
                    int target = lastRow[r][j];
                    while (upto < target) {
                        upto++;
                        cum = (cum + dp[upto][j]) % MOD;
                    }
                    if (target >= 0) dpNext[r + 1][j] = (dpNext[r + 1][j] + cum) % MOD;
                }
            }

            for (int i = 0; i < n; i++) {
                long cum = 0;
                int upto = -1;
                for (int c = 0; c < m - 1; c++) {
                    int target = lastCol[i][c];
                    while (upto < target) {
                        upto++;
                        cum = (cum + dp[i][upto]) % MOD;
                    }
                    if (target >= 0) dpNext[i][c + 1] = (dpNext[i][c + 1] + cum) % MOD;
                }
            }

            dp = dpNext;
        }

        long ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (suf[i][j] > 0) ans = (ans + dp[i][j]) % MOD;

        return (int) ans;
    }
}