class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomNoteCounts = new HashMap<>();
        HashMap<Character, Integer> magazineCounts = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            ransomNoteCounts.put(c, ransomNoteCounts.getOrDefault(c, 0) + 1);
        }
        for (char c : magazine.toCharArray()) {
            magazineCounts.put(c, magazineCounts.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : ransomNoteCounts.entrySet()) {
            char charNeeded = entry.getKey();
            int countNeeded = entry.getValue();
            int countAvailable = magazineCounts.getOrDefault(charNeeded, 0);
            if (countAvailable < countNeeded) {
                return false;
            }
        }
        return true;
    }
}