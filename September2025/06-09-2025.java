// Find length of Loop
// Difficulty: MediumAccuracy: 44.26%Submissions: 281K+Points: 4Average Time: 30m
// Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

// Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null, indicating there is no loop. Note that pos is not passed as a parameter.



/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        Node slow = head, fast = head;
        boolean found = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                found = true;
                break;
            }
        }

        if (!found) return 0;

        int res = 1;
        Node temp = slow.next;
        while (temp != slow) {
            res++;
            temp = temp.next;
        }
        return res;
    }
}