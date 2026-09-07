// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> quickSortHelper(List<Pair> pairs, int l, int r) {
        if (r - l + 1 <= 1) {
            return pairs;
        }

        Pair pivot = pairs.get(r);
        int idx = l;

        for (int i = l; i <= r; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair tmp = pairs.get(i);
                pairs.set(i, pairs.get(idx));
                pairs.set(idx, tmp);

                idx++;
            }
        }

        pairs.set(r, pairs.get(idx));
        pairs.set(idx, pivot);

        quickSortHelper(pairs, l, idx - 1);
        quickSortHelper(pairs, idx + 1, r);

        return pairs;
    }
}
