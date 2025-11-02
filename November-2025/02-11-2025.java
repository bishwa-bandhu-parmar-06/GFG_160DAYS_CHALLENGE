// Max DAG Edges
// Difficulty: MediumAccuracy: 73.45%Submissions: 7K+Points: 4
// Given a directed acyclic graph (DAG) with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v, find the maximum number of additional edges that can be added to the graph without forming any cycles.

// Note: The resulting graph must remain a DAG, meaning that adding any further edge would not create a cycle.


class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        return (V * (V - 1)) / 2 - edges.length;
    }
}