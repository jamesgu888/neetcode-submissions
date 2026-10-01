class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (String word : wordDict) {
            if ((word.length() <= s.length()) && (s.substring(0, word.length()).equals(word)) && (!visited.contains(word.length()))) {
                queue.offer(word.length());
                visited.add(word.length());
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (i == s.length()) {
                return true;
            }

            for (String word : wordDict) {
                if ((i + word.length() <= s.length()) && 
                (s.substring(i, i + word.length()).equals(word)) && 
                (!visited.contains(i + word.length()))) {
                    queue.offer(i + word.length());
                    visited.add(i + word.length());
                }
            }
        }

        return false;
    }
}
