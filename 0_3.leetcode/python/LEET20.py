from typing import *
def isValid(s: str) -> bool:
    stack = []
    table = {
        ")":"(",
        "}":"{",
        "]":"["
    }

    for i in range(len(s)):
        if s[i] not in table:
            stack.append(s[i])
        elif not stack and table[s[i]] != stack.pop():
            return False

    return not stack

result = isValid( s = "(])")
print(result)

        