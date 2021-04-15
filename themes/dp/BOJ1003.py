from sys import stdin
readline = stdin.readline

arr = [[0, 0] for _ in range(41)]
T = int(readline())

arr[0] = [1, 0]
arr[1] = [0, 1]

def solve():
    for _ in range(T):
        N = int(readline())
        print(*cnt_zero_one(N))

def cnt_zero_one(n):
    if n == 0 or n == 1:
        return arr[n]

    for i in range(2, n+1):
        arr[i] = [arr[i-1][0] + arr[i-2][0], arr[i-1][1] + arr[i-2][1]]

    return arr[n]
solve()
