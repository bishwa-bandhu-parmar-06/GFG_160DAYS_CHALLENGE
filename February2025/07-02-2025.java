// Inorder Traversal
// Difficulty: EasyAccuracy: 67.15%Submissions: 176K+Points: 2Average Time: 15m
// Given a Binary Tree, your task is to return its In-Order Traversal.

// An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).

// Follow Up: Try solving this with O(1) auxiliary space.

class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Node current = root;

        while (current != null) {
            if (current.left == null) {
                // Visit the current node and move right
                result.add(current.data);
                current = current.right;
            } else {
                // Find the inorder predecessor of current
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Create a temporary thread to return to current later
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } 
                // Remove the thread and visit the current node
                else {
                    predecessor.right = null;
                    result.add(current.data);
                    current = current.right;
                }
            }
        }
        return result;
    }
}