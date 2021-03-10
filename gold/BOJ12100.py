from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)

readline = stdin.readline


def main():
    N = int(readline().strip())
    _map = [list(map(int, readline().split())) for _ in range(N)]
    print(dfs(_map, N, 0))

def dfs(_map, N, moves):
    if moves == 5:
        _max = 0
        for m in _map:
            _max = max([_max] + m)
        
        return _max

    _max = 0
    _max = max(_max, dfs(move_right(_map, N), N, moves+1))
    _max = max(_max, dfs(move_left(_map, N), N, moves+1))
    _max = max(_max, dfs(move_up(_map, N), N, moves+1))
    _max = max(_max, dfs(move_down(_map, N), N, moves+1))
    
    return _max

def move_right(_map, N):
    temp = [[_map[i][j] for j in range(N)] for i in range(N)]
    for row in range(N):
        p = N-1
        x = 0
        for col in range(N-1, -1, -1):
            if temp[row][col] == 0: continue
            if x == 0:
                x = temp[row][col]
            else:
                if x == temp[row][col]:
                    temp[row][p] = 2 * x
                    p -= 1
                    x = 0
                else:
                    temp[row][p] = x
                    p -= 1
                    x = temp[row][col]
            temp[row][col] = 0

        if x != 0: temp[row][p] = x

    return temp

def move_left(_map, N):
    temp = [[_map[i][j] for j in range(N)] for i in range(N)]
    for row in range(N):
        p = 0
        x = 0
        for col in range(N):
            if temp[row][col] == 0: continue
            if x == 0:
                x = temp[row][col]
            else:
                if x == temp[row][col]:
                    temp[row][p] = 2 * x
                    p += 1
                    x = 0
                else:
                    temp[row][p] = x
                    p += 1
                    x = temp[row][col]
            temp[row][col] = 0

        if x != 0: temp[row][p] = x

    return temp

def move_down(_map, N):
    temp = [[_map[i][j] for j in range(N)] for i in range(N)]
    for col in range(N):
        p = N-1
        x = 0
        for row in range(N-1, -1, -1):
            if temp[row][col] == 0: continue
            if x == 0:
                x = temp[row][col]
            else:
                if x == temp[row][col]:
                    temp[p][col] = 2 * x
                    p -= 1
                    x = 0
                else:
                    temp[p][col] = x
                    p -= 1
                    x = temp[row][col]
            temp[row][col] = 0

        if x != 0: temp[p][col] = x
    
    return temp

def move_up(_map, N):
    temp = [[_map[i][j] for j in range(N)] for i in range(N)]
    for col in range(N):
        p = 0 # 옮겨진 숫자의 위치
        x = 0 # 옮겨질 숫자
        for row in range(N):
            if temp[row][col] == 0: continue # 값이 0일 경우 옮길 수가 없기 때문에 넘어간다.
            if x == 0: 
                x = temp[row][col] # 옮길 수 지정
            else:
                if x == temp[row][col]: # 옮길 수와 현재 수가 같은 경우 
                    temp[p][col] = 2 * x # 옮겨질 위치에 더한 결과를 저장
                    x = 0 # 옮긴 후 초기화
                    p += 1 # 위치 이동
                else:
                    temp[p][col] = x # 두 수가 같지 않으므로 더하지 않고 이동만
                    p += 1 # 위치 이동
                    x = temp[row][col] # 현재 수로 초기화    
            temp[row][col] = 0 # 해당 수를 옮겼으니 0으로 변경
        
        if x != 0 : temp[p][col] = x
                
    return temp

if __name__ == "__main__":
    main()