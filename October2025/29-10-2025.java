// Graph Diameter
// Difficulty: MediumAccuracy: 72.38%Submissions: 7K+Points: 4
// You are given an undirected connected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and vertex v.
// Find the diameter of the graph.
// The diameter of a graph (sometimes called the width) is the number of edges on the longest path between two vertices in the graph.

// Note: Graph do not contains any cycle.


class Solution {
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int nodeA = bfs(0, adj, V)[0];
        int[] result = bfs(nodeA, adj, V);
        return result[1];
    }
    private int[] bfs(int start, List<List<Integer>> adj, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        int farthestNode = start;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : adj.get(node)) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                    if (dist[nei] > dist[farthestNode]) {
                        farthestNode = nei;
                    }
                }
            }
        }
        return new int[]{farthestNode, dist[farthestNode]};
    }
}