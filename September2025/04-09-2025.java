
// Linked List Group Reverse
// Difficulty: HardAccuracy: 57.08%Submissions: 263K+Points: 8Average Time: 30m
// You are given the head of a Singly linked list. You have to reverse every k node in the linked list and return the head of the modified list.
// Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.









// class Node {
//     int data;
//     Node next;
//     Node(int val) {
//         data = val;
//         next = null;
//     }
// }

class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prevGroupEnd = dummy;
        Node curr = head;

        while (curr != null) {
            Node groupStart = curr;
            
            // find the kth node or the last node if less than k remain
            int count = 0;
            Node temp = curr;
            while (count < k - 1 && temp.next != null) {
                temp = temp.next;
                count++;
            }

            Node nextGroupStart = temp.next;

            // reverse this group of size (count+1)
            Node prev = nextGroupStart;
            Node node = groupStart;
            for (int i = 0; i <= count; i++) {
                Node next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            // connect previous group to newly reversed group
            prevGroupEnd.next = prev;

            // move prevGroupEnd to end of this group
            prevGroupEnd = groupStart;
            curr = nextGroupStart;
        }

        return dummy.next;
    }
}
