class BrowserPage {
    String val;
    BrowserPage prev;
    BrowserPage next;

    public BrowserPage(String val) {
        this(val, null, null);
    }

    public BrowserPage(String val, BrowserPage prev, BrowserPage next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class BrowserHistory {
    private BrowserPage cur;

    public BrowserHistory(String homepage) {
        cur = new BrowserPage(homepage);
    }
    
    public void visit(String url) {
        BrowserPage newPage = new BrowserPage(url, cur, null);
        cur.next = newPage;
        cur = cur.next;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (cur.prev == null) {
                break;
            }
            cur = cur.prev;
        }

        return cur.val;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }

        return cur.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */