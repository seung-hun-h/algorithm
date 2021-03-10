from sys import stdin
import heapq

readline = stdin.readline


def get_min_path():
    q = []
    heapq.heappush(q, [0, 0, 0])

    while q:
        w, r, c = heapq.heappop(q)
        _map[r][c] = 2

        if r == N-1 and c == M-1:
            return w+1

        for i in range(4):
            n_r = r + dr[i]
            n_c = c + dc[i]

            if 0 <= n_r < N and 0 <= n_c < M and _map[n_r][n_c] == 1:
                heapq.heappush(q, [w+1, n_r, n_c]) 
                _map[n_r][n_c] = 2


if __name__ == "__main__":
    N, M = map(int, readline().split())
    _map = [list(map(int, list(readline().strip()))) for _ in range(N)]

    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]

    print(get_min_path())