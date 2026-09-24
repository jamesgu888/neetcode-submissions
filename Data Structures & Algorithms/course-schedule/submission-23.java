class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] edge : prerequisites) {
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.putIfAbsent(edge[0], new ArrayList<>());

            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int cur, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (!graph.containsKey(cur) || graph.get(cur).isEmpty()) {
            return true;
        }

        if (visited.contains(cur)) {
            return false;
        }

        visited.add(cur);
        for (int neighbor : graph.get(cur)) {
            if (!dfs(neighbor, graph, visited)) {
                return false;
            }
        }

        visited.remove(cur);
        graph.put(cur, new ArrayList<>());
        return true;
    }
}
