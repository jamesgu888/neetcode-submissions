// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int l, int r) {
        if (r - l + 1 <= 1) {
            return pairs;
        }

        int m = (l + r) / 2;
        mergeSortHelper(pairs, l, m);
        mergeSortHelper(pairs, m + 1, r);

        merge(pairs, l, m, r);
        return pairs;
    }

    public void merge(List<Pair> pairs, int l, int m, int r) {
        List<Pair> left = new ArrayList<>(pairs.subList(l, m + 1));
        List<Pair> right = new ArrayList<>(pairs.subList(m + 1, r + 1));

        int leftPtr = 0;
        int rightPtr = 0;
        int idx = l;

        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr).key <= right.get(rightPtr).key) {
                pairs.set(idx, left.get(leftPtr));
                leftPtr++;
            } else {
                pairs.set(idx, right.get(rightPtr));
                rightPtr++;
            }

            idx++;
        }

        while (leftPtr < left.size()) {
            pairs.set(idx, left.get(leftPtr));
            leftPtr++;
            idx++;
        }

        while (rightPtr < right.size()) {
            pairs.set(idx, right.get(rightPtr));
            rightPtr++;
            idx++;
        }
    }
}
