// Maximum path sum from any node
// Difficulty: Medium        Accuracy: 42.92%     Submissions: 92K+   Points: 4   Average Time: 45m
// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.


class Solution {
    int maxSum = Integer.MIN_VALUE; // Stores the maximum path sum

    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        maxPathSum(node);
        return maxSum;
    }

    private int maxPathSum(Node node) {
        if (node == null) return 0;

        // Compute the maximum sum of paths in left and right subtrees
        int leftSum = Math.max(0, maxPathSum(node.left));  // Ignore negative paths
        int rightSum = Math.max(0, maxPathSum(node.right)); // Ignore negative paths

        // Calculate the max sum considering the current node
        int currentMax = node.data + leftSum + rightSum;

        // Update the global max sum
        maxSum = Math.max(maxSum, currentMax);

        // Return the max path sum that can be extended upwards
        return node.data + Math.max(leftSum, rightSum);
    }
}