// Level order traversal
// Difficulty: EasyAccuracy: 70.31%Submissions: 222K+Points: 2
// Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.


class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                level.add(node.data);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            
            ans.add(level);
        }
        
        return ans;
    }
}