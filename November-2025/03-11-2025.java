// Safe States
// Difficulty: MediumAccuracy: 55.52%Submissions: 78K+Points: 4Average Time: 20m
// Given a directed graph with V vertices numbered from 0 to V-1 and E directed edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents a directed edge from vertex u to vertex v. Return all Safe Nodes of the graph.
// A vertex with no outgoing edges is called a terminal node. A vertex is considered safe if every path starting from it eventually reaches a terminal node.


class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
        int[] outdeg = new int[V];
        for (int i = 0; i < V; i++) 
            revGraph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            revGraph.get(v).add(u);
            outdeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> safe = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (outdeg[i] == 0){
                q.add(i);
            } 
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            safe.add(node);
            
            for (int parent : revGraph.get(node)) {
                outdeg[parent]--;
                if (outdeg[parent] == 0){
                    q.add(parent);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}