// Top K Frequent in Array
// Difficulty: MediumAccuracy: 40.23%Submissions: 106K+Points: 4Average Time: 30m
// Given a non-empty integer array arr[]. Your task is to find and return the top k elements which have the highest frequency in the array.

// Note: If two numbers have the same frequency, the larger number should be given the higher priority.

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->
        {
            if(map.get(b).equals(map.get(a))){
                return b-a;
            }
            else{
                return map.get(b)-map.get(a);
            }
        });
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<k && i<list.size();i++){
            res.add(list.get(i));
        }
        return res;
    }
}