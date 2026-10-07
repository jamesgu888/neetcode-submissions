class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (int card : map.keySet()) {
                min = Math.min(min, card);
            }

            for (int i = 0; i < groupSize; i++) {
                if (map.containsKey(min + i)) {
                    if (map.get(min + i) > 1) {
                        map.put(min + i, map.get(min + i) - 1);
                    } else {
                        map.remove(min + i);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
