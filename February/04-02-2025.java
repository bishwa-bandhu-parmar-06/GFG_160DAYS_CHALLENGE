// Diameter of a Binary Tree
// Difficulty: MediumAccuracy: 47.37%Submissions: 324K+Points: 4Average Time: 20m
// Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.

class Solution {
    int fans=0;
    int diameter(Node root) {
        depth(root);
        return fans;
    }
    int depth(Node root){
        if(root==null) return 0;
        int l=depth(root.left); 
        int r=depth(root.right); 
        fans=Math.max(fans,l+r);
        return 1+Math.max(l,r);
    }
}