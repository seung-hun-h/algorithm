from sys import stdin
readline = stdin.readline

R, C, M = map(int, readline().split())
_map = [[[] for _ in range(C+1)]  for _ in range(R+1)]

for _ in range(M):
    r, c, s, d, z = map(int, readline().split())
    _map[r][c] = [s, d, z]

def solve():
    ans = 0

    for col in range(1, C+1):
        # 같은 열에 있는 상어 잡기
        for row in range(1, R+1):
            if _map[row][col]:
                ans += _map[row][col][2]
                _map[row][col] = [] # 상어를 잡은 후 _map에서 제거
                break
   
        # 상어 이동
        move_result = []
        for row in range(1, R+1):
            for col in range(1, C+1):
                if _map[row][col]:
                    move_result.append(move(row, col))

        # 해당 열에 상어가 있을 경우 크기가 큰 상어가 작은 상어를 잡아 먹는다.
        for res in move_result:
            if _map[res[0]][res[1]]:
                    # 큰 상어가 작은 상어를 잡아 먹는다.
                    if res[2][-1] > _map[res[0]][res[1]][-1]: 
                        _map[res[0]][res[1]] = res[2]
            else:
                # 상어가 없을 경우 위치 시킨다.
                _map[res[0]][res[1]] = res[2]

    print(ans)

def move(row, col):
    s, d, z = _map[row][col]
    r, c = row, col
    if d == 1 or d == 2:
         while s > 0:
            diff = 0
            if d == 1:
                diff = abs(r - 1)
            else:
                diff = abs(r - R)
            
            if diff >= s:
                if d == 1:
                    r -= s
                else:
                    r += s
                break
            else:
                if d == 1:
                    r = 1
                    d = 2
                else:
                    r = R
                    d = 1
        
                s -= diff
    else:
        while s > 0:
            diff = 0
            # 현재 위치와 끝 지점간 차이를 구한다.
            if d == 4:
                diff = abs(c - 1)
            else:
                diff = abs(c - C)
            
            # 차이가 속도보다 크거나 같은 경우 
            # 최대 이동할 수 있는 지점이 끝 지점이기 때문에
            # 현재 위치에서 속도를 뺀 후 이동을 종료한다.
            if diff >= s:
                if d == 4:
                    c -= s
                else:
                    c += s
                break # 반드시 작성
            
            else:
                # 차이가 속도보다 작은 경우 
                # 상어를 끝지점으로 이동 시킨 후 방향을 전환한다. 
                
                if d == 4:
                    c = 1
                    d = 3
                else:
                    c = C
                    d = 4
                # 방향 전환 후 다시 남은 거리만큼 이동하기위해 
                # 속도에서 차이를 뺀 후 
                # 처음부터 다시 반복한다.
                s -= diff
     # 상어의 수정된 방향을 반영한다.           
    _map[row][col][1] = d
    temp = _map[row][col]
    # 이동전 위치를 초기화한다.
    _map[row][col] = []
    return r, c, [*temp,]
solve()