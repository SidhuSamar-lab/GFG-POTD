// Consecutive 1's not allowed

// Given a positive integer n, count all possible distinct binary strings of length n such that there are no consecutive 1’s.

// Examples :

// Input: n = 3
// Output: 5
// Explanation: 5 strings are ("000", "001", "010", "100", "101").
// Input: n = 2
// Output: 3
// Explanation: 3 strings are ("00", "01", "10").
// Input: n = 1
// Output: 2
// Constraints:
// 1 ≤ n ≤ 44


class Solution {
    int countStrings(int n) {
        if (n == 1) return 2;
        int a = 1, b = 2;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}