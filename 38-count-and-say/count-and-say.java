class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";            
        }
        String result= "1";
        for(int i=2; i<=n; i++){
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prevChar = result.charAt(0);

            for(int j =1; j<result.length(); j++){
                char ch = result.charAt(j);
                if(ch == prevChar){
                    count++;

                }else{
                    current.append(count);
                    current.append(prevChar);
                    count =1;
                    prevChar =ch;

                }
            }
            current.append(count);
            current.append(prevChar);

            result = current.toString();


        }
        return result;

            


            
        
    }
}