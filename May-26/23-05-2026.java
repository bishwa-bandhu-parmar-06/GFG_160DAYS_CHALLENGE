// Transform to Sum Tree
// Difficulty: EasyAccuracy: 70.5%Submissions: 81K+Points: 2
// Given a root of a binary tree with n nodes, where each node may contain positive or negative values, convert it into a tree such that each node’s new value is equal to the sum of all values in its left and right subtrees (based on the original tree). For leaf nodes, update their values to 0.

// Examples:      


class Solution {
    public void toSumTree(Node root) {
        convertToSumTree(root);
    }

    private int convertToSumTree(Node node) {
        if (node == null) return 0;

        // Recursively compute left and right subtree sums
        int leftSum = convertToSumTree(node.left);
        int rightSum = convertToSumTree(node.right);

        int oldValue = node.data;

        // Update current node's data
        node.data = leftSum + rightSum;

        // Return the total sum including the original node value
        return node.data + oldValue;
    }
}