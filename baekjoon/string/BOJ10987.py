from sys import stdin
readline = stdin.readline

def solve():
    alphas = ['a', 'e','i','o','u']
    cnt = 0
    line = readline().strip()
    for alpha in alphas:
        cnt += line.count(alpha)
    print(cnt)

solve()