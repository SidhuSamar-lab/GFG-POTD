// Sum of subarray minimums

// Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.

// Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.

// Examples:

// Input: arr[] = [10, 20]
// Output: 40
// Explanation: Subarrays are [10], [20], [10, 20]. Minimums are 10, 20, 10.
// Sum of all these is 40.
// Input: arr[] = [1, 2, 3, 4]
// Output: 20
// Explanation: Subarrays are [1], [2], [3], [4], [1, 2], [1, 2, 3], [1, 2, 3, 4], [2, 3], [2, 3, 4], [3, 4]. Minimums are 1, 2, 3, 4, 1, 1, 1, 2, 2, 3.
// Sum of all these is 20.
// Constraints:
// 1 ≤ arr.size() ≤ 3*104
// 1 ≤ arr[i] ≤ 103


import java.util.*;

class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007;
        long result = 0;
        
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                count += left[stack.pop()];
            }
            left[i] = count;
            stack.push(i);
        }
        
        stack.clear();
        
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                count += right[stack.pop()];
            }
            right[i] = count;
            stack.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * left[i] * right[i]) % mod;
        }
        
        return (int) result;
    }
}