// Max Profit from Two Machines

// Given two machines, Machine A and Machine B, and a set of n tasks. The profit earned for performing each task is given in two arrays a[] and b[] such that if Machine A performs the i-th task, the profit is a[i], and if Machine B performs it, the profit is b[i].

// Machine A can process at most x tasks, and Machine B can process at most y tasks. It is guaranteed that x + y ≥ n, so all tasks can be assigned. Return the maximum possible profit after assigning each task to either Machine A or Machine B.

// Examples:

// Input: x = 3, y = 3, a[] = [1, 2, 3, 4, 5], b[] = [5, 4, 3, 2, 1]
// Output: 21
// Explanation: Machine A performs tasks with indices [2, 3, 4], and Machine B performs the rest [0, 1], giving profits (3 + 4 + 5) + (5 + 4) = 21.
// Input: x = 4, y = 4, a[] = [1, 4, 3, 2, 7, 5, 9, 6], b[] = [1, 2, 3, 6, 5, 4, 9, 8]
// Output: 43
// Explanation: Machine A performs tasks with indices [1, 4, 5, 6], and Machine B performs the rest [0, 2, 3, 7], giving profits (4 + 7 + 5 + 9) + (1 + 3 + 6 + 8) = 43.
// Input: x = 3, y = 4, a[] = [8, 7, 15, 19, 16, 16, 18], b[] = [1, 7, 15, 11, 12, 31, 9]
// Output: 110
// Explanation: Machine A performs tasks with indices [0, 3, 6], and Machine B performs the rest [1, 2, 4, 5], giving profits (8 + 19 + 18) + (7 + 15 + 12 + 31) = 110.
// Constraints:
// 1 ≤ a.size() == b.size() ≤ 105
// 1 ≤ x, y ≤ 105
// 1 ≤ a[i], b[i] ≤ 104


class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        java.util.Arrays.sort(idx, (i, j) -> Math.abs(a[j] - b[j]) - Math.abs(a[i] - b[i]));
        int ca = 0, cb = 0, res = 0;
        for (int id : idx) {
            if ((a[id] >= b[id] && ca < x) || cb == y) {
                res += a[id];
                ca++;
            } else {
                res += b[id];
                cb++;
            }
        }
        return res;
    }
}