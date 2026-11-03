// Count Tree Paths With Limited Max Edge Weight
// Difficulty: HardAccuracy: 71.75%Submissions: 30K+Points: 8
// Given a weighted tree with n nodes, numbered from 1 to n and n - 1 edges, where each edge is represented as [u, v, w] indicating an edge between nodes u and v with weight w.

// You are also given an array queries[], where each queries[i] represents a maximum allowed edge weight.

// For each query x, find the number of distinct paths in the tree such that the maximum edge weight along the path is less than or equal to x.

// Return an array containing the number of valid paths for each query.

// Note:

// A path from node u to node v and the path from node v to node u are considered the same path.
// A path must contain at least one edge. A path from a node to itself is not considered.
// Examples:

// Input: n = 3, edges[][] = [[1, 2, 1], [2, 3, 4]], queries[] = [3]
// Output: [1]
// Explanation:
// For x = 3, only the edge [1, 2, 1] has weight less than or equal to 3.
// Therefore, the only valid path is: 1 -> 2
// The path 1 -> 3 contains an edge of weight 4, so it is not valid.
// Hence, the answer is 1.
// Input: n = 7, edges[][] = [[1, 2, 3], [2, 3, 1], [2, 4, 9], [3, 6, 7], [3, 5, 8], [5, 7, 4]], queries[] = [1, 3, 5]
// Output: [1, 3, 4]
// Explanation: For x = 1, only the edge [2, 3, 1] satisfies the condition. 
// Therefore, the only valid path is 2 -> 3, giving an answer of 1.
// For x = 3, the edges [2, 3, 1] and [1, 2, 3] can be used. 
// They form three valid paths: 1 -> 2, 2 -> 3, and 1 -> 3. 
// For x = 5, the edges with weights 1, 3, and 4 can be used. 
// They form four valid paths: 1 -> 2, 2 -> 3, 1 -> 3, and 5 -> 7.
// Constraints:

// 2 ≤ n ≤ 104
// 1 ≤ queries.size() ≤ 104
// 0 ≤ queries[i] ≤ 105
// edges.size() = n-1
// edges[i].size() = 3
// 1 ≤ edges[i][0], edges[i][1] ≤ n
// edges[i][0] != edges[i][1]
// 0 ≤ edges[i][2] ≤ 105



import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int[] parent;
    int[] size;

    private int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        int q = queries.length;
        
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[][] sortedQueries = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1; 
        }

        int[] ans = new int[q];
        int edgeIdx = 0;
        int totalPaths = 0;

        for (int i = 0; i < q; i++) {
            int limit = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];

            while (edgeIdx < edges.length && edges[edgeIdx][2] <= limit) {
                int u = edges[edgeIdx][0];
                int v = edges[edgeIdx][1];
                
                int rootU = find(u);
                int rootV = find(v);

                if (rootU != rootV) {
                    totalPaths += size[rootU] * size[rootV];
                    parent[rootU] = rootV;
                    size[rootV] += size[rootU];
                }
                edgeIdx++;
            }
            ans[originalIdx] = totalPaths;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            result.add(ans[i]);
        }
        
        return result;
    }
}