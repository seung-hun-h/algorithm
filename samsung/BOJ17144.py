from sys import stdin
readline = stdin.readline

R, C, T = map(int, readline().split())
_map = []
cleaner = []
dusts = []
dr, dc = (1, -1, 0, 0), (0, 0, 1, -1)
ans = 0
for r in range(R):
    line = list(map(int, readline().split()))
    for c in range(C):
        if line[c] == -1:
            cleaner.append([r, c])
        elif line[c] != 0:
            ans += line[c]
            dusts.append([r, c])

    _map.append(line)

def solve():
    for _ in range(T):
        # Done
        spread()
        # Done
        move()


def move():
    global dusts, ans
    up, down = cleaner
    temp = []
    while dusts:
        dust = dusts.pop()
        r, c = dust
        d = _map[r][c]
        _map[r][c] = 0
        if r <= up[0]:
            if r == up[0]:
                if c + 1 < C:
                    c += 1
                else:
                    r -= 1
            elif c == C-1:
                if r - 1 >= 0:
                    r -= 1
                else:
                    c -= 1
            elif r == 0:
                if c - 1 >= 0:
                    c -= 1
                else:
                    r += 1
            elif c == 0:
                r += 1
        elif r >= down[0]:
            if r == down[0]:
                if c + 1 < C:
                    c += 1
                else:
                    r += 1
            elif c == C-1:
                if r + 1 < R:
                    r += 1
                else:
                    c -= 1
            elif r == R-1:
                if c - 1 >= 0:
                    c -= 1
                else:
                    r -= 1
            elif c == 0:
                r -= 1

        if _map[r][c] != -1:
            temp.append([r, c, d])
    cur = 0
    while temp:
        r, c, d = temp.pop()
        cur += d
        if _map[r][c] == 0:
            dusts.append([r, c])
        _map[r][c] = d
    
    ans = cur

def spread():
    temp = []
    while dusts:
        dust = dusts.pop()
        # 먼지 초기화
        r, c = dust
        d = _map[r][c]
        _map[r][c] = 0
        if (d // 5) == 0:
            temp.append([r, c, d])
            continue
        spreaded = 0
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if 0<=nr<R and 0<=nc<C and _map[nr][nc] != -1:
                spreaded += (d // 5)
                temp.append([nr, nc, d // 5])
        
        d -= spreaded

        temp.append([r, c, d])
    
    while temp:
        t = temp.pop()
        r, c, d = t
        if _map[r][c] == 0:
            dusts.append([r, c])
        _map[r][c] += d

solve()
print(ans)