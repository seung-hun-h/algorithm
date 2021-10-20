from typing import *
import bisect

def twoSum(numbers: List[int], target: int) -> List[int]:
    for i in range(len(numbers)):
        left, right = numbers[:i], numbers[i+1:]
        j1 = bisect.bisect_left(left, target-numbers[i])
        j2 = bisect.bisect_left(right, target-numbers[i])

        if j1 < len(left) and left[j1] == (target-numbers[i]):
            return [i+1, j1+1]
        if j2 < len(right) and right[j2] == (target-numbers[i]):
            return [i+1, j2+i+2]

def twoSum2(numbers: List[int], target: int) -> List[int]:
    left, right = 0, len(numbers) - 1
    while left < right:
        if numbers[left] + numbers[right] < target:
            left += 1
        elif numbers[left] + numbers[right] > target:
            right -= 1
        else:
            return [left+1, right+1]

def twoSum3(numbers: List[int], target: int) -> List[int]:
    for k, v in enumerate(numbers):
        left, right = k+1, len(numbers) - 1
        t = target - v

        while left <= right:
            mid = left + (right - left) // 2

            if numbers[mid] < t:
                left = mid + 1
            elif numbers[mid] > t:
                right = mid - 1
            else:
                return k+1, mid+1

def twoSum4(numbers: List[int], target: int) -> List[int]:
    for k, v in enumerate(numbers):
        expected = target - v
        i = bisect.bisect_left(numbers, expected, lo=k+1)
        if i < len(numbers) and numbers[i] == expected:
            return k+1, i+1



print(twoSum3(numbers = [-1,0], target = -1))