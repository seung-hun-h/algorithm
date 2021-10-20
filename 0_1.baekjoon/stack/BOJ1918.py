from sys import stdin
readline = stdin.readline

infix = readline().strip()

def solve():
    res = ''
    stack = []
    for x in infix:
        if x.isalpha():
            res += x
        else:
            if x == "(":
                stack.append(x)
            elif x == "*" or x == "/":
                while stack and (stack[-1] == "*" or stack[-1] == "/"):
                    res += stack.pop()
                stack.append(x)
            elif x == "+" or x == "-":
                while stack and stack[-1] != "(":
                    res += stack.pop()
                stack.append(x)
            else:
                while stack and stack[-1] != "(":
                    res += stack.pop()
                stack.pop()

    while stack:
        res += stack.pop()

    print(res)

solve()