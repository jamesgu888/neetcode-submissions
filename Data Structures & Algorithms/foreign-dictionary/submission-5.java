class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.substring(0, word2.length()).equals(word2)) {
                return "";
            }

            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        Map<Character, Integer> indegree = new HashMap<>();

        for (char c : graph.keySet()) {
            indegree.put(c, 0);
        }

        for (char needChar : graph.keySet()) {
            for (char forChar : graph.get(needChar)) {
                indegree.put(forChar, indegree.get(forChar) + 1);
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);

            for (char neighbor : graph.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return (res.length() == graph.size()) ? res.toString() : "";
    }
}
