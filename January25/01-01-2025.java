
// Print Anagrams Together
// Difficulty: Medium        Accuracy: 65.78%           Submissions: 79K+           Points: 4
// Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.

// Note: The final output will be in lexicographic order.




//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String,ArrayList<String>> map = new HashMap<>();
        for(String s:arr){
            if(!map.containsKey(s)) map.put(s,new ArrayList<>());
            map.get(s).add(s);
        }//done mapping these words
        for(int i=0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[j].isEmpty() || arr[i].equals(arr[j])) {
                    arr[j] = "";
                    continue;
                }
                if(isAnagrams(arr[i],arr[j])){
                    map.get(arr[i]).add(arr[j]);
                    arr[j] = "";
                }
            }
        }
        Arrays.sort(arr);
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(String s:arr){
            if(s.isEmpty()) continue;
            res.add(map.get(s));
        }
        
        return res;
    }
    
    private boolean isAnagrams(String a,String b){
        if(a.length() != b.length()) return false;
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();
        Arrays.sort(arr);Arrays.sort(brr);
        return Arrays.equals(arr,brr);
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends