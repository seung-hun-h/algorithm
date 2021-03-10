from sys import stdin

readline = stdin.readline


def floyd_warshall():
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if _map[i][j] == 0:
                    if _map[i][k] == 1 and _map[k][j] == 1:
                        _map[i][j] = 1
                    elif _map[i][k] == -1 and _map[k][j] == -1:
                        _map[i][j] = -1

if __name__ == "__main__":
    n, k = map(int, readline().split())
    _map = [[0] * n for _ in range(n)]

    for _ in range(k):
        u, v = map(int, readline().split())
        _map[u-1][v-1] = -1
        _map[v-1][u-1] = 1 

    floyd_warshall()
    t = int(readline().strip())
    
    for _ in range(t):
        start, end = map(int, readline().split())
        start -= 1
        end -= 1

        print(_map[start][end])