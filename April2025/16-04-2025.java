// Floyd Warshall
// Difficulty: MediumAccuracy: 32.89%Submissions: 182K+Points: 4Average Time: 15m
// You are given an weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
// The graph may contain negative edge weights, but it does not contain any negative weight cycles.

// Your task is to find the shortest distance between every pair of nodes i and j in the graph.

// Note: Modify the distances for every pair in place.


class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Avoid integer overflow when dist[i][k] or dist[k][j] is 'infinity'
                    if (dist[i][k] != 1e8 && dist[k][j] != 1e8) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
    }
}
