from sys import stdin
readline = stdin.readline


def get_tech_max_sum():
    _max = 0
    for row in range(N):
        cur = 0
        for col in range(M):
            visited[row][col] = True
            cur = max(cur, dfs(row, col, 1, _map[row][col]))
            visited[row][col] = False
            cur = max(cur, cal_special_block(row, col))
            
        _max = max(_max, cur)

    return _max
    
def cal_special_block(row, col):
    res = 0
    for i in range(4):
        cur = _map[row][col]
        for j in range(3):
            nr = row + dr[(i+j)%4]
            nc = col + dc[(i+j)%4]
            if 0 <= nr < N and 0 <= nc < M:
                cur += _map[nr][nc]
            else:
                cur = 0
                break
        res = max(res, cur)
    return res

def dfs(row, col, depth, _sum):
    if depth == 4:
        return _sum
    _max = 0
    for i in range(4):
        nr = row + dr[i]
        nc = col + dc[i]
        if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc]:
            visited[nr][nc] = True
            _max = max(_max, dfs(nr, nc, depth+1, _sum + _map[nr][nc]))
            visited[nr][nc] = False
    
    return _max

if __name__ == "__main__":
    N, M = map(int, readline().split())
    _map = [list(map(int, readline().split())) for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]

    print(get_tech_max_sum())