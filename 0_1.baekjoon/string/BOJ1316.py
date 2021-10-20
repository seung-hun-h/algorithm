from sys import stdin
readline = stdin.readline

N = int(readline())

def solve():
    cnt = 0
    for _ in range(N):
        check = set()
        line = readline().strip() + "/"
        flag = True
        for i in range(1, len(line)):
            if line[i-1] != line[i]:
                if line[i-1] in check:
                    flag = False
                    break
                check.add(line[i-1])
        
        if flag:
            cnt += 1
    print(cnt)

def solve2():
    cnt = 0
    for _ in range(N):
        line = readline().strip()
        if list(line) == sorted(line, key=line.find):
            cnt += 1
    print(cnt)

solve2()