// Max Equal Sum in 3 Stacks
// Difficulty: MediumAccuracy: 48.71%Submissions: 53K+Points: 4Average Time: 20m
// Given three stacks s1, s2, and s3, represented by arrays where the first element of each array represents the top of the corresponding stack.

// Find the maximum possible equal sum(sum of all elements) of all three stacks by removing zero or more elements from the top of each stack.

// If it is not possible to make the sum of all three stacks equal, return 0.

// Examples:

// Input: s1 = [3, 2, 1, 1, 1], s2 = [4, 3, 2], s3 = [2, 5, 4, 1]
// Output: 5
// Explanation: Remove 3 from s1, 4 from s2, and 2, 5 from s3. The remaining sums of all three stacks are equal to 5.
// pop
// Input: s1 = [4,7], s2 = [10], s3 = [1,2,3]
// Output: 0
// Explanation: It is not possible to make the sums of all three stacks equal by removing elements from their tops.
// Constraints:

// 1 ≤ s1.size(), s2.size(), s3.size() ≤ 5 * 105
// // 1 ≤ s1[i], s2[i], s3[i] ≤ 103



import java.util.ArrayList;

class Solution {
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2, ArrayList<Integer> s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int num : s1) sum1 += num;
        for (int num : s2) sum2 += num;
        for (int num : s3) sum3 += num;

        int i = 0, j = 0, k = 0;
        int n1 = s1.size(), n2 = s2.size(), n3 = s3.size();

        while (i < n1 && j < n2 && k < n3) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(i++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(j++);
            } else {
                sum3 -= s3.get(k++);
            }
        }

        return 0;
    }
}