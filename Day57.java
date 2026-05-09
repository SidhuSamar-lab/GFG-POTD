// Count Spanning Trees in a Graph

// Given a connected undirected graph with n vertices and m edges, where each edge is represented as edges[i]=[u,v]  indicating an edge between vertices u and v.

// Determine the total number of distinct spanning trees that can be formed from the graph.

// Note: A spanning tree is a subgraph of the given graph that includes all n vertices, has exactly n-1 edges, is connected, and contains no cycles; therefore, every connected undirected graph always has at least one spanning tree.

// Examples:

// Input: n = 6, edges = [[0, 3], [0, 1], [1, 2], [1, 5], [3, 4]]
// Output: 1
// Explanation: The graph has 6 vertices and 5 edges, and it is connected, so it is already a tree (m = n-1). A tree has only one spanning tree, which is the graph itself, so the answer is 1.
  
// Input: n = 3, edges = [[0, 1], [0, 2], [1, 2]]
// Output: 3
// Explanation: There are exactly 3 possible spanning trees for the given graph. 
 
// Input: n = 1, edges = []
// Output: 1
// Explanation: With 1 vertex, a spanning tree needs 0 edges. The graph already satisfies this, so the answer is 1.
// Constraints:
// 1 ≤ n ≤ 10
// n -1  ≤ m ≤ n*(n-1)/2
// 0 ≤ edges[i][0], edges[i][1] ≤ n-1



class Solution {
    public int countSpanTree(int n, int[][] edges) {
        int[][] lap = new int[n][n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            lap[u][u]++;
            lap[v][v]++;
            lap[u][v]--;
            lap[v][u]--;
        }
        int[][] mat = new int[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i - 1][j - 1] = lap[i][j];
            }
        }
        return (int)Math.round(det(mat));
    }
    double det(int[][] a) {
        int n = a.length;
        double[][] m = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = a[i][j];
        double res = 1;
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i; j < n; j++) {
                if (Math.abs(m[j][i]) > Math.abs(m[pivot][i])) pivot = j;
            }
            if (Math.abs(m[pivot][i]) < 1e-9) return 0;
            if (i != pivot) {
                double[] temp = m[i];
                m[i] = m[pivot];
                m[pivot] = temp;
                res *= -1;
            }
            res *= m[i][i];
            for (int j = i + 1; j < n; j++) {
                double factor = m[j][i] / m[i][i];
                for (int k = i; k < n; k++) {
                    m[j][k] -= factor * m[i][k];
                }
            }
        }
        return res;
    }
}
