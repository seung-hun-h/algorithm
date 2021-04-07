from sys import stdin
readline = stdin.readline

N = int(readline())
commands = [list(map(int, readline().split())) for _ in range(N)]

green = [[0 for _ in range(4)] for _ in range(6)]
blue = [[0 for _ in range(4)] for _ in range(6)]

point = 0

def solve():
    global green, blue
    for t, x, y in commands:
        drop_block(t, x, y)
        green = delete(green)
        blue = delete(blue)
        # for b in green:
        #     print(b)
        # print()
        # for b in blue:
        #     print(b)
        # print()

    print(point)
    cnt = 0
    for g, b in zip(green, blue):
        cnt += sum(b)
        cnt += sum(g)
    print(cnt)

def delete(area):
    global point
    rows = []
    cnt = 0
    for r in range(6):
        flag = True
        for c in range(4):
            if not area[r][c]:
                flag = False
                break
        if flag:
            rows.append(r)
    
    temp = [[0 for _ in range(4)] for _ in range(len(rows))]
    for r in range(6):
        if r not in rows:
            temp.append(area[r])

    point += len(rows)
    rows = []
    area = temp
    for r in range(2):
        for c in range(4):
            if area[r][c] == 1:
                cnt+=1
                break
    
    for i in range(cnt):
        rows.append(5-i)

    temp = [[0 for _ in range(4)] for _ in range(len(rows))]
    for r in range(6):
        if r not in rows:
            temp.append(area[r])
    return temp

def drop_block(t, x, y):
    t -= 1
    blocks = [[[0, 0]], [[0, 0], [0, 1]], [[0, 0], [1, 0]]]
    block = blocks[t]
    
    # blue
    bx, by = y, 3-x
    for r in range(5, -1, -1):
        flag = True
        for dx, dy in block:
            if r+dy >= 6 or by-dx < 0 or blue[r+dy][by-dx]:
                flag = False
        
        if flag:
            for dx, dy in block:
                for i in range(r+dy):
                    if blue[i][by-dx]:
                        flag = False
                        break

            if flag:
                for dx, dy in block:
                    blue[r+dy][by-dx] = 1
                break
    
    # green
    for r in range(5, -1, -1):
        flag = True
        for dx, dy in block:
            if r+dx >= 6 or y+dy >= 6 or green[r+dx][y+dy]:
                flag = False
        
        if flag:
            for dx, dy in block:
                for i in range(r+dx):
                    if green[i][y+dy]:
                        flag = False
                        break
                                    
            if flag:
                for dx, dy in block:
                    green[r+dx][y+dy] = 1
                break                
    
solve()