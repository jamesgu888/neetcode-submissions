/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>(); // orig node -> cloned node
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                for (Node neighbor : cur.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        queue.offer(neighbor);
                        map.put(neighbor, new Node(neighbor.val));
                    }

                    map.get(cur).neighbors.add(map.get(neighbor));
                }
            }
        }

        return map.get(node);
    }
}