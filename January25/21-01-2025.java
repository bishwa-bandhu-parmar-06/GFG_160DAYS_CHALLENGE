// Linked List Group Reverse
// Difficulty: Hard       Accuracy: 57.08%      Submissions: 223K+        Points: 8
// Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.


class Solution {
    public static Node reverse(Node temp){
        Node start = temp;
        Node mid = temp.next;
        start.next=null;
        while(mid!=null){
            Node fr = mid.next;
            mid.next = start;
            start = mid;
            mid = fr;
        }
        return start;
    }
    public static Node kthNode(Node temp, int k){
        k = k - 1;
        while(temp.next!=null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node nextNode = null;
        Node prevNode = null;
        while(temp != null){
            Node kthnode = kthNode(temp,k);
            nextNode = kthnode.next;
            kthnode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthnode;
            } else {
                prevNode.next = kthnode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}