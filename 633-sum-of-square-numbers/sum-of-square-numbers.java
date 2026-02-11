class Solution {
    public boolean judgeSquareSum(int c) {
        int low =0;
        int high = (int)Math.sqrt(c);
        
        while(low<=high){
            
            long val=((long)low*low+(long)high*high);
            if(val>c)
            {
                high--;
            }
            if(val==c)
            {
                return true;
            }
            else
            {
                low++;
            }
        
        }
        return false;
    }
        
}