def solution(s):
    _min = len(s)
    for length in range(1, len(s) // 2 + 1):
        _min = min(_min, compression(s, length))

    return _min

def compression(s, length):
    tokens = [s[i:i+length] for i in range(0, len(s), length)]
    cur = tokens[0]
    cnt = 1
    length = 0
    for i in range(1, len(tokens)):
        if cur == tokens[i]:
            cnt += 1
        else:
            length += len(str(cnt)) if cnt > 1 else 0
            length += len(cur)
            cur = tokens[i]
            cnt = 1
    length += len(str(cnt)) if cnt > 1 else 0
    length += len(cur)
    return length
"""
[카카오 2020 공채] 문자열 압축
해결: O
시간: 28분
"""