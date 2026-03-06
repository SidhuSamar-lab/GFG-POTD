// Smallest window containing all characters

// Given two strings s and p. Find the smallest substring in s consisting of all the characters (including duplicates) of the string p. Return empty string in case no such substring is present.
// If there are multiple such substring of the same length found, return the one with the least starting index.

// Examples:

// Input: s = "timetopractice", p = "toc"
// Output: "toprac"
// Explanation: "toprac" is the smallest substring in which "toc" can be found.
// Input: s = "zoomlazapzo", p = "oza"
// Output: "apzo"
// Explanation: "apzo" is the smallest substring in which "oza" can be found.
// Input: s = "zoom", p = "zooe"
// Output: ""
// Explanation: No substring is present containing all characters of p.
// Constraints: 
// 1 ≤ s.length(), p.length() ≤ 106
// s, p consists of lowercase english letters




class Solution {
    public static String minWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        int[] need = new int[256];
        int[] window = new int[256];

        for (char c : p.toCharArray()) need[c]++;

        int left = 0, count = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window[c]++;

            if (need[c] != 0 && window[c] <= need[c]) count++;

            while (count == p.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);
                window[l]--;

                if (need[l] != 0 && window[l] < need[l]) count--;

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}
