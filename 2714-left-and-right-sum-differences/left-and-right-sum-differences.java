class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int totalSum = 0;
        
        for (int j = 0; j < n; j++) {
            totalSum += nums[j];
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            arr[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return arr;
    }
}