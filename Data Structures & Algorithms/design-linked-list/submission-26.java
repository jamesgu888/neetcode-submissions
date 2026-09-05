class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {
    private ListNode head;
    private ListNode tail;

    public MyLinkedList() {
        head = tail = null;
    }
    
    public int get(int index) {
        if (head == null || index < 0) {
            return -1;
        }

        ListNode cur = head;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }

        return (cur == null) ? -1 : cur.val;
    }
    
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
            return;
        }

        ListNode newNode = new ListNode(val);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }
    
    public void addAtTail(int val) {
        if (tail == null) {
            addAtHead(val);
            return;
        }

        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }

        ListNode cur = head;

        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }

            cur = cur.next;
        }

        if (cur == null) {
            addAtTail(val);
        } else {
            ListNode prev = cur.prev;
            ListNode newNode = new ListNode(val);
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = cur;
            cur.prev = newNode;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (head == null || index < 0) {
            return;
        }

        ListNode cur = head;

        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }

            cur = cur.next;
        }

        if (cur == null) {
            return;
        }

        if (cur.prev == null) {
            head = cur.next;
        } else {
            cur.prev.next = cur.next;
        }

        if (cur.next == null) {
            tail = cur.prev;
        } else {
            cur.next.prev = cur.prev;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */