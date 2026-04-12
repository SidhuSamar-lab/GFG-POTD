// Toeplitz matrix

// A Toeplitz matrix (also known as a diagonal-constant matrix) is a matrix in which every descending diagonal from left to right contains the same element.

// Given a rectangular matrix mat, determine whether it is a Toeplitz matrix or not.
// Implement the function isToeplitz(mat) that returns:

// true if the matrix is a Toeplitz matrix
// false otherwise
// Examples:

// Input: mat[][] = [[6, 7, 8],
//                 [4, 6, 7],
//                 [1, 4, 6]]
// Output: true
// Explanation: The matrix is Toeplitz because every diagonal from top-left to bottom-right has the same elements. 
// For example, the main diagonal is 6 → 6 → 6, and other diagonals like 7 → 7 and 4 → 4 are also constant. 
// Since all diagonals follow this pattern, the matrix is Toeplitz, so the output is true.
// Input: mat[][] = [[6, 3, 8],
//                 [4, 9, 7],
//                 [1, 4, 6]]
// Output: false
// Explanation: The primary diagonal elements of the given matrix are [6, 9, 6]. As the diagonal elements are not same, the given matrix is not Toeplitz Matrix.
// Constraints:
// 1 ≤ mat.size(), mat[0].size() ≤ 40
// 0 ≤ mat[i][j] ≤ 100


class Solution {
    public boolean isToeplitz(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != mat[i - 1][j - 1]) return false;
            }
        }
        return true;
    }
}