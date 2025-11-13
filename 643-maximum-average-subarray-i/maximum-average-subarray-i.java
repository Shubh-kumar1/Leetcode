class Solution {
    public double findMaxAverage(int[] nums, int k) {
         int n = nums.length;
        if (n == 0 || k <= 0) return 0.0;

        long sum = 0L;
        long maxSum = Long.MIN_VALUE;

        int i = 0;
        int j = 0;

        while (j < n) {

           
            sum += nums[j];

            int windowSize = j - i + 1;

            
            if (windowSize > k) {
                sum -= nums[i];
                i++;
                windowSize = j - i + 1;
            }

            
            if (windowSize == k) {
                if (sum > maxSum) maxSum = sum;
            }

            j++;
        }

        return maxSum / (double) k;
    }
}