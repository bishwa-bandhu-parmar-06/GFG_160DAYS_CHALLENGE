// Minimum cost to connect all houses in a city
// Difficulty: MediumAccuracy: 64.58%Submissions: 17K+Points: 4
// Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location of each house, the task is to find the minimum cost to connect all the houses of the city.

// The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.



class Solution {

    public int minCost(int[][] houses) {
        int n = houses.length;
        if (n == 1) return 0;

        // We'll use Prim's algorithm.
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {cost, node}

        // Start from node 0 with cost 0.
        pq.offer(new int[]{0, 0});
        int totalCost = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int cost = top[0], u = top[1];

            if (visited[u]) continue;
            visited[u] = true;
            totalCost += cost;

            // Add edges from u to all unvisited nodes.
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = manhattan(houses[u], houses[v]);
                    pq.offer(new int[]{dist, v});
                }
            }
        }

        return totalCost;
    }

    // Manhattan distance between two points.
    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

