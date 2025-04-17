// Minimum Weight Cycle
// Difficulty: HardAccuracy: 79.2%Submissions: 1K+Points: 8
// Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents the edge between the nodes u and v having w edge weight.
// Your task is to find the minimum weight cycle in this graph.

class Solution {
    static final int INF = 1000000000;

    public int findMinCycle(int V, int[][] edges) {
        int[][] dist = new int[V][V];

        // Initialize distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // Fill initial distances from edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = Math.min(dist[u][v], w); // in case of multiple edges
            dist[v][u] = Math.min(dist[v][u], w);
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minCycle = INF;

        // Try removing each edge and finding the shortest path between its nodes
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            // Check for cycle: path from u to v + direct edge
            if (dist[u][v] < INF) {
                minCycle = Math.min(minCycle, dist[u][v] + w);
            }
        }

        return minCycle == INF ? -1 : minCycle;
    }
}
