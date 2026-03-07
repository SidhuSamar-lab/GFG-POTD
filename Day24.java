// Dice throw

// Given n dice each with m faces. Find the number of ways to get sum x which is the summation of values on each face when all the dice are thrown.

// Example:

// Input: m = 6, n = 3, x = 12
// Output: 25
// Explanation: There are 25 total ways to get the Sum 12 using 3 dices with faces from 1 to 6.
// Input: m = 2, n = 3, x = 6
// Output: 1
// Explanation: There is only 1 way to get the Sum 6 using 3 dices with faces from 1 to 2. All the dices will have to land on 2.
// Constraints:
// 1 <= m,n,x <= 50


class Solution {
    static int noOfWays(int m, int n, int x) {
        int[][] dp = new int[n + 1][x + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= m && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        return dp[n][x];
    }
}