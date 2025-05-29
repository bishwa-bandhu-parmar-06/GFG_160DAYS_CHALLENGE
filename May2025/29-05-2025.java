// Sum of nodes on the longest path
// Difficulty: MediumAccuracy: 52.39%Submissions: 119K+Points: 4
// Given a binary tree root[], you need to find the sum of the nodes on the longest path from the root to any leaf node. If two or more paths have the same length, the path with the maximum sum of node values should be considered.

class Solution {
    int maxLen = 0;
    int maxSum = 0;
    
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        solve(root, 0, 0);
        return maxSum;
    }
    private void solve(Node node, int currLen, int currSum) {
        if (node == null) return;
        
        currSum += node.data;
        currLen++;
        
        if (node.left == null && node.right == null) {
            if (currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            } else if (currLen == maxLen) {
                maxSum = Math.max(maxSum, currSum);
            }
            return;
        }
        
        solve(node.left, currLen, currSum);
        solve(node.right, currLen, currSum);
    }
}