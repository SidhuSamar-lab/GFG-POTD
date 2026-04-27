// Smallest window containing 0, 1 and 2

// Given a string s consisting only of the characters '0', '1' and '2', determine the length of the smallest substring that contains all three characters at least once.

// If no such substring exists, return -1.

// Examples :

// Input: s = "10212"
// Output: 3
// Explanation: The substring "102" is the shortest substring that contains all three characters '0', '1', and '2', so the answer is 3.
// Input: s = "12121"
// Output: -1
// Explanation: The character '0' is not present in the string, so no substring can contain all three characters '0', '1', and '2'. Hence, the answer is -1.
// Constraints:
// 1 ≤ s.size() ≤ 105

class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        
        int[] count = new int[3]; // for '0','1','2'
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int unique = 0;

        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - '0';
            
            if (count[idx] == 0) unique++;
            count[idx]++;

            while (unique == 3) {
                minLen = Math.min(minLen, right - left + 1);

                int lIdx = s.charAt(left) - '0';
                count[lIdx]--;
                if (count[lIdx] == 0) unique--;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}