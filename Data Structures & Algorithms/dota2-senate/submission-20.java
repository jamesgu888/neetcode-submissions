class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int r = 0;
        int d = 0;
        
        for (char c : senate.toCharArray()) {
            queue.offer(c);
        }

        while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char c = queue.poll();

                if (c == 'R') {
                    if (d == 0) {
                        r++;
                        queue.offer(c);
                    } else {
                        d--;
                    }
                } else {
                    if (r == 0) {
                        d++;
                        queue.offer(c);
                    } else {
                        r--;
                    }
                }
            }

            size = queue.size();
            int checkR = 0, checkD = 0;
            for (int i = 0; i < size; i++) {
                char c = queue.poll();
                if (c == 'R') {
                    checkR++;
                } else {
                    checkD++;
                }
                queue.offer(c);
            }

            if ((checkR == 0 || checkD == 0) && (checkR + checkD) > 0) {
                return (checkR > 0) ? "Radiant" : "Dire";
            }
        }
    }
}