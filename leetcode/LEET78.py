from typing import *    

def subsets(nums: List[int]) -> List[List[int]]:
    result = []
    def dfs(start, arr, current):
        result.append(current)
        if start >= len(arr):
            return
        for i in range(start, len(arr)):
            dfs(i+1, arr, current+[arr[i]])
    dfs(0, nums, []) 
    return result
res = subsets([1, 2, 3])
print(res)