class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length==0){
            return new int[0];
        }
        HashMap<Integer,Integer> h = new HashMap<>();
        
        for(int i=0; i<nums1.length; i++){
            h.put(nums1[i], h.getOrDefault(nums1[i],0)+1);

            
        }
         ArrayList<Integer> l = new ArrayList<>();
         
        for(int i=0; i<nums2.length; i++){
            int val = nums2[i];
            int count = h.getOrDefault(val,0);
            if(count>0){
                l.add(val);
                if(count == 1){
                    h.remove(val);
                }else h.put(val, count - 1);
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}