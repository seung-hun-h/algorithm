from sys import stdin
readline = stdin.readline

N, K = map(int, readline().split())
arr = list(map(int, readline().split()))

def solve():
    _sum = sum(arr[:K])
    _max = _sum

    for i in range(K, N):
        _sum = _sum + arr[i] - arr[i-K]
        _max = max(_sum, _max)

    print(_max)

solve()