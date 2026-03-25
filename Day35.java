// Number of Ways to Arrive at Destination

// You are given an undirected weighted graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where edges[i] = [ui, vi, timei] means that there is an undirected edge between nodes ui and vi that takes timei minutes to reach.
// Your task is to return in how many ways you can travel from node 0 to node V - 1 in the shortest amount of time.

// Examples:

// Input: V = 4, edges[][] = [[0, 1, 2], [1, 2, 3], [0, 3, 5], [1, 3, 3], [2, 3, 4]]
    
// Output: 2
// Explanation: The shortest path from 0 to 3 is 5.
// Two ways to reach 3 in 5 minutes are:
// 0 -> 3
// 0 -> 1 -> 3
// Input: V = 6, edges[][] = [[0, 2, 3], [0, 4, 2], [0, 5, 7], [2, 3, 1], [2, 5, 5], [5, 3, 3], [5, 1, 4], [1, 4, 1], [4, 5, 5]]
    
// Output: 4
// Explanation: The shortest path from 0 to 5 is 7.
// Four ways to reach 5 in 7 minutes are:
// 0 -> 5
// 0 -> 4 -> 5
// 0 -> 4 -> 1 -> 5
// 0 -> 2 -> 3 -> 5
// Constraints:
// 1 ≤ V ≤ 200
// V - 1 ≤ edges.size() ≤ V * (V - 1) / 2
// 0 ≤ ui, vi ≤ V - 1
// 1 ≤ timei ≤ 105
// ui != vi


import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[V];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                long wt = nei[1];

                if (dist[next] > d + wt) {
                    dist[next] = d + wt;
                    ways[next] = ways[node];
                    pq.add(new long[]{next, dist[next]});
                } else if (dist[next] == d + wt) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return ways[V - 1];
    }
}