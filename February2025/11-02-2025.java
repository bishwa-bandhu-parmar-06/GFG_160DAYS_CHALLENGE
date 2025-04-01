// Check for BST
// Difficulty: EasyAccuracy: 25.37%Submissions: 560K+Points: 2Average Time: 30m
// Given the root of a binary tree. Check whether it is a BST or not.
// Note: We are considering that BSTs can not contain duplicate Nodes.
// A BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

class Solution {
    // Helper function to check if the tree is a BST within given constraints.
    boolean isBSTUtil(Node root, long minVal, long maxVal) {
        if (root == null) return true;

        // If the current node violates the BST property, return false
        if (root.data <= minVal || root.data >= maxVal) return false;

        // Recursively check left and right subtrees
        return isBSTUtil(root.left, minVal, root.data) &&
               isBSTUtil(root.right, root.data, maxVal);
    }

    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
