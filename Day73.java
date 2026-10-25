// Sum of Beauty of All Substrings
// Difficulty: EasyAccuracy: 57.41%Submissions: 30K+Points: 2Average Time: 30m
// Given a string s, return the sum of the beauty of all substrings of s. The beauty of a substring is defined as the difference between the maximum and minimum frequencies of the characters present in that substring.

// Examples:

// Input: s = "aaac"
// Output: 3
// Explanation: The substrings with non-zero beauty are "aaac" and "aac". 
// For "aaac", the frequencies are a = 3 and c = 1. Its beauty is 3 − 1 = 2. 
// For "aac", the frequencies are a = 2 and c = 1. Its beauty is 2 − 1 = 1. 
// The remaining substrings have a beauty of 0. Therefore, the sum of the beauties of all substrings is 2 + 1 = 3.
// Input: s = "aabc"
// Output: 2
// Explanation: The substrings with non-zero beauty are "aab" and "aabc". 
// For "aab", the frequencies are a = 2 and b = 1. Its beauty is 2 − 1 = 1. 
// For "aabc", the frequencies are a = 2, b = 1, and c = 1. Its beauty is 2 − 1 = 1. 
// Therefore, the sum of the beauties of all substrings is 1 + 1 = 2.
// Constraints:

// 1 ≤ s.size() ≤ 500
// s consists only of lowercase English alphabets


class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                
                int max = 0;
                int min = Integer.MAX_VALUE;
                
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }
                
                sum += (max - min);
            }
        }
        
        return sum;
    }
}