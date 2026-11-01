// Maximum Subarray Sum with One Square Allowed
// Difficulty: MediumAccuracy: 74.07%Submissions: 6K+Points: 4
// Given an integer array arr[], find the maximum subarray sum by squaring at most one element.

// Examples:

// Input: arr[] =  [-1, -2, 3, -2, 3]
// Output: 10
// Explanation: The subarray {3, -2, 3} with squaring -2 will give the maximum sum as 3 + 4 + 3 = 10.
// Input: arr[] =  [-4, -4, -2, 5, 2, -1]
// Output: 27
// Explanation: The subarray {5, 2} with squaring 5 will give a maximum sum of 25 + 2 = 27.
// Constraints:

// 1 ≤ arr.size() ≤ 105
// -103 ≤ arr[i] ≤ 103



class Solution {
    public int maximumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        long noSq = arr[0];
        long sq = (long) arr[0] * arr[0];
        long maxSum = Math.max(noSq, sq);
        
        for (int i = 1; i < arr.length; i++) {
            long val = arr[i];
            long valSq = val * val;
            
            long nextNoSq = Math.max(val, noSq + val);
            long nextSq = Math.max(valSq, Math.max(noSq + valSq, sq + val));
            
            noSq = nextNoSq;
            sq = nextSq;
            
            maxSum = Math.max(maxSum, Math.max(noSq, sq));
        }
        
        return (int) maxSum;
    }
}