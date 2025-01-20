// Merge two sorted linked lists
// Difficulty: Medium      Accuracy: 62.91%         Submissions: 174K+      Points: 4
// Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.


class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // Base cases: if one of the lists is null, return the other
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Dummy node to act as the start of the merged list
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists and merge them
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        // Attach the remaining part of the list (if any)
        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }

        // Return the merged list, starting from dummy.next
        return dummy.next;
    }
}
