// Palindrome Linked List
// Difficulty: MediumAccuracy: 41.48%Submissions: 380K+Points: 4Average Time: 20m
// You are given the head of a singly linked list of positive integers. You have to check if the given linked list is palindrome or not.


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
         Node temp=null;
         temp=head;
         boolean flag=true;
         
         List<Integer> list=new ArrayList<>();
         
         while(temp!=null){
             list.add(temp.data);
             temp=temp.next;
         }
         int j=0;
         
         for(int i=list.size()-1;i>=0;i--){
             int data1=list.get(i);
             int data2=list.get(j);
             
             if(data1!=data2){
                 flag=false;
                 return flag;
             }
             j++;
         }
         
         return flag;
        
    }
}