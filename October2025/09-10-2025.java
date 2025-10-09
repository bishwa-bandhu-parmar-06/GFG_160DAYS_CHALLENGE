


// Postorder Traversal
// Difficulty: EasyAccuracy: 74.96%Submissions: 138K+Points: 2Average Time: 15m
// Given the root of a Binary Tree, your task is to return its Postorder Traversal.

// Note: A postorder traversal first visits the left child (including its entire subtree), then visits the right child (including its entire subtree), and finally visits the node itself.


class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        if(root == null) return list;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.data);
        
        return list;
        
    }
}