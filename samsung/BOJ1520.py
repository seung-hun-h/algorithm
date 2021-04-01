from sys import stdin, setrecursionlimit
readline = stdin.readline
setrecursionlimit(10 ** 6)


M, N = map(int ,readline().split())
_map = [list(map(int, readline().split())) for _ in range(M)]
cnt = [[-1] * N for _ in range(M)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

def solve(r, c):
    if r == 0 and c == 0:
        return 1
    if cnt[r][c] == -1:
        cnt[r][c] = 0

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            if 0<=nr<M and 0<=nc<N and _map[nr][nc] > _map[r][c]:
                cnt[r][c] += solve(nr, nc)
                
    # 이미 방문한 노드는 해당 값 반환
    return cnt[r][c]

print(solve(M-1, N-1))