class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            int newCount = hm.getOrDefault(s.charAt(i), 0) - 1;

            if (newCount <= 0) {
                hm.remove(s.charAt(i));
            } else {
                hm.put(s.charAt(i), newCount);
            }
        }
        for (Character key : hm.keySet()) {
            return key;
        }
        return '\0';
    }
}
