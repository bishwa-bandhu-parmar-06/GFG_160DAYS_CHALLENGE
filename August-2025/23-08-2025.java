// Allocate Minimum Pages
// Difficulty: MediumAccuracy: 35.51%Submissions: 319K+Points: 4Average Time: 35m
// Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

// Note: If it is not possible to allocate books to all students, return -1.


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
       
   }
}