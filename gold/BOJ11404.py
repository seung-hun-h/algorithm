from sys import stdin
readline = stdin.readline
INF = 100000 * 99 + 1

def floyd_warshall():
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if i != j:
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

    for i in range(n):
        for j in range(n):
            if dist[i][j] >= INF:
                dist[i][j] = 0
        print(*dist[i])

        
if __name__ == "__main__":
    n = int(readline().strip())
    m = int(readline().strip())
    dist = [[INF] * n for _ in range(n)]

    for _ in range(m):
        u, v, w = map(int, readline().split())
        dist[u-1][v-1] = min(dist[u-1][v-1], w)
        dist[u-1][u-1] = 0
        dist[v-1][v-1] = 0

    floyd_warshall()