from typing import *
import heapq

def findKthLargest(nums: List[int], k: int) -> int:
    return heapq.nlargest(k, nums)[-1]

nums = [3,2,1,5,6,4] 
k = 2
ans = findKthLargest(nums, k)
print(ans)