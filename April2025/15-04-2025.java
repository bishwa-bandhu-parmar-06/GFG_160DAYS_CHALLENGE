// Bellman-Ford
// Difficulty: MediumAccuracy: 48.11%Submissions: 181K+Points: 4Average Time: 25m
// Given an weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents a direct edge from node u to v having w edge weight. You are also given a source vertex src.

// Your task is to compute the shortest distances from the source to all other vertices. If a vertex is unreachable from the source, its distance should be marked as 108. Additionally, if the graph contains a negative weight cycle, return [-1] to indicate that shortest paths cannot be reliably computed.


class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int INF = 100000000;
        int[] dist = new int[V];

        // Step 1: Initialize distances from src to all other vertices as INF
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
        }
        dist[src] = 0;

        // Step 2: Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != INF && dist[u] + w < dist[v]) {
                return new int[]{-1}; // Negative cycle detected
            }
        }

        return dist;
    }
}
