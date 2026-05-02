// Position of the Set Bit

// Given an integer n, determine position of the only set bit (1) in its binary representation. The position is counted starting from 1 at the least significant bit (LSB).

// If n contains exactly one set bit, return its position.
// If n contains no set bits or more than one set bit, return -1.
// Examples:

// Input: n = 2
// Output: 2
// Explanation: 2 is represented as "10" in binary. It has only one set bit, which is at position 2.
// Input: n = 5
// Output: -1
// Explanation: 5 is represented as "101" in binary. It has two set bits; therefore, the output is -1.
// Constraints:
// 0 ≤ n ≤ 108


class Solution {
    public int findPosition(int n) {
        if (n == 0 || (n & (n - 1)) != 0) return -1;
        int pos = 1;
        while ((n & 1) == 0) {
            n >>= 1;
            pos++;
        }
        return pos;
    }
}