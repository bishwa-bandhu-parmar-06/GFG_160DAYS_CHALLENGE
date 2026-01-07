// Count distinct elements in every window
// Difficulty: MediumAccuracy: 41.83%Submissions: 172K+Points: 4Average Time: 20m
// Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i<k; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ans.add(map.size());
        int l =0;
        for(int i =k ; i<arr.length; i++){
            map.put(arr[l],map.get(arr[l])-1);
            if(map.get(arr[l])==0) map.remove(arr[l]);
            l++;
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            ans.add(map.size());
        }
        return ans;
    }
}

