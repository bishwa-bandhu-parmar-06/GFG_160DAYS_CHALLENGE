// Max rectangle
// Difficulty: HardAccuracy: 36.43%Submissions: 123K+Points: 8Average Time: 35m
// You are given a 2D binary matrix mat[ ][ ], where each cell contains either 0 or 1. Your task is to find the maximum area of a rectangle that can be formed using only 1's within the matrix.


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][]) {
        // add code here.
        int n=M.length;
        int m=M[0].length;
        int[]arr=new int[m];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(M[i][j]==1)arr[j]++;
                else arr[j]=0;
            }
            res=Math.max(res,largestRectangleArea(arr));
        }
        return res;
    }
    int largestRectangleArea(int[] hist) {
        int n=hist.length;
        Stack<Integer>s=new Stack<>();
        s.push(0);
        int ans=0;
        for(int i=1;i<n;i++){
            while(!s.isEmpty() && hist[s.peek()]>=hist[i])
            {
                int j=s.pop();
                int sum=(s.isEmpty()) ? hist[j]*i:hist[j]*(i-s.peek()-1);
                ans=Math.max(ans,sum);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int tp=s.pop();
            int sum=(s.isEmpty()) ? hist[tp]*n:hist[tp]*(n-s.peek()-1);
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}