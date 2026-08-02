class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> res = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                case "+":
                    int one = res.pop();
                    int two = res.pop();
                    res.push(two);
                    res.push(one);
                    res.push(one + two);
                    break;
                case "D":
                    int three = res.pop();
                    res.push(three);
                    res.push(three * 2);
                    break;
                case "C":
                    res.pop();
                    break;
                default:
                    res.push(Integer.parseInt(operation));
                    break;
            }
        }

        int total = 0;

        for (int num : res) {
            total += num;
        }

        return total;
    }
}