// Subsets with MEX in Range
// Difficulty: HardAccuracy: 81.48%Submissions: 3K+Points: 8
// Given an array arr[] of integers and a range [l, r], count the number of subsets whose Minimum Excluded (MEX) value lies within the given range, inclusive.

// Minimum Excluded (or MEX) of a subset is the smallest non-negative integer that is not present in the subset.
// An empty subset has Minimum Excluded as zero.
// Since the answer can be very large, return the answer modulo 109 + 7.

// Examples:

// Input: arr[] = [2, 0, 1, 0], l = 1, r = 2
// Output: 9
// Explanation: The subsets whose MEX lies in the range [1, 2] are counted as follows:
// MEX = 1: The subsets must contain at least one 0 and must not contain 1. These subsets are [0] (2 ways), [2, 0] (2 ways), [0, 0] (1 way), and [2, 0, 0] (1 way). Total = 6.
// MEX = 2: The subsets must contain both 0 and 1 but must not contain 2. These subsets are [0, 1] (2 ways) and [0, 1, 0] (1 way). Total = 3.
// The subsets [2, 0, 1] and [2, 0, 1, 0] have MEX = 3, which is outside the given range. Therefore, the total number of valid subsets is 6 + 3 = 9.
// Input: arr[] = [2, 0, 1], l = 1, r = 2
// Output: 3
// Explanation: The subsets whose MEX lies in the range [1, 2] are [0] (MEX = 1), [2, 0] (MEX = 1), and [0, 1] (MEX = 2). Hence, the answer is 3.
// Constraints:

// 2 ≤ arr.size() ≤ 105
// 0 ≤ arr[i], r ≤ arr.size()
// 0 ≤ l ≤ r


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int cntSubsets(int[] arr, int l, int r) {
        int MOD = 1000000007;
        Map<Integer, Integer> countMap = new HashMap<>();
        int othersCount = 0;
        
        for (int num : arr) {
            if (num <= r) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            } else {
                othersCount++;
            }
        }
        
        long totalValidSubsets = 0;
        long currentWays = 1; 
        
        for (int mex = 0; mex <= r; mex++) {
            int freq = countMap.getOrDefault(mex, 0);
            
            if (mex >= l) {
                long subsetsForThisMex = (currentWays * 1) % MOD;
                long otherElementsPower = power(2, othersCount);
                
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    if (entry.getKey() > mex) {
                        otherElementsPower = (otherElementsPower * power(2, entry.getValue())) % MOD;
                    }
                }
                
                totalValidSubsets = (totalValidSubsets + subsetsForThisMex * otherElementsPower) % MOD;
            }
            
            if (freq == 0) {
                break;
            }
            
            long waysToPickAtLeastOne = (power(2, freq) - 1 + MOD) % MOD;
            currentWays = (currentWays * waysToPickAtLeastOne) % MOD;
        }
        
        return (int) totalValidSubsets;
    }
    
    private long power(long base, long exp) {
        long res = 1;
        base = base % 1000000007;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % 1000000007;
            base = (base * base) % 1000000007;
            exp /= 2;
        }
        return res;
    }
}