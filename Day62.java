// Longest Increasing Path in Matrix
// Solved
// Difficulty: HardAccuracy: 44.5%Submissions: 22K+Points: 8
// Given a matrix with n rows and m columns, find the length of the longest path such that:

// The path can start and end at any cell.
// A cell cannot be visited more than once.
// The values in path are strictly increasing. 
// From each cell,  you can move left, right, up, or down.
// Diagonal moves and moves outside the matrix are not allowed.
// Examples:

// Input: n = 3, m = 3, matrix[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
// Output: 5
// Explanation: One such path is 1 -> 2 -> 3 -> 6 -> 9, where each number is strictly greater than the previous.

// Input: n = 3, m = 3, matrix[][] = [[3, 4, 5], [6, 2, 6], [2, 2, 1]]
// Output: 4
// Explanation: One of the longest increasing paths is 3 -> 4 -> 5 -> 6.

// Input: n = 2, m = 2, matrix[][] = [[1, 1], [1, 1]]
// Output: 1
// Explanation: There can at most one vertex as all vertices are same.
// Constraints:

// 1 ≤ n, m ≤ 1000
// 0 ≤ matrix[i][j] ≤ 230



class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longIncPath(int[][] matrix, int n, int m) {
        if (matrix == null || n == 0 || m == 0) {
            return 0;
        }

        int[][] memo = new int[n][m];
        int longestPath = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j, n, m, memo));
            }
        }

        return longestPath;
    }

    private int dfs(int[][] matrix, int i, int j, int n, int m, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int max = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, 1 + dfs(matrix, x, y, n, m, memo));
            }
        }

        memo[i][j] = max;
        return max;
    }
}