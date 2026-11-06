// Balanced Binary Tree Counter
// Difficulty: EasyAccuracy: 38.47%Submissions: 31K+Points: 2Average Time: 10m
// Given a height h, find the maximum number of distinct balanced binary trees of height exactly h.

// A binary tree is balanced if, for every node, the heights of its left and right subtrees differ by at most 1. A tree with a single node has height 1. An empty tree has height 0.

// Note: Since the answer can be very large, return it modulo 109 + 7.

// Examples:

// Input: h = 1
// Output: 1
// Explanation: Only one tree of height 1 exists i.e. a single node.
// Input: h = 2
// Output: 3 
// Explanation: 3 distinct balanced trees of height 2 exist.

// Input: h = 3
// Output: 15
// Explanation: 15 distinct balanced trees of height 3 exist.

// Constraints:

// 1 ≤ h ≤ 106



class Solution {
    public int countBT(int h) {
        if (h == 0 || h == 1) return 1;
        
        long MOD = 1000000007L;
        long prev2 = 1; // dp[0]
        long prev1 = 1; // dp[1]
        
        for (int i = 2; i <= h; i++) {
            // dp[i] = dp[i-1] * dp[i-1] + 2 * dp[i-1] * dp[i-2]
            long term1 = (prev1 * prev1) % MOD;
            long term2 = (2L * prev1 % MOD * prev2) % MOD;
            long curr = (term1 + term2) % MOD;
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return (int) prev1;
    }
}