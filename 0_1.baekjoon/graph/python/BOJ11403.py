from sys import stdin
readline = stdin.readline

N = int(readline())
graph = [list(map(int, readline().split())) for _ in range(N)]

def solve():
    for k in range(N):
        for i in range(N):
            for j in range(N):
                if graph[i][j] == 1: continue
                if all([graph[i][k], graph[k][j]]):
                    graph[i][j] = 1

    for g in graph:
        print(*g)
solve()