// Generate IP Addresses

// Given a string s containing only digits, your task is to restore it by returning all possible valid IP address combinations. You can return your answer in any order.

// A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255(inclusive).

// Note: The numbers cannot be 0 prefixed unless they are 0. For example, 1.1.2.11 and 0.11.21.1 are valid IP addresses while 01.1.2.11 and 00.11.21.1 are not.
// If there are no possible valid IP address return an empty list. The driver code will print -1 in this case.

// Examples:

// Input: s = “255678166”
// Output: [“25.56.78.166”, “255.6.78.166”, “255.67.8.166”, “255.67.81.66”]
// Explanation: These are the only valid possible IP addresses.
// Input: s = “25505011535”
// Output: []
// Explanation: We cannot generate a valid IP address with this string.
// Constraints:
// 1 ≤ s.size() ≤ 16
// s contains only digits(i.e. 0-9)

import java.util.*;

class Solution {

    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(s, 0, 0, "", res);
        return res;
    }

    void backtrack(String s, int index, int parts, String current, ArrayList<String> res) {

        if (parts == 4 && index == s.length()) {
            res.add(current.substring(0, current.length() - 1));
            return;
        }

        if (parts == 4 || index == s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

            if ((part.length() > 1 && part.charAt(0) == '0') || Integer.parseInt(part) > 255)
                continue;

            backtrack(s, index + len, parts + 1, current + part + ".", res);
        }
    }
}