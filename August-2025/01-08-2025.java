
// Balancing Consonants and Vowels Ratio
// Difficulty: MediumAccuracy: 52.97%Submissions: 11K+Points: 4
// You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets. You need to find the number of balanced strings in arr[] which can be formed by concatinating one or more contiguous strings of arr[].
// A balanced string contains the equal number of vowels and consonants. 






class Solution {
    public int countBalanced(String[] arr) {
        int n = arr.length;
        int []count = new int[n];
        for(int i=0; i<n; i++){
            int c = 0;
            for(int j = 0; j<arr[i].length(); j++){
                char ch = arr[i].charAt(j);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    c--;
                }else c++;
            }
            count[i] = c;
        }
        
        
        HashMap<Integer, Integer>map = new HashMap<>();
        int sum = 0, c = 0;
        for(int i=0; i<n; i++){
            sum+=count[i];
            if(sum==0)c++;
            if(map.containsKey(sum))c+=map.get(sum);
            
            map.put(sum, map.getOrDefault(sum , 0) + 1);
        }
        
        
        return c;
        
    }
}