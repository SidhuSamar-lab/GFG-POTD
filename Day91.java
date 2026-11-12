// Closest in BST
// Difficulty: MediumAccuracy: 47.51%Submissions: 94K+Points: 4Average Time: 30m
// Given root of a Binary Search Tree (BST) and an integer k, find the minimum absolute difference between k and the value of any node in the BST.

// Examples:

// Input: root = [10, 2, 11, 1, 5, N, N, N, N, 3, 6, N, 4], k = 13

// Output: 2
// Explanation: The node with value 11 is closest to k = 13. So, the minimum absolute difference is |11 - 13| = 2.
// Input: root = [8, 1, 9, N, 4, N, 10, 3], k = 9

// Output: 0
// Explanation: The node with value 9 is closest to k = 9. So, the minimum absolute difference is |9 - 9| = 0.
// Constraints:

// 1 ≤ size of binary tree, k ≤ 105
// 0 ≤ Node.data ≤ 105



/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/
class Solution {
    static int minDiff(Node root, int K) {
        int ans = Integer.MAX_VALUE;
        Node curr = root;

        while (curr != null) {
            ans = Math.min(ans, Math.abs(curr.data - K));
            if (K < curr.data) {
                curr = curr.left;
            } else if (K > curr.data) {
                curr = curr.right;
            } else {
                return 0;
            }
        }

        return ans;
    }
}