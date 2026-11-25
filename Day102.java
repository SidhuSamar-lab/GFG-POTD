// Two Pairs with Same Sum
// Difficulty: MediumAccuracy: 50.31%Submissions: 19K+Points: 4Average Time: 15m
// Given an array arr[] of positive integers, find four indices a, b, c, and d such that arr[a] + arr[b] = arr[c] + arr[d], where a, b, c, d are all distinct indices.

// If multiple such quadruplets exist, return the one that is lexicographically smallest when the indices are considered in the order a, b, c, d.
// If no such quadruplet exists, return {-1, -1, -1, -1}. 
// Ensure a < b and c < d, and the pair (a, b) is lexicographically smaller than the pair (c, d).
// Examples:

// Input: arr[] = [3, 4, 7, 1, 2, 9, 8]
// Output: [0, 2, 3, 5]
// Explanation: arr[0] + arr[2] = 3 + 7 = 10, arr[3] + arr[5] = 1 + 9 = 10. 
// This is the lexicographically smallest such quadruplet of indices.
// Input: arr[] = [1, 2, 3, 3]
// Output: [-1, -1, -1, -1]
// Explanation: No two distinct pairs of indices produce the same sum.
// Constraints:

// 4 ≤ arr.size() ≤ 103
// 1 ≤ arr[i] ≤ 107




import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        Map<Integer, int[]> map = new HashMap<>();
        int[] ans = null;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new int[]{i, j});
                } else {
                    int[] prev = map.get(sum);
                    int a = prev[0], b = prev[1];
                    if (a != i && a != j && b != i && b != j) {
                        int[] cand = new int[]{a, b, i, j};
                        if (ans == null || isSmaller(cand, ans)) {
                            ans = cand;
                        }
                    }
                }
            }
        }

        if (ans == null) {
            return new ArrayList<>(Arrays.asList(-1, -1, -1, -1));
        }
        return new ArrayList<>(Arrays.asList(ans[0], ans[1], ans[2], ans[3]));
    }

    private boolean isSmaller(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }
        return false;
    }
}