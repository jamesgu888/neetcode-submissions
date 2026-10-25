class StockSpanner {
    private List<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);

        int idx = list.size() - 1;
        int days = 0;

        while (idx >= 0) {
            if (list.get(idx) <= price) {
                days++;
            } else {
                break;
            }

            idx--;
        }

        return days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */