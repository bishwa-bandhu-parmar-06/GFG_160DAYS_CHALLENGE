// Minimum Weight Cycle
// Difficulty: HardAccuracy: 79.2%Submissions: 1K+Points: 8
// Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents the edge between the nodes u and v having w edge weight.
// Your task is to find the minimum weight cycle in this graph.

class Solution {
    public int findMinCycle(int V, int[][] edges) {
        final int INF = (int)1e9;

        // Adjacency list: each node stores a list of (neighbor, weight)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int minCycle = INF;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            // Temporarily remove the edge (u, v)
            removeEdge(adj, u, v);
            removeEdge(adj, v, u);

            // Dijkstra from u to v
            int[] dist = new int[V];
            Arrays.fill(dist, INF);
            dist[u] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            pq.offer(new int[]{0, u});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int d = curr[0], node = curr[1];

                if (d > dist[node]) continue;

                for (int[] nei : adj.get(node)) {
                    int neighbor = nei[0], wt = nei[1];
                    if (dist[node] + wt < dist[neighbor]) {
                        dist[neighbor] = dist[node] + wt;
                        pq.offer(new int[]{dist[neighbor], neighbor});
                    }
                }
            }

            // If path from u to v exists, a cycle exists
            if (dist[v] != INF) {
                minCycle = Math.min(minCycle, dist[v] + w);
            }

            // Restore the edge
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        return minCycle == INF ? -1 : minCycle;
    }

    private void removeEdge(List<List<int[]>> adj, int from, int to) {
        adj.get(from).removeIf(edge -> edge[0] == to);
    }
}
