# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S):
    # write your code in Python 3.6
    stack = []
    for s in S:
        if s == "{" or s == "(" or s == "[":
            stack.append(s)
        elif s == "}":
            if stack and stack[-1] == "{":
                stack.pop()
            else:
                return 0
        elif s == ")":
            if stack and stack[-1] == "(":
                stack.pop()
            else:
                return 0
        elif s == "]":
            if stack and stack[-1] == "[":
                stack.pop()
            else:
                return 0

    return 1 if not stack else 0