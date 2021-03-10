from sys import stdin
readline = stdin.readline

def main():
    cctvs = []
    _map = []
    for i in range(N):
        row = list(map(int, readline().split()))
        _map.append(row)
        for j in range(M):
            if 0 < row[j] < 6:
                cctvs.append([i, j, row[j]])

    dfs(_map, 0, cctvs)

def dfs(_map, cnt, cctvs):
    global ans, dirs
    temp = [[_map[i][j] for j in range(M)] for i in range(N)]
    if cnt == len(cctvs): # CCTV를 모두 설치한 경우
        num = 0
        for i in range(N):
            num += temp[i].count(0)
        ans = min(ans, num)
        return
    
    r, c, cctv = cctvs[cnt]
    for i in dirs[cctv]:
        watch(temp, r, c, i) # 해당 방향으로 감시 확장
        dfs(temp, cnt + 1, cctvs)
        temp = [[_map[i][j] for j in range(M)] for i in range(N)] # 초기화

def watch(_map, r, c, _dir):
    for d in _dir: # 주어진 방향에 대해
        nr, nc = r, c # 확장
        while 0 <= nr < N and 0 <= nc < M:
            if _map[nr][nc] == 6: break
            if _map[nr][nc] == 0:
                _map[nr][nc] = -1
            
            nr += dr[d]
            nc += dc[d]

if __name__ == '__main__':
    N, M = map(int, readline().split())
    ans = N * M
    dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)
    dirs = [[], [[0], [1], [2], [3]], [[0, 1], [2, 3]], [[0, 2], [2, 1], [1, 3], [3, 0]], 
            [[0, 2, 3], [0, 1, 2], [1, 2, 3], [0, 1, 3]], [[0, 1, 2, 3]]]
    main()
    print(ans)