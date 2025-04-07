// Directed Graph Cycle
// Difficulty: MediumAccuracy: 27.88%Submissions: 467K+Points: 4
// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
// The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call DFS for every vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, recStack, adj)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                // Node is in the recursion stack -> cycle found
                return true;
            }
        }

        recStack[node] = false; // remove the node from recursion stack
        return false;
    }
}
