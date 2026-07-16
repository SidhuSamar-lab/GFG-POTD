// Numbers with Given Digit Sum
// Difficulty: MediumAccuracy: 26.33%Submissions: 18K+Points: 4
// Given two integers n and sum, determine the number of n-digit positive integers whose digits add up to sum.

// An n-digit number cannot have leading zeros; that is, the first digit must be between 1 and 9.
// If there exist no n digit number with sum of digits equal to given sum, return -1.
// Examples :

// Input: n = 2, sum = 2
// Output: 2
// Explaination: The valid 2-digit numbers whose digits sum to 2 are 11 and 20.
// Input: n = 1, sum = 10
// Output: -1
// Explaination: A single-digit number can only have a digit sum between 0 and 9.
// Input: n = 2, sum = 10
// Output: 9
// Explaination: The 2-digit numbers whose digits add up to 10 are: 19, 28, 37, 46, 55, 64, 73, 82, 91.
// Constraints:
// 1 ≤ n ≤ 9
// 1 ≤ sum ≤ 81


class Solution {
    public int countWays(int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int d = 1; d <= 9 && d <= sum; d++) dp[1][d] = 1;
        for (int i = 2; i <= n; i++) {
            for (int s = 0; s <= sum; s++) {
                for (int d = 0; d <= 9 && d <= s; d++) {
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
}