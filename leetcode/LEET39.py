from typing import *
def combinationSum(candidates: List[int], target: int) -> List[List[int]]:
    result = []
    candidates.sort()
    def dfs(idx, nums, target, current):
        if target == 0:
            result.append(current)
            return
        
        if idx >= len(nums):
            return

        if target >= nums[idx]:
            dfs(idx, nums, target-nums[idx], current+[nums[idx]])
        dfs(idx+1, nums, target, current)
    
    dfs(0, candidates, target, [])
    return result

res = combinationSum(candidates = [2,3,5], target = 8)
print(res)