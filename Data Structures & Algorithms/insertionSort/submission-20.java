// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> res = new LinkedList<>();

        for (int i = 0; i < pairs.size(); i++) {            
            for (int j = i - 1; j >= 0 && pairs.get(j).key > pairs.get(j + 1).key; j--) {
                Pair tmp = pairs.get(j);
                pairs.set(j, pairs.get(j + 1));
                pairs.set(j + 1, tmp);
            }

                        res.add(new ArrayList<>(pairs));

        }

        return res;
    }
}
