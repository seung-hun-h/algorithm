from sys import stdin
from collections import deque
readline = stdin.readline

R, C, N = map(int, readline().split())
_map = [list(readline().strip()) for _ in range(R)]
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)

def solve():
    if N == 1:
        for m in _map:
            print(''.join(m))
        return
    
    if N%2 == 0:
        for _ in range(R):
            print("O" * C)
        return
    
    for t in range(N-1):
        if t % 2 == 0:
            bombs = find_bombs()
        else:
            while bombs:
                r, c = bombs.popleft()
                _map[r][c] = "."
                for i in range(4):
                    nr, nc = r + dr[i], c + dc[i]
                    if 0<=nr<R and 0<=nc<C:
                        _map[nr][nc] = "."
    for m in _map:
        print(''.join(m))

def find_bombs():
    q = deque()
    for r in range(R):
        for c in range(C):
            if _map[r][c] == "O":
                q.append([r, c])
            else:
                _map[r][c] = "O"

    return q

solve()