class Solution {
    public String firstPalindrome(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }
        
        
        for(String word : words){
            if (word == null) continue; 
            if(word.length() == 1){
                return word;
            }
            int low =0; 
            int high = word.length()-1;

            boolean isPal = true;      
            while(low<high){
                if(word.charAt(low) != word.charAt(high)){

                   isPal =false;
                   break;
                }
                low++;
                high--;
            }
            if (isPal) return word;
               
            
        }
        return "";

    }
}