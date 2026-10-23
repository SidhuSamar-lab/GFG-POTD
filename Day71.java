// Count Pairs Violating BST Property
// Difficulty: MediumAccuracy: 56.99%Submissions: 36K+Points: 4
// Given root of a binary tree in which all node values are distinct, count pairs of nodes that violate any of the following Binary Search Tree (BST) properties.


// All values in the left subtree are strictly smaller.
// All values in the right subtree are strictly greater.
// Examples:

// Input: root[] = [10, 50, 40, N, N, 20, 30]
// 2056958715
// Output: 5
// Explanation: Pairs violating BST property are:-
// (10, 50), 10 should be greater than its left child value.
// (40, 30), 40 should be less than its right child value.
// (50, 20), (50, 30) and (50, 40), maximum of left subtree of 10 is 50 greater than 20, 30 and 40 of its right subtree.
// Input: root[] = [80, 40, 30, 70, N, 60, 50]

// Output: 10
// Explanation: There are total 10 pairs (80, 30), (80, 60), (80, 50), (30, 60), (40, 70), (40, 30), (40, 50), (70, 30), (70, 60), (70, 50) which violate the BST properties.
// Constraints:

// 1 ≤ size of binary tree ≤ 5*104
// 1 ≤ node.data ≤ 109
// All node values are distinct.


import java.util.ArrayList;
import java.util.List;

class Solution {
    int inversions;

    public int pairsViolatingBST(Node root) {
        inversions = 0; // Reset inversions for each test case
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        
        int[] arr = new int[inOrderList.size()];
        for (int i = 0; i < inOrderList.size(); i++) {
            arr[i] = inOrderList.get(i);
        }
        
        mergeSortAndCount(arr, 0, arr.length - 1);
        return inversions;
    }
    
    private void inOrder(Node node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);
    }
    
    private void mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergeSortAndCount(arr, left, mid);
        mergeSortAndCount(arr, mid + 1, right);
        mergeAndCount(arr, left, mid, right);
    }
    
    private void mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += (mid - i + 1);
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }
}