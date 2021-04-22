"""
Link: https://leetcode.com/problems/valid-palindrome/
SOLVING:
IMPLEMENTATION:
DEBUGING:
CLEAR: O
"""
def reverseString(s) -> None:
    """
    Do not return anything, modify s in-place instead.
    """
    # s = list(reversed(s))
    s = s[::-1]
    print(s)

s = ["H","a","n","n","a","h"]
print(reverseString(s))
    