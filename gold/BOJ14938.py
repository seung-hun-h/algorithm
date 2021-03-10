from sys import stdin
readline = stdin.readline

INF = 4000

def get_max_items():
    # 플로이드 와샬 알고리즘
    # 임의의 시작점이기 때문에 플로이드 와샬 알고리즘이 적절하다 생각 
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if i != j:
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]) 

    _max = 0
    for i in range(n):
        cur = items[i]
        for j in range(n):
            if dist[i][j] > m:
                dist[i][j] = 0
            if dist[i][j] != 0:
                cur += items[j]
        _max = max(_max, cur)
    
    return _max


if __name__ == "__main__":
    n, m, r = map(int, readline().split())
    items = list(map(int, readline().split()))
    dist = [[INF] * n for _ in range(n)]

    for _ in range(r):
        u, v, w = map(int, readline().split())
        dist[u-1][v-1] = w
        dist[v-1][u-1] = w

    for i in range(n):
        dist[i][i] = 0

    print(get_max_items())