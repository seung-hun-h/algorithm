"""
Link: https://leetcode.com/problems/valid-palindrome/
SOLVING:
IMPLEMENTATION:
DEBUGING:
CLEAR: O
"""
from collections import deque
import re

def solve(s):
    new_str = ''.join([char.lower() for char in s if char.isalnum()])
    
    left, right = 0, len(new_str) - 1 if len(new_str) != 0 else 0
    print(new_str)
    while left < right and new_str[left] == new_str[right]:
        left += 1
        right -= 1
    
    print(left >= right)

def solve2(s):
    strs = deque()
    for char in s: 
        if char.isalnum():
            strs.append(char.lower())
    while len(strs) > 1:
        if strs.popleft() != strs.pop():
            return False
    return True

def solve3(s):
    s = s.lower()
    s = re.sub("[^a-z0-9]", '', s)
    return s == s[::-1]


print(solve3("A man, a plan, a canal: Panama"))
# print(solve2("0p"))