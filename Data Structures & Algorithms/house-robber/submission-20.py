class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        if len(nums) == 2: return max(nums[0], nums[1])

        memo = [0] * len(nums)
        memo[0] = nums[0]
        memo[1] = nums[1]
        memo[2] = nums[0] + nums[2]
        for i in range(3, len(nums)):
            memo[i] = max(nums[i] + memo[i - 2], nums[i] + memo[i - 3])
        
        return max(memo[-1], memo[-2])