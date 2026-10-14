class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Integer> stack = new Stack<>();
        int[][] cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        for (int[] car : cars) {
            stack.push(car[1]);
        }

        int fleet = 0;
        double fleetTime = 0;
        for (int i = cars.length - 1; i >= 0; i--) {
            double time = ((double) target - cars[i][0]) / cars[i][1];

            if (time > fleetTime) {
                fleet++;
                fleetTime = time;
            }
        }

        return fleet;
    }
}
