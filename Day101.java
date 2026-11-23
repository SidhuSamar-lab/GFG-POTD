// Character at Position in Infinite String
// Difficulty: MediumAccuracy: 44.43%Submissions: 6K+Points: 4
// Given a string s and an integer pos, an infinite string is constructed by repeatedly applying the following operation. In the i-th step, append i consecutive $ characters, followed by the reverse of the current string, to the current string.

// Formally, if the current string is s, update it as:

// s = s + ('$' repeated i times) + reverse(s)
// The initial string is the given s, and the process continues indefinitely.

// Find and return the character at the pos(1-based indexing) in the resulting infinite string.

// Examples:

// Input: s = "12345", pos = 3
// Output: 3
// Explanation: In "12345...", the character at pos 3 is 3.
// Input: s = "12345", pos = 10
// Output: 2
// Explanation: In "12345$54321...", the character at pos 10 is 2.
// Input: s = "abc", pos = 7
// Output: a
// Explanation: In "abc$cba...", the character at pos 7 is a.
// Constraints:

// 1 ≤ s.size() ≤ 105
// 1 ≤ pos ≤ 109
// s consists of English alphabets and digits



class Solution {
    public char posInfinite(String s, int pos) {
        long len = s.length();
        long step = 0;
        while (len < pos) {
            step++;
            len = 2 * len + step;
        }
        long p = pos;
        while (step > 0) {
            long prevLen = (len - step) / 2;
            if (p > prevLen && p <= prevLen + step) {
                return '$';
            } else if (p > prevLen + step) {
                p = len - p + 1;
            }
            len = prevLen;
            step--;
        }
        return s.charAt((int) (p - 1));
    }
}