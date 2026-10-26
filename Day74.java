// Minimize Max Min Diff with Subarray Removal
// Difficulty: MediumAccuracy: 54.13%Submissions: 41K+Points: 4
// You are given an array arr[] of size n. You need to remove a subarray of size k , such that the difference between the maximum and minimum values of the remaining array is minimized. Find the minimum value obtained after performing the operation of the removal of the subarray.

// Examples:

// Input: arr = [1, 2, 3, 4, 5], k = 3 
// Output: 1
// Explanation: We remove first subarray of length 3, the remaining array is [4,5] and the difference of maximum and minimum element is 1 i.e 5 - 4 = 1
// Input: arr = [2, 3, 1, 4, 6, 7], k = 3
// Output: 2
// Explanation: 
// If we remove the subarray [2,3,1] then remaining array is [4,6,7] and the difference  = 7-4 = 3
// If we remove the subarray [3,1,4] then remaining array is [2,6,7] and the difference  = 7-2 = 5
// If we remove the subarray [1,4,6] then remaining array is [2,3,7] and the difference  = 7-2 = 5
// If we remove the subarray [4,6,7] then remaining array is [2,3,1] and the difference  = 3-1 = 2
// So the answer is min(3,5,5,2) = 2
// Constraints:

// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 109
// 0 ≤ k < arr.size()


class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;
        if (k == 0) {
            int max = arr[0], min = arr[0];
            for (int num : arr) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            return max - min;
        }
        
        int[] prefMin = new int[n];
        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        int[] suffMax = new int[n];
        
        prefMin[0] = arr[0];
        prefMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefMin[i] = Math.min(prefMin[i - 1], arr[i]);
            prefMax[i] = Math.max(prefMax[i - 1], arr[i]);
        }
        
        suffMin[n - 1] = arr[n - 1];
        suffMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], arr[i]);
            suffMax[i] = Math.max(suffMax[i + 1], arr[i]);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n - k; i++) {
            int currentMin;
            int currentMax;
            
            if (i == 0) {
                currentMin = suffMin[k];
                currentMax = suffMax[k];
            } else if (i == n - k) {
                currentMin = prefMin[i - 1];
                currentMax = prefMax[i - 1];
            } else {
                currentMin = Math.min(prefMin[i - 1], suffMin[i + k]);
                currentMax = Math.max(prefMax[i - 1], suffMax[i + k]);
            }
            
            ans = Math.min(ans, currentMax - currentMin);
        }
        
        return ans;
    }
}
