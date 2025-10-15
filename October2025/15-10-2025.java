// k-th Smallest in BST
// Difficulty: MediumAccuracy: 43.53%Submissions: 149K+Points: 4Average Time: 40m
// Given the root of a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.


class Solution {
    private int kSmallest(Node root, int[] k) {
        if (root == null) return -1;

        int left = kSmallest(root.left, k);
        if (left != -1) return left;

        if (k[0] == 1) return root.data;
        k[0]--;

        return kSmallest(root.right, k);
    }

    public int kthSmallest(Node root, int k) {
        return kSmallest(root, new int[]{k});
    }
}