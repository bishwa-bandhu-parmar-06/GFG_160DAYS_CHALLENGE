// Closest Neighbour in BST
// Difficulty: EasyAccuracy: 36.98%Submissions: 56K+Points: 2
// Given the root of a binary search tree and a number k, find the greatest number in the binary search tree that is less than or equal to k.


class Solution {
    int ans = -1;
    void inOrder(Node root,int k) {
        if(root == null) return;
        
        inOrder(root.left,k);
        if(root.data <= k) {
            ans = Math.max(ans,root.data);
            inOrder(root.right,k);
        }
    }
    public int findMaxFork(Node root, int k) {
        inOrder(root,k);
        return ans;
    }
}