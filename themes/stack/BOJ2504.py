from sys import stdin
readline = stdin.readline

string = readline().strip()
table = {")":"(", "]":"["}
point = {"(":2, "[":3}


def solve():
    stack = []

    for s in string:
        if s == "(" or s == "[":
            stack.append(s)
        elif s == ")" or s == "]":
            cur = 0
            while stack and stack[-1] != table[s]:
                if not stack[-1].isdigit():
                    return 0
                cur += int(stack.pop())

            if not stack: 
                return 0

            cur = cur if cur else 1
            cur *= point[stack.pop()]
            stack.append(str(cur))
            
    if "(" in stack or "[" in stack:
        return 0
    return sum(map(int, stack))

print(solve())