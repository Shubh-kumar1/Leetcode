class Solution {
    public int distributeCandies(int[] candyType) {
        int c = candyType.length;
        int canEat =  c/2;      
        HashSet<Integer> s = new HashSet<>();
        for(int i=0; i<c; i++){
            s.add(candyType[i]);


        }
        return Math.min(s.size(),canEat);
        
    }
}