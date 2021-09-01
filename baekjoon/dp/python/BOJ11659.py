from sys import stdin 
readline = stdin.readline

N, M = map(int, readline().split())
arr = [0]+list(map(int, readline().split()))

def solve():
    _sum = [0] * (N+1)
    _sum[1] = arr[1]
    for i in range(2, N+1):
        _sum[i] = _sum[i-1] + arr[i]
    
    for _ in range(M):
        i, j = map(int, readline().split())

        print(_sum[j] - _sum[i-1])

solve()