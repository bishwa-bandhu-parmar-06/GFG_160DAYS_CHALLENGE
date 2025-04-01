// Lowest Common Ancestor in a BST
// Difficulty: EasyAccuracy: 65.2%Submissions: 162K+Points: 2Average Time: 20m
// Given a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2). You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA) of the given two nodes in the BST.

// LCA between two nodes n1 and n2 is defined as the lowest node that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).


class Solution {
    Node LCA(Node root, Node n1, Node n2) {
        if (root == null) {
            return null;
        }
        
        // If both n1 and n2 are smaller than root, then LCA lies in the left subtree
        if (root.data > n1.data && root.data > n2.data) {
            return LCA(root.left, n1, n2);
        }
        
        // If both n1 and n2 are greater than root, then LCA lies in the right subtree
        if (root.data < n1.data && root.data < n2.data) {
            return LCA(root.right, n1, n2);
        }
        
        // If one of n1 or n2 matches the root or they are on different sides, root is the LCA
        return root;
    }
}
