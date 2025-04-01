// K Sum Paths
// Difficulty: MediumAccuracy: 44.73%Submissions: 114K+Points: 4
// Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

class Solution {
    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // To handle case where path sum itself is k
        return dfs(root, 0, k, prefixSumMap);
    }
    
    private int dfs(Node node, int currentSum, int k, HashMap<Integer, Integer> prefixSumMap) {
        if (node == null) return 0;

        // Add current node's value to running sum
        currentSum += node.data;

        // Check if a subpath exists with sum (currentSum - k)
        int count = prefixSumMap.getOrDefault(currentSum - k, 0);

        // Store the current sum in the map
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // Recur for left and right children
        count += dfs(node.left, currentSum, k, prefixSumMap);
        count += dfs(node.right, currentSum, k, prefixSumMap);

        // Backtrack: Remove the current sum before returning to the parent
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);
        
        return count;
    }
}
