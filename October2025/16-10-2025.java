// Remove BST keys outside given range
// Difficulty: MediumAccuracy: 59.43%Submissions: 14K+Points: 4
// Given the root of a Binary Search Tree (BST) and two integers l and r, remove all the nodes whose values lie outside the range [l, r].

// Note: The modified tree should also be BST and the sequence of the remaining nodes should not be changed.

class Solution {
    Node removekeys(Node root, int l, int r) {
        if (root == null) return null;
        if (root.data < l) {
            return removekeys(root.right, l, r);
        }
        if (root.data > r) {
            return removekeys(root.left, l, r);
        }
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);
        return root;
    }
}