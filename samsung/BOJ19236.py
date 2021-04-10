from sys import stdin
from copy import deepcopy
readline = stdin.readline

# 물고기 인덱스 담고 있음
_map = [[[] for _ in range(4)] for _ in range(4)]
# 물고기 위치 담고 있음
fishes = [[] for _ in range(17)]
eaten = [False] * 17
ans = 0

dr = (-1, -1, 0, 1, 1, 1, 0, -1)
dc = (0, -1, -1, -1, 0, 1, 1, 1)

for r in range(4):
    line = list(map(int, readline().split()))
    for c in range(0, 8, 2):
        _map[r][c//2] = line[c]
        fishes[line[c]] = [r, c//2, line[c+1]]

def solve():
    row, col = 0, 0
    point = _map[row][col]
    _map[row][col] = -1
    eaten[point] = True
    _, _, _dir = fishes[point]
    fishes[point][2] = -1
    dfs(row, col, _dir, point, _map, fishes)

def dfs(row, col, _dir, point, idxs, wheres):
    global ans
    idxs_copy = deepcopy(idxs)
    wheres_copy = deepcopy(wheres)
    ans = max(ans, point)
    # 물고기 이동
    fishes_move(idxs_copy, wheres_copy)

    nr, nc = row + dr[_dir-1], col + dc[_dir-1]
    while 0<=nr<4 and 0<=nc<4:
        if idxs_copy[nr][nc] != 0:
            f_idx = idxs_copy[nr][nc]
            f_dir = wheres_copy[f_idx][2]
            
            idxs_copy[nr][nc] = -1
            idxs_copy[row][col] = 0
            wheres_copy[f_idx][2] = -1
            
            dfs(nr, nc, f_dir, point + f_idx, idxs_copy, wheres_copy)

            idxs_copy[nr][nc] = f_idx
            idxs_copy[row][col] = -1
            wheres_copy[f_idx][2] = f_dir

        nr, nc = nr + dr[_dir-1], nc + dc[_dir-1]

def fishes_move(idxs, wheres):
    for i in range(1, 17):
        r, c, d = wheres[i]
        if idxs[r][c] <= 0 or d == -1: continue
        nr, nc, nd = r + dr[d-1], c + dc[d-1], d
        cnt = 1
        while not(0<=nr<4 and 0<=nc<4 and idxs[nr][nc] != -1) and cnt != 9:
            nd = (nd + 8) % 8 + 1
            nr, nc = r + dr[nd-1], c + dc[nd-1]
            cnt += 1

        if cnt < 9:
            f_idx = idxs[nr][nc]
            if f_idx == 0:
                idxs[r][c] = 0
                idxs[nr][nc] = i
                wheres[i] = [nr, nc, nd]
            else:
                idxs[r][c] = f_idx
                idxs[nr][nc] = i
                
                f_dir = wheres[f_idx][2]

                wheres[f_idx] = [r, c, f_dir]
                wheres[i] = [nr, nc, nd]
    

solve()
print(ans)