class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int gola_index = -1;
        for(int i=n-1; i>0; i--){
            if(arr[i]< arr[i-1]){
                gola_index = i-1;
                break;
            }

        }
        if(gola_index == -1){
            return arr;
        }
            
            
        
        int swap_index = gola_index;
        for(int j =n-1; j>= gola_index+1; j--){
            if(arr[j]<arr[gola_index]){
                 while(j-1 > gola_index && arr[j] == arr[j-1]) {
                    j--;
                }

                swap_index = j;
                break;
            }
        }
        
        swap(arr, gola_index, swap_index);
       
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    

}
        

    
