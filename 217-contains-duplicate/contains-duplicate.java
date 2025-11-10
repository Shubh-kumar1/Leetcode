class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            int prevNum = nums[i-1];
            if(nums[i] == prevNum){
                return true;
            }

        }
       return false;
            
    }
}