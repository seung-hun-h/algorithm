from sys import stdin
from collections import deque
readline = stdin.readline

N, M, T = map(int, readline().split())
circles = [deque() for _ in range(N+1)]

for r in range(1, N+1):
    circle = circles[r]
    line = list(map(int, readline().split()))
    for l in line:
        circle.append(l)

commands = [list(map(int, readline().split())) for _ in range(T)]

def solve():
    for command in commands:
        rotate(*command)
        delete()


    total = 0
    for i in range(1, N+1):
        total += sum(circles[i])
    print(total)

def delete():
    # 상하 인접
    # 짝수 원판의 아래 위만 검사하여 제거
    flags = [[False] * M for _ in range(N+1)]
    isDeleted = False
    total = 0
    cnt = 0
    for i in range(1, N+1):
        if i % 2 == 0:
            up = i + 1
            down = i - 1
            
            for j in range(M):
                if circles[i][j] == 0: continue
                if up <= N and circles[i][j] == circles[up][j]:
                    flags[up][j] = True
                    flags[i][j] = True
                if circles[i][j] == circles[down][j]:
                    flags[i][j] = True
                    flags[down][j] = True
        
                if flags[i][j]:
                    isDeleted = True

        for j in range(M):
            if circles[i][j] == 0: continue
            total += circles[i][j]
            cnt += 1
            if circles[i][j] == circles[i][(j+1) % M]:
                flags[i][j] = True
                flags[i][(j+1) % M] = True

            if flags[i][j]:
                isDeleted = True

    if isDeleted:
        for r in range(1, N+1):
            for c in range(M):
                if flags[r][c]:
                    circles[r][c] = 0
    else:
        if cnt:
            mean = total / cnt
            for r in range(1, N+1):
                for c in range(M):
                    if circles[r][c]:
                        if circles[r][c] < mean:
                            circles[r][c] += 1
                        elif circles[r][c] > mean:
                            circles[r][c] -= 1
def rotate(x, d, k):
    for i in range(1, len(circles)):
        if i % x == 0:
            # 시계 방향
            if d == 0:
                for _ in range(k):
                    circles[i].appendleft(circles[i].pop())
            else:
                for _ in range(k):
                    circles[i].append(circles[i].popleft())

solve()