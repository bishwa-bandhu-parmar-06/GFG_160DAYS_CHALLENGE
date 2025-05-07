// Root to Leaf Paths
// Difficulty: MediumAccuracy: 43.65%Submissions: 143K+Points: 4Average Time: 30m
// Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

// Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the right subtree.


class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        solve(root, ans, path );
        return ans; 
    }
    public static void solve(Node root , ArrayList<ArrayList<Integer>> ans,
    ArrayList<Integer> path){
        if(root == null)
            return ;
        
        path.add(root.data);
        
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(path));
        }
        
         solve(root.left , ans, path);
         solve(root.right , ans , path);
         
         //Backtrack
         path.remove(path.size() - 1);
    }
}

