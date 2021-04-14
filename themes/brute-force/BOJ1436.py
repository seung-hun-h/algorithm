from sys import stdin
readline = stdin.readline

N = int(readline())
def solve():
    i = 0
    cnt = 0
    while True:
        if i % 1000 == 666:
            for j in range(1000):
                cnt += 1
                if cnt == N:
                    return i * 1000 + j

        elif i % 100 == 66:
            for j in range(100):
                cnt += 1
                if cnt == N:
                    return i * 1000 + 600 + j
        
        elif i % 10 == 6:
            for j in range(10):
                cnt += 1
                if cnt == N:
                    return i * 1000 + 660 + j
        
        else:
            cnt += 1
            if cnt == N:
                return i * 1000 + 666

        i += 1


print(solve())