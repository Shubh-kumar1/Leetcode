
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[] prefixSkill = new long[n];
        prefixSkill[0] = skill[0];
        for (int i = 1; i < n; i++) {
            prefixSkill[i] = prefixSkill[i - 1] + skill[i];
        }

        
        List<Integer> hullIndices = new ArrayList<>();
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                while (hullIndices.size() >= 2) {
                    int i2 = hullIndices.get(hullIndices.size() - 1);
                    int i1 = hullIndices.get(hullIndices.size() - 2);
                    
                    long p1x = (i1 == 0) ? 0 : prefixSkill[i1 - 1];
                    long p1y = prefixSkill[i1];
                    long p2x = prefixSkill[i2 - 1];
                    long p2y = prefixSkill[i2];
                    long p3x = prefixSkill[i - 1];
                    long p3y = prefixSkill[i];

                    
                    long val = (p2x - p1x) * (p3y - p2y) - (p2y - p1y) * (p3x - p2x);

                    if (val >= 0) { 
                        hullIndices.remove(hullIndices.size() - 1);
                    } else { 
                        break;
                    }
                }
                hullIndices.add(i);
            }
        }
        
        long currentS = 0;

        for (int j = 1; j < m; j++) {
            long m1 = mana[j - 1];
            long m2 = mana[j];

            long hullMax = Long.MIN_VALUE;

            if (!hullIndices.isEmpty()) {
                
                int l = 0, r = hullIndices.size() - 1;
                int optIdx = hullIndices.get(0);
                
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (mid + 1 < hullIndices.size()) {
                        int i1 = hullIndices.get(mid);
                        int i2 = hullIndices.get(mid + 1);
                        
                        long dy = prefixSkill[i2] - prefixSkill[i1];
                        long dx = prefixSkill[i2 - 1] - prefixSkill[i1 - 1];

                        
                        if (dy * m1 > dx * m2) {
                             optIdx = hullIndices.get(mid + 1);
                             l = mid + 1;
                        } else {
                             r = mid - 1;
                        }
                    } else {
                        break;
                    }
                }
                
                hullMax = prefixSkill[optIdx] * m1 - prefixSkill[optIdx - 1] * m2;
            }

            long i0Val = prefixSkill[0] * m1;
            long delta = Math.max(i0Val, hullMax);
            currentS += delta;
        }

        return currentS + prefixSkill[n - 1] * mana[m - 1];
    }
}