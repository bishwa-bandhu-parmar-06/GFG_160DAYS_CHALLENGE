// Clone List with Next and Random
// Difficulty: Hard       Accuracy: 64.8%         Submissions: 103K+           Points: 8
// You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

// Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// Return the head of the copied linked list.

// NOTE : Original linked list should remain unchanged.


class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Insert cloned nodes next to original nodes
        Node current = head;
        while (current != null) {
            Node clonedNode = new Node(current.data);
            clonedNode.next = current.next;
            current.next = clonedNode;
            current = clonedNode.next;
        }

        // Step 2: Update random pointers for cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and cloned lists
        Node original = head;
        Node cloneHead = head.next;
        Node cloneCurrent = cloneHead;

        while (original != null) {
            original.next = original.next.next;
            if (cloneCurrent.next != null) {
                cloneCurrent.next = cloneCurrent.next.next;
            }
            original = original.next;
            cloneCurrent = cloneCurrent.next;
        }

        return cloneHead;
    }
}
