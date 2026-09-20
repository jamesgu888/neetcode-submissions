class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, tmp);

            i /= 2;
        }
    }

    public Integer pop() {
        if (heap.size() <= 1) {
            return -1;
        }

        if (heap.size() == 2) {
            return heap.remove(heap.size() - 1);
        }

        int res = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));
        int i = 1;

        while (2 * i < heap.size()) {
            if (2 * i + 1 < heap.size() && heap.get(i) > heap.get(2 * i + 1) && heap.get(2 * i + 1) < heap.get(2 * i)) {
                int tmp = heap.get(2 * i + 1);
                heap.set(2 * i + 1, heap.get(i));
                heap.set(i, tmp);

                i = 2 * i + 1;
            } else if (heap.get(i) > heap.get(2 * i)) {
                int tmp = heap.get(2 * i);
                heap.set(2 * i, heap.get(i));
                heap.set(i, tmp);

                i = 2 * i;
            } else {
                break;
            }
        }

        return res;
    }

    public Integer top() {
        if (heap.size() <= 1) {
            return -1;
        }

        return heap.get(1);
    }

    public void heapify(List<Integer> nums) {
        if (nums.size() == 0) {
            return;
        }

        nums.add(nums.get(0));

        heap = nums;
        int cur = (heap.size() - 1) / 2;

        while (cur > 0) {
            int i = cur;

            while (2 * i < heap.size()) {
                if (2 * i + 1 < heap.size() && heap.get(i) > heap.get(2 * i + 1) && heap.get(2 * i + 1) < heap.get(2 * i)) {
                    int tmp = heap.get(2 * i + 1);
                    heap.set(2 * i + 1, heap.get(i));
                    heap.set(i, tmp);

                    i = 2 * i + 1;
                } else if (heap.get(i) > heap.get(2 * i)) {
                    int tmp = heap.get(2 * i);
                    heap.set(2 * i, heap.get(i));
                    heap.set(i, tmp);

                    i = 2 * i;
                } else {
                    break;
                }
            }

            cur--;
        }
    }
}
