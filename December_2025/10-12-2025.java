// Missing And Repeating
// Difficulty: EasyAccuracy: 24.83%Submissions: 663K+Points: 2Average Time: 30m
// Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in this range is missing, and another number occurs twice in the array, find both the duplicate number and the missing number.



class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int[] n = new int[arr.length+1];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<arr.length;i++){
            n[arr[i]]++;
        }
        
        for(int i=1;i<n.length;i++){
            if(n[i]==2){
                al.add(i);
            }
        }
        for(int i=1;i<n.length;i++){
            if(n[i]==0){
                al.add(i);
            }
        }
        return al;
    }
}