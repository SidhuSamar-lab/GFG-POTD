// Palindrome with Replacement
// Difficulty: MediumAccuracy: 60.42%Submissions: 26K+Points: 4
// Given a string s consisting of lowercase English letters and the character '?', 

// Replace every '?' with a lowercase English letter such that the resulting string is a palindrome.
// If it is possible to form a palindrome, return the minimum possible sum of the absolute ASCII differences between every pair of adjacent characters in the resulting string.
// If it is not possible to form a palindrome, return -1.
// Examples:

// Input: s = a???c??c????
// Output: 4
// Explanation: One optimal palindrome is "abbbccccbbba". The sum of the absolute ASCII differences between adjacent characters is 1 + 0 + 0 + 1 + 0 + 0 + 0 + 1 + 0 + 0 + 1 = 4, which is the minimum possible. 
// Input: s = a???c??c???c
// Output: -1
// Explanation: It is not possible to replace the '?' characters to make the string a palindrome because the first and last characters are different and cannot be changed.
// Constraints:

// 1 ≤ s.size() ≤ 10



class Solution {
    public int minimumSum(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            if (arr[i] != '?' && arr[j] != '?') {
                if (arr[i] != arr[j]) {
                    return -1;
                }
            } else if (arr[i] != '?') {
                arr[j] = arr[i];
            } else if (arr[j] != '?') {
                arr[i] = arr[j];
            }
        }
        
        int m = (n + 1) / 2;
        int sum = 0;
        char lastFixed = '?';
        
        for (int i = 0; i < m; i++) {
            if (arr[i] != '?') {
                if (lastFixed != '?') {
                    sum += Math.abs(arr[i] - lastFixed);
                }
                lastFixed = arr[i];
            }
        }
        
        return sum * 2;
    }
}