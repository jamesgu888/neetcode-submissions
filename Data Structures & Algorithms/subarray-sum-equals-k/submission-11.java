class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        map.put(runningSum, 1);
        int res = 0;

        for (int num : nums) {
            runningSum += num;
            int requiredSum = runningSum - k;

            if (map.containsKey(runningSum - k)) {
                res += map.get(runningSum - k);
            }

            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }

        return res;
    }
}