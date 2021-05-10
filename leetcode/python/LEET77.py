from typing import *

def combine(n: int, k: int) -> List[List[int]]:
    def dfs(prefix, start, k):
        if k == 0:
            res.append(prefix[:])
            return

        for i in range(start, n+1):
            prefix.append(i)
            dfs(prefix, i+1, k-1)
            prefix.pop()
            
    res = []
    dfs([], 1, k)
    return res
result = combine(4, 2)
print(result)