from typing import *
import collections

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = right = 0
        counts = collections.Counter()

        for right, char in enumerate(s, 1):
            counts[char] += 1
            most_char_n = counts.most_common(1)[0][1]
            
            if right - left - most_char_n > k:
                counts[s[left]] -= 1
                left += 1
        # right에 1이 더해지지 않고 종료
        return right - left

sol = Solution()
print(sol.characterReplacement(s = "AABABBA", k = 1))