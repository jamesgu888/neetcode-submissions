class Solution {
    public double myPow(double x, int n) {
        double res = dfs(x, Math.abs((long) n));
        if (n < 0) {
            return 1 / res;
        }
        return res;
    }

    private double dfs(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 != 0) {
            return x * dfs(x, n - 1);
        }

        double res = dfs(x, n / 2);
        return res * res;
    }
}
