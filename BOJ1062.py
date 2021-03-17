from sys import stdin
readline = stdin.readline

def count_path():
    global ans
    for i in range(N):

        # 가로
        flag = True
        for j in range(N-1):
            cur = []
            if abs(_map[i][j] - _map[i][j+1]) > 1:
                flag = False
                break
            if abs(_map[i][j] - _map[i][j+1]) == 1:
                # 뒷 부분이 크면 앞을 확인
                if _map[i][j] > _map[i][j+1]:
                    
                    for k in range(j+1, j+1+L):
                        if k >= N or _map[i][k] != _map[i][j+1] or c_done[i][k]: 
                            flag = False
                            break
                        cur.append([i, k])
                else:
                    for k in range(j, j-L, -1):
                        if k < 0 or _map[i][k] != _map[i][j] or c_done[i][k]: 
                            flag = False
                            break
                        cur.append([i, k])
            if flag:
                for r, c in cur:
                    c_done[r][c] = True
        if flag: ans += 1
       
        # 세로
        flag = True
        for j in range(N-1):
            cur = []
            if abs(_map[j][i] - _map[j+1][i]) > 1:
                flag = False
                break
            if abs(_map[j][i] - _map[j+1][i]) == 1:
                # 뒷 부분이 크면 앞을 확인
                if _map[j][i] > _map[j+1][i]:
                    
                    for k in range(j+1, j+1+L):
                        if k >= N or _map[k][i] != _map[j+1][i] or r_done[k][i]: 
                            flag = False
                            break
                        cur.append([k, i])
                else:
                    for k in range(j, j-L, -1):
                        if k < 0 or _map[k][i] != _map[j][i] or r_done[k][i]: 
                            flag = False
                            break
                        cur.append([k, i])
                if flag:
                    for r, c in cur:
                        r_done[r][c] = True
        if flag: ans += 1

if __name__ == '__main__':
    N, L = map(int, readline().split())
    _map = [list(map(int, readline().split())) for _ in range(N)]
    r_done = [[False] * N for _ in range(N)]
    c_done = [[False] * N for _ in range(N)]
    ans = 0
    count_path()
    print(ans)