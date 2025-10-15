class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nums.get(i);

        int[] incEnd = new int[n];
        int[] incStart = new int[n];

        incEnd[0] = 1;
        for (int i = 1; i < n; i++) {
            incEnd[i] = (arr[i] > arr[i - 1]) ? incEnd[i - 1] + 1 : 1;
        }

        incStart[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            incStart[i] = (arr[i] < arr[i + 1]) ? incStart[i + 1] + 1 : 1;
        }

        int maxK = 0;
        for (int i = 0; i < n - 1; i++) {
            int k = Math.min(incEnd[i], incStart[i + 1]);
            maxK = Math.max(maxK, k);
        }

        return maxK;
    }
}