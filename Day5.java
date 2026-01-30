// Interleave the First Half of the Queue with Second Half
// Difficulty: MediumAccuracy: 62.41%Submissions: 24K+Points: 4Average Time: 20m
// Given a queue q[] of even size. Your task is to rearrange the queue by interleaving its first half with the second half.

// Interleaving is the process of mixing two sequences by alternating their elements while preserving their relative order.
// In other words, Interleaving means place the first element from the first half and then first element from the 2nd half and again second element from the first half and then second element from the 2nd half and so on....

// Examples:

// Input: q[] = [2, 4, 3, 1]
// Output: [2, 3, 4, 1]
// Explanation: We place the first element of the first half 2 and after that 
// place the first element of second half 3 and after that repeat
// the same process one more time so the resulting queue will be [2, 3, 4, 1]
// Input: q[] = [3, 5]
// Output: [3, 5]
// Explanation: We place the first element of the first half 3 and first element
// of the second half 5 so the resulting queue is [3, 5]
// Constraints:
// 1 ≤ queue.size() ≤ 103
// 1 ≤ queue[i] ≤ 105


import java.util.*;

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        int half = n / 2;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < half; i++) {
            stack.push(q.poll());
        }
        
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        
        for (int i = 0; i < half; i++) {
            q.offer(q.poll());
        }
        
        for (int i = 0; i < half; i++) {
            stack.push(q.poll());
        }
        
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
            q.offer(q.poll());
        }
    }
}