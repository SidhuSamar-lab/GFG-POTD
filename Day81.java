// Largest Sum Cycle
// Difficulty: HardAccuracy: 51.93%Submissions: 37K+Points: 8
// Given an array edge[] of size n, there are n cells numbered from 0 to n - 1. Each cell has at most one outgoing edge.

// For every cell i:

// edge[i] is the cell reached from i in one step.
// edge[i] = -1 means that cell i has no outgoing edge.
// A cycle is a sequence of cells where, by following the outgoing edges, we eventually return to the starting cell. The sum of a cycle is the sum of the indices of all cells in that cycle.

// Return the maximum cycle sum. If there is no cycle, return -1.

// Examples:

// Input: edge[] = [1, 2, 0, -1]
// Output: 3
// Explanation: There is only one cycle in the graph i.e. 0 -> 1 -> 2 -> 0. Sum of the cell index in that cycle = 0 + 1 + 2 = 3.

// Input: edge[] = [2, 0, -1, 2]
// Output: -1
// Explanation: There is no cycle in the graph. The edges are 1 -> 0 -> 2 <- 3. Hence, 2 has no outgoing edge, so no cycle exists.

// Constraints:

// 2 ≤ edge.size() ≤ 105
// -1 ≤ edge[i] < edge.size()
// edge[i] != i



import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (edge[i] != -1) {
                inDegree[edge[i]]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            vis[curr] = true;
            int next = edge[curr];
            if (next != -1) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        long maxSum = -1;
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                long cycleSum = 0;
                int curr = i;
                while (!vis[curr]) {
                    vis[curr] = true;
                    cycleSum += curr;
                    curr = edge[curr];
                }
                maxSum = Math.max(maxSum, cycleSum);
            }
        }
        
        return (int) maxSum; 
    }
}