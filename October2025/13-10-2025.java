// Maximum Non-Adjacent Nodes Sum
// Difficulty: MediumAccuracy: 55.35%Submissions: 97K+Points: 4Average Time: 45m
// Given the root of a binary tree with integer values. Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, neither its parent nor its children can be included.


/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
     //public int getMaxSum(Node root) {
    //     // code here
    private int[] helper(Node root) {
        if (root == null)
            return new int[]{0, 0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

       
        int include = root.data + left[1] + right[1];

        
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{include, exclude};
    }

    public int getMaxSum(Node root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();

      
        Node root1 = new Node(11);
        root1.left = new Node(1);
        root1.right = new Node(2);
        System.out.println(sol.getMaxSum(root1)); // Output: 11

       
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.right.left = new Node(5);
        root2.right.right = new Node(6);
        System.out.println(sol.getMaxSum(root2));
    }
}

