class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> groups = new HashMap<>();

        for (String string : strs) {
            List<Integer> list = getArray(string);

            if (groups.containsKey(list)) {
                List<String> tmp = groups.get(list);
                tmp.add(string);
                groups.put(list, tmp);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(string);
                groups.put(list, tmp);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list : groups.values()) {
            res.add(list);
        }

        return res;
    }

    private List<Integer> getArray(String string) {
        List<Integer> list = new ArrayList<>(26);

        for (int i = 0; i < 26; i++) {
            list.add(0);
        }

        for (char c : string.toCharArray()) {
            list.set(c - 'a', list.get(c - 'a') + 1);
        }

        return list;
    }
}
