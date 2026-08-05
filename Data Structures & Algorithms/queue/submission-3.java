class Node {
    private int val;
    private Node prev;
    private Node next;

    public Node(int val) {
        this(val, null, null);
    }

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class Deque {
    private Node head;
    private Node tail;
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        }

        return false;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }

        int res = tail.val;
        
        if (size != 1) {
            tail.prev.next = null;
        }
        tail = tail.prev;

        if (size == 1) {
            head = null;
        }

        size--;
        return res;
    }

    public int popleft() {
        if (size == 0) {
            return -1;
        }

        int res = head.val;

        if (size != 1) {
            head.next.prev = null;
        }
        head = head.next;

        if (size == 1) {
            tail = null;
        }

        size--;
        return res;
    }
}
