class DynamicArray {
    private int[] arr;
    private int cap;
    private int size;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
        cap = capacity;
        size = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (size == cap) {
            resize();
        }

        arr[size] = n;
        size++;
    }

    public int popback() {
        int res = arr[--size];

        return res;
    }

    private void resize() {
        cap *= 2;
        int[] newArr = new int[cap];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return cap;
    }
}
