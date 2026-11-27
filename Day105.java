// Count Edges in Graph
// Difficulty: EasyAccuracy: 79.92%Submissions: 5K+Points: 2
// Given an undirected graph with V vertices numbered from 0 to V - 1, represented by an adjacency list adj[][], where adj[i] contains the vertices adjacent to vertex i.

// Return the total number of edges present in the graph.

// Examples:

// Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]

// Output: 4
// Explanation: The edges in the graph are: (0-1), (0-2), (2-3), (1-2). Hence, total number of edges = 4.
// Input: adj[][] = [[1], [0, 2], [1, 3], [2]]

// Output: 3
// Explanation: The edges in the graph are: (0-1), (1-2), (2-3). Hence, total number of edges = 3.
// Constraints:

// 1 ≤ adj.size() ≤ 104
// 0 ≤ adj[i][j] < adj.size()




import java.util.ArrayList;

class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int sum = 0;
        for (ArrayList<Integer> list : adj) {
            sum += list.size();
        }
        return sum / 2;
    }
}