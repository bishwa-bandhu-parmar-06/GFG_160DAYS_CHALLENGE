// Reverse a linked list
// Difficulty: EasyAccuracy: 73.11%Submissions: 330K+Points: 2
// Given the head of a linked list, the task is to reverse this list and return the reversed head.



class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        Node curr = head, prev = null, Next = null;
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
}