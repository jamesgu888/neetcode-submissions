class Graph {
    private Map<Integer, List<Integer>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        graph.putIfAbsent(src, new ArrayList<>());
        graph.putIfAbsent(dst, new ArrayList<>());

        List<Integer> tmp = graph.get(src);
        tmp.add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!graph.containsKey(src) || !graph.containsKey(dst)) {
            return false;
        }

        List<Integer> tmp = graph.get(src);
        return tmp.remove(Integer.valueOf(dst));
    }

    public boolean hasPath(int src, int dst) {
        return dfs(graph, src, dst, new HashSet<>());
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int cur, int target, Set<Integer> visited) {
        if (cur == target) {
            return true;
        }

        if (visited.contains(cur)) {
            return false;
        }

        visited.add(cur);
        for (int node : graph.get(cur)) {
            if (dfs(graph, node, target, visited)) {
                return true;
            }
        }

        return false;
    }
}
