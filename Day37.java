// Articulation Point - II

// You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
// Your task is to return all the articulation points (or cut vertices) in the graph.
// An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

// Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
// If no such point exists, return {-1}.

// Examples :

// Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]

// Output: [1, 4]
// Explanation: Removing the vertex 1 or 4 will disconnects the graph as-
   
// Input: V = 4, edges[][] = [[0, 1], [0, 2]]
// Output: [0]
// Explanation: Removing the vertex 0 will increase the number of disconnected components to 3.  
// Constraints:
// 1 ≤ V, E ≤ 104


import java.util.*;

class Solution {
    static int timer;

    static void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis, int[] tin, int[] low, boolean[] isArticulation) {

        vis[u] = true;
        tin[u] = low[u] = ++timer;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!vis[v]) {
                dfs(v, u, adj, vis, tin, low, isArticulation);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] >= tin[u] && parent != -1) {
                    isArticulation[u] = true;
                }
                children++;
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        if (parent == -1 && children > 1) {
            isArticulation[u] = true;
        }
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] isArticulation = new boolean[V];

        timer = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj, vis, tin, low, isArticulation);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) res.add(i);
        }

        if (res.size() == 0) {
            res.add(-1);
        }

        return res;
    }
}