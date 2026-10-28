// Nth in Concatenated Decimal String
// Difficulty: MediumAccuracy: 66.51%Submissions: 5K+Points: 4Average Time: 15m
// Consider a string s formed by concatenating the decimal representations of all positive integers in order:

// s = "12345678910111213141516171819202122232425262728293031..."

// Given an integer n, find the nth character (1-based indexing) in the string s.

// Examples:

// Input: n = 10
// Output: '1'
// Explanation: The 10th in "1234567891.." character is '1'.
// Input: n = 11
// Output: '0'
// Explanation: The 11th character in "12345678910.."  is '0'.
// Constraints:

// 1 ≤ n ≤ 109


class Solution {
    public char nthCharacter(int n) {
        long len = 1;
        long count = 9;
        long start = 1;
        
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        
        long num = start + (n - 1) / len;
        return Long.toString(num).charAt((int)((n - 1) % len));
    }
}