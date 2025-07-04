// Subarrays With At Most K Distinct Integers
// Difficulty: MediumAccuracy: 62.15%Submissions: 12K+Points: 4
// You are given an array arr[] of positive integers and an integer k, find the number of subarrays in arr[] where the count of distinct integers is at most k.

// Note: A subarray is a contiguous part of an array.



class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int i=0,j=0,n = arr.length,countK=0,totalCount = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        while(j<n)
        {
            if(map.containsKey(arr[j]))
            map.put(arr[j],map.get(arr[j])+1);
            else
            {
                countK++;
                map.put(arr[j],1);
            }
            
            if(countK<=k)
            {
                totalCount+=(j-i+1);
                j++;
            }
            else
            {
                while(countK>k)
                {
                    int I = arr[i];
                    int countI = map.get(I);
                    if(countI==1)
                    {
                        countK--;
                        map.remove(I);
                    }
                    else
                    map.put(I,countI-1);
                    i++;
                }
                totalCount+=j-i+1;
                j++;
            }
        }
        return totalCount;
    }
}