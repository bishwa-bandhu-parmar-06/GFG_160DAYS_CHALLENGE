// Check Repeated Substring with K Replacements
// Difficulty: MediumAccuracy: 53.15%Submissions: 42K+Points: 4
// Given a string s and an integer k, check if it is possible to convert s to a string that is repetition of a substring with k characters else returns false. In order to convert we can replace one substring of length k with any k characters.

class Solution {
	public boolean kSubstr(String s, int k) {
		// code here
		int n = s.length();
		
		if (n%k != 0)
			return false;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int i = 0;
		
		while (i<n) {
			String temp = s.substring(i, i + k);
			map.put(temp, map.getOrDefault(temp, 0) + 1);
			i += k;
		}
		
		int size = map.size();
		
		if (size == 1)
			return true;
		if ((size == 2) && map.containsValue(1))
			return true;
		
		return false;
	}
}