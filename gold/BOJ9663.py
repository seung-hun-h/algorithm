from sys import stdin
readline = stdin.readline

N = int(readline().strip())
a, b, c = [False] * N, [False] * (2 * N-1), [False] * (2 * N-1)
ans = 0

def dfs(level):
    global ans

    if level == N:
        ans += 1
        return
    
    for i in range(N):
        if not(a[i] or b[level+i] or c[level-i+N-1]):
            a[i] = b[level+i] = c[level-i+N-1] = True
            dfs(level+1)
            a[i] = b[level+i] = c[level-i+N-1] = False

dfs(0)
print(ans)    