# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N, A):
    # write your code in Python 3.6
    result = [0] * (N+1)
    _max, cmd_max = 0, 0

    for cmd in A:
        if cmd == N+1:
            cmd_max = _max
        
        else:
            if result[cmd] < cmd_max:
                result[cmd] = cmd_max + 1
            else:
                result[cmd] += 1

            _max = max(_max, result[cmd])

    for i in range(1, N+1):
        if result[i] < cmd_max:
            result[i] = cmd_max

    return result[1:]