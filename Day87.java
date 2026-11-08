// Minimum Time with 2 Scanners
// Difficulty: EasyAccuracy: 19.53%Submissions: 22K+Points: 2
// Geek has n documents that need to be scanned using two scanners. Scanner 1 takes s1 units of time to scan one document, while scanner 2 takes s2 units of time to scan one document.

// Both scanners can operate simultaneously, and each scanner can scan only one document at a time. A scanner can start scanning its next document immediately after finishing the current one.

// Find the minimum time required to scan all n documents.

// Examples:

// Input: n = 2, s1 = 2, s2 = 4
// Output: 4
// Explanation: We can either scan both documents using scanner 1, which takes 2 × 2 = 4 units of time, or scan one document using each scanner simultaneously, which takes max(2, 4) = 4 units of time. Both approaches require 4 units of time.
// Input: n = 2, s1 = 1, s2 = 3
// Output: 2
// Explanation: The optimal approach is to scan both documents using scanner 1, which takes 2 × 1 = 2 units of time.
// Constraints:

// 1 ≤ n, s1, s2 ≤ 106
// 1 ≤ s1 * n, s2 * n ≤ 109



class Solution {
    public int minTime(int n, int s1, int s2) {
        long low = 1;
        long high = (long) Math.min(s1, s2) * n;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long scanned = (mid / s1) + (mid / s2);

            if (scanned >= n) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}