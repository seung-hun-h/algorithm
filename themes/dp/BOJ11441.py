from sys import stdin   
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))
M = int(readline())

def solve():
    _sums = [0]
    _sum = 0
    for i in range(N):
        _sum += arr[i]
        _sums.append(_sum)

    for _ in range(M):
        s, e = map(int, readline().split())
        print(_sums[e] - _sums[s-1])
solve()