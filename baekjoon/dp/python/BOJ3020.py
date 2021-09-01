from sys import stdin
readline = stdin.readline

N, H = map(int, readline().split())


def solve():
    _min = 100000000000000000
    cnt = 0
    up, down = [0] * (H+1), [0] * (H+1)
    for i in range(N):
        n = int(readline())
        if i % 2 == 0:
            down[n] += 1
        else:
            up[n] += 1
    
    for i in range(H-1, 0, -1):
        down[i] += down[i+1]         
        up[i] += up[i+1]         

    
    for i in range(1, H+1):
        cur = down[i] + up[H-i+1]
        if cur < _min:
            _min = cur
            cnt = 1
        elif cur == _min:
            cnt += 1
    
    print(_min, cnt)

solve()