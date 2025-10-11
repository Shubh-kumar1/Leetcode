class Solution {
    public String reversePrefix(String word, char ch) {
        int idx =-1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
               idx=i;
               break;
            }
        }
         if (idx == -1) return word;

        char[] arr = word.toCharArray();

        int left = 0, right = idx;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);


    }
}