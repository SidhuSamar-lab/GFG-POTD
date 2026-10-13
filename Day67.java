// Adding Ones
// Difficulty: EasyAccuracy: 48.06%Submissions: 53K+Points: 2
// Consider an array arr[] of size n, initially containing all zeros. You are also given an array updates[] of k positive integers.

// For each value j in updates[], add 1 to every element arr[i] whose index satisfies i ≥ j.

// The indices in updates[] are 1-based.

// Perform all the updates and modify arr[] accordingly.

// Examples:

// Input: n = 3, updates[] = [1, 1, 2, 3]
// Output: [2, 3, 4]
// Explanation: Initially, arr[] = [0, 0, 0]. After the first update 1, the array becomes [1, 1, 1]. 
// After the second update 1, it becomes [2, 2, 2]. The update 2 increments all elements from index 2 onward, giving [2, 3, 3]. Finally, the update 3 increments the element at index 3, resulting in [2, 3, 4].
// Input: n = 2, updates[] = [1, 1, 1]
// Output: [3, 3] 
// Explanation: Initially the array is [0, 0]. After the first 1, it becomes [1, 1]. 
// After the second 1 it becomes [2, 2]. After the third 1, it becomes [3, 3].
// Constraints:

// 1 ≤ n, updates.size() ≤ 105
// 1 ≤ updates[i] ≤ n



import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(0);
        }
        
        for (int j : updates) {
            arr.set(j - 1, arr.get(j - 1) + 1);
        }
        
        for (int i = 1; i < n; i++) {
            arr.set(i, arr.get(i) + arr.get(i - 1));
        }
        
        return arr;
    }
}