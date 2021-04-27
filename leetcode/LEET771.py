from typing import *
import collections

def numJewelsInStones(jewels: str, stones: str) -> int:
    count = collections.Counter(stones)
    
    ans = 0
    for j in jewels:
        ans += count[j]
    
    return ans

def numJewelsInStones(jewels: str, stones: str) -> int:
    return sum([s in jewels for s in stones])