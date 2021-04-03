from sys import stdin
readline = stdin.readline

N, K = map(int, readline().split())
_map = [list(map(int, readline().split())) for _ in range(N)]
horses = [list(map(int, readline().split())) for _ in range(K)]
hmap = [[[] for _ in range(N)] for _ in range(N)]

dr, dc = (0, 0, -1, 1), (1, -1, 0, 0)

for i in range(len(horses)):
    hmap[horses[i][0]-1][horses[i][1]-1].append(i)

def solve():
    for turn in range(1, 1001):
        for i in range(K):
            flag = move(i)
            if flag:
                return turn

    return -1

def move(horse):
    r, c, d = horses[horse]

    nr, nc = r + dr[d-1], c + dc[d-1]

    if not(0<nr<=N and 0<nc<=N) or _map[nr-1][nc-1] == 2:
        if d == 1 or d == 2:
            d = (d + 2) % 2 + 1
        else:
            d = (d - 2) % 2 + 3
        
        nr, nc = r + dr[d-1], c + dc[d-1]

        if not(0<nr<=N and 0<nc<=N) or _map[nr-1][nc-1] == 2:
            horses[horse][2] = d
            return False
    
    idx = 0
    for i in range(len(hmap[r-1][c-1])):
        if hmap[r-1][c-1][i] == horse:
            idx = i
            break
    
    moving = hmap[r-1][c-1][idx:]
    hmap[r-1][c-1] = hmap[r-1][c-1][:idx]

    if _map[nr-1][nc-1] == 1:
        moving = list(reversed(moving))
    
    horses[horse] = [nr, nc, d]
    for i in moving:
        horses[i][:2] = [nr, nc]

    hmap[nr-1][nc-1] += moving

    if len(hmap[nr-1][nc-1]) >= 4:
        return True
    return False
print(solve())