// Powerful Integer
// Difficulty: MediumAccuracy: 51.91%Submissions: 45K+Points: 4
// You are given a 2D integer array intervals[][] of length n, where each intervals[i] = [start, end] represents a closed interval (i.e., all integers from start to end, inclusive). You are also given an integer k. An integer is called Powerful if it appears in at least k intervals. Find the maximum Powerful Integer.

// Note: If no integer occurs at least k times return -1.

class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        TreeMap<Integer, Integer>map=new TreeMap<>();
        for(int i=0;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            map.put(start, map.getOrDefault(start, 0)+1);
            map.put(end+1, map.getOrDefault(end+1, 0)-1);
        }
        int result=-1;
        int count=0;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            if(val>=0){
                count+=val;
                if(count>=k){
                    result=key;
                }
            }else{
                if(count>=k){
                    result=key-1;
                }
                count+=val;
            }
        }
        return result;
    }
}