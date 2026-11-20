// Min Flips for Alternate
// Difficulty: EasyAccuracy: 48.58%Submissions: 61K+Points: 2
// Given a binary string s, we can flip any bit (change 0 to 1 or 1 to 0) to make the string alternating. A string is called alternating if no two adjacent characters are the same.

// Find the minimum number of bit flips required to make the string alternating.

// Examples:

// Input: s = "001"
// Output: 1
// Explanation: Flip the bit at index 0 from 0 to 1 to obtain "101", which is an alternating binary string. Hence, the minimum number of flips required is 1.
// Input: s = "0001010111" 
// Output: 2
// Explanation: Flip the bit at indices 1 and 8 to obtain "0101010101", which is an alternating binary string. Hence, the minimum number of flips required is 2.
// Constraints:

// 1 ≤ s.size() ≤ 105
// s consists only of the characters 0 and 1



class Solution {
    public int minFlips(String s) {
        int flips0 = 0;
        int flips1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != expected0) {
                flips0++;
            }
            if (s.charAt(i) != expected1) {
                flips1++;
            }
        }
        return Math.min(flips0, flips1);
    }
}