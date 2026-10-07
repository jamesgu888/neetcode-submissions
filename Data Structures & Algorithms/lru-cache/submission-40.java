public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int val, int key, Node prev, Node next) {
        this.val = val;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node oldest;
    private Node newest;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        oldest = new Node(0, 0, null, null);
        newest = new Node(0, 0, null, null);

        oldest.next = newest;
        newest.prev = oldest;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.prev = newest.prev;
        cur.next = newest;
        newest.prev.next = cur;
        newest.prev = cur;

        return cur.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.next.prev = old.prev;
            old.prev.next = old.next;
        } else if (map.size() == capacity) {
            Node remove = oldest.next;
            remove.next.prev = oldest;
            oldest.next = remove.next;
            map.remove(remove.key);
        }

        Node newNode = new Node(value, key, newest.prev, newest);
        newest.prev.next = newNode;
        newest.prev = newNode;
        map.put(key, newNode);
    }
}
