from typing import *

def singleNumber(nums: List[int]) -> int:
    result = 0
    
    for num in nums:
        result ^= num
    
    return result