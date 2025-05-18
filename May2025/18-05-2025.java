// Level Order in spiral form
// Difficulty: EasyAccuracy: 36.43%Submissions: 225K+Points: 2Average Time: 20m
// Given a binary tree and the task is to find the spiral order traversal of the tree and return the list containing the elements.
// Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels we print the node's value from left to right.
// For below tree, function should return [1, 2, 3, 4, 5, 6, 7]

class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<Node> s1 = new Stack<>(); 
        Stack<Node> s2 = new Stack<>(); 
        
        // Push first level to first stack 's1'
        s1.push(root);

        // Keep printing while any of the stacks has some nodes
        while (!s1.isEmpty() || !s2.isEmpty()) {

            // Print nodes of current level from s1 and 
            // push nodes of next level to s2
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                res.add(temp.data);

                // Note that right child is pushed before left
                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }

            // Print nodes of current level from s2 and 
            // push nodes of next level to s1
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                res.add(temp.data);

                // Note that left child is pushed before right
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }

        return res;
    }
}