// Repeated Pattern Check
// Difficulty: EasyAccuracy: 26.05%Submissions: 25K+Points: 2
// Given a string s made of two characters of 'x' and 'y'.  The task is to verify whether s is made by concatenating substrings that follow the pattern xnyn (equal number of y's follow equal number of x's).

// Examples:

// Input: s = "xxyyxy" 
// Output: true
// Explanation: The string can be split into "xxyy" + "xy". Both substrings contain an equal number of consecutive 'x' and 'y' characters.
// Input: s = "xyx"
// Output: false
// Explanation: The last 'x' cannot form a valid substring because it is not followed by a matching 'y'. 
// Constraints:

// 1 ≤ s.size() ≤ 105
// s consists only of the characters x and y



class Solution {
    public boolean findPattern(String s) {
        int n = s.length();
        int i = 0;

        while (i < n) {
            int xCount = 0;
            while (i < n && s.charAt(i) == 'x') {
                xCount++;
                i++;
            }

            if (xCount == 0) {
                return false;
            }

            int yCount = 0;
            while (i < n && s.charAt(i) == 'y') {
                yCount++;
                i++;
            }

            if (xCount != yCount) {
                return false;
            }
        }

        return true;
    }
}