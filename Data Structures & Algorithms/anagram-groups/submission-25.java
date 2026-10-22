class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String string : strs) {
            List<Integer> freq = getFreq(string);

            map.putIfAbsent(freq, new ArrayList<>());
            map.get(freq).add(string);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<Integer> freq : map.keySet()) {
            res.add(map.get(freq));
        }

        return res;
    }

    private List<Integer> getFreq(String string) {
        List<Integer> freq = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            freq.add(0);
        }

        for (char c : string.toCharArray()) {
            freq.set(c - 'a', freq.get(c - 'a') + 1);
        }
        
        return freq;
    }
}
