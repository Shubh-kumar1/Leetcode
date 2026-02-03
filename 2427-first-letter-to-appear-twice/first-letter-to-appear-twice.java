class Solution {
    public char repeatedCharacter(String s) {
        char ans = ' ';
        int minSecondIndex = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if (j < minSecondIndex) {
                        minSecondIndex = j;
                        ans = s.charAt(i);
                    }
                     break;
                }
            }
        }
         return ans;
            
        
    }
}