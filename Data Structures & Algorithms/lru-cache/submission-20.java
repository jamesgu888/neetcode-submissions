public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private Map<Integer, Node> map;
    private int cap;
    private Node newest;
    private Node oldest;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        newest = new Node(0, 0);
        oldest = new Node(0, 0);

        oldest.next = newest;
        newest.prev = oldest;
    }
    
    public int get(int key) {
        Node cur = map.get(key);
        
        if (cur == null) {
            return -1;
        }

        int res = cur.val;
        update(cur);

        if (map.size() > cap) {
            removeOldest();
        }

        return res;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            update(cur);
            return;
        }

        Node cur = new Node(key, value);
        map.put(key, cur);
        cur.next = newest;
        cur.prev = newest.prev;
        newest.prev.next = cur;
        newest.prev = cur;

        if (map.size() > cap) {
            removeOldest();
        }
    }

    private void update(Node cur) {
        // remove cur from current position
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

        // set cur node neighbors
        cur.next = newest;
        cur.prev = newest.prev;

        // set neighbors
        cur.next.prev = cur;
        cur.prev.next = cur;
    }

    private void removeOldest() {
        Node cur = oldest.next;

        // remove cur from current position
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

        map.remove(cur.key);
    }
}
