// Sum of All Digit Subsequences
// Difficulty: EasyAccuracy: 52.22%Submissions: 12K+Points: 2
// Given a string s which consists of digits, find sum of all digits across all non-empty subsequences of s.

// Note: Since the answer can be very large, return it modulo 10^9 + 7.

// Examples:

// Input: s = "123" 
// Output: 24
// Explanation: The non-empty subsequences are: [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]. The sum of all digits in these subsequences is: 1 + 2 + 3 + (1 + 2) + (1 + 3) + (2 + 3) + (1 + 2 + 3) = 24.
// Input: s = "405"
// Output: 36
// Explanation: The non-empty subsequences are: [4], [0], [5], [4, 0], [4, 5], [0, 5], [4, 0, 5]. The sum of all digits in these subsequences is 36.
// Constraints:

// 1 ≤ s.size() ≤ 105
// s consists only of digits(1 - 9).




class Solution {
    public int subsequenceSum(String s) {
        long MOD = 1000000007L;
        int n = s.length();
        long digitSum = 0;

        for (int i = 0; i < n; i++) {
            digitSum = (digitSum + (s.charAt(i) - '0')) % MOD;
        }

        long powerOfTwo = modPow(2L, n - 1, MOD);
        long ans = (digitSum * powerOfTwo) % MOD;

        return (int) ans;
    }

    private long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}