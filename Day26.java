// Largest number in one swap

// Given a string s, return the lexicographically largest string that can be obtained by swapping at most one pair of characters in s.

// Examples:

// Input: s = "768"
// Output: "867"
// Explanation: Swapping the 1st and 3rd characters(7 and 8 respectively), gives the lexicographically largest string.
// Input: s = "333"
// Output: "333"
// Explanation: Performing any swaps gives the same result i.e "333".
// Constraints:
// 1 ≤ |s| ≤ 105
// '0' ≤ s[i] ≤ '9'


class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        int[] last = new int[10];
        
        // store last occurrence of each digit
        for(int i = 0; i < n; i++){
            last[arr[i] - '0'] = i;
        }
        
        for(int i = 0; i < n; i++){
            int digit = arr[i] - '0';
            
            // check for larger digits
            for(int d = 9; d > digit; d--){
                if(last[d] > i){
                    char temp = arr[i];
                    arr[i] = arr[last[d]];
                    arr[last[d]] = temp;
                    
                    return new String(arr);
                }
            }
        }
        
        return s;
    }
}