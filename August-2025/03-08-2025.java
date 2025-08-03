class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] op) {
        // code here
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        
        int n=op.length;
        for(int i=0;i<n;i++){
            int sum = op[i][0];
            int r1=op[i][1];
            int c1=op[i][2];
            int r2=op[i][3];
            int c2=op[i][4];
            
            for(int j=r1;j<=r2;j++){
                for(int k=c1;k<=c2;k++){
                    mat[j][k]+=sum;
                }
            }
        }
        
        int r=mat.length;
        int c=mat[0].length;
        
        for(int i=0;i<r;i++){
            ArrayList<Integer> in = new ArrayList<>();
            for(int j=0;j<c;j++){
                in.add(mat[i][j]);
            }
            li.add(in);
        }
        
        return li;
    }
}