// K Sum Paths

// Given the root of a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k.

// Note: A path can start and end at any node within the tree but must always move downward (from parent to child).

// Examples:

// Input: root = [8, 4, 5, 3, 2, N, 2, 3, -2, N, 1], k = 7

// Output: 3
// Explanation: The following paths sum to k
 
// Input: root = [1, 2, 3], k = 3

// Output: 2 
// Explanation: The following paths sum to k

// Constraints:
// 1 ≤ number of nodes ≤ 104
// -100 ≤ node value ≤ 100
// -109 ≤ k ≤ 109


/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

import java.util.*;

class Solution {
    public int countAllPaths(Node root, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0L, k, map);
    }

    int dfs(Node node, long sum, int k, HashMap<Long, Integer> map) {
        if (node == null) return 0;

        sum += node.data;
        int count = map.getOrDefault(sum - k, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        count += dfs(node.left, sum, k, map);
        count += dfs(node.right, sum, k, map);

        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0) map.remove(sum);

        return count;
    }
}