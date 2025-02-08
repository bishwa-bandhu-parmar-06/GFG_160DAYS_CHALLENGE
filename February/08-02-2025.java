// Tree Boundary Traversal
// Difficulty: MediumAccuracy: 23.33%Submissions: 432K+Points: 4Average Time: 35m
// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

// Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

// Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

// Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 




class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        if (!isLeaf(node)) result.add(node.data); // Root node (not added if it's a leaf)

        addLeftBoundary(node.left, result);
        addLeaves(node, result);
        addRightBoundary(node.right, result);

        return result;
    }

    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) temp.add(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i)); // Reverse order
        }
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
}
