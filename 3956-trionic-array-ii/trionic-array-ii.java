public class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) {
            return 0;
        }

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        int[] leftLimit = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                leftLimit[i] = leftLimit[i - 1];
            } else {
                leftLimit[i] = i;
            }
        }

        int[] rightLimit = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && nums[i] < nums[i + 1]) {
                rightLimit[i] = rightLimit[i + 1];
            } else {
                rightLimit[i] = i;
            }
        }

        long maxTrionicSum = Long.MIN_VALUE;
        boolean found = false;

        for (int p = 1; p < n - 2; p++) {
        
            if (leftLimit[p] < p) {
                for (int q = p + 1; q < n - 1; q++) {
                   
                    if (nums[q] >= nums[q - 1]) {
                        break;
                    }

                    int rMax = rightLimit[q];
                    if (rMax > q) {
                        int lMin = leftLimit[p];
                        
                        long currentLeftSum = 0;
                        long bestLeftSum = Long.MIN_VALUE;
                        for (int l = p - 1; l >= lMin; l--) {
                            currentLeftSum += nums[l];
                            if (currentLeftSum > bestLeftSum) {
                                bestLeftSum = currentLeftSum;
                            }
                        }

                        long currentRightSum = 0;
                        long bestRightSum = Long.MIN_VALUE;
                        for (int r = q + 1; r <= rMax; r++) {
                            currentRightSum += nums[r];
                            if (currentRightSum > bestRightSum) {
                                bestRightSum = currentRightSum;
                            }
                        }

                        long middleSum = pref[q + 1] - pref[p];
                        long totalSum = bestLeftSum + middleSum + bestRightSum;

                        if (!found || totalSum > maxTrionicSum) {
                            maxTrionicSum = totalSum;
                            found = true;
                        }
                    }
                }
            }
        }

        if (found) {
            return maxTrionicSum;
        }
        return 0;
    }
}