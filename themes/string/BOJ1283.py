from sys import stdin
readline = stdin.readline

N = int(readline())

def solve():
    short = set()
    res = []
    for _ in range(N):
        words = readline().strip().split()
        done = False
        # 1
        for i in range(len(words)):
            if words[i][0].lower() not in short and words[i][0].upper() not in short:
                short.add(words[i][0])
                words[i] = "[" + words[i][0] + "]" + words[i][1:]
                done = True
                break
        # 2
        if not done:
            for i in range(len(words)):
                for j in range(len(words[i])):
                    if words[i][j].upper() not in short and words[i][j].lower() not in short:
                        short.add(words[i][j])
                        done = True
                        words[i] = words[i][:j]+"[" + words[i][j] + "]" + words[i][j+1:]
                        break
                if done:
                    break
        print(" ".join(words))
solve()