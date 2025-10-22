class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int max_freq = 0;
        
        Set<Integer> targets = new HashSet<>();
        for (int num : nums) {
            targets.add(num);
            targets.add(num - k);
            targets.add(num + k);
        }

        for (int T : targets) {
            int start_range = lower_bound(nums, T - k);
            int end_range = upper_bound(nums, T + k);
            int total_candidates = end_range - start_range;
            
            int start_equal = lower_bound(nums, T);
            int end_equal = upper_bound(nums, T);
            int count_equal = end_equal - start_equal;
            
            int count_needed = total_candidates - count_equal;
            
            int freq_for_T = count_equal + Math.min(numOperations, count_needed);
            
            max_freq = Math.max(max_freq, freq_for_T);
        }
        
        return max_freq;
    }

    private int lower_bound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private int upper_bound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}