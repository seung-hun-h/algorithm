from typing import *

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        for i in range(1, len(nums)):
            nums[i] += nums[i - 1] if nums[i - 1] > 0 else 0
            
        return max(nums)

    def maxSubArray(self, nums: List[int]) -> int:
        best_sum = -float('inf')
        current_sum = 0

        for num in nums:
            current_sum = max(current_sum + num, num)
            best_sum = max(current_sum, best_sum)

        return best_sum


sol = Solution()
print(sol.maxSubArray(nums = [-2,1,-3,4,-1,2,1,-5,4]))