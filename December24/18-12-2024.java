// Allocate Minimum Pages
// Difficulty: Medium         Accuracy: 35.51%          Submissions: 227K+           Points: 4
// You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).


class Solution {
    public static int countStudent(int []arr,int pages){
       int n = arr.length;
       int student=1;
       long studentPages=0;
       for(int i =0;i<n;i++){
           if(studentPages+arr[i]<=pages){
               studentPages+=arr[i];
           }else{
               student++;
               studentPages=arr[i];
           }
       }
       return student;
   }
   public static int findPages(int[] arr, int k) {
       int n =arr.length;
        if(k>n){
           return -1;
       }
       int low = arr[0];  

for (int i = 1; i < arr.length; i++) {
   if (arr[i] > low) {
       low = arr[i];  
   }
}
       int high=0;
       for(int  i =0;i<n;i++){
           high+=arr[i];

       }
       while(low<=high){
           int mid=(low+high)/2;
           if(countStudent(arr, mid)>k){
               low=mid+1;
           }else{
               high=mid-1;
           }
       }
       return low;
       // code here
   }
}