class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (String currentWord : words) {
            if (result.isEmpty() || !areAnagrams(currentWord, result.get(result.size() - 1))) {
                result.add(currentWord);
            }
        }
        
        return result;
    }

    private boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}