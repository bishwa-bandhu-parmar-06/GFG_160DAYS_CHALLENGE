// Topological sort
// Difficulty: MediumAccuracy: 56.52%Submissions: 277K+Points: 4Average Time: 15m
// Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes an directed edge u -> v. Return topological sort for the given graph.

// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
// Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // Step 1: Create adjacency list and in-degree array
        ArrayList<Integer> adj[] = new ArrayList[V];
        int[] inDegree = new int[V];
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Build the graph and compute in-degree for each vertex
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            inDegree[v]++;
        }
        
        // Step 2: Initialize queue with vertices having 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Step 3: Process the queue and perform topological sort
        ArrayList<Integer> topoOrder = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);
            
            // Reduce in-degree of neighbors
            for (int v : adj[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        // Step 4: If we processed all vertices, return the result
        // Else, there is a cycle and topological sorting is not possible
        if (topoOrder.size() == V) {
            return topoOrder;
        } else {
            return new ArrayList<>(); // Return an empty list if there is a cycle
        }
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
            {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };
        
        ArrayList<Integer> result = topoSort(V, edges);
        if (result.isEmpty()) {
            System.out.println("Cycle detected. Topological sorting not possible.");
        } else {
            System.out.println("Topological Sort: " + result);
        }
    }
}
