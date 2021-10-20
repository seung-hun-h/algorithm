# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(H):
    # write your code in Python 3.6
    stack = []
    ans = 0

    for h in H:
        # 현재 보다 높은 위치는 이미 짓는 것으로 판단
        # 따라서 스택에서 제거
        while stack and stack[-1] > h:
            stack.pop()

        if not stack or stack[-1] < h:
            stack.append(h)
            ans += 1

    return ans

"""
다시!
"""