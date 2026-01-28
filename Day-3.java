// Count Subset With Target Sum II
// Difficulty: MediumAccuracy: 40.32%Submissions: 10K+Points: 4
// Given an array arr[] and an integer k, find the count of subsets whose sum is equals to k.

// Note: It is guaranteed that the no of valid subsets will fit within a 32-bit integer.

// Examples:

// Input: arr[] = [1, 3, 2], k = 3
// Output: 2
// Explanation: The two subsets whose sum is equals to k are [1, 2] and [3].
// Input: arr[] = [4, 2, 3, 1, 2], k = 4
// Output: 3
// Explanation: The three subsets whose sum is equals to k are [4], [2, 2] and [3, 1].
// Input: arr[] = [10, 20, 30], k = 25
// Output: 0
// Explanation: No subsets exits with sum equals to k.
// Constraints:
// 1 ≤ arr.size() ≤ 40
// -107 ≤ arr[i], k ≤ 107


import java.util.*;

class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        if (k > sum || k < 0) {
            return 0;
        }
        
        int[] dp = new int[(int)k + 1];
        dp[0] = 1;
        
        for (int num : arr) {
            for (int j = k; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[k];
    }
}