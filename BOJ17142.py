from sys import stdin
from itertools import combinations as cb
import heapq
readline = stdin.readline

N, K = map(int, readline().split())
_map = []
virus = []
total = N ** 2

dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

for r in range(N):
    line = list(map(int, readline().split()))
    _map.append(line)
    for c in range(N):
        if line[c] == 2:
            virus.append([r, c])
        if line[c] != 0:
            total -= 1

MAX = int(1e5)
ans = MAX
def solve():
    virus_cb = cb(virus, K)
    for v in virus_cb:
        spread(v)

def spread(v):
    global ans
    cur = total
    cur_map = [[_map[i][j] for j in range(N)] for i in range(N)]
    q = []

    if cur == 0:
        ans = 0
        return

    for i in range(len(v)):
        heapq.heappush(q, [0] + v[i])
        cur_map[v[i][0]][v[i][1]] = -1

    while q:
        t, r, c = heapq.heappop(q)

        if ans <= t:
            return

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            
            if 0<=nr<N and 0<=nc<N:
                if cur_map[nr][nc] == 0:
                    cur_map[nr][nc] = -1
                    heapq.heappush(q, [t+1, nr, nc])
                    cur -= 1
                    if cur == 0:
                        ans = min(ans, t+1)
                        return
                    
                elif cur_map[nr][nc] == 2:
                    heapq.heappush(q, [t+1, nr, nc])
                    cur_map[nr][nc] = -1
solve()
print(ans if ans != MAX else -1)

