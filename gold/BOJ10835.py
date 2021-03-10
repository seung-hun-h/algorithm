from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)
readline = stdin.readline

N = int(readline())
left = [*map(int, readline().split())]
right = [*map(int, readline().split())]
d = [[-1] * N for _ in range(N)]

def dfs(l, r):
    if l >= N or r >= N:
        return 0
    
    if d[l][r] != -1:
        return d[l][r]
    
    if left[l] > right[r]:
        d[l][r] = dfs(l, r+1) + right[r]
    else:
        d[l][r] = max(dfs(l+1, r), dfs(l+1, r+1))

    return d[l][r]

print(dfs(0, 0))