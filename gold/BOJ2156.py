from sys import stdin
readline = stdin.readline

N = int(readline())
wines = [int(readline()) for _ in range(N)]

def dp():
    d = [0, wines[0], wines[0]]
    for i in range(1, N):
        # 0: 현재 포도주를 마시지 않는다
        # 1: 첫 번째 이전 포도주를 마시지 않는다
        # 2: 두 번째 이전 포도주를 마시지 않는다
        d = [max(d), d[0]+wines[i], d[1]+wines[i]] 

    return max(d)

print(dp())