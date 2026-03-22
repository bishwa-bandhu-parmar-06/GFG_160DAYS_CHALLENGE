// Rotten Oranges
// Difficulty: MediumAccuracy: 46.02%Submissions: 204K+Points: 4Average Time: 20m
// Given a matrix mat[][], where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
// 0 : Empty cell
// 1 : Cell have fresh oranges
// 2 : Cell have rotten oranges

// Your task is to determine the minimum time required so that all the oranges become rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.

// Note: If it is impossible to rot every orange then simply return -1.

class Solution {
    class State {
        int r, c, t;
        
        State(int _r, int _c, int _t) {
            this.r = _r;
            this.c = _c;
            this.t = _t;
        }
    }
    
    public int orangesRot(int[][] mat) {
        
        int m = mat.length, n = mat[0].length;
        Queue<State> q = new LinkedList<State>();
        
        int fresh = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 2) {
                    q.offer(new State(i, j, 0));
                }
                else if (mat[i][j] == 1) fresh++;
            }
        }
        
        int mt = 0;
        while(!q.isEmpty()) {
            State s = q.poll();
            
            mt = Math.max(mt, s.t);
            
            int[][] del = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};
            for(int i=0; i<4; i++) {
                int nr = s.r + del[i][0];
                int nc = s.c + del[i][1];
                
                if((nr >= 0 && nr < m) && (nc >= 0 && nc < n) && mat[nr][nc] == 1) {
                    q.offer(new State(nr, nc, s.t + 1));
                    mat[nr][nc] = 2;
                    fresh--;
                }
            }
        }
        
        if(fresh != 0) return -1;
        return mt;
    }
}
