// Symmetric Tree
// Difficulty: EasyAccuracy: 44.96%Submissions: 164K+Points: 2Average Time: 20m
// Given the root of a binary tree, check whether it is symmetric, i.e., whether the tree is a mirror image of itself.


// A binary tree is symmetric if the left subtree is a mirror reflection of the right subtree.

class Solution {
    
    boolean f(Node n1, Node n2){
        if(n1==null && n2==null)return true;
        if(n1==null || n2==null)return false;
        
        if(f(n1.left,n2.right)==false)return false;
        if(f(n1.right,n2.left)==false)return false;
        
        if(n1.data!=n2.data)return false;
        if(n1.data!=n2.data)return false;
        return true;
    }
    
    public boolean isSymmetric(Node root) {
        
        return f(root,root);
    }
}