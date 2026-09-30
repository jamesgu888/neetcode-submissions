class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // num, freq

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        int max = -1;

        for (int num : map.keySet()) {
            if (num > max && map.get(num) == 1) {
                max = num;
            }
        }

        return max;
    }
}
