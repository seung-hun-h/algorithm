from sys import stdin
readline = stdin.readline

N, M = map(int, readline().split())
home = []
chicken = []
result = []
ans = 2 * N**2
for r in range(N):
    line = list(map(int, readline().split()))
    for c in range(N):
        if line[c] == 1:
            home.append((r, c))
        elif line[c] == 2:
            chicken.append((r, c))

def solve(idx, cnt):
    global ans
    if idx > len(chicken): return
    if cnt == M:
        t = 0
        for hr, hc in home:
            dist = 2 * N + 1
            for j in result:
                cr, cc = chicken[j]
                dist = min(dist, abs(hr-cr) + abs(hc-cc))
            t += dist
        ans = min(ans, t)
        return
    result.append(idx)
    solve(idx+1, cnt+1)
    result.pop()
    solve(idx+1, cnt)

solve(0, 0)
print(ans)
