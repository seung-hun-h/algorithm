from sys import stdin
readline = stdin.readline

_map = [list(readline()) for _ in range(5)]
S = []
include = [False] * 25
ans = 0

dr = (1, -1, 0, 0)
dc = (0, 0, 1, -1)

def solve(idx, yn, cnt):
    global ans
    if yn >= 4 or 25 - idx < 7 - cnt:
        return

    # 7명을 모두 소집한 경우
    if cnt == 7:
        visited = [[False for _ in range(5)] for _ in range(5)]
        visited[S[0]//5][S[0]%5] = True
        if check(S[0], visited, [1]):
            ans += 1
        return

    # 현재 인원의 위치
    r = idx // 5
    c = idx % 5

    # 현재 인원을 포함하는 경우
    S.append(idx)
    include[idx] = True

    # 현재 인원이 임도연파인경우
    if _map[r][c] == "Y":
        solve(idx+1, yn+1, cnt+1)
    # 현재 인원이 이다솜파인경우
    elif _map[r][c] == "S":
        solve(idx+1, yn, cnt+1)

    # 현재 인원을 포함하지 않는경우
    S.pop()
    include[idx] = False
    solve(idx+1, yn, cnt)

def check(n, visited, cnt):
    if cnt[0] == 7:
        return True
    r = n // 5
    c = n % 5

    res = False
    for i in range(4):
        nr, nc = r + dr[i], c + dc[i]

        if 0<=nr<5 and 0<=nc<5 and not visited[nr][nc]:
            if include[nr*5+nc]:
                visited[nr][nc] = True
                cnt[0] += 1
                res = check(nr*5+nc, visited, cnt)
                if res:
                    return res
    return res

solve(0, 0, 0)
print(ans)