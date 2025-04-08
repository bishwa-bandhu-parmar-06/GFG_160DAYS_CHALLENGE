// Bridge edge in a graph
// Difficulty: MediumAccuracy: 34.61%Submissions: 61K+Points: 4
// // Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.

// Note:

// An edge is called a bridge if removing it increases the number of connected components of the graph.
// if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.
// Examples :

class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // Build the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Perform DFS from c, skipping the edge (c, d)
        boolean[] visited = new boolean[V];
        dfs(c, visited, adj, c, d);

        // If d is not visited, then the edge is a bridge
        return !visited[d];
    }

    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            // Skip the edge (c, d) or (d, c)
            if ((node == c && neighbor == d) || (node == d && neighbor == c)) {
                continue;
            }
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, c, d);
            }
        }
    }
}
