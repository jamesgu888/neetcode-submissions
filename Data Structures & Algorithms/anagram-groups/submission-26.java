class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>(); // charList -> anagrams

        for (String str : strs) {
            List<Integer> charList = decompose(str);
            map.putIfAbsent(charList, new ArrayList<>());
            map.get(charList).add(str);
        }

        List<List<String>> res = new ArrayList<>();

        for (List<String> values : map.values()) {
            res.add(values);
        }

        return res;
    }

    private List<Integer> decompose(String str) {
        List<Integer> charList = new ArrayList<>(Collections.nCopies(26, 0));

        for (char c : str.toCharArray()) {
             charList.set(c - 'a', charList.get(c - 'a') + 1);
        }

        return charList;
    }
}
