// Median of BST
// Difficulty: MediumAccuracy: 27.43%Submissions: 103K+Points: 4
// You are given the root of a Binary Search Tree, find the median of it. 

// Let the nodes of the BST, when written in ascending order (inorder traversal), be represented as V1, V2, V3, …, Vn, where n is the total number of nodes in the BST.

// If number of nodes are even: return V(n/2)
// If number of nodes are odd: return V((n+1)/2)


class Solution {
    public int findMedian(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, ans);
        Collections.sort(ans);
        int n = ans.size();
        int idx = (n + 1) / 2;
        return ans.get(idx-1);
    }
    
    public static void helper(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        ans.add(root.data);
        helper(root.left, ans);
        helper(root.right, ans);
    
    }
}