from typing import *
import collections
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        missing = len(t)
        need = collections.Counter(t)
        left = start = end = 0

        for right, char in enumerate(s, 1):
            print(right, char)
            missing -= need[char] > 0
            need[char] -= 1

            # t의 모든 문자를 포함한 경우
            if missing == 0:
                # 쓸모 없는 문자 제거
                while left < right and need[s[left]] < 0:
                    need[s[left]] += 1
                    left += 1 # 시작 포인터 당기기
                
                if not end or right - left <= end - start:
                    start, end = left, right
        
        return s[start:end]


sol = Solution()
print(sol.minWindow(s = "ADOBECODEBANC", t = "ABC"))