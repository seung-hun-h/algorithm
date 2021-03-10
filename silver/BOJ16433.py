from sys import stdin
from collections import deque

readline = stdin.readline

def main():
    _map = [[0] * (N+1) for _ in range(N+1)]
    
    q = deque()
    q.append([R, C])

    while q:
        r, c = q.popleft()
        _map[r][c] = 1

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 1 <= nr <= N and 1 <= nc <= N and not _map[nr][nc]:
                _map[nr][nc] = 1
                q.append([nr, nc])

    print_result(_map)


def print_result(_map):
    for i in range(1, N+1):
        line = ''
        for j in range(1, N+1):
            if _map[i][j] == 0:
                line += '.'
            else:
                line += 'v'
        print(line)

        
if __name__ == "__main__":
    N, R, C = map(int, readline().split())
    dr = [-1, 1, -1, 1]
    dc = [-1, -1, 1, 1]

    main()