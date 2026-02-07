class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') aCount++;
        }
        
        int minDeletions = aCount;
        int bCount = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                aCount--; 
            } else {
                bCount++;
            }
            minDeletions = Math.min(minDeletions, aCount + bCount);
        }
        
        return minDeletions;
    }
}