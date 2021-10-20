from sys import stdin
readline = stdin.readline

N, M = map(int, readline().split())
arr = [[0]*(M+1)]+[[0]+list(map(int, list(readline().strip()))) for _ in range(N)]

def solve():
    _max = 0
    for i in range(1, N+1):
        for j in range(1, M+1):
            if arr[i][j] == 0: continue

            arr[i][j] = min(arr[i-1][j-1], arr[i-1][j], arr[i][j-1]) + 1
            _max = max(_max, arr[i][j])
    
    print(_max ** 2)

solve()

"""
해결: O
시간: 51분
DP라는 걸 몰랐으면 풀 수 있었을까?
DP로 풀어야 하는 근거 찾기!
1. 정사각형의 위치나 여부를 묻는 것이 아닌 최대 크기만 구하기 떄문
2. 중복된 하위 문제들의 결과를 저장해뒀다가 풀이 해나간다.
즉, 했던 일 또하는 것
"""