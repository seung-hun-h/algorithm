from sys import stdin
readline = stdin.readline

def solve():
    line = readline().rstrip('\n')
    while line:
        cnt = [0] * 4
        for i in range(len(line)):
            if line[i] == "\n": break
            if line[i].isalpha():
                if line[i].islower():
                    cnt[0] += 1
                else:
                    cnt[1] += 1
            elif line[i].isdigit():
                cnt[2] += 1
            elif line[i].isspace():
                cnt[3] += 1

        print(*cnt)
        line = readline().rstrip("\n")

solve()
 