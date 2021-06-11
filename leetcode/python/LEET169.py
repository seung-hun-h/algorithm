from typing import *
import collections

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counter = collections.defaultdict(int)   
        half = len(nums) // 2

        for num in nums:
            counter[num] += 1

            if counter[num] > half:
                return num

        return 0

    def majorityElement(self, nums: List[int]) -> int:
        if not nums:
            return
        
        if len(nums) == 1:
            return nums[0]
        
        half = len(nums) // 2

        a = self.majorityElement(nums[:half])
        b = self.majorityElement(nums[half:])

        return a if nums.count(a) > half else b
    
    def majorityElement(self, nums: List[int]) -> int:
        return sorted(nums)[len(nums) // 2]