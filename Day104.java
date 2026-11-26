// Range Vowel Count Queries
// Difficulty: MediumAccuracy: 77.43%Submissions: 5K+Points: 4
// Given a string s and a 2D array queries[][], where each query consists of two integers l and r, find the number of vowels in the substring s[l....r] for each query. The substring includes both indices l and r.

// Return an array containing the answers to all queries in the order they are given.

// Examples:

// Input: s = "geeksforgeeks", queries[][] = [[1, 3], [2, 4], [1, 9]]
// Output: [2, 1, 4]
// Explanation:
// Query 1: "eek" has 2 vowels (e, e).
// Query 2: "eks" has 1 vowel (e).
// Query 3: "eeksforge" has 4 vowels (e, e, o, e).
// Input: s = "helloworld", queries[][] = [[0, 4], [5, 9], [0, 9]]
// Output: [2, 1, 3]
// Explanation:
// Query 1: "hello" has 2 vowels (e, o).
// Query 2: "world" has 1 vowel (o).
// Query 3: "helloworld" has 3 vowels (e, o, o).
// Constraints:

// 1 ≤ s.size(), queries.size() ≤ 105
// s consists only of lowercase English alphabets
// queries[i].size() = 2
// 0 ≤ queries[i][0] ≤ queries[i][1] < s.size()




import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int isVowel = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
            prefix[i + 1] = prefix[i] + isVowel;
        }
        ArrayList<Integer> ans = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            ans.add(prefix[q[1] + 1] - prefix[q[0]]);
        }
        return ans;
    }
}