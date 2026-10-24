// Trace Path
// Difficulty: EasyAccuracy: 50.66%Submissions: 39K+Points: 2Average Time: 10m
// Given a rectangular grid with n rows and m columns, and a string s representing a sequence of movement commands. Geek can start from any cell of the grid and follows all the commands in s in the same order.

// The string s consists only of the characters L, R, D, and U, where:

// L: Move one cell left, from (i, j) to (i, j - 1).
// R: Move one cell right, from (i, j) to (i, j + 1).
// D: Move one cell up, from (i, j) to (i - 1, j).
// U: Move one cell down, from (i, j) to (i + 1, j).
// Determine whether there exists at least one starting cell such that Geek remains within the grid while following all the commands in s.

// Examples:

// Input: n = 1, m = 1, s = "R"
// Output: false
// Explanation: There is only one cell(1, 1). So Geek can only start from (1, 1). On taking right(R) Geek moves to (1, 2), which is out of grid. Therefore, there is no cell from where Geek can start and remain inside the grid after tracing the route. 
// Input: n = 2, m = 3, s = "LLRU"
// Output: true
// Explanation: One possible cell is (1, 3). (1, 3) -> (1, 2) -> (1, 1) -> (1, 2) -> (2, 2). Thus, there is a cell from where if Geek starts, it remains inside the grid throughout tracing the route.
// frame_3972
// Constraints:

// 1 ≤ n, m, s.size() ≤ 104
// s consists only of the characters L R D and U.



class Solution {
    public boolean isPossible(int n, int m, String s) {
        int r = 0, c = 0;
        int min_r = 0, max_r = 0, min_c = 0, max_c = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                c--;
                min_c = Math.min(min_c, c);
            } else if (ch == 'R') {
                c++;
                max_c = Math.max(max_c, c);
            } else if (ch == 'D') {
                r--;
                min_r = Math.min(min_r, r);
            } else if (ch == 'U') {
                r++;
                max_r = Math.max(max_r, r);
            }
        }

        if (max_r - min_r >= n || max_c - min_c >= m) {
            return false;
        }

        return true;
    }
}