class Solution {
    public String simplifyPath(String path) {
        Stack<String> files = new Stack<>();
        StringBuilder cur = new StringBuilder();

        for (char c : path.toCharArray()) {
            if (c == '/') {
                if (cur.isEmpty()) {
                    continue;
                } else {
                    String tmp = cur.toString();

                    if (tmp.equals("..")) {
                        if (!files.isEmpty()) {
                            files.pop();
                        }
                    } else if (!tmp.equals(".")) {
                        files.push(tmp);
                    }

                    cur = new StringBuilder();
                }
            } else {
                cur.append(c);
            }
        }

        if (!cur.isEmpty()) {
            String tmp = cur.toString();

            if (tmp.equals("..")) {
                if (!files.isEmpty()) {
                    files.pop();
                }
            } else if (!tmp.equals(".")) {
                files.push(tmp);
            }
        }

        Collections.reverse(files);
        StringBuilder res = new StringBuilder();
        while (!files.isEmpty()) {
            res.append("/" + files.pop());
        }
        return (res.isEmpty()) ? "/" : res.toString();
    }
}