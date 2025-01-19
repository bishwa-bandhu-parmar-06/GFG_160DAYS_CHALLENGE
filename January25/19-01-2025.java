//Rotate a Linked List
//Difficulty: MediumAccuracy: 39.95%Submissions: 272K+Points: 4
//Given the head of a singly linked list, your task is to left rotate the linked list k times.



class Solution {
    public Node rotate(Node head, int k) {
        int size=0;
        Node head1=head;
        Node prev=null;
        while(head1!=null){
            prev=head1;
            head1=head1.next;
            size++;
        }
        k=k%size;
        while(k-->0){
            Node temp=head.next;
            prev.next=head;
            prev=prev.next;
            head.next=null;
            head=temp;
            
        }
        return head;
    }
}