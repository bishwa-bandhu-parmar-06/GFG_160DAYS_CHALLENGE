// BST with Dead End
// Difficulty: MediumAccuracy: 35.99%Submissions: 91K+Points: 4
// You are given a Binary Search Tree (BST) containing unique positive integers greater than 0.

// Your task is to determine whether the BST contains a dead end.

// Note: A dead end is a leaf node in the BST such that no new node can be inserted in the BST at or below this node while maintaining the BST property and the constraint that all node values must be > 0.


class Solution {
    static boolean dfs(Node root, int mini, int maxi){
        if(root == null) return false;
        
        // Leaf node and no space for new node → dead end
        if(root.left == null && root.right == null && mini == maxi)
            return true;

        // Check left and right subtrees
        return dfs(root.left, mini, root.data - 1) || 
               dfs(root.right, root.data + 1, maxi);
    }

    public boolean isDeadEnd(Node root) {
        return dfs(root, 1, Integer.MAX_VALUE);
    }
}

