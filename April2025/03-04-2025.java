// Rotten Oranges
// Difficulty: MediumAccuracy: 46.02%Submissions: 171K+Points: 4Average Time: 20m
// Given a matrix mat[][] of dimension n * m where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
// 0 : Empty cell
// 1 : Cell have fresh oranges
// 2 : Cell have rotten oranges

// We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.

// Note: Your task is to return the minimum time to rot all the fresh oranges. If not possible returns -1.




class Solution {
    public int orangesRotting(int[][] mat) {
        if (mat == null || mat.length == 0) return -1;
        
        int n = mat.length, m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0, time = 0;

        // Step 1: Collect all initially rotten oranges and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // Store row, col, time
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh orange exists, return 0
        if (freshCount == 0) return 0;

        // Step 2: BFS to rot fresh oranges
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] rotten = queue.poll();
            int i = rotten[0], j = rotten[1], t = rotten[2];

            for (int[] dir : directions) {
                int ni = i + dir[0], nj = j + dir[1];

                if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1) {
                    mat[ni][nj] = 2; // Rot the fresh orange
                    queue.offer(new int[]{ni, nj, t + 1});
                    freshCount--; // Reduce fresh count
                    time = t + 1; // Update time
                }
            }
        }

        return freshCount == 0 ? time : -1; // If fresh oranges remain, return -1
    }
}
