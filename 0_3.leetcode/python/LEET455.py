from typing import *
import bisect

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort(reverse=True)
        s.sort(reverse=True)
        
        i = j = 0
        while i < len(g) and j < len(s):
            if g[i] <= s[j]:
                j += 1
            i += 1
        
        return j

    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        
        result = 0 # 쿠키를 부여 받은 아이 수 

        for i in s:
            index = bisect.bisect_right(g, i)

            if index > result: # i 이하의 개수가 준 부여 받은 아이 수 보다 많을 때
                result += 1

        return result