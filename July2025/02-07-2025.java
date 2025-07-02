// Longest subarray with Atmost two distinct integers
// Difficulty: MediumAccuracy: 47.98%Submissions: 117K+Points: 4Average Time: 30m
// Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.


class Solution {
    public int totalElements(int[] arr) {
        int n=arr.length;
        int start=0;
        int maxLength=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.size()>2){
                map.put(arr[start],map.get(arr[start])-1);
                if(map.get(arr[start])==0){
                    map.remove(arr[start]);
                }
                start++;
            }
            maxLength=Math.max(maxLength,i-start+1);
        }
        return maxLength;
    }
}

