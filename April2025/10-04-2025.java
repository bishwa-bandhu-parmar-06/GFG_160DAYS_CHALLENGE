// Minimum cost to connect all houses in a city
// Difficulty: MediumAccuracy: 70.36%Submissions: 9K+Points: 4
// Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location of each house, the task is to find the minimum cost to connect all the houses of the city.

// The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.




class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        
        // Initialize distances as max value
        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        
        // Start from house 0
        minDist[0] = 0;
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            // Find the unvisited node with minimum distance
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            totalCost += minDist[u];

            // Update distances for remaining nodes
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int cost = Math.abs(houses[u][0] - houses[v][0]) + Math.abs(houses[u][1] - houses[v][1]);
                    if (cost < minDist[v]) {
                        minDist[v] = cost;
                    }
                }
            }
        }

        return totalCost;
    }
}
