// Largest BST
// Difficulty: MediumAccuracy: 29.73%Submissions: 201K+Points: 4Average Time: 40m
// You're given a binary tree. Your task is to find the size of the largest subtree within this binary tree that also satisfies the properties of a Binary Search Tree (BST). The size of a subtree is defined as the number of nodes it contains.

// Note: A subtree of the binary tree is considered a BST if for every node in that subtree, the left child is less than the node, and the right child is greater than the node, without any duplicate values in the subtree.


class Solution {
    
    static class Info {
        boolean isBST;
        int size;
        int min, max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxSize;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        maxSize = 0;
        postorder(root);
        return maxSize;
    }
    
    private static Info postorder(Node node) {
        if (node == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = postorder(node.left);
        Info right = postorder(node.right);

        // Check BST property
        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size);
            int minVal = Math.min(node.data, left.min);
            int maxVal = Math.max(node.data, right.max);
            return new Info(true, size, minVal, maxVal);
        } else {
            // Not a BST
            return new Info(false, Math.max(left.size, right.size), 0, 0);
        }
    }
}