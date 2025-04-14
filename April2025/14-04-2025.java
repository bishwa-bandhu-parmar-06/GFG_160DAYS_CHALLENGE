// Alien Dictionary
// Difficulty: HardAccuracy: 47.81%Submissions: 158K+Points: 8
// A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.

// Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.

// However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").

// A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.

// Note: Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.



class Solution {
    public String findOrder(String[] words) {
        // Step 1: Initialize the graph
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize graph and indegree map
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build the graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            
            // Edge case: ["abc", "ab"] => invalid
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }

            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                char from = first.charAt(j);
                char to = second.charAt(j);
                if (from != to) {
                    if (!graph.get(from).contains(to)) {
                        graph.get(from).add(to);
                        inDegree.put(to, inDegree.get(to) + 1);
                    }
                    break; // only first different character matters
                }
            }
        }

        // Step 3: Topological sort using Kahn's algorithm
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.append(current);
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all characters are not included, cycle exists
        if (order.length() != inDegree.size()) {
            return "";
        }

        return order.toString();
    }
}