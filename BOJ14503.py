from sys import stdin
from collections import deque
readline = stdin.readline


# 1: 벽, 0: 빈 공간, 2: 이미 청소
def count_clean_block(r, c, d):
    global ans
    q = deque()
    q.append([r, c, d])
    _map[r][c] = 2
    while q:
        r, c, d = q.popleft()
        flag = False
        for i in range(1, 5):
            nd = ((d - i) + 4) % 4
            nr = r + front[nd][0]
            nc = c + front[nd][1]

            if 0<=nr<N and 0<=nc<M and _map[nr][nc] == 0:
                q.append([nr, nc, nd])
                _map[nr][nc] = 2
                ans += 1
                flag = True
                break   
            
        if not flag:
            nr = r + back[d][0]
            nc = c + back[d][1]
            if 0<=nr<N and 0<=nc<M and _map[nr][nc] != 1:
                q.append([nr, nc, d])

if __name__ == '__main__':
    N, M = map(int, readline().split())
    r, c, d = map(int, readline().split())
    _map = [list(map(int , readline().split())) for _ in range(N)]
    front = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    back = [[1, 0], [0, -1], [-1, 0], [0, 1]]
    ans = 1
    count_clean_block(r, c, d)
    print(ans)