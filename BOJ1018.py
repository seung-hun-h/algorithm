from sys import stdin, setrecursionlimit
readline = stdin.readline
setrecursionlimit(10 ** 6)

N, M = map(int, readline().split())
ans = N * M + 1
_map = [list(readline().strip()) for _ in range(N)]

def solve(row, col):
    global ans
    # 더이상 아래로 갈 수 없는 경우
    # 종료
    if row + 8 > N:
        return
    # 더이상 옆으로 옮길 수 없는 경우 아래로 한 칸
    if col + 8 > M:
        solve(row+1, 0)
        return


    equal_cnt = 0 # 시작 지점이 현재 배열과 동일한 경우
    diff_cnt = 1 # 시작 지점이 현재 배열과 다른 경우
    temp = [[_map[i][j] for j in range(col, col+8)] for i in range(row, row+8)]
    for c in range(1, 8):
        if temp[0][c] == temp[0][c-1]:
            equal_cnt += 1
            temp[0][c] = "B" if temp[0][c-1] == "W" else "W"    
        else:
            diff_cnt += 1
        

    for r in range(1, 8):
        for c in range(8):
            if temp[r-1][c] == temp[r][c]:
                equal_cnt += 1
                temp[r][c] = "B" if temp[r-1][c] == "W" else "W"
            else:
                diff_cnt += 1

    ans = min(ans, equal_cnt, diff_cnt)
    solve(row , col+1)
solve(0, 0)
print(ans)