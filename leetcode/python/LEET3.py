from typing import *
import collections


def lengthOfLongestSubstring(s: str) -> int:
    used = {}
    max_length = start = 0
    for idx, char in enumerate(s):
        # If letter in window is already used,
        # Move start pointer to rear of letter
        if char in used and start <= used[char]:
            start = used[char]+1
        else:
            max_length = max(max_length, idx - start + 1)
        
        used[char] = idx

    return max_length
res = lengthOfLongestSubstring("dvdf")
print(res)