// Left View of Binary Tree
// Difficulty: EasyAccuracy: 33.74%Submissions: 555K+Points: 2Average Time: 20m
// You are given the root of a binary tree. Your task is to return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.

// If the tree is empty, return an empty list.


class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> solution = new ArrayList<>();
        if (root == null) return solution;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            solution.add(queue.peek().data);
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node currNode = queue.poll();
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }
        
        return solution;
    }
}