class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(num)) {
                int seen = map.get(num).get(map.get(num).size() - 1);
                if (Math.abs(seen - i) <= k) {
                    return true;
                }
            } else {
                map.put(num, new ArrayList<>());
            }

            map.get(num).add(i);
        }

        return false;
    }
}