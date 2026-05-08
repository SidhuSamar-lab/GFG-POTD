// Remove Invalid Parentheses

// Given a string s consisting of lowercase letters and parentheses '(' and ')'.

// A string is considered valid if:

// Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
// Parentheses are properly nested.
// Remove the minimum number of invalid parentheses from s so that the resulting string becomes valid.  Return all the possible distinct valid strings in lexicographically sorted order.

// Examples :

// Input:  = "()())()"
// Output: ["(())()", "()()()"]
// Explanation: 
// The string "()())()" has one extra ')', making it invalid. By removing one ')', we can make it valid in two ways:
// Remove the 3rd index ')' -> "(())()"
// Remove the 4th index ')' -> "()()()"
// Both are valid and require the minimum removals.
// Input: s = "(a)())()"
// Output: ["(a())()", "(a)()()"]
// Explanation: 
// We remove one ')' (minimum removals) to make it valid. Possible valid results:
// Remove a ')' -> "(a())()"
// Remove another ')' -> "(a)()()"
// Input: s = ")("
// Output: [""]
// Explanation: The string ")(" is invalid. Removing both parentheses (minimum removals) gives an empty string "", which is valid.
// Constraints:
// 1 ≤ |s| ≤ 20
// s consists of lowercase English letters and parentheses '(' and ')'


class Solution {
    public List<String> validParenthesis(String s) {
        java.util.List<String> res = new java.util.ArrayList<>();
        java.util.Set<String> vis = new java.util.HashSet<>();
        java.util.Queue<String> q = new java.util.LinkedList<>();
        q.add(s);
        vis.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (isValid(cur)) {
                res.add(cur);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                String next = cur.substring(0, i) + cur.substring(i + 1);
                if (!vis.contains(next)) {
                    vis.add(next);
                    q.add(next);
                }
            }
        }
        java.util.Collections.sort(res);
        return res;
    }
    boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
