// Count the paths
// Difficulty: MediumAccuracy: 42.71%Submissions: 49K+Points: 4Average Time: 10m
// Given a Directed Acyclic Graph (DAG) with V nodes labeled from 0 to V-1, and a list of directed edges, count the total number of distinct paths from a given start node to a destination node. Each edge is represented as edges[i] = [u, v], indicating a directed edge from u to v.


class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        
        Integer[] memo = new Integer[V];
        
        return dfs(graph, src, dest, memo);
    }
    
    private int dfs(List<List<Integer>> graph, int node, int dest, Integer[] memo){
        if(node == dest) return 1;
        
        if(memo[node] != null) return memo[node];
        
        int totalPaths = 0;
        
        for(int neighbor : graph.get(node)){
            totalPaths += dfs(graph, neighbor, dest, memo);
        }
        
        memo[node] = totalPaths;
        
        return totalPaths;
    }
}