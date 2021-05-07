def solution(key, lock):
    answer = True
    M, N = len(key), len(lock)
    for _ in range(4): # 회전
        for r_off in range(-(M-1), N, 1): # key row 이동 오프셋
            for c_off in range(-(M-1), N, 1): # key column 이동 오프셋
                _key = []
                for r in range(M):
                    if not(0<=r+r_off<N): continue 
                    for c in range(M):
                        if not(0<=c+c_off<N): continue # lock의 크기 벗어난 경우 
                        if key[r][c] == 1: # lock의 내부 key의 값이 1인 경우
                            _key.append([r+r_off, c+c_off])
                
                if check(_key, lock):
                    return True
        key = rotate(key)
    return False

def check(_key, lock):
    _sum = sum([sum(lock[i]) for i in range(len(lock))])
    N = len(lock)
    for r, c in _key:
        if r < 0 or c < 0 or r >= N or c >= N: continue
        if lock[r][c] == 1:
            return False
        _sum += 1
    
    return _sum == len(lock)**2

# 90도 회전
def rotate(arr):
    N = len(arr)
    temp = [[0 for _ in range(N)] for _ in range(N)]
    for r in range(N):
        for c in range(N):
            temp[r][c] = arr[N-1-c][r]

    return temp
key = [[1, 1, 1], [1, 1, 1], [1, 1, 1]]
lock =[[1, 1, 1], [1, 1, 0], [1, 1, 0]]

res = solution(key, lock)
print(res)