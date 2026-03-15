// Vertical Tree Traversal
// Difficulty: MediumAccuracy: 32.87%Submissions: 222K+Points: 4Average Time: 45m
// Given the root of a Binary Tree, find the vertical traversal of the tree starting from the leftmost level to the rightmost level.

// Note: If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.


class Solution {
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Pair> queue = new ArrayDeque<>();
        
        if(root==null) return ans;
        
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int lvl = pair.lvl;
            
            map.computeIfAbsent(lvl, level -> new ArrayList<>()).add(node.data);
            
            if(node.left!=null) queue.add(new Pair(node.left, lvl-1));
            if(node.right!=null) queue.add(new Pair(node.right, lvl+1));
        }
        
        for(int horizontalDist : map.keySet()) {
            ans.add(map.get(horizontalDist));
        }
        
        return ans;
    }
    
    static class Pair {
        Node node;
        int lvl;
        
        public Pair(Node node, int lvl) {
            this.node = node;
            this.lvl = lvl;
        }
    }
}