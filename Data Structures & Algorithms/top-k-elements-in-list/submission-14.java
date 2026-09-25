class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.putIfAbsent(num, 0);
            freq.put(num, freq.get(num) + 1);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int num : freq.keySet()) {
            list.get(freq.get(num)).add(num);
        }

        int[] res = new int[k];
        int count = 0;

        for (int i = list.size() - 1; i >= 0 && count < k; i--) {
            for (int num : list.get(i)) {
                res[count] = num;
                count++;

                if (count == k) {
                    break;
                }
            }
        }

        return res;
    }
}
