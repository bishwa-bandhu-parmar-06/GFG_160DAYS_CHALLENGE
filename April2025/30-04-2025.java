// Find length of Loop
// Difficulty: EasyAccuracy: 44.26%Submissions: 252K+Points: 2Average Time: 30m
// Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

// Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. If c is 0, then there is no loop.


class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        int ans=0;
        Node slow=head;
        Node fast=head;
        while(fast!=null && slow!=null){
            fast=fast.next;
            if(fast==null) break;
            slow=slow.next;
            fast=fast.next;
            if(fast==null) break;
            if(fast==slow){
                do{
                    ans++;
                    slow=slow.next;
                }while(fast!=slow);
                break;
            }
        }
        return ans;
    }
}
