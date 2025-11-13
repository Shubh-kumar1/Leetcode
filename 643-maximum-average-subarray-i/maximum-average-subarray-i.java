class Solution {
    public double findMaxAverage(int[] nums, int k) {
         int n = nums.length;
        if (n == 0 || k <= 0 || k > n) return 0.0; 

       
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long maxSum = sum;

       
        for (int i = k; i < n; i++) {
            sum += nums[i];         
            sum -= nums[i - k];     
            if (sum > maxSum) maxSum = sum;
        }

        return maxSum / (double) k;
    }
}
   