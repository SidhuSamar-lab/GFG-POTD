// Maximum Weight Transformation of String
// Difficulty: MediumAccuracy: 55.64%Submissions: 5K+Points: 4
// Given a string s consisting only of the characters 'A' and 'B', you can toggle any character. A toggle changes 'A' to 'B' or 'B' to 'A'.

// The weight of a string is calculated using the following rules:

// An alternating adjacent pair ("AB" or "BA") contributes 4 to the weight.
// Each character can belong to at most one pair, so the pairs must not overlap.
// Every character that does not belong to any pair contributes 1 to the weight.
// Each toggle performed decreases the total weight by 1.
// Therefore, Weight = Weight of alternating adjacent pairs + Weight of characters that do not belong to any pair - Number of Toggles

// You can toggle characters to make adjacent characters different and form pairs. Find the maximum possible weight obtainable from the string by choosing pairs and toggling characters optimally.

// Examples:
// Input: s = "AA"
// Output: 3
// Explanation: The possible transformed strings are "AA", "AB", "BA", and "BB". The strings "AB" and "BA" each contain one alternating adjacent pair, contributing 4 to the weight. One toggle is required to obtain either string from "AA", reducing the weight by 1. Therefore, the maximum weight is 4 - 1 = 3.
// Input: s = "ABB"
// Output: 5
// Explanation: Possible transformations are "ABB", "ABA", "AAB", "AAA", "BBB", "BBA", "BAB" and "BAA". The original string "ABB" contains the alternating adjacent pair "AB", contributing 4 to the weight, while the remaining character 'B' contributes 1. No toggles are required. Therefore, the maximum weight is 4 + 1 = 5.
// Constraints:

// 1 ≤ s.size() ≤ 105
// s consists only of the characters A and B



class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        int prev2 = 0;
        int prev1 = 1;
        
        for (int i = 2; i <= n; i++) {
            int noPair = prev1 + 1;
            int pairWeight = (s.charAt(i - 1) != s.charAt(i - 2)) ? 4 : 3;
            int withPair = prev2 + pairWeight;
            
            int curr = Math.max(noPair, withPair);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}