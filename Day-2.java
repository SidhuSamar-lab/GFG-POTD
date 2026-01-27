// Word Search
// Difficulty: MediumAccuracy: 32.69%Submissions: 86K+Points: 4Average Time: 20m
// You are given a matrix mat[][] of size n*m containing english alphabets and a string word. Check if the word exists on the mat[][] or not. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

// Examples :

// Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
// Output: true
// Explanation: Word "GEEK" can be found in the given grid as follows.

// Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
// Output: false
// Explanation: Word "GEEK" cannot be found in the given grid.

// Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
// Output: true
// Explanation: There are multiple ways to construct the word "AB".

// Constraints:
// 1 ≤ n, m ≤ 6
// 1 ≤ word.size() ≤ 15
// mat and word consists of only lowercase and uppercase English letters.


class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        if (mat == null || mat.length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[n][m];
                    if (dfs(mat, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] mat, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length) {
            return false;
        }
        
        if (visited[row][col] || mat[row][col] != word.charAt(index)) {
            return false;
        }
        
        visited[row][col] = true;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (dfs(mat, word, index + 1, newRow, newCol, visited)) {
                return true;
            }
        }
        
        visited[row][col] = false;
        
        return false;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        char[][] mat1 = {
            {'T', 'E', 'E'},
            {'S', 'G', 'K'},
            {'T', 'E', 'L'}
        };
        String word1 = "GEEK";
        System.out.println("Test 1 - Expected: true, Got: " + sol.isWordExist(mat1, word1));
        
        char[][] mat2 = {
            {'T', 'E', 'U'},
            {'S', 'G', 'K'},
            {'T', 'E', 'L'}
        };
        String word2 = "GEEK";
        System.out.println("Test 2 - Expected: false, Got: " + sol.isWordExist(mat2, word2));
        
        char[][] mat3 = {
            {'A', 'B', 'A'},
            {'B', 'A', 'B'}
        };
        String word3 = "AB";
        System.out.println("Test 3 - Expected: true, Got: " + sol.isWordExist(mat3, word3));
        
        char[][] mat4 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word4 = "ABCCED";
        System.out.println("Test 4 - Expected: true, Got: " + sol.isWordExist(mat4, word4));
        
        String word5 = "ABCB";
        System.out.println("Test 5 - Expected: false, Got: " + sol.isWordExist(mat4, word5));
    }
}