class Solution {

    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        for (String str : strs) {
            string.append(str + "~");
        }

        return string.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;

        while (end < str.length()) {
            if (str.charAt(end) == '~') {
                res.add(str.substring(start, end));
                start = end + 1;
            }

            end++;
        }

        return res;
    }
}
