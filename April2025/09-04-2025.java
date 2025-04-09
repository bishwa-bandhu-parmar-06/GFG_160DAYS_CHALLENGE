// Articulation Point - II
// Difficulty: HardAccuracy: 55.15%Submissions: 22K+Points: 8Average Time: 30m
// You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
// Your task is to return all the articulation points (or cut vertices) in the graph.
// An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

// Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
// If no such point exists, return {-1}.


class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[V];
        int[] disc = new int[V];  // Discovery times
        int[] low = new int[V];   // Lowest discovery time reachable
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];  // Articulation points
        Arrays.fill(parent, -1);

        time = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, visited, disc, low, parent, ap, adj);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (ap[i]) result.add(i);
        }
        if (result.isEmpty()) result.add(-1);
        return result;
    }

    static int time;

    static void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap, ArrayList<Integer>[] adj) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, visited, disc, low, parent, ap, adj);

                low[u] = Math.min(low[u], low[v]);

                // Case 1: u is root and has two or more children
                if (parent[u] == -1 && children > 1)
                    ap[u] = true;

                // Case 2: u is not root and low[v] >= disc[u]
                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent[u]) {
                // Update low value of u for back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
