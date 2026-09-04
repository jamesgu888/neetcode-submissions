class DynamicArray {
    private int capacity;
    private int size;
    private int[] arr;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (size + 1 > capacity) {
            resize();
        }

        arr[size] = n;
        size++;
    }

    public int popback() {
        int tmp = arr[size - 1];
        size--;
        return tmp;
    }

    private void resize() {
        capacity *= 2;
        int[] tmp = new int[capacity];

        for (int i = 0; i < size; i++) {
            tmp[i] = arr[i];
        }

        arr = tmp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
