class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        TreeMap<Integer, Integer> small = new TreeMap<>();
        TreeMap<Integer, Integer> large = new TreeMap<>();

        long sumSmall = 0;
        int cntSmall = 0;
        int need = k - 1;

        for (int i = 1; i <= dist + 1; i++) {
            add(small, nums[i]);
            sumSmall += nums[i];
            cntSmall++;
        }

        while (cntSmall > need) {
            int x = small.lastKey();
            remove(small, x);
            sumSmall -= x;
            cntSmall--;
            add(large, x);
        }

        long ans = nums[0] + sumSmall;

        for (int l = 1, r = dist + 2; r < n; l++, r++) {

            if (small.containsKey(nums[l])) {
                remove(small, nums[l]);
                sumSmall -= nums[l];
                cntSmall--;
            } else {
                remove(large, nums[l]);
            }

            if (!small.isEmpty() && nums[r] > small.lastKey()) {
                add(large, nums[r]);
            } else {
                add(small, nums[r]);
                sumSmall += nums[r];
                cntSmall++;
            }

            while (cntSmall > need) {
                int x = small.lastKey();
                remove(small, x);
                sumSmall -= x;
                cntSmall--;
                add(large, x);
            }

            while (cntSmall < need) {
                int x = large.firstKey();
                remove(large, x);
                add(small, x);
                sumSmall += x;
                cntSmall++;
            }

            ans = Math.min(ans, nums[0] + sumSmall);
        }

        return ans;
    }

    private void add(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int x) {
        int cnt = map.get(x);
        if (cnt == 1) map.remove(x);
        else map.put(x, cnt - 1);
    }
}
