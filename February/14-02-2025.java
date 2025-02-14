// Fixing Two nodes of a BST
// Difficulty: HardAccuracy: 53.68%Submissions: 56K+Points: 8Average Time: 45m
// Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
// Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).



class Solution {
    Node first, middle, last, prev;
    
    void correctBST(Node root) {
        first = middle = last = prev = null;
        
        // Perform inorder traversal and identify swapped nodes
        inorder(root);
        
        // Fix the swapped nodes
        if (first != null && last != null) {
            // Case 1: Non-adjacent nodes swapped
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            // Case 2: Adjacent nodes swapped
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    void inorder(Node root) {
        if (root == null) return;
        
        inorder(root.left);
        
        // Identify swapped nodes
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        
        prev = root;
        
        inorder(root.right);
    }
}
