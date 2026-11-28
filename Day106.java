// Path Exists Between Two Vertices
// Difficulty: EasyAccuracy: 64.27%Submissions: 10K+Points: 2
// Given an undirected graph with V vertices numbered from 0 to V - 1, represented by an adjacency list adj[][], where adj[i] contains all vertices adjacent to vertex i. Also given two vertices u and v, check whether a path exists between them.

// Return true if a path exists, otherwise return false.

// Examples:


// Input: adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 1, v = 5
// 420046859
// Output: false
// Explanation: There is no path from vertex 1 to vertex 5.
// Input: adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 2, v = 3
// 420046859
// Output: true
// Explanation: We can reach vertex 3 from vertex 2 via vertex 0.
// 1
// Constraints:

// 2 ≤ adj.size() ≤ 105
// 0 ≤ adj[i][j], u, v < adj.size()
// u != v


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == v) return true;
            for (int next : adj.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return false;
    }
}