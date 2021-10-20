from typing import *

def search(nums: List[int], target: int) -> int:
    if not nums:
        return -1

    left, right = 0, len(nums) - 1

    while left < right:
        mid = left + (right - left) // 2

        if nums[mid] > nums[right]:
            left = mid + 1
        else:
            right = mid
    
    pivot = left

    left, right = 0, len(nums) - 1

    while left <= right:
        mid = left + (right - left) // 2
        mid_pivot = (mid + pivot) % len(nums)

        if nums[mid_pivot] < target:
            left = mid + 1 # mid_pivot 오른쪽 이동
        elif nums[mid_pivot] > target:
            right = mid - 1 # mid_pivot 왼쪽 이동
        else:
            return mid_pivot
    return - 1

print(search(nums = [4,5,6,7,0,1,2], target = 0))