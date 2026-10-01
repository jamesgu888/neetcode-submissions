class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) > 1) {
                return num;
            }
        }

        return 0;
    }
}
