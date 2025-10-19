class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String res = s;
        q.offer(s);
        seen.add(s);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.compareTo(res) < 0) res = curr;

            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String added = new String(chars);
            if (seen.add(added)) q.offer(added);

            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            if (seen.add(rotated)) q.offer(rotated);
        }
        return res;
    }
}
