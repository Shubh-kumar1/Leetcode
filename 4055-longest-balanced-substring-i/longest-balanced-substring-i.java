class Solution {
    public int longestBalanced(String s) {
         int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int common = 0;
                boolean balanced = true;
                for (int f : freq) {
                    if (f > 0) {
                        if (common == 0) {
                            common = f;
                        } else if (common != f) {
                            balanced = false;
                            break;
                        }
                    }
                }
                if (balanced) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;

    }
}