// Check if subtree
// Difficulty: MediumAccuracy: 24.34%Submissions: 161K+Points: 4Average Time: 45m
// Given two binary trees with roots root1 (for tree T) and root2 (for tree S), each containing at most N nodes. Determine whether tree S is a subtree of tree T.

// Return true if S is a subtree of T, otherwise return false.

// Note: A tree S is considered a subtree of T if there exists a node in T such that the subtree rooted at that node is identical to S. Two trees are identical if they have the same structure and the same node values.

// Examples:

// Input: root1 = [1, 2, 3, N, N, 4], root2 = [3, 4]
             
// Output: true 
// Explanation: In the tree rooted at root1, the subtree starting at node 3 is identical to the tree rooted at root2 (same structure and node values). Hence, root2 is a subtree of root1, so the output is true.
// Input: root1 = [26, 10, N, 20, 30, 40, 60], root2 = [26, 10, N, 20, 30, 40, 60]
                        
// Output: true 
// Explanation: Both root1 and root2 represent identical trees. So, root2 is a subtree of root1, and the output is true.
// Constraints:
// 1 ≤ n ≤ 103
// 1 ≤ value of nodes ≤ 104


/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
     public boolean isSubTreeEqual(Node root1, Node root2) {
        // Base Case
        // Both null
        if(root1 == null && root2 == null) {
            return true;
        }
        // Anyone one is null or data isnt matching
        if(root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        
        // Matching left & right
        return isSubTreeEqual(root1.left, root2.left) && isSubTreeEqual(root1.right, root2.right);
    }
    
    public boolean isSubTree(Node root1, Node root2) {
        // Base Case
        if(root1 == null ) {
            return false;
        }
        // Matching data and subtree
        if(root1.data == root2.data && isSubTreeEqual(root1, root2)) {
            return true;
        }
        
        // Checking left & right
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }
}