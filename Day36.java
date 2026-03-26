// Chocolates Pickup

// You are given a 2D matrix grid[][] of size n*m, where each cell grid[i][j] represents the number of chocolates available at position (i, j).

// Two robots are collecting chocolates from this grid:

// Robot 1 starts at the top-left corner (0, 0)
// Robot 2 starts at the top-right corner (0, m - 1)
// Your task is to determine the maximum total number of chocolates both robots can collect while following these rules:

// From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
// When a robot visits a cell, it collects all the chocolates there.
// If both robots land on the same cell, the chocolates in that cell are collected only once.
// Robots cannot move outside the boundaries of the grid.
// Both robots must continue moving until they reach the bottom row of the grid.
// Example:

// Input: grid[][] = [[4, 1, 2], [3, 6, 1], [1, 6, 6], [3, 1, 2]]
// Output: 32
// Explanation: The path followed by first robot is: (0, 0) -> (1, 0) -> (2, 1) -> (3, 0), so first robot collected: 4 + 3 + 6 + 3 = 16 chocolates.
// The path followed by second robot is: (0, 2) -> (1, 1) -> (2, 2) -> (3, 2), so second robot collected: 2 + 6 + 6 + 2 = 16 chocolates.
// Total both robots collected 16 + 16 = 32 chocolates.
// Constraint:
// 2 ≤ n, m ≤ 70
// 0 ≤ grid[i][j] ≤ 100


class Solution {
    public int maxChocolate(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) dp[n - 1][j1][j2] = grid[n - 1][j1];
                else dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = 0;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                int val = dp[i + 1][nj1][nj2];
                                if (j1 == j2) val += grid[i][j1];
                                else val += grid[i][j1] + grid[i][j2];
                                maxi = Math.max(maxi, val);
                            }
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m - 1];
    }
}