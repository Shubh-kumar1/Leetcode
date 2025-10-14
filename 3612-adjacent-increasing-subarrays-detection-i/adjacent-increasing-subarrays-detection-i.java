class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) {
            return false;
        }
        if (k <= 1) {
            return n >= 2 * k;
        }

        int count = 2;
        int runLength = 1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                runLength++;
            } else {
                runLength = 1;
                if (count == 1) {
                    count = 2;
                }
            }

            if (count == 2) {
                if (runLength >= k) {
                    count--;

                    int secondSubarrayStartIndex = i + 1;
                    
                    if (secondSubarrayStartIndex + k > n) {
                        count = 2; 
                        continue;
                    }

                    boolean secondIsIncreasing = true;
                    for (int j = secondSubarrayStartIndex + 1; j < secondSubarrayStartIndex + k; j++) {
                        if (nums.get(j) <= nums.get(j - 1)) {
                            secondIsIncreasing = false;
                            break;
                        }
                    }

                    if (secondIsIncreasing) {
                        count--;
                        return true;
                    } else {
                        count = 2;
                    }
                }
            }
        }
        
        return false;
    }
}

