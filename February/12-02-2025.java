// k-th Smallest in BST
// Difficulty: MediumAccuracy: 43.53%Submissions: 125K+Points: 4Average Time: 40m
// Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.

class Solution {
    int count = 0, result = -1;
    
    public int kthSmallest(Node root, int k) {
        inorder(root, k);
        return result;
    }
    
    private void inorder(Node node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.data;
            return;
        }

        inorder(node.right, k);
    }
}
