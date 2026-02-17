class Solution {
    public List<String> readBinaryWatch(int turnedOn) {        
        List<String> result = new ArrayList<>();
        
        for(int hour = 0; hour < 12; hour++){           
            for(int minute = 0; minute < 60; minute++){                
                int totalBits = countBits(hour) + countBits(minute);                
                if(totalBits == turnedOn){                    
                    String time = hour + ":" + (minute < 10 ? "0" + minute : minute);
                    
                    result.add(time);
                }
            }
        }
        
        return result;
    }
    
    private int countBits(int num){
        
        int count = 0;
        
        while(num > 0){
            count += num % 2;
            num /= 2;
        }
        
        return count;
    }
}
