class Solution {
    public String[] findWords(String[] words) {
        String r1= "qwertyuiop";
        String r2= "asdfghjkl";
        String r3 = "zxcvbnm";

        ArrayList<String> result = new ArrayList<>();
        for(String word : words){
            String w = word.toLowerCase();

             boolean ok = true;

             for(int i=0; i<w.length(); i++){
                if(r1.indexOf(w.charAt(i))==-1){
                    ok = false;
                    break;
                }
            }
            if(ok){
                result.add(word);
                continue;
            }
             ok = true;
            for (int i = 0; i < w.length(); i++) {
                if (r2.indexOf(w.charAt(i)) == -1) {
                    ok = false;
                    break;
                }
            }
             if(ok){
                result.add(word);
                continue;
            }
            ok = true;
            for (int i = 0; i < w.length(); i++) {
                if (r3.indexOf(w.charAt(i)) == -1) {
                    ok = false;
                    break;
                }
            }
            if (ok) result.add(word);
        }
        return result.toArray(new String[0]);

        
    }
}