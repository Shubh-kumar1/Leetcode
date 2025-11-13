class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet <Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            while(set.contains(c)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        
        }
         return maxLen;
    }
}