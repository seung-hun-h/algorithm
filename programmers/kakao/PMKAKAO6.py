def solution(s):
    _min = len(s)
    for length in range(1, len(s) // 2 + 1):
        _min = min(_min, compression(s, length))

    return _min

def compression(s, length):
    tokens = [s[i:i+length] for i in range(0, len(s), length)]
    cur = tokens[0]
    cnt = 1
    temp = ''
    for i in range(1, len(tokens)):
        if cur == tokens[i]:
            cnt += 1
        else:
            temp += str(cnt) if cnt > 1 else ''
            temp += cur
            cur = tokens[i]
            cnt = 1
    temp += str(cnt) if cnt > 1 else ''
    temp += tokens[-1]
    print(temp)
    return len(temp)
solution("ababcdcdababcdcd")