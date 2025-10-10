// ZigZag Tree Traversal
// Difficulty: MediumAccuracy: 54.05%Submissions: 186K+Points: 4Average Time: 30m
// Given the root of a binary tree. You have to find the zig-zag level order traversal of the binary tree.
// Note: In zig zag traversal we traverse the nodes from left to right for odd-numbered levels, and from right to left for even-numbered levels.

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] level = new Integer[size];
            
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                int index = leftToRight ? i : size - 1 - i;
                level[index] = node.data;
                
                if (node.left != null)
                    q.offer(node.left);
                    
                if (node.right != null)
                    q.offer(node.right);
            }
            
            leftToRight = !leftToRight;
            ans.addAll(Arrays.asList(level));
        }
        
        return ans;
    }
}