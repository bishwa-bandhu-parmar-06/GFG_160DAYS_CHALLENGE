// Bottom View of Binary Tree
// Difficulty: MediumAccuracy: 54.18%Submissions: 329K+Points: 4Average Time: 45m
// You are given the root of a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

// Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.


// Lokesh Java language
class Solution {
    
    static class Pair {
        Node node;
        int hd;  // horizontal distance
        
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        // Map to store the last (bottom-most) node at each horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0)); // root has horizontal distance 0
        
        while (!q.isEmpty()) {
            Pair current = q.poll();
            Node node = current.node;
            int hd = current.hd;
            
            // For bottom view, we overwrite previous values for same hd
            map.put(hd, node.data);
            
            // Add left and right children with updated horizontal distances
            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }
        
        // Extract values from the TreeMap in sorted order of horizontal distance
        for (int val : map.values()) {
            result.add(val);
        }
        
        return result;
    }
}