from sys import stdin

readline = stdin.readline
INF = 10000 * 500 + 1


def is_possible():
    dist = [INF] * N
    dist[0] = 0
    updated = False
    for i in range(N):
        updated = False
        for j in range(N):
            for v, t in graph[j]:
                if dist[v] > dist[j] + t:
                    dist[v] = dist[j] + t
                    updated = True
        if not updated:
            break

    return updated

if __name__ == "__main__":
    T = int(readline().strip())
    for _ in range(T):
        N, M, W = map(int, readline().split())
        graph = [[] for _ in range(N)]

        for _ in range(M):
            S, E, T = map(int, readline().split())
            graph[S-1].append([E-1, T])
            graph[E-1].append([S-1, T])

        for _ in range(W):
            S, E, T = map(int, readline().split())
            graph[S-1].append([E-1, -T])

        if is_possible():
            print('YES')
        else:
            print('NO')