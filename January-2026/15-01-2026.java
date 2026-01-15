// Candy
// Difficulty: HardAccuracy: 55.27%Submissions: 47K+Points: 8Average Time: 45m
// There are n children standing in a line. Each child is assigned a rating value given in the integer array arr[]. You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating than their neighbors get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute.

// Note: The answer will always fit into a 32-bit integer.



class Solution {
    public int minCandy(int arr[]) {
        int n = arr.length;
        
        int []giveCandy = new int[n];
        Arrays.fill(giveCandy, 1);
        
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                giveCandy[i] = Math.max(giveCandy[i], giveCandy[i-1] + 1);
            }
            int j = n - i - 1;
            if(arr[j] > arr[j + 1]) {
                giveCandy[j] = Math.max(giveCandy[j], giveCandy[j+1] + 1);
            }
        }
        
        int result = 0;
        
        for(int candy : giveCandy) {
            result += candy;
        }
        return result;
    }
}