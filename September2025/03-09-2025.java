// Reverse a Doubly Linked List
// Difficulty: EasyAccuracy: 70.38%Submissions: 197K+Points: 2Average Time: 15m
// You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.


/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node cur=head;
        Node hu=null;
        while(cur!=null){
            Node t=cur.next;
            cur.next=cur.prev;
            cur.prev=t;
            hu=cur;
            cur=cur.prev;
        }
        return hu;
    }
}