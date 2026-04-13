// Next Smallest Palindrome

// Given a number, in the form of an array num[] containing digits from 1 to 9(inclusive). Find the next smallest palindrome strictly larger than the given number.

// Examples:

// Input: num[] = [9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2]
// Output: [9, 4, 1, 8, 8, 0, 8, 8, 1, 4, 9]
// Explanation: Next smallest palindrome is 9 4 1 8 8 0 8 8 1 4 9.
// Input: num[] = [2, 3, 5, 4, 5]
// Output: [2, 3, 6, 3, 2]
// Explanation: Next smallest palindrome is 2 3 6 3 2.
// Constraints:
// 1 ≤ n ≤ 105
// 1 ≤ num[i] ≤ 9


class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        boolean all9 = true;
        for (int x : num) {
            if (x != 9) {
                all9 = false;
                break;
            }
        }
        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] res = num.clone();
        int i = n / 2 - 1;
        int j = (n % 2 == 0) ? n / 2 : n / 2 + 1;

        boolean leftSmaller = false;

        while (i >= 0 && res[i] == res[j]) {
            i--;
            j++;
        }

        if (i < 0 || res[i] < res[j]) leftSmaller = true;

        while (i >= 0) {
            res[j++] = res[i--];
        }

        if (leftSmaller) {
            int carry = 1;
            i = n / 2 - 1;

            if (n % 2 == 1) {
                res[n / 2] += carry;
                carry = res[n / 2] / 10;
                res[n / 2] %= 10;
                j = n / 2 + 1;
            } else {
                j = n / 2;
            }

            while (i >= 0) {
                res[i] += carry;
                carry = res[i] / 10;
                res[i] %= 10;
                res[j++] = res[i--];
            }
        }

        return res;
    }
}