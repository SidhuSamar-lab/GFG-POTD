// Generate Permutations of an array
// Difficulty: MediumAccuracy: 83.29%Submissions: 6K+Points: 4
// Given an array arr[] of unique elements. Generate all possible permutations of the elements in the array.
// Note: You can return the permutations in any order, the driver code will print them in sorted order.

// Examples:

// Input: arr[] = [1, 2, 3]
// Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
// Explanation: There are 6 possible permutations (3! = 6) of the array.
// Input: arr[] = [1, 3]
// Output: [[1, 3], [3, 1]]
// Explanation: There are 2 possible permutations (2! = 2) of the array.
// Constraints:
// 1 ≤ arr.size() ≤ 9

import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, used, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrack(int[] arr, boolean[] used, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        if (temp.size() == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.add(arr[i]);
            backtrack(arr, used, temp, result);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}