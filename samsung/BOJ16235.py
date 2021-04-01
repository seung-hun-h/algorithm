from sys import stdin
from collections import deque
readline = stdin.readline

N, M, K = map(int, readline().split())
_map = [[5] * N for _ in range(N)]
nutri = [list(map(int, readline().split())) for _ in range(N)]
tree = [[deque() for _ in range(N)] for _ in range(N)]
ans = 0
for _ in range(M):
    r, c, a = map(int, readline().split())
    tree[r-1][c-1].append(a)
    ans += 1
dr = (-1, -1, -1, 0, 0, 1, 1, 1)
dc = (-1, 0, 1, -1, 1, -1, 0, 1)

def solve():
    global tree, ans
    for _ in range(K):

        # 봄 & 여름
        for r in range(N):
            for c in range(N):
                for k in range(len(tree[r][c])):
                    if _map[r][c] >= tree[r][c][k]:
                        _map[r][c] -= tree[r][c][k]
                        tree[r][c][k] += 1
                    else:
                        while k < len(tree[r][c]):
                            _map[r][c] += (tree[r][c].pop() // 2)
                            ans -= 1                 
                        break

        # 가을 & 겨울
        for r in range(N):
            for c in range(N):
                for k in range(len(tree[r][c])):
                    if tree[r][c][k] % 5 == 0:
                        for i in range(8):
                            nr, nc = r + dr[i], c + dc[i]
                            if 0 <= nr < N and 0 <= nc < N:
                                tree[nr][nc].appendleft(1)
                                ans += 1
                _map[r][c] += nutri[r][c]
        

    print(ans)
        

solve()