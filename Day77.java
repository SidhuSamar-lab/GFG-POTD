// Optimal File Merge
// Difficulty: MediumAccuracy: 82.09%Submissions: 4K+Points: 4Average Time: 15m
// Given an integer array files[], where files[i] represents the size of the i-th file, merge all the files into a single file with the minimum total computation cost.

// The cost of merging two files of sizes x and y is x + y. After merging, a new file of size x + y is created, which can be merged further with other files.

// Return the minimum total cost required to merge all the files.

// Note: It is guaranteed that the minimum total computation cost fits within a 32-bit signed integer.

// Examples:

// Input: files[] = [3, 2, 4]
// Output: 14
// Explanation: There are different ways to combine these files. Optimal method is given below:
// Lightbox
// Input: files[] = [2, 3, 6, 5, 7, 4]
// Output: 68
// Explanation: There are different ways to combine these files. Optimal method is given below:

// Constraints:

// 1 ≤ files.size() ≤ 105
// 1 ≤ files[i] ≤ 103


import java.util.PriorityQueue;

class Solution {
    public int minComputation(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int file : files) {
            pq.add(file);
        }
        
        int totalCost = 0;
        
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            
            int mergedCost = first + second;
            totalCost += mergedCost;
            
            pq.add(mergedCost);
        }
        
        return totalCost;
    }
}