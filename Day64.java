// Maximum Frequency with K Increments
// Difficulty: MediumAccuracy: 69.43%Submissions: 6K+Points: 4Average Time: 30m
// Given an integer array arr[]. In one operation, you can choose an index and increment its value by 1.

// Find the maximum possible frequency of any element after performing at most k operations.

// Examples:

// Input: arr[] = [2, 2, 4], k = 4
// Output: 3
// Explanation: Apply two increment operations on index 0 and two operations on index 1 to make arr[]= [4, 4, 4]. Frequency of 4 is 3.
// Input: arr[] = [7, 7, 7, 7], k = 5
// Output: 4
// Explanation: The frequency of 7 is already 4, so no operations are needed.
// Constraints:

// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 106
// 0 ≤ k ≤ 105

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        long windowSum = 0;
        int maxFreq = 1;
        
        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];
            
            while ((long) arr[right] * (right - left + 1) - windowSum > k) {
                windowSum -= arr[left];
                left++;
            }
            
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        
        return maxFreq;
    }
}