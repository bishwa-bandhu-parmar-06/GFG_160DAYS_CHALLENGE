// Bus Ticket Change
// Difficulty: EasyAccuracy: 52.02%Submissions: 55K+Points: 2Average Time: 30m
// You are given an array arr[] representing passengers in a queue. Each bus ticket costs 5 coins, and arr[i] denotes the note a passenger uses to pay (which can be 5, 10, or 20). You must serve the passengers in the given order and always provide the correct change so that each passenger effectively pays exactly 5 coins. Your task is to determine whether it is possible to serve all passengers in the queue without ever running out of change.


class Solution {
    public boolean canServe(int[] arr) {
        // code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(5 , 0);
        map.put(10 , 0);
        map.put(20 , 0);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 5){
                map.put(5 , map.getOrDefault(5 , 0) + 1);
            }else if(arr[i] == 10){
                map.put(5 , map.getOrDefault(5 , 0) - 1);
                if(map.get(5) < 0){
                    return false;
                }
                map.put(10 , map.getOrDefault(10 , 0) + 1);
            }else{
                if(map.get(10) > 0){// If i have $10 then try to give them
                    map.put(10 , map.getOrDefault(10 , 0) - 1);
                    if(map.get(10) < 0){
                        return false;
                    }
                    map.put(5 , map.getOrDefault(5 , 0) - 1);
                    if(map.get(5) < 0){
                        return false;
                    }
                }else{//Otherwise you must give 3 $5 
                    map.put(5 , map.getOrDefault(5 , 0) - 3);
                    if(map.get(5) < 0){
                        return false;
                    }
                }
                map.put(20 , map.getOrDefault(20 , 0) + 1);
            }
        }
        return true;
    }
}