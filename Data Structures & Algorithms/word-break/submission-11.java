class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (String word : wordDict) {
            if ((word.length() <= s.length()) && (s.substring(0, word.length()).equals(word)) && (!visited.contains(word))) {
                queue.offer(word);
                visited.add(word);
            }
        }

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if (cur.equals(s)) {
                return true;
            }

            for (String word : wordDict) {
                if ((cur.length() + word.length() <= s.length()) && 
                (s.substring(cur.length(), cur.length() + word.length()).equals(word)) && (!visited.contains(cur + word))) {
                    queue.offer(cur + word);
                    visited.add(cur + word);
                }
            }
        }

        return false;
    }
}
