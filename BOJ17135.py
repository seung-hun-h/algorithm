from sys import stdin
import heapq
from itertools import combinations as cb
readline = stdin.readline

N, M, D = map(int, readline().split())
dr = (0, -1, 0)
dc = (-1, 0, 1)
_map = [list(map(int, readline().split())) for _ in range(N)]
all_archers = [[N-1, i] for i in range(M)]

archers_cb = cb(all_archers, 3) # 궁수 자리 배치 모든 경우의 수


def solve(archers_org):
    cnt = 0
    _map_cp = [[_map[i][j] for j in range(M)] for i in range(N)]
    archers = [[archers_org[i][0], archers_org[i][1]] for i in range(3)]
    for t in range(N):
        delete_rc = []
        # 죽일 적 찾기
        # BFS로 가장 가까운 적 찾는다.
        for archer in archers:
            r, c = bfs(_map_cp, archer[0], archer[1])
            if r != -1 and c != -1:
                delete_rc.append([r, c])

        # 적 죽이기
        for r, c in delete_rc:
            if _map_cp[r][c] != 0:
                _map_cp[r][c] = 0
                cnt += 1

        # 궁수의 위치 한 칸 위로
        for archer in archers:
            archer[0] -= 1        
    
    return cnt

def bfs(_map_cp, ar_r, ar_c):
    q = []
    heapq.heappush(q, [1, ar_c, ar_r]) # 가장 왼쪽의 적을 먼저 죽인다.
                                       # 최우선: 거리, 차선: 왼쪽으로 최소 힙에 정렬
    visited = [[False] * M for _ in range(D)]
    while q:
        d, c, r = heapq.heappop(q)
        visited[ar_r-r][c] = True
        
        if _map_cp[r][c] == 1 and d <= D:
            return r, c
        
        for i in range(3):
            nr, nc = r + dr[i], c + dc[i]
            if 0<=nr<N and 0<=nc<M and (abs(ar_r-nr) + abs(ar_c-nc)) <= D and ar_r-nr < D and not visited[ar_r-nr][nc]:
                heapq.heappush(q, [d+1, nc, nr])
                visited[ar_r-nr][nc] = True

    return -1, -1 # 죽일 수 있는 적이 없는 경우

ans = 0
for archers in archers_cb:
    ans = max(ans, solve(archers))
print(ans)