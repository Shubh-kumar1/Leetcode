class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < n) {

            sum = sum + nums[j];
            while (sum >= target) {
                int winSize = j - i + 1;
                if (winSize < minLen) {
                    minLen = winSize;
                }
                sum -= nums[i];
                i++;

            }
            j++;

        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }

    }

}