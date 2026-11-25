// Geek's Destination with Special Jump
// Difficulty: HardAccuracy: 72.35%Submissions: 5K+Points: 8
// Geek starts at position 0 on the positive X-axis and needs to reach or pass position d on the positive X-axis.

// Geek normally follows a repeating movement pattern:

// Move forward by a units, taking a seconds.
// Move backward by b units, taking b seconds.
// Geek also has a special jump that moves him exactly j units forward in 1 second. He can use it at any time, even in the middle of a forward or backward movement, and the journey ends immediately after the jump.

// Given five integers a, b, d, l, and r. For every integer j in the range [l, r], find the minimum time required for Geek to reach or pass position d. He may either use the special jump or reach the destination using normal movement alone, whichever takes less time.

// Return the sum of the minimum times for all jump lengths from l to r. Since, the answer can be large, return modulo 109 + 7. 

// Note: Each jump length is considered independently.

// Examples:

// Input: a = 2, b = 1, d = 5, l = 3, r = 4
// Output: 5
// Explanation: 
// For j = 3, Geek moves 2 units forward, then takes a jump of 3 units to reach the destination. The minimum time required is 3 seconds.
// For j = 4, Geek moves 1 unit forward, then takes a jump of 4 units to reach the destination. The minimum time required is 2 seconds.
// Total sum for the range [l, r] = 3 + 2 = 5.
// Input: a = 4, b = 2, d = 8, l = 2, r = 4
// Output: 26
// Explanation:
// For j = 2, Geek moves 4 units forward, then 2 units backward. She then moves 4 units forward again and takes a jump of 2 units to reach the destination. The minimum time required is 11 seconds.
// For j = 3, Geek moves 4 units forward, then 2 units backward. She then moves 3 units forward and takes a jump of 3 units to reach the destination. The minimum time required is 10 seconds.
// For j = 4, Geek moves 4 units forward, then takes a jump of 4 units to reach the destination. The minimum time required is 5 seconds.
// Total sum for the range [l, r] = 11 + 10 + 5 = 26.
// Constraints:

// a ≤ 10
// 0 < b < a
// a < d ≤ 108
// 0 < l ≤ r
// r < d



import java.math.BigInteger;

class Solution {
    static final BigInteger MOD = BigInteger.valueOf(1_000_000_007L);
    long a, b, m;

    long T(long x) {
        if (x <= a) return x;
        long k = (x - a + m - 1) / m;
        return x + 2 * b * k;
    }

    BigInteger G(long n) {
        if (n <= a) return BigInteger.ZERO;
        long Y = n - a;
        long q = Y / m, rem = Y % m;
        BigInteger bq = BigInteger.valueOf(q);
        return BigInteger.valueOf(m).multiply(bq).multiply(bq.add(BigInteger.ONE)).divide(BigInteger.TWO)
                .add(BigInteger.valueOf(rem).multiply(bq.add(BigInteger.ONE)));
    }

    public int minTime(int A, int B, int d, int l, int r) {
        a = A; b = B; m = a - b;
        long D = d, L = l, R = r;
        long Td = T(D);
        BigInteger total = BigInteger.ZERO;

        long s = Math.max(L, D);
        if (s <= R) total = total.add(BigInteger.valueOf(R - s + 1));

        long lo = L, hi = Math.min(R, D - 1);
        if (lo <= hi) {
            long left = lo, right = hi + 1;
            while (left < right) {
                long mid = (left + right) >>> 1;
                if (1 + T(D - mid) <= Td) right = mid;
                else left = mid + 1;
            }
            long j0 = left;
            if (j0 > lo)
                total = total.add(BigInteger.valueOf(j0 - lo).multiply(BigInteger.valueOf(Td)));
            if (j0 <= hi) {
                long xlo = D - hi, xhi = D - j0;
                BigInteger cnt = BigInteger.valueOf(xhi - xlo + 1);
                BigInteger sumX = BigInteger.valueOf(xlo + xhi).multiply(cnt).divide(BigInteger.TWO);
                BigInteger sumK = G(xhi).subtract(G(xlo - 1));
                total = total.add(cnt).add(sumX)
                        .add(BigInteger.valueOf(2 * b).multiply(sumK));
            }
        }
        return total.mod(MOD).intValue();
    }
}