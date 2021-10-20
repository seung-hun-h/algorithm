def solution(p):
    if not p:
        return p
    u, v = split(p)

    if correct(u):
        return u + solution(v)
    temp = "("+ solution(v) + ")" + ''.join([")" if c == "(" else "(" for c in u[1:-1] ])
    return temp

def correct(s):
    if s[0] == ")":
        return False
    stack = [s[0]]
    for i in range(1, len(s)):
        if s[i] == "(":
            stack.append(s[i])
        else:
            if not stack:
                return False
            stack.pop()
    
    return True

def split(p):
    stack = [p[0]]
    idx = 0
    for i in range(1, len(p)):
        if stack and stack[-1] == p[i]:
            stack.append(p[i])
        else:
            if stack:
                stack.pop()
                if not stack:
                    idx = i+1
                    break
            else:
                idx = i
                break
    
    return p[:idx], p[idx:]

"""
[카카오 2020 공채] 괄호 변환
해결: O
시간: 빨리 끝남, 측정 안함
"""