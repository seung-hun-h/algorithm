from sys import stdin
from collections import deque
readline = stdin.readline

ans = int(1e6)
N = int(readline().strip())
_map = [[0] * (N+1)]
total = 0
for _ in range(N):
    line = [0]+list(map(int, readline().split()))
    total += sum(line)
    _map.append(line)


def solve():
    for x in range(1, N+1):
        for y in range(1, N+1):
            for d1 in range(1, N+1):
                for d2 in range(1, N+1):
                    if x + d1 + d2 > N:
                        continue
                    if y - d1 < 1:
                        continue
                    if y + d2 > N:
                        continue
                    find(x, y, d1, d2)                
def find(x, y, d1, d2):
    global ans
    region = [[0] * (N+1) for _ in range(N+1)]    
    population = [0] * 6

    # 경계선
    region[x][y] = 5
    for i in range(1, d1+1):
        region[x+i][y-i] = 5
    
    for i in range(1, d2+1):
        region[x+i][y+i] = 5

    for i in range(1, d2+1):
        region[x+d1+i][y-d1+i] = 5

    for i in range(1, d1+1):
        region[x+d2+i][y+d2-i] = 5

    # 1 구역
    for r in range(1, x+d1):
        for c in range(1, y+1):
            if region[r][c] == 5:break
            if region[r][c] == 0:
                region[r][c] = 1
                population[1] += _map[r][c]
    # 2 구역
    for r in range(1, x+d2+1):
        for c in range(N, y, -1):
            if region[r][c] == 5:break
            if region[r][c] == 0:
                region[r][c] = 2
                population[2] += _map[r][c]

    # 3 구역
    for r in range(x+d1, N+1):
        for c in range(1, y-d1+d2):
            if region[r][c] == 5:break
            if region[r][c] == 0:
                region[r][c] = 3
                population[3] += _map[r][c]

    # 4 구역
    for r in range(x+d2+1, N+1):
        for c in range(N, y-d1+d2-1, -1):
            if region[r][c] == 5:break
            if region[r][c] == 0:
                region[r][c] = 4
                population[4] += _map[r][c]
    
    population[5] = total - sum(population)

    ans = min(ans, max(population[1:])-min(population[1:]))

solve()
print(ans)