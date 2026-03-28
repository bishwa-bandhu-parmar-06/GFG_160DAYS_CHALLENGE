// Articulation Point - II
// Difficulty: HardAccuracy: 55.15%Submissions: 43K+Points: 8Average Time: 30m
// You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
// Your task is to return all the articulation points (or cut vertices) in the graph.
// An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

// Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
// If no such point exists, return {-1}.


class Solution {

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {

    ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

    for(int i=0;i<V;i++)

    adj.add(new ArrayList<>());

    for(int[]e:edges){

        adj.get(e[0]).add(e[1]);

        adj.get(e[1]).add(e[0]);

    }

        int[] disc = new int[V];

        int[] low = new int[V];

        int[] parent = new int[V];

        int[] childCount = new int[V];

        int[] nextNeighborIdx = new int[V]; // Tracks which neighbor to visit next

        boolean[] isArticulation = new boolean[V];

        int timer = 0;

 

        Arrays.fill(disc, -1);

        Arrays.fill(parent, -1);

 

        for (int i = 0; i < V; i++) {

            if (disc[i] == -1) {

                Stack<Integer> stack = new Stack<>();

                stack.push(i);

                disc[i] = low[i] = ++timer;

 

                while (!stack.isEmpty()) {

                    int u = stack.peek();

                    ArrayList<Integer> neighbors = adj.get(u);

 

                    if (nextNeighborIdx[u] < neighbors.size()) {

                        int v = neighbors.get(nextNeighborIdx[u]++);

                        

                        if (v == parent[u]) continue;

 

                        if (disc[v] == -1) {

                            // Tree Edge

                            parent[v] = u;

                            childCount[u]++;

                            disc[v] = low[v] = ++timer;

                            stack.push(v);

                        } else {

                            // Back Edge

                            low[u] = Math.min(low[u], disc[v]);

                        }

                    } else {

                        // Post-order processing (Backtracking)

                        stack.pop();

                        if (!stack.isEmpty()) {

                            int p = stack.peek();

                            low[p] = Math.min(low[p], low[u]);

                            

                            // Check articulation point condition for non-root

                            if (parent[p] != -1 && low[u] >= disc[p]) {

                                isArticulation[p] = true;

                            }

                        }

                    }

                }

                

                // Root case: Articulation if it has > 1 child in DFS tree

                if (childCount[i] > 1) {

                    isArticulation[i] = true;

                }

            }

        }

 

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            if (isArticulation[i]) result.add(i);

        }

        

        if (result.isEmpty()) result.add(-1);

        return result;

    }

}