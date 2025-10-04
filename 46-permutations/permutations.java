class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    public void backtrack(List<List<Integer>>result, List<Integer> currentPermutation,int[] nums){
        if(currentPermutation.size() == nums.length){
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        for(int num : nums){
            if(currentPermutation.contains(num)){
                continue;
            }
            currentPermutation.add(num);

            backtrack(result,currentPermutation,nums);

            currentPermutation.remove(currentPermutation.size()-1);
        }
    }
}