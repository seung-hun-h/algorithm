from typing import *

def arrayPairSum(self, nums: List[int]) -> int:
    return sum(sorted(nums)[::2])