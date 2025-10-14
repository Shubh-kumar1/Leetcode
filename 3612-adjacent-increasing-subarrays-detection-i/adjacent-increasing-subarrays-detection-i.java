class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) {
            return false;
        }
        
        if (k <= 1) {
            return n >= 2*k;
        }

        boolean[] isIncreasing = new boolean[n];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count >= k) {
                isIncreasing[i] = true;
            }

            if (i >= (2 * k - 1)) {
                if (isIncreasing[i] && isIncreasing[i - k]) {
                    return true;
                }
            }
        }

        return false;
    }
}

