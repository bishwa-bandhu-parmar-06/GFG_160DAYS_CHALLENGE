// Add Number Linked Lists
// Difficulty: Medium      Accuracy: 34.52%         Submissions: 300K+          Points: 4
// Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

// For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

// Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.





class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(num1 != null){
            s1.push(num1.data);
            num1 = num1.next;
        }
         while(num2 != null){
            s2.push(num2.data);
            num2 = num2.next;
        }
        Node result = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int val1 = s1.isEmpty() ? 0: s1.pop();
            int val2 = s2.isEmpty()? 0: s2.pop();
            int sum = val1 + val2 + carry;
           
            Node newNode = new Node(sum % 10);
            newNode.next = result;
            result = newNode;
            carry = sum / 10;
            
        }
        while (result != null && result.data == 0) {
        result = result.next;
    }

    // If the result is empty (in case of 0), return a single node with 0
    return result != null ? result : new Node(0);
    }
}