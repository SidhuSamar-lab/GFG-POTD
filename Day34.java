// Burning Tree

// Given the root of a binary tree and a target node, determine the minimum time required to burn the entire tree if the target node is set on fire. In one second, the fire spreads from a node to its left child, right child, and parent.

// Note: The tree contains unique values.

// Examples : 

// Input: root = [1, 2, 3, 4, 5, 6, 7], target = 2
  
// Output: 3
// Explanation: Initially 2 is set to fire at 0 sec 
// At 1 sec: Nodes 4, 5, 1 catches fire.
// At 2 sec: Node 3 catches fire.
// At 3 sec: Nodes 6, 7 catches fire.
// It takes 3s to burn the complete tree.
// Input: root = [1, 2, 3, 4, 5, N, 7, 8, N, N, 10], target = 10

// Output: 5
// Explanation: Initially 10 is set to fire at 0 sec 
// At 1 sec: Node 5 catches fire.
// At 2 sec: Node 2 catches fire.
// At 3 sec: Nodes 1 and 4 catches fire.
// At 4 sec: Node 3 and 8 catches fire.
// At 5 sec: Node 7 catches fire.
// It takes 5s to burn the complete tree.
// Constraints:
// 1 ≤ number of nodes ≤ 105
// 1 ≤ node->data ≤ 105

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

    private void markParents(Node root, Map<Node, Node> parentMap) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    private Node findTarget(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;

        Node left = findTarget(root.left, target);
        if (left != null) return left;

        return findTarget(root.right, target);
    }

    public int minTime(Node root, int target) {

        Map<Node, Node> parentMap = new HashMap<>();
        markParents(root, parentMap);

        Node targetNode = findTarget(root, target);

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.offer(targetNode);
        visited.add(targetNode);

        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    visited.add(parentMap.get(curr));
                    q.offer(parentMap.get(curr));
                }
            }
        }

        return time;
    }
}