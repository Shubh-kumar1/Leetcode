class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;

        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int keptCount =1;
        int lastkeptEnd = intervals[0][1];

        for(int i=0; i<intervals.length; i++){
            int currentStart = intervals[i][0];

            if(currentStart >= lastkeptEnd){
                keptCount++;
                lastkeptEnd = intervals[i][1];
            }
        }
        return intervals.length - keptCount;

        
    }
}