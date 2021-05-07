from collections import deque
def solution(board):
    N = len(board)
    INF = int(10 ** 9)
    d = ((-1, 0), (0, -1), (1, 0), (0, 1))
    dp = [[[[0 for _ in range(N*N)] for _ in range(4)] for _ in range(N)] for _ in range(N)]
    q = deque()
    q.append([0, 0, 3, 0])
    q.append([0, 0, 2, 0])
    dp[0][0][0][0] = 1    
    while q:
        row, col, _dir, coner = q.popleft()

        # 직진
        nr, nc = row + d[_dir][0], col + d[_dir][1]
        if 0<=nr<N and 0<=nc<N and not board[nr][nc] and not dp[nr][nc][_dir][coner]:
            dp[nr][nc][_dir][coner] = dp[row][col][_dir][coner] + 1
            q.append([nr, nc, _dir, coner])

        # 좌회전
        nd, nconer = (_dir+1)%4, coner+1
        nr, nc = row + d[nd][0], col + d[nd][1]
        if 0<=nr<N and 0<=nc<N and not board[nr][nc] and\
            nconer < N*N and not dp[nr][nc][nd][nconer]:
            dp[nr][nc][nd][nconer] = dp[row][col][_dir][coner] + 1
            q.append([nr, nc, nd, nconer])
        # 우회전
        nd, nconer = (_dir+3)%4, coner+1
        nr, nc = row + d[nd][0], col + d[nd][1]
        if 0<=nr<N and 0<=nc<N and not board[nr][nc] and\
            nconer < N*N and not dp[nr][nc][nd][nconer]:
            dp[nr][nc][nd][nconer] = dp[row][col][_dir][coner] + 1
            q.append([nr, nc, nd, nconer])

    answer = INF
    for cost in dp[N-1][N-1]:
        for c in range(N*N):
            if cost[c] == 0: continue
            answer = min(answer, cost[c]*100 + c*500 )
    return answer

res = solution([[0, 0, 1, 0], [0, 0, 0, 0], [0, 1, 0, 1], [1, 0, 0, 0]])
print(res)