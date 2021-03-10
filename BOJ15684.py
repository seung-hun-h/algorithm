from sys import stdin
readline = stdin.readline

def dfs(cnt, start_r, start_c):
    global ans
    if all_n_n():
        ans = min(ans, cnt)
        return
    #  종료 조건
    if cnt == 3 or ans <= cnt:
        return


    for r in range(start_r, H+1):
        # 이미 사다리가 놓여진 row의 다음 col에는 다리를 둘 수 없다.
        k = start_c if r == start_r else 1 
        for c in range(k, N+1):
            if (c - 1 > 0 and ladder[r][c-1]) or (c + 1 < N and ladder[r][c+1]):
                continue
            if not ladder[r][c]:
                ladder[r][c] = True
                dfs(cnt + 1, r, c+2)
                ladder[r][c] = False

def all_n_n():
    for c in range(1, N+1):
        cur = c 
        for r in range(1, H+1):
            if cur > N or cur < 0: return False
            if ladder[r][cur]:
                cur += 1
            elif cur - 1 > 0 and ladder[r][cur-1]:
                cur -= 1
        if cur != c: return False
    return True

if __name__ == "__main__":
    N, M, H = map(int, readline().split())
    ladder = [[False] * (N+1) for _ in range(H+1)]
    for _ in range(M):
        a, b = map(int, readline().split())
        ladder[a][b] = True
    ans = 4
    dfs(0, 1, 1)
    print(ans if ans < 4 else -1)