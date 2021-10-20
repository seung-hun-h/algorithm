from typing import *
import bisect

def intersection(nums1: List[int], nums2: List[int]) -> List[int]:
    nums2.sort()
    result = set()
    for target in nums1:
        index = bisect.bisect_left(nums2, target)
        if index < len(nums2) and nums2[index] == target:
            result.add(target)

    return list(result)

def intersection2(nums1: List[int], nums2: List[int]) -> List[int]:
    nums1.sort()
    nums2.sort()
    i = j = 0
    result = set()
    while i < len(nums1) and j < len(nums2):
        if nums1[i] < nums2[j]:
            i += 1
        elif nums1[i] > nums2[j]:
            j += 1
        else:
            result.add(nums1[i])
            i += 1
            j += 1
    return list(result)
print(intersection2(nums1 = [1,2,2,1], nums2 = [2,2]))