// Vertical Tree Traversal

// Given the root of a Binary Tree, find the vertical traversal of the tree starting from the leftmost level to the rightmost level.

// Note: If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

// Examples:

// Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, N, 8, N, 9, N, 10, 11, N]
                    
// Output: [[4], [2], [1, 5, 6, 11], [3, 8, 9], [7], [10]]
// Explanation: The below image shows the horizontal distances used to print vertical traversal starting from the leftmost level to the rightmost level.
     
// Input: root = [1, 2, 3, 4, 5, N, 6]
     
// Output: [[4], [2], [1, 5], [3], [6]]
// Explanation: From left to right the vertical order will be [[4], [2], [1, 5], [3], [6]]
// Constraints:
// 1 ≤ number of nodes ≤ 105
// 1 ≤ node->data ≤ 105

import java.util.*;

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if (node.left != null)
                q.add(new Pair(node.left, hd - 1));

            if (node.right != null)
                q.add(new Pair(node.right, hd + 1));
        }

        for (ArrayList<Integer> list : map.values()) {
            res.add(list);
        }

        return res;
    }
}