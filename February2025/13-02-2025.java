// Pair Sum in BST
// Difficulty: Medium        Accuracy: 44.02%         Submissions: 67K+       Points: 4     Average Time: 40m
// Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

class Solution {
    boolean findTarget(Node root, int target) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        
        int left = 0, right = inorderList.size() - 1;
        
        while (left < right) {
            int sum = inorderList.get(left) + inorderList.get(right);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inorderTraversal(Node root, List<Integer> inorderList) {
        if (root == null) return;
        inorderTraversal(root.left, inorderList);
        inorderList.add(root.data);
        inorderTraversal(root.right, inorderList);
    }
}
