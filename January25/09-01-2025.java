// // Indexes of Subarray Sum
// Difficulty: MediumAccuracy: 16.5%Submissions: 1.7MPoints: 4
// Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

// Note: If no such array is possible then, return [-1].


class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        for(int i=0;i<arr.length; i++){
            sum+=arr[i];
            if(sum==target){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(1);
                ans.add(i+1);
                return ans;
            }
            else if(map.containsKey(sum-target)){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(map.get(sum-target)+2);
                ans.add(i+1);
                return ans;
            }
            map.put(sum,i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        return ans;
    }
}