class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {
            int min = map.firstKey();

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
