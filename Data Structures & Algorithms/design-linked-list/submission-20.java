class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this(val, null, null);
    }

    ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, null, null);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode nextNode = head;
        for (int i = 0; i < index; i++) {
            nextNode = nextNode.next;
        }

        ListNode prevNode = nextNode.prev;
        ListNode newNode = new ListNode(val, prevNode, nextNode);

        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
        return;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }

        ListNode prevNode = curNode.prev;
        ListNode nextNode = curNode.next;

        if (prevNode == null && nextNode == null) {
            head = null;
            tail = null;
        } else if (prevNode != null && nextNode == null) {
            prevNode.next = null;
            tail = prevNode;
        } else if (prevNode == null && nextNode != null) {
            nextNode.prev = null;
            head = nextNode;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        size--;
        return;
    }
}
