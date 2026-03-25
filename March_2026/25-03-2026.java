// Minimum height roots
// Difficulty: MediumAccuracy: 72.83%Submissions: 7K+Points: 4
// You are given an undirected graph, which has tree characteristics with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an edge from vertex u to v.

// You can choose any vertex as the root of the tree. Your task is to find all the vertices that, when chosen as the root, result in the minimum possible height of the tree.

// Note: The height of a rooted tree is defined as the maximum number of edges on the path from the root to any leaf node.


class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 1 ; i <= V ; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(V > 2){
            int size = q.size();
            V -= size;
            while(size > 0){
                int u = q.remove();
                for(int v : adj.get(u)){
                    indegree[v]--;
                    if(indegree[v] == 1){
                        q.add(v);
                    }
                }
                size--;
            }
        }
        while(!q.isEmpty()){
            result.add(q.remove());
        }
        
        return result;
    }
}