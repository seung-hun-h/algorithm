from typing import *
import collections

def removeDuplicateLetters(s: str) -> str:
    for char in sorted(set(s)):
        suffix = s[s.index(char):]

        if set(s) == set(suffix):
            return char + removeDuplicateLetters(s.replace(char, ''))
    
    return ''

def removeDuplicateLetters2(s: str) -> str:
    counter, stack = collections.Counter(s), []

    for char in s:
        counter[char] -= 1

        if char in stack:
            continue
            
        while stack and char < stack[-1] and counter[stack[-1]] > 0:
            stack.pop()
        stack.append(char)
    return ''.join(stack)

res = removeDuplicateLetters(s = "bcabc")
print(res)