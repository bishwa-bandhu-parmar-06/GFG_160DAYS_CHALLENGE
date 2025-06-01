// Count pairs Sum in matrices
// Difficulty: EasyAccuracy: 45.66%Submissions: 49K+Points: 2
// Given two matrices mat1[][] and mat2[][] of size n x n, where the elements in each matrix are arranged in strictly ascending order. Specifically, each row is sorted from left to right, and the last element of a row is smaller than the first element of the next row.
// You're given a target value x, your task is to find and count all pairs {a, b} such that a is from mat1 and b is from mat2 where the sum of a + b is equal to x.


class Solution {// two pointer
    int countPairs(int[][] mat1, int[][] mat2, int x){
        int n = mat1.length,cnt=0;
        int a=0,b=n-1,i1=0,i2=n-1;
        while(i2>=0&&i1<n){
            int sum = mat1[i1][a]+mat2[i2][b];
            if(sum==x){
                cnt++;
                a++;
                b--;
            }else if(sum<x){
                a++;
            }else b--;
            if(a==n){
                a=0;
                i1++;
            }
            if(b==-1){
                i2--;
               b=n-1;
            }
                
        }
        return cnt;
    }
}