from sys import stdin
from collections import deque
readline = stdin.readline

N = int(readline())
_map = [[0 for _ in range(N)] for _  in range(N)]
visited = [[[False for _ in range(2)] for _ in range(N)] for _ in range(N)]
tree = []
target = []

dr = (-1, 0, 1)
dc = (-1, 0, 1)

for r in range(N):
    line = list(readline())
    for c in range(N):
        if line[c] == "B":
            tree.append([r, c])
        elif line[c] == "E":
            target.append([r, c])
        else:
            _map[r][c] = int(line[c])  

t_core = target[1]
t_shape = 0 if target[0][0] != target[1][0] else 1

def solve():
    # ㅣ:0, ㅡ:1
    shape = 0 if tree[0][0] != tree[1][0] else 1
    core = tree[1]

    q = deque()
    q.append([core[0], core[1], shape, 0])
    visited[core[0]][core[1]][shape] = True

    while q:
        r, c, s, cnt = q.popleft()

        if r == t_core[0] and c == t_core[1] and s == t_shape:
            return cnt
        
        # 상
        up_r = r - 1
        if up_r >= 0:
            if s == 0 and up_r > 0:
                if not _map[up_r-1][c] and not visited[up_r][c][s]:
                    q.append([up_r, c, s, cnt+1])
                    visited[up_r][c][s] = True
            elif s == 1:
                if not _map[up_r][c-1] and not _map[up_r][c] and not _map[up_r][c+1] and not visited[up_r][c][s]:
                    q.append([up_r, c, s, cnt+1])
                    visited[up_r][c][s] = True
        # 하
        down_r = r + 1
        if down_r < N:
            if s == 0 and down_r < N-1:
                if not _map[down_r+1][c] and not visited[down_r][c][s]:
                    q.append([down_r, c, s, cnt+1])
                    visited[down_r][c][s] = True
            elif s == 1:
                if not _map[down_r][c-1] and not _map[down_r][c] and not _map[down_r][c+1] and not visited[down_r][c][s]:
                    q.append([down_r, c, s, cnt+1])
                    visited[down_r][c][s] = True
        # 좌
        left_c = c - 1
        if left_c >= 0:
            if s == 0:
                if not _map[r-1][left_c] and not _map[r][left_c] and not _map[r+1][left_c] and not visited[r][left_c][s]:
                    q.append([r, left_c, s, cnt+1])
                    visited[r][left_c][s] = True

            elif s == 1 and left_c > 0:
                if not _map[r][left_c-1] and not visited[r][left_c][s]:
                    q.append([r, left_c, s, cnt+1])
                    visited[r][left_c][s] = True

        # 우
        right_c = c + 1
        if right_c < N:
            if s == 0:
                if not _map[r-1][right_c] and not _map[r][right_c] and not _map[r+1][right_c] and not visited[r][right_c][s]:
                    q.append([r, right_c, s, cnt+1])
                    visited[r][right_c][s] = True

            elif s == 1 and right_c < N - 1:
                if not _map[r][right_c+1] and not visited[r][right_c][s]:
                    q.append([r, right_c, s, cnt+1])
                    visited[r][right_c][s] = True

        # 회전
        flag = True
        ns = 1 if s == 0 else 0
        if s == 0:
            for i in range(3):
                nr = r + dr[i]
                l_c = c - 1
                r_c = c + 1
                if l_c < 0 or r_c >= N:
                    flag = False
                    break
                if _map[nr][l_c] == 1 or _map[nr][r_c] == 1:
                    flag = False
                    break
        elif s == 1:
            for i in range(3):
                nc = c + dc[i]
                u_r = r - 1
                d_r = r + 1
                if u_r < 0 or d_r >= N:
                    flag = False
                    break
                if _map[u_r][nc] == 1 or _map[d_r][nc] == 1:
                    flag = False
                    break
        if flag and not visited[r][c][ns]:
            q.append([r, c, ns, cnt+1])
            visited[r][c][ns] = True

ans = solve()
print(ans if ans is not None else 0)