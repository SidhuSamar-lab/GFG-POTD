// Count Group Occurrences
// Difficulty: EasyAccuracy: 27.88%Submissions: 56K+Points: 2
// Given a string s and an integer k, count the number of distinct characters that appear in exactly k groups in the string.

// A group is defined as one or more consecutive occurrences of the same character. For example, in the string "aaabbcca", the groups are "aaa", "bb", "cc" and "a".

// Examples:

// Input: s = "abc", k = 1
// Output: 3
// Explanation: The characters 'a', 'b' and 'c' each appear in exactly one group.
// Input: s = "geeksforgeeks", k = 2
// Output: 4
// Explanation: The characters 'g', 'e', 'k' and 's' each appear in exactly two groups.
// Input: s = "aaaaa", k = 2
// Output: 0
// Explanation: The character 'a' appears in only one group, so no character appears in exactly two groups.
// Constraints:

// 1 ≤ s.size() ≤ 105
// 1 ≤ k ≤ 103
// s consists only of lowercase English alphabets



class Solution {
    int getCount(String s, int k) {
        int[] groupCount = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                groupCount[s.charAt(i) - 'a']++;
            }
        }

        int ans = 0;
        for (int count : groupCount) {
            if (count == k) {
                ans++;
            }
        }

        return ans;
    }
}