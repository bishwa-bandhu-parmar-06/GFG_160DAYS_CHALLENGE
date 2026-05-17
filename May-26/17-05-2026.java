// Make the array beautiful
// Difficulty: EasyAccuracy: 49.96%Submissions: 73K+Points: 2
// Given an array of negative and non-negative integers. You need to make the array beautiful.

// An array is beautiful if two adjacent integers, arr[i] and arr[i+1] are either negative or positive. You can do the following operation any number of times until the array becomes beautiful.
// If two adjacent are different i.e. one of them is negative and other is positive, remove them. 
// Return the beautiful array after performing the above operation.
// An empty array is also a beautiful array.
// There can be multiple beautiful output arrays. For consistencty with the test cases, scan the array from left to right for removing two adjacent.
// Examples:

// Input: arr[] = [4, 2,-2, 1] 
// Output: [4, 1]
// Explanation: As at indices 1 and 2 , 2 and -2 have different sign, they are removed. And the the final array is: [4, 1].
// Input: arr[] = [2,-2, -1, 1]
// Output: []
// Explanation: As at indices 0 and 1, 2 and -2 have different sign, so they are removed. Now the array is 1 -1.Now 1 and -1 are also removed as they have different sign. So the final array is empty. 
// Constraints:
// 1 ≤ arr.size() ≤ 105
// -105 ≤ arr[i] ≤ 105


class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        
        ArrayList<Integer> ans= new ArrayList<>();
        int i=0;
        
        for(int k: arr){
            ans.add(k);
        }
        
        while(i<ans.size()-1){
            int p=ans.get(i)>>31;
            int q=ans.get(i+1)>>31;
            if((p==-1 && q==-1)||(p==0 && q==0)){//checking if both numbers ar positive/zero or negative
                i++;
                
            }
            else{
                ans.remove(i+1);
                ans.remove(i);
                i=0;
            }
        }
        
        return ans;
    }
}