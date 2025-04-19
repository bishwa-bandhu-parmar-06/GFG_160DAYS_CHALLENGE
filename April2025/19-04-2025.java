// Maximum XOR of two numbers in an array
// Difficulty: MediumAccuracy: 50.0%Submissions: 16K+Points: 4
// Given an array arr[] of non-negative integers of size n. Find the maximum possible XOR between two numbers present in the array.

class Solution {
    // Trie Node
    class TrieNode {
        TrieNode[] children = new TrieNode[2]; // 0 and 1
    }

    private TrieNode root = new TrieNode();

    // Insert number into Trie
    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) { // 32-bit integers
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Find maximum XOR for num with elements in Trie
    private int findMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;
            if (node.children[toggledBit] != null) {
                maxXor |= (1 << i); // set the bit in maxXor
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    public int maxXor(int[] arr) {
        int maxResult = 0;
        for (int num : arr) {
            insert(num);
        }

        for (int num : arr) {
            maxResult = Math.max(maxResult, findMaxXor(num));
        }

        return maxResult;
    }
}
