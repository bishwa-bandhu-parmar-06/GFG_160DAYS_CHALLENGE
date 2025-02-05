// Mirror Tree
// Difficulty: EasyAccuracy: 72.67%Submissions: 217K+Points: 2Average Time: 20m
// Given a binary tree, convert the binary tree to its Mirror tree.

// Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.     

class Solution {


    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if( node == null){
            return;
        }

//use temp and just swap it
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.right);
        mirror(node.left);
         
    }
}