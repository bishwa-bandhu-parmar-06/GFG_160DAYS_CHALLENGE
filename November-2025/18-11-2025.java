// Number of Ways to Arrive at Destination
// Difficulty: MediumAccuracy: 61.13%Submissions: 86K+Points: 4Average Time: 30m
// You are given an undirected weighted graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where edges[i] = [ui, vi, timei] means that there is an undirected edge between nodes ui and vi that takes timei minutes to reach.
// Your task is to return in how many ways you can travel from node 0 to node V - 1 in the shortest amount of time.



class Solution {
    public int countPaths(int V, int[][] edges) {
        // code here
          final long MOD = (long)1e9 + 7;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        long[] dist = new long[V];
        long[] ways = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int u = (int) top[1];
            if (d > dist[u]) continue;
            for (int[] nxt : adj.get(u)) {
                int v = nxt[0];
                long w = nxt[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    ways[v] = ways[u];
                    pq.add(new long[]{dist[v], v});
                }
                else if (dist[v] == dist[u] + w) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return (int)(ways[V - 1] % MOD);
    }
}