class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxBalancedSize = 1; 
        for (int i = 0; i < n; i++) {
            long limit = (long) nums[i] * k;
            int j = upperBound(nums, limit);
            int size = j - i;
            maxBalancedSize = Math.max(maxBalancedSize, size);
        }

        return n - maxBalancedSize;
    }

    private static int upperBound(int[] nums, long target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; 
    }
}