// Majority Element
// Difficulty: MediumAccuracy: 27.82%Submissions: 704K+Points: 4Average Time: 59m
// Given an array arr[]. Find the majority element in the array. If no majority element exists, return -1.

// Note: A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int count =1;
        int n= arr.length;
        Arrays.sort(arr);
        for( int i=1 ; i<arr.length ; i++){
            if(arr[i]==arr[i-1]){
                count ++;
                 if( count > n/2){
               return arr[i - 1];
            
            }
            }
            else{
                count =1;
            }
        }
             if (count > n / 2) {
            return arr[n - 1];
        }
           
            
        
        return -1;
    }
}