// Add Number Linked Lists
// Difficulty: MediumAccuracy: 34.52%Submissions: 372K+Points: 4Average Time: 30m
// You are given the head of two singly linked lists head1 and head2 representing two non-negative integers. You have to return the head of the linked list representing the sum of these two numbers.

// Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.


/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node addTwoLists(Node head1, Node head2) {
        // code here
           Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(head1!=null){
            s1.push(head1.data);
            head1 = head1.next;
        }
        while(head2!=null){
            s2.push(head2.data);
            head2 = head2.next;
        }
        
        int carry = 0;
        Node result = null;
        
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int sum = carry ;
            
            if(!s1.isEmpty()){
                sum += s1.pop();
            }
            if(!s2.isEmpty()){
                sum += s2.pop();
            }
            carry = sum/10;
            int digit = sum%10;
            
            Node newNode = new Node(digit);
            newNode.next = result;
            result = newNode;
        }
        while(result!=null && result.data == 0 && result.next!=null){
            result = result.next;
        }
        
        return result;
    }
}