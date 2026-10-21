class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = l + (r - l) / 2;

        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m ,r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        List<Integer> list = new ArrayList<>();
        int i = l;
        int j = m + 1;

        while (i < m + 1 && j < r + 1) {
            if (nums[i] <= nums[j]) {
                list.add(nums[i]);
                i++;
            } else {
                list.add(nums[j]);
                j++;
            }
        }

        while (i < m + 1) {
            list.add(nums[i]);
            i++;
        }

        while (j < r + 1) {
            list.add(nums[j]);
            j++;
        }

        for (int k = 0; k <= (r - l); k++) {
            nums[l + k] = list.get(k);
        }
    }
}