from typing import *

def permute(nums: List[int]) -> List[List[int]]:
    def dfs(prefix, suffix):
        if not suffix:
            result.append(prefix)
            return
        
        for i in range(len(suffix)):
            dfs(prefix+[suffix[i]], suffix[:i] + suffix[i+1:])

    result = []
    dfs([], nums)
    return result

res = permute([1, 2, 3])
print(res)