// Height of Binary Tree
// Difficulty: EasyAccuracy: 78.58%Submissions: 306K+Points: 2Average Time: 15m
// Given a binary tree, find its height.

// The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // Base case: If node is null, height is -1 (for edge count)
        if (node == null) return -1;

        // Recursively find the height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Height of the tree is the maximum height of left or right subtree plus 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}