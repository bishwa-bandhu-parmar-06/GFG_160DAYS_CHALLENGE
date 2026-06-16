



// Construct List using XOR Queries
// Difficulty: MediumAccuracy: 50.86%Submissions: 39K+Points: 4Average Time: 20m
// There is an array that initially contains only a single value, 0. 

// Given a list of queries queries[][] of size q, where each query is of one of the following types:

// 0 x: Insert x into the array.
// 1 x: Replace every element a in the array with a ^ x, where ^ denotes the bitwise XOR operator.
// Return the array in sorted order after performing all the queries.


class Solution {

    public static ArrayList<Integer> constructList( int[][] queries) {

        ArrayList<Integer>ans=new ArrayList<>();

        int sum=0,q=queries.length;

        for(int i=0;i<q;i++){

         int u=queries[q-i-1][0];

         int v=queries[q-i-1][1];

         if(u==0){

             v=v^sum;

             ans.add(v);

         }else

             sum^=v;

         

         }

         ans.add(sum);

         Collections.sort(ans);

         return ans;

    }

}