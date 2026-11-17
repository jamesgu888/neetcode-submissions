class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> parents = new HashMap<>(); // child node -> parent node

        for (int[] edge : edges) {
            parents.putIfAbsent(edge[0], edge[0]);
            parents.putIfAbsent(edge[1], edge[1]);
        }

        for (int[] edge : edges) {
            int childRoot = find(parents, edge[0]);
            int parentRoot = find(parents, edge[1]);

            if (childRoot == parentRoot) {
                return edge;
            }

            parents.put(childRoot, parentRoot);
        }

        return null;
    }

    private int find(Map<Integer, Integer> parents, int cur) {
        if (parents.get(cur) != cur) {
            parents.put(cur, find(parents, parents.get(cur)));
        }

        return parents.get(cur);
    }
}