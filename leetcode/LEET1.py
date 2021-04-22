from typing import *

def twoSum(nums: List[int], target: int) -> List[int]:
    nums_dict = dict()
    for i, num in enumerate(nums):
        if target-num in nums_dict and i != nums_dict[target-num]:
            return [i, nums_dict[target-num]]
        nums_dict[num] = i
    

result = twoSum(nums = [2,7,11,15], target = 9)
print(result)