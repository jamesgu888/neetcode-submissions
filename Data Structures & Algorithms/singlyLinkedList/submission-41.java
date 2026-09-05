class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        head = tail = null;
    }

    public int get(int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return -1;
            }

            cur = cur.next;
        }
        
        if (cur == null) {
            return -1;
        }
        return cur.val;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val, head);
        head = newNode;

        if (tail == null) {
            tail = head;
        }
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean remove(int index) {
        if (index < 0 || head == null) {
            return false;
        }

        ListNode cur = head;
        ListNode prev = null;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return false;
            }

            prev = cur;
            cur = cur.next;
        }

        if (cur == null) {
            return false;
        } else if (cur == head) {
            head = cur.next;
            
            if (cur == tail) {
                tail = head;
            }
        } else {
            prev.next = cur.next;

            if (cur == tail) {
                tail = prev;
            }
        }

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            int val = cur.val;
            list.add(val);
            cur = cur.next;
        }

        return list;
    }
}
