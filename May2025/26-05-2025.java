// Insert in Sorted Circular Linked List
// Difficulty: MediumAccuracy: 25.56%Submissions: 131K+Points: 4Average Time: 20m
// Given a sorted circular linked list, the task is to insert a new node in this circular linked list so that it remains a sorted circular linked list.


class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
        
        // Inserting element at the start while retaining circular list
        if (head.data >= data) {
            newNode.next = head;
            
            Node ptr = head;
            while (ptr.next != head) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
            
            return newNode;
        }
        
        Node ptr = head;
        while (ptr.next != head && ptr.next.data <= data) {
            ptr = ptr.next;
        }
        
        newNode.next = ptr.next;
        ptr.next = newNode;
        
        return head;
    }
}