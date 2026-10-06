class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            right[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int l = left[i];
            int r = (right[i] == -1) ? heights.length : right[i];
            int width = r - l - 1;

            max = Math.max(max, heights[i] * width);
        }

        return max;
    }
}
