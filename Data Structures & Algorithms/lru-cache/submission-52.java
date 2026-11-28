class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this(val, 0, null, null);
    }

    public Node(int val, int key, Node prev, Node next) {
        this.val = val;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    private Map<Integer, Node> map;
    private Node youngest;
    private Node oldest;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        youngest = new Node(0);
        oldest = new Node(0);
        youngest.prev = oldest;
        oldest.next = youngest;

        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            cur.next = youngest;
            cur.prev = youngest.prev;
            cur.prev.next = cur;
            cur.next.prev = cur;

            return cur.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            map.remove(key);
        } else if (map.size() + 1 > capacity) {
            Node cur = oldest.next;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            map.remove(cur.key);
        }

        Node newNode = new Node(value, key, youngest.prev, youngest);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        map.put(key, newNode);
    }
}
