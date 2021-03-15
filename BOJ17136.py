from sys import stdin
readline = stdin.readline

_map = [list(map(int, readline().split())) for _ in range(10)]

def solve(row, col, size):
    global ans 
    if row == 10:
        ans = min(ans, sum(size))
        return
    
    if col == 10:
        solve(row+1, 0, size)
        return
    if _map[row][col] == 0:
        solve(row, col+1, size)
        return

    for s in range(4, -1, -1):
        # 해당 사이즈 종이를 5개 썼을 경우 
        if size[s] == 5: continue

        if row+s < 10 and col+s < 10:
            flag = True
            for i in range(row, row+s+1):
                for j in range(col, col+s+1):
                    # 적어도 하나 이상 0이면 s * s 크기의 
                    # 색종이로 덮을 수 없음
                    if _map[i][j] == 0:
                        flag = False
                        break
                if not flag : break
            # s * s 색종이로 덮는 것이 가능한 경우
            if flag:
                for i in range(row, row+s+1):
                    for j in range(col, col+s+1):
                        _map[i][j] = 0
                size[s] += 1
                solve(row, col+s+1, size)
                size[s] -= 1
            
                for i in range(row, row+s+1):
                    for j in range(col, col+s+1):
                        _map[i][j] = 1


li = [0] * 6
ans = 26
solve(0, 0, li)
print(ans if ans != 26 else -1)
        