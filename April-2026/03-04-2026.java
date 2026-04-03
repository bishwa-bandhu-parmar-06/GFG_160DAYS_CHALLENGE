// Print Diagonally
// Difficulty: EasyAccuracy: 66.11%Submissions: 42K+Points: 2Average Time: 10m
// Give a n * n square matrix mat[][], return all the elements of its anti-diagonals from top to bottom.


class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = mat.length, m = mat[0].length;
        
        for(int i=0;i<m;i++){
            int j=i, k = 0;
            
            while(k<n && j>=0){
                ans.add(mat[k][j]);
                k++;
                j--;
            }
        }
        for(int i=1;i<n;i++){
            int j=m-1, k = i;
            
            while(k<n && j>=0){
                ans.add(mat[k][j]);
                k++;
                j--;
            }
        }
        return ans;
    }
}