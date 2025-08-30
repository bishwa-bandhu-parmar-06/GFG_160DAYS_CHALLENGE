// The Celebrity Problem
// Difficulty: MediumAccuracy: 38.33%Submissions: 339K+Points: 4Average Time: 30m
// A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] of size n*n is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.



class Solution {
    public int celebrity(int mat[][]) {
        // Two Pointor Approach
        int n = mat.length;
        int l = 0, r = n-1;
        
        // Step 1: Eliminate non-celebrities
        while(l < r)
        {
            if(mat[l][r] == 1) 
                l++; // l knows r → l can't be celebrity
            else 
                r--; // l doesn't know r → r can't be celebrity
        }
        
        // Step 2: Verify candidate
        int candidate = l;
        for (int i = 0; i < n; i++) 
        {
            if (i == candidate) continue;
            // check if candidate knows someone OR someone doesn't know candidate
            if ((mat[candidate][i] == 1) || (mat[i][candidate] == 0)) 
            {
                return -1; 
            }
        }

        return candidate;
    }
}