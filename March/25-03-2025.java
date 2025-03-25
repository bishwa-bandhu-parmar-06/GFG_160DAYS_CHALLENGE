// Boolean Parenthesization
// Difficulty: HardAccuracy: 20.15%Submissions: 131K+Points: 8Average Time: 30m
// You are given a boolean expression s containing
//     'T' ---> true
//     'F' ---> false 
// and following operators between symbols
//    &   ---> boolean AND
//     |   ---> boolean OR
//    ^   ---> boolean XOR
// Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

// Note: The answer is guaranteed to fit within a 32-bit integer.


// import java.util.*;

class Solution {
    static Integer[][][] dp = new Integer[101][101][2];
   
    static int countWays(String s) {
        
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        int n=s.length();
        int i=0;
        int j=s.length()-1;
        
       int count = recursion(s,0,j,true);
         
        return count;
    }
    
    
    static int recursion(String s,int i,int j,boolean isTrue) {
        
        if(i==j) {
            if(s.charAt(i) == 'T') {
                if(isTrue) return 1;
                else  return 0;
            }
            if(s.charAt(i) == 'F') {
                if(!isTrue) return 1;
                else  return 0;
            }
        }
        
        if(i>j) return 0;
        
        if(isTrue == true) {
            if(dp[i][j][0] != -1 ) return dp[i][j][0];
            
        } else {
            if(dp[i][j][1] != -1 ) return dp[i][j][1];
        }
        
        
        int ans=0;
        
        for(int k=i+1;k<=j-1;k=k+2) {
            
            int leftTrue=recursion(s,i,k-1,true);
            int leftFalse=recursion(s,i,k-1,false);
            
            int rightTrue=recursion(s,k+1,j,true);
            int rightFalse=recursion(s,k+1,j,false);
            
            
        

            if(s.charAt(k) == '|'){
                
                if(isTrue == true) {
                    ans = ans+(leftTrue*rightFalse) + (leftFalse*rightTrue) 
                    + (leftTrue*rightTrue);
                } else {
                    ans =  ans+(leftFalse*rightFalse);
                }
                
            } else if(s.charAt(k) == '&') {
                
                if(isTrue == true) {
                    ans =  ans+(leftTrue*rightTrue);
                } else {
                    ans =  ans+(leftFalse*rightFalse) + (leftFalse*rightTrue) 
                    + (leftTrue*rightFalse);
                }
                
            }  else {
                
                if(isTrue == true) {
                    ans =  ans+(leftTrue*rightFalse) + (leftFalse*rightTrue);
                   
                } else {
                    ans =  ans+(leftTrue*rightTrue) +(leftFalse*rightFalse) ;
                }
            }
             
            
        }
        
        if(isTrue == true) {
            dp[i][j][0] = ans;
            
        } else {
            dp[i][j][1] = ans;
        }
        
       return ans;
        
    }
}