// Top View of Binary Tree
// Difficulty: MediumAccuracy: 38.43%Submissions: 446K+Points: 4Average Time: 45m
// You are given the root of a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

// Note:

// Return the nodes from the leftmost node to the rightmost node.
// If multiple nodes overlap at the same horizontal position, only the topmost (closest to the root) node is included in the view. 


/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> li = new ArrayList<>();
        if(root == null) return li;
        Map<Integer,Integer> mp = new TreeMap<>();
        Queue<Node> qn=new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        qn.add(root);
        q.add(0);
        
        while(!qn.isEmpty()){
            Node node = qn.poll();
            int h = q.poll();
            mp.putIfAbsent(h,node.data);
            
            if(node.left!=null){
                qn.add(node.left);
                q.add(h-1);
            }
            if(node.right!=null){
                qn.add(node.right);
                q.add(h+1);
            }
        }
        li.addAll(mp.values());
        return li;
    }
}