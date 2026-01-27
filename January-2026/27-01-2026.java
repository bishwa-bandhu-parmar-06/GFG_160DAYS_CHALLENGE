// Word Search
// Difficulty: MediumAccuracy: 32.69%Submissions: 85K+Points: 4Average Time: 20m
// You are given a matrix mat[][] of size n*m containing english alphabets and a string word. Check if the word exists on the mat[][] or not. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.


 class Solution {
    int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public boolean solve(int i , int r , int c , char mat[][] , boolean vis[][] , String word){
        if(i >= word.length()){
            return true;
        }
        
        if(r >=  mat.length || r < 0 || c >= mat[0].length || c < 0 || vis[r][c] || (mat[r][c] != word.charAt(i)) )
        return false;
        
        
        boolean check = false;
         vis[r][c] = true;
        
        if(mat[r][c] == word.charAt(i)){
           
            for(int d[] : dir){
               int r1 = r + d[0];
               int c1 = c + d[1];
                if(solve(i+1,r1,c1,mat,vis,word)){
                   return true;}
            }
            
        }
        vis[r][c] = false;
        return check;
    }
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        
        for(int i = 0; i<mat.length; i++ ){
            for(int j = 0 ; j<mat[0].length;j++){
                
                if(solve(0,i,j,mat,vis,word))
                return true;
            }
        }
        return false;
        
    }
} 