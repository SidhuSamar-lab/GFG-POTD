// Longest subarray with Atmost two distinct integers

// Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.

// Examples:

// Input: arr[] = [2, 1, 2]
// Output: 3
// Explanation: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1). Hence, the length of the longest subarray is 3.
// Input: arr[] = [3, 1, 2, 2, 2, 2]
// Output: 5
// Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which has a length of 5.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 105


import java.util.*;

class Solution {
    public int totalElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        
        for (int right = 0; right < arr.length; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
